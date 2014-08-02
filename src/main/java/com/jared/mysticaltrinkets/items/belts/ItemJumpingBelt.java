package com.jared.mysticaltrinkets.items.belts;

import java.util.List;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingJumpEvent;
import baubles.api.BaubleType;
import baubles.api.BaublesApi;
import baubles.api.IBauble;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ItemJumpingBelt extends Item implements IBauble {

	public ItemJumpingBelt() {
		super();
		this.setMaxStackSize(1);
		MinecraftForge.EVENT_BUS.register(this);
		this.setMaxDamage(1);
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean par4) {
		info.add(EnumChatFormatting.YELLOW + "Tier: 2");
		info.add(EnumChatFormatting.DARK_PURPLE + "Gives the wearer a jump boost.");
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

	@SubscribeEvent
	public void onPlayerJump(LivingJumpEvent event) {
		if (event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			ItemStack belt = BaublesApi.getBaubles(player).getStackInSlot(3);

			if (belt != null && belt.getItem() == this) {
				player.motionY += 0.3;
				player.fallDistance = -1F;
			}
		}
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
