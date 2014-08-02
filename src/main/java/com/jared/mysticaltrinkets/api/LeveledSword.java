package com.jared.mysticaltrinkets.api;

import java.util.List;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

public class LeveledSword extends ItemSword {
	private int level;
	private int xp = 0;

	private int[] levelXP = { 100, 300, 500, 1000 };

	public LeveledSword(ToolMaterial material, int level0XP, int level1XP, int level2XP, int level3XP) {
		super(material);
		this.setMaxStackSize(1);
		this.levelXP[0] = level0XP;
		this.levelXP[1] = level1XP;
		this.levelXP[2] = level2XP;
		this.levelXP[3] = level3XP;
		this.bFull3D = true;
	}

	public boolean onLeftClickEntity(ItemStack itemstack, EntityPlayer player, Entity entity) {

		NBTTagCompound nbt = itemstack.getTagCompound();

		if (nbt != null) {
			if (!nbt.hasKey("mysticalMaxXP") || nbt.getInteger("mysticalMaxXP") < levelXP[0]) {
				nbt.setInteger("mysticalMaxXP", levelXP[0]);
			}
			if (!nbt.hasKey("mysticalLevel")) {
				nbt.setInteger("mysticalLevel", 0);
			}
			if (!nbt.hasKey("mysticalXP")) {
				nbt.setInteger("mysticalXP", 0);
			}
			nbt.setInteger("mysticalXP", nbt.getInteger("mysticalXP") + player.worldObj.rand.nextInt(10) + 1);

			if (nbt.getInteger("mysticalLevel") == 2 && nbt.hasKey("mysticalLevel")) {
				if (entity.worldObj.rand.nextInt(7) == 0) {
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
				}
			}
			if (nbt.getInteger("mysticalLevel") >= 3 && nbt.hasKey("mysticalLevel")) {
				if (entity.worldObj.rand.nextInt(7) == 0) {
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.harm.id, 1, 2));
					player.heal(3);
				}
				if (entity.worldObj.rand.nextInt(3) == 0) {
					((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.harm.id, 1, 1));
					player.heal(2);
				}
				if (entity.worldObj.rand.nextInt(5) == 0) {
					player.heal(2);
				}

			}
		}

		return false;
	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) {
		NBTTagCompound nbt = itemstack.getTagCompound();
		if (nbt != null) {
			if (!nbt.hasKey("mysticalMaxXP") || nbt.getInteger("mysticalMaxXP") < levelXP[0]) {
				nbt.setInteger("mysticalMaxXP", levelXP[0]);
			}
			if (!nbt.hasKey("mysticalLevel")) {
				nbt.setInteger("mysticalLevel", 0);
			}
			if (!nbt.hasKey("mysticalXP")) {
				nbt.setInteger("mysticalXP", 0);
			}

			if (nbt.getInteger("mysticalXP") < levelXP[0] && !nbt.getBoolean("level0")) {
				nbt.setInteger("mysticalMaxXP", levelXP[0]);
				nbt.setInteger("mysticalLevel", 0);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", false);
				nbt.setBoolean("level2", false);
				nbt.setBoolean("level3", false);
				nbt.setBoolean("level4", false);
				itemstack.damageItem(-50, (EntityLivingBase) entity);
				itemstack.addEnchantment(Enchantment.unbreaking, 1);
			}
			if (nbt.getInteger("mysticalXP") > levelXP[0] && !nbt.getBoolean("level1") && nbt.getBoolean("level0")) {
				nbt.setInteger("mysticalLevel", 1);
				nbt.setInteger("mysticalMaxXP", levelXP[1]);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", true);
				nbt.setBoolean("level2", false);
				nbt.setBoolean("level3", false);
				nbt.setBoolean("level4", false);
				itemstack.damageItem(-75, (EntityLivingBase) entity);
			}
			if (nbt.getInteger("mysticalXP") > levelXP[1] && !nbt.getBoolean("level2") && nbt.getBoolean("level1")) {
				nbt.setInteger("mysticalLevel", 2);
				nbt.setInteger("mysticalMaxXP", levelXP[2]);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", true);
				nbt.setBoolean("level2", true);
				nbt.setBoolean("level3", false);
				nbt.setBoolean("level4", false);
				itemstack.damageItem(-100, (EntityLivingBase) entity);

			}
			if (nbt.getInteger("mysticalXP") > levelXP[2] && !nbt.getBoolean("level3") && nbt.getBoolean("level2")) {
				nbt.setInteger("mysticalLevel", 3);
				nbt.setInteger("mysticalMaxXP", levelXP[3]);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", true);
				nbt.setBoolean("level2", true);
				nbt.setBoolean("level3", true);
				nbt.setBoolean("level4", false);
				itemstack.damageItem(-150, (EntityLivingBase) entity);
			}
			if (nbt.getInteger("mysticalXP") > levelXP[3] + 1 && !nbt.getBoolean("level4") && nbt.getBoolean("level3")) {
				nbt.setInteger("mysticalLevel", 4);
				nbt.setInteger("mysticalMaxXP", levelXP[3]);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", true);
				nbt.setBoolean("level2", true);
				nbt.setBoolean("level3", true);
				nbt.setBoolean("level4", true);
				itemstack.damageItem(-300, (EntityLivingBase) entity);
			}
		}

	}

	public void addInformation(ItemStack itemstack, EntityPlayer player, List list, boolean par4) {
		NBTTagCompound nbt = itemstack.getTagCompound();
		if (nbt != null) {
			if (!nbt.hasKey("mysticalMaxXP") || nbt.getInteger("mysticalMaxXP") < levelXP[0]) {
				nbt.setInteger("mysticalMaxXP", levelXP[0]);
			}
			if (!nbt.hasKey("mysticalLevel")) {
				nbt.setInteger("mysticalLevel", 0);
			}
			if (!nbt.hasKey("mysticalXP")) {
				nbt.setInteger("mysticalXP", 0);
			}

			list.add(EnumChatFormatting.DARK_AQUA + "Level: " + nbt.getInteger("mysticalLevel"));
			list.add(EnumChatFormatting.LIGHT_PURPLE + "XP: " + nbt.getInteger("mysticalXP") + "/" + nbt.getInteger("mysticalMaxXP"));
			if(!(nbt.getInteger("mysticalLevel") <=3)){
				list.remove(EnumChatFormatting.DARK_AQUA + "Level: " + nbt.getInteger("mysticalLevel"));
				list.remove(EnumChatFormatting.LIGHT_PURPLE + "XP: " + nbt.getInteger("mysticalXP") + "/" + nbt.getInteger("mysticalMaxXP"));
				list.add(EnumChatFormatting.DARK_AQUA + "Max Level");
			}
			
		}
	}

}
