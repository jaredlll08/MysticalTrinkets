package com.jared.mysticaltrinkets.items.belts;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import baubles.api.BaubleType;
import baubles.api.IBauble;

import com.jared.mysticaltrinkets.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBelt extends Item implements IBauble {

	private int type;

	private static IIcon belt;
	private static IIcon overlay;

	public ItemBelt(int type) {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
		this.type = type;
	}

	@SideOnly(Side.CLIENT)
	public static IIcon func_94589_d(String par0Str) {
		if (par0Str == "Belt") {
			return belt;
		}
		if (par0Str == "Belt_Overlay") {
			return overlay;
		} else {
			return null;
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	/**
	 * Gets an icon index based on an item's damage value
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int par1) {

		return this.belt;
	}

	/**
	 * Gets an icon index based on an item's damage value and the given render
	 * pass
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
		return par2 == 0 ? this.overlay : super.getIconFromDamageForRenderPass(par1, par2);
	}

	@Override
	public int getColorFromItemStack(ItemStack par1ItemStack, int par2) {
		if (type == 1) {
			if (par2 == 0) {
				return (255 << 16) | (231 << 8) | 56;
			}
		}
		if (type == 2) {
			if (par2 == 0)
				return (127 << 16) | (142 << 8) | 255;
		}
		return (180 << 16) | (180 << 8) | 180;
	}

	public void registerIcons(IIconRegister icon) {
		// this.itemIcon = icon.registerIcon(ModInfo.modid + ":Amulet");
		this.belt = icon.registerIcon(ModInfo.modid + ":Belt");
		this.overlay = icon.registerIcon(ModInfo.modid + ":Belt_Overlay");
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean par4) {
		info.add(EnumChatFormatting.YELLOW + "Tier: 0");
		info.add(EnumChatFormatting.GREEN + "Used as a crafting reagent.");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;
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
