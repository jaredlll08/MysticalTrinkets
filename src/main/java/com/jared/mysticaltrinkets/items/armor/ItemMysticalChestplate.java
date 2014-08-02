package com.jared.mysticaltrinkets.items.armor;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

import com.jared.mysticaltrinkets.ModInfo;
import com.jared.mysticaltrinkets.items.tools.MysticalTools;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMysticalChestplate extends ItemArmor implements ISpecialArmor {

	private static IIcon amulet;
	private static IIcon overlay;
	private static NBTTagCompound nbt = new NBTTagCompound();
	private int type;

	public ItemMysticalChestplate(int type) {
		super(MysticalTools.Mystical_Metal_Armor, "mystical".length(), 1);
		nbt.setInteger("type", type);
		this.type = type;
	}

	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5) {

	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	/**
	 * Gets an icon index based on an item's damage value and the given render
	 * pass
	 */
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int par1, int par2) {
		return par2 == 1 ? this.overlay : super.getIconFromDamageForRenderPass(par1, par2);
	}

	// @Override
	// public int getColorFromItemStack(ItemStack par1ItemStack, int par2) {
	// if (par2 == 1) {
	// if(nbt.getInteger("type")==3){
	// return (255 << 16) | (0 << 8) | 0;
	// }
	// return (255 << 16) | (231 << 8) | 56;
	// if(nbt.getInteger("type")==1){
	// return (255 << 16) | (231 << 8) | 56;
	// }
	// }
	// return (180 << 16) | (180 << 8) | 180;
	// }

	@Override
	public int getColorFromItemStack(ItemStack par1ItemStack, int par2) {
		if (par2 == 1) {
			if (type == 0) {
				return (255 << 16) | (80 << 8) | 65;
			}
			if (type == 1) {
				return (255 << 16) | (212 << 8) | 0;
			}
			if (type == 2) {
				return (12 << 16) | (255 << 8) | 45;
			}
			if (type == 3) {
				return (0 << 16) | (140 << 8) | 255;
			}
		}
		return (180 << 16) | (180 << 8) | 180;
	}

	public void registerIcons(IIconRegister icon) {
		this.itemIcon = icon.registerIcon(ModInfo.modid + ":Mystical_Chestplate");
		this.amulet = icon.registerIcon(ModInfo.modid + ":Mystical_Chestplate");
		this.overlay = icon.registerIcon(ModInfo.modid + ":Mystical_Chestplate_Overlay");

	}

	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage, int slot) {
		if (source == source.inFire || source == source.lava || source == source.onFire) {
			return new ArmorProperties(1, 1, MathHelper.floor_double(damage));
		}

		if (source == source.generic) {
			return new ArmorProperties(1, 1, MathHelper.floor_double(damage * 2.75D));
		}
		return new ArmorProperties(1, 1, MathHelper.floor_double(damage * 2.75D));
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return 7;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		if (source.getSourceOfDamage() != null) {
			stack.damageItem(damage * 2, (EntityLivingBase) source.getSourceOfDamage());
		}

	}

//	@Override
//	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
//		return !(stack.getItem() == MysticalTools.mysticalLeggs) ? ModInfo.modid + ":textures/armor/Mystical_Layer_1.png" : ModInfo.modid + ":textures/armor/Mystical_Layer_2.png";
//	}

}
