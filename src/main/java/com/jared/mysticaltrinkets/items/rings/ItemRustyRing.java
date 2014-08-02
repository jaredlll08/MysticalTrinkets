package com.jared.mysticaltrinkets.items.rings;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import baubles.api.BaubleType;
import baubles.api.IBauble;

public class ItemRustyRing extends Item implements IBauble {

	public ItemRustyRing() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean par4) {
		info.add(EnumChatFormatting.YELLOW + "Tier: 0");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {
	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {

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
