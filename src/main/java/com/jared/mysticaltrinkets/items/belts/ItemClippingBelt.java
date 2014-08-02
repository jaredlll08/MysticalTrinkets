package com.jared.mysticaltrinkets.items.belts;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import baubles.api.BaubleType;
import baubles.api.IBauble;

import com.jared.mysticaltrinkets.ModInfo;

public class ItemClippingBelt extends Item implements IBauble {

	World world;
	EntityPlayer play;

	public ItemClippingBelt() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}
	public void registerIcons(IIconRegister icon) {
		 this.itemIcon = icon.registerIcon(ModInfo.modid + ":Belt");
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean par4) {

		info.add(EnumChatFormatting.DARK_PURPLE + "*Creative Only*");
		info.add(EnumChatFormatting.YELLOW + "Gives the wearer the ability");
		info.add(EnumChatFormatting.YELLOW + "to pass through blocks.");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.epic;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
		player.noClip = true;
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.noClip = false;
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
