package com.jared.mysticaltrinkets.items.amulets;

import java.util.List;
import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import baubles.api.BaubleType;
import baubles.api.IBauble;

public class ItemAbsorptionAmulet extends Item implements IBauble {

	public ItemAbsorptionAmulet() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) {
		Random random = new Random();
		if (random.nextInt(10) == 0) {
			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entity;
				player.heal(0.5F);
			}
		}
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean par4) {
		info.add(EnumChatFormatting.YELLOW + "Tier: 3");
		info.add(EnumChatFormatting.YELLOW + "Gives the wearer an absorption buff.");
		info.add(EnumChatFormatting.DARK_AQUA + "*Sometimes takes to many hearts when unequiped.*");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.AMULET;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

		Random random = new Random();
		if (random.nextInt(11000) == 1) {
			player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 12000, 2));
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		player.addPotionEffect(new PotionEffect(Potion.field_76444_x.id, 12000, 2));

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.removePotionEffect(Potion.field_76444_x.id);
		Random random = new Random();
		if (random.nextInt(2) == 1) {
			player.addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
		}
		// player.removePotionEffect(Potion.harm.id);
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

}
