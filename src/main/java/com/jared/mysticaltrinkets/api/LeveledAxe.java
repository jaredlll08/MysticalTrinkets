package com.jared.mysticaltrinkets.api;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class LeveledAxe extends ItemAxe {
	private int level;
	private int xp = 0;

	private int[] levelXP = { 100, 300, 500, 1000 };

	public LeveledAxe(ToolMaterial material, int level0XP, int level1XP, int level2XP, int level3XP) {
		super(material);
		this.setMaxStackSize(1);
		this.levelXP[0] = level0XP;
		this.levelXP[1] = level1XP;
		this.levelXP[2] = level2XP;
		this.levelXP[3] = level3XP;
		this.bFull3D = true;

	}

	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) {
		NBTTagCompound nbt = itemstack.getTagCompound();
		if (nbt != null) {
			if (!nbt.hasKey("mysticalmaxXP") || nbt.getInteger("mysticalmaxXP") < levelXP[0]) {
				nbt.setInteger("mysticalmaxXP", levelXP[0]);
			}
			if (!nbt.hasKey("mysticalLevel")) {
				nbt.setInteger("mysticalLevel", 0);
			}
			if (!nbt.hasKey("mysticalXP")) {
				nbt.setInteger("mysticalXP", 0);
			}

			if (nbt.getInteger("mysticalXP") < levelXP[0] && !nbt.getBoolean("level0")) {
				nbt.setInteger("mysticalmaxXP", levelXP[0]);
				nbt.setInteger("mysticalLevel", 0);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", false);
				nbt.setBoolean("level2", false);
				nbt.setBoolean("level3", false);
				nbt.setBoolean("level4", false);
				itemstack.damageItem(-20, (EntityLivingBase) entity);
			}
			if (nbt.getInteger("mysticalXP") > levelXP[0] && !nbt.getBoolean("level1") && nbt.getBoolean("level0")) {
				nbt.setInteger("mysticalLevel", 1);
				nbt.setInteger("mysticalmaxXP", levelXP[1]);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", true);
				nbt.setBoolean("level2", false);
				nbt.setBoolean("level3", false);
				nbt.setBoolean("level4", false);
				itemstack.damageItem(-50, (EntityLivingBase) entity);
			}
			if (nbt.getInteger("mysticalXP") > levelXP[1] && !nbt.getBoolean("level2") && nbt.getBoolean("level1")) {
				nbt.setInteger("mysticalLevel", 2);
				nbt.setInteger("mysticalmaxXP", levelXP[2]);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", true);
				nbt.setBoolean("level2", true);
				nbt.setBoolean("level3", false);
				nbt.setBoolean("level4", false);
				itemstack.damageItem(-75, (EntityLivingBase) entity);
			}
			if (nbt.getInteger("mysticalXP") > levelXP[2] && !nbt.getBoolean("level3") && nbt.getBoolean("level2")) {
				nbt.setInteger("mysticalLevel", 3);
				nbt.setInteger("mysticalmaxXP", levelXP[3]);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", true);
				nbt.setBoolean("level2", true);
				nbt.setBoolean("level3", true);
				nbt.setBoolean("level4", false);
				itemstack.damageItem(-100, (EntityLivingBase) entity);
			}
			if (nbt.getInteger("mysticalXP") > levelXP[3] + 1 && !nbt.getBoolean("level4") && nbt.getBoolean("level3")) {
				nbt.setInteger("mysticalLevel", 4);
				nbt.setInteger("mysticalmaxXP", levelXP[3]);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", true);
				nbt.setBoolean("level2", true);
				nbt.setBoolean("level3", true);
				nbt.setBoolean("level4", true);
				itemstack.damageItem(-175, (EntityLivingBase) entity);			
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

	public boolean onBlockDestroyed(ItemStack itemstack, World world, Block block, int x, int y, int z, EntityLivingBase entity) {
		int i = 1;
		int j = 1;

		NBTTagCompound nbt = itemstack.getTagCompound();
		if (nbt != null) {
			if (nbt.getInteger("mysticalLevel") < 4) {
				nbt.setInteger("mysticalXP", nbt.getInteger("mysticalXP") + (int) block.getBlockHardness(world, x, y, z));
			}
		}

		if (nbt.getInteger("mysticalLevel") == 1 && nbt.hasKey("mysticalLevel")) {
			if (ForgeHooks.isToolEffective(itemstack, block, world.getBlockMetadata(x, y, z))) {
				if (world.getBlock(x, y + 1, z) == block) {
					block.harvestBlock(world, (EntityPlayer) entity, x, y + 1, z, world.getBlockMetadata(x, y + 1, z));
					world.setBlockToAir(x, y + 1, z);
					i++;
				}

			}

		}
		if (nbt.getInteger("mysticalLevel") == 2 && nbt.hasKey("mysticalLevel")) {
			if (ForgeHooks.isToolEffective(itemstack, block, world.getBlockMetadata(x, y, z))) {
				if (world.getBlock(x, y + 1, z) == block) {
					block.harvestBlock(world, (EntityPlayer) entity, x, y + 1, z, world.getBlockMetadata(x, y + 1, z));
					world.setBlockToAir(x, y + 1, z);
				}
				if (world.getBlock(x, y + 2, z) == block) {
					block.harvestBlock(world, (EntityPlayer) entity, x, y + 2, z, world.getBlockMetadata(x, y + 2, z));
					world.setBlockToAir(x, y + 2, z);
				}
				if (world.getBlock(x, y + 3, z) == block) {
					block.harvestBlock(world, (EntityPlayer) entity, x, y + 3, z, world.getBlockMetadata(x, y + 3, z));
					world.setBlockToAir(x, y + 3, z);
				}

			}

		}

		if (nbt.getInteger("mysticalLevel") == 2 && nbt.hasKey("mysticalLevel")) {
			if (ForgeHooks.isToolEffective(itemstack, block, world.getBlockMetadata(x, y, z))) {
				if (world.getBlock(x, y + 1, z) == block) {
					block.harvestBlock(world, (EntityPlayer) entity, x, y + 1, z, world.getBlockMetadata(x, y + 1, z));
					world.setBlockToAir(x, y + 1, z);
				}
				if (world.getBlock(x, y + 2, z) == block) {
					block.harvestBlock(world, (EntityPlayer) entity, x, y + 2, z, world.getBlockMetadata(x, y + 2, z));
					world.setBlockToAir(x, y + 2, z);
				}
				if (world.getBlock(x, y + 3, z) == block) {
					block.harvestBlock(world, (EntityPlayer) entity, x, y + 3, z, world.getBlockMetadata(x, y + 3, z));
					world.setBlockToAir(x, y + 3, z);
				}
				if (world.getBlock(x, y + 4, z) == block) {
					block.harvestBlock(world, (EntityPlayer) entity, x, y + 4, z, world.getBlockMetadata(x, y + 4, z));
					world.setBlockToAir(x, y + 4, z);
				}
				if (world.getBlock(x, y + 5, z) == block) {
					block.harvestBlock(world, (EntityPlayer) entity, x, y + 5, z, world.getBlockMetadata(x, y + 5, z));
					world.setBlockToAir(x, y + 5, z);
				}

			}

		}
		if (nbt.getInteger("mysticalLevel") == 4 && nbt.hasKey("mysticalLevel")) {
			if (ForgeHooks.isToolEffective(itemstack, block, world.getBlockMetadata(x, y, z))) {
				while (world.getBlock(x, y + j, z) == block) {
					block.harvestBlock(world, (EntityPlayer) entity, x, y + j, z, world.getBlockMetadata(x, y + j, z));
					world.setBlockToAir(x, y + j, z);
					i++;
					j++;
				}
			}

		}

		itemstack.damageItem(i, entity);
		return true;

	}
}
