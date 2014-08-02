package com.jared.mysticaltrinkets.items.belts;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import baubles.api.BaubleType;
import baubles.api.IBauble;

public class ItemSpeedBelt extends Item implements IBauble {

	public ItemSpeedBelt() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean par4) {
		info.add(EnumChatFormatting.YELLOW + "Tier: 3");
		info.add(EnumChatFormatting.BLUE + "Gives the wearer a speed buff.");
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

		if (player instanceof EntityPlayer) {
			EntityPlayer play = (EntityPlayer) player;
			if ((play.onGround || play.capabilities.isFlying) && play.moveForward > 0F)
				play.moveFlying(0F, 1F, play.capabilities.isFlying ? 0.050F : 0.07F);

		}
		// if (itemstack.getItemDamage() == 0) {
		//
		// player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 40, 0));
		//
		// }
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

		// player.addPotionEffect(new PotionEffect(Potion.moveSpeed.id,
		// Integer.MAX_VALUE));
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		player.setAIMoveSpeed(0.1F);
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
