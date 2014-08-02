package com.jared.mysticaltrinkets.api;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;

public class LeveledPickaxe extends ItemPickaxe {
	private int level;
	private int xp = 0;

	private int[] levelXP = { 100, 300, 500, 1000 };

	public LeveledPickaxe(ToolMaterial material, int level0XP, int level1XP, int level2XP, int level3XP) {
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
			}
			if (nbt.getInteger("mysticalXP") > levelXP[0] && !nbt.getBoolean("level1") && nbt.getBoolean("level0")) {
				nbt.setInteger("mysticalLevel", 1);
				nbt.setInteger("mysticalMaxXP", levelXP[1]);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", true);
				nbt.setBoolean("level2", false);
				nbt.setBoolean("level3", false);
				nbt.setBoolean("level4", false);
				// if (world.rand.nextInt(2) == 0) {
				// itemstack.addEnchantment(Enchantment.efficiency, 1);
				// } else {
				// itemstack.addEnchantment(Enchantment.unbreaking, 1);
				//
				// }
				itemstack.damageItem(-50, (EntityLivingBase) entity);

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
				itemstack.damageItem(-200, (EntityLivingBase) entity);
			}
			if (nbt.getInteger("mysticalXP") > levelXP[3] + 1 && !nbt.getBoolean("level4") && nbt.getBoolean("level3")) {
				nbt.setInteger("mysticalLevel", 4);
				nbt.setInteger("mysticalMaxXP", levelXP[3]);
				nbt.setBoolean("level0", true);
				nbt.setBoolean("level1", true);
				nbt.setBoolean("level2", true);
				nbt.setBoolean("level3", true);
				nbt.setBoolean("level4", true);
				itemstack.damageItem(-400, (EntityLivingBase) entity);
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

		NBTTagCompound nbt = itemstack.getTagCompound();
		if (nbt != null) {
			if (nbt.getInteger("mysticalLevel") < 4) {
				nbt.setInteger("mysticalXP", nbt.getInteger("mysticalXP") + (int) block.getBlockHardness(world, x, y, z));
			}

			if (nbt.getInteger("mysticalLevel") == 1 && nbt.hasKey("mysticalLevel")) {
				if (ForgeHooks.isToolEffective(itemstack, block, world.getBlockMetadata(x, y, z)) && block != Blocks.stone) {
					if (world.getBlock(x - 1, y, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z, world.getBlockMetadata(x - 1, y, z));
						world.setBlockToAir(x - 1, y, z);
						i++;
					}
					if (world.getBlock(x + 1, y, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z, world.getBlockMetadata(x + 1, y, z));
						world.setBlockToAir(x + 1, y, z);
						i++;
					}
					if (world.getBlock(x, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y - 1, z, world.getBlockMetadata(x, y - 1, z));
						world.setBlockToAir(x, y - 1, z);
						i++;
					}

					if (world.getBlock(x, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y + 1, z, world.getBlockMetadata(x, y + 1, z));
						world.setBlockToAir(x, y + 1, z);
						i++;
					}
					if (world.getBlock(x, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y, z - 1, world.getBlockMetadata(x, y, z - 1));
						world.setBlockToAir(x, y, z - 1);
						i++;
					}
					if (world.getBlock(x, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y, z + 1, world.getBlockMetadata(x, y, z + 1));
						world.setBlockToAir(x, y, z + 1);
						i++;
					}
				}

			}

			if (nbt.getInteger("mysticalLevel") == 2 && nbt.hasKey("mysticalLevel")) {
				if (ForgeHooks.isToolEffective(itemstack, block, world.getBlockMetadata(x, y, z)) && block != Blocks.stone) {
					if (world.getBlock(x - 1, y, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z, world.getBlockMetadata(x - 1, y, z));
						world.setBlockToAir(x - 1, y, z);
						i++;
					}
					if (world.getBlock(x + 1, y, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z, world.getBlockMetadata(x + 1, y, z));
						world.setBlockToAir(x + 1, y, z);
						i++;
					}
					if (world.getBlock(x, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y - 1, z, world.getBlockMetadata(x, y - 1, z));
						world.setBlockToAir(x, y - 1, z);
						i++;
					}

					if (world.getBlock(x, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y + 1, z, world.getBlockMetadata(x, y + 1, z));
						world.setBlockToAir(x, y + 1, z);
						i++;
					}
					if (world.getBlock(x, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y, z - 1, world.getBlockMetadata(x, y, z - 1));
						world.setBlockToAir(x, y, z - 1);
						i++;
					}
					if (world.getBlock(x, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y, z + 1, world.getBlockMetadata(x, y, z + 1));
						world.setBlockToAir(x, y, z + 1);
						i++;
					}

					if (world.getBlock(x - 1, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z - 1, world.getBlockMetadata(x - 1, y, z - 1));
						world.setBlockToAir(x - 1, y, z - 1);
						i++;
					}
					if (world.getBlock(x + 1, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z - 1, world.getBlockMetadata(x + 1, y, z - 1));
						world.setBlockToAir(x + 1, y, z - 1);
						i++;
					}
					if (world.getBlock(x, y - 1, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y - 1, z - 1, world.getBlockMetadata(x, y - 1, z - 1));
						world.setBlockToAir(x, y - 1, z - 1);
						i++;
					}

					if (world.getBlock(x, y + 1, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y + 1, z - 1, world.getBlockMetadata(x, y + 1, z - 1));
						world.setBlockToAir(x, y + 1, z - 1);
						i++;
					}

					if (world.getBlock(x - 1, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z + 1, world.getBlockMetadata(x - 1, y, z + 1));
						world.setBlockToAir(x - 1, y, z + 1);
						i++;
					}
					if (world.getBlock(x + 1, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z + 1, world.getBlockMetadata(x + 1, y, z + 1));
						world.setBlockToAir(x + 1, y, z + 1);
						i++;
					}
					if (world.getBlock(x, y - 1, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y - 1, z + 1, world.getBlockMetadata(x, y - 1, z + 1));
						world.setBlockToAir(x, y - 1, z + 1);
						i++;
					}

					if (world.getBlock(x, y + 1, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y + 1, z + 1, world.getBlockMetadata(x, y + 1, z + 1));
						world.setBlockToAir(x, y + 1, z + 1);
						i++;
					}

					if (world.getBlock(x + 1, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z - 1, world.getBlockMetadata(x + 1, y, z - 1));
						world.setBlockToAir(x + 1, y, z - 1);
						i++;
					}
					if (world.getBlock(x + 1, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z + 1, world.getBlockMetadata(x + 1, y, z + 1));
						world.setBlockToAir(x + 1, y, z + 1);
						i++;
					}
					if (world.getBlock(x + 1, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y - 1, z, world.getBlockMetadata(x + 1, y - 1, z));
						world.setBlockToAir(x + 1, y - 1, z);
						i++;
					}

					if (world.getBlock(x + 1, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y + 1, z, world.getBlockMetadata(x + 1, y + 1, z));
						world.setBlockToAir(x + 1, y + 1, z);
						i++;
					}

					if (world.getBlock(x - 1, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z - 1, world.getBlockMetadata(x - 1, y, z - 1));
						world.setBlockToAir(x - 1, y, z - 1);
						i++;
					}
					if (world.getBlock(x - 1, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z + 1, world.getBlockMetadata(x - 1, y, z + 1));
						world.setBlockToAir(x - 1, y, z + 1);
						i++;
					}
					if (world.getBlock(x - 1, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y - 1, z, world.getBlockMetadata(x - 1, y - 1, z));
						world.setBlockToAir(x - 1, y - 1, z);
						i++;
					}

					if (world.getBlock(x - 1, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y + 1, z, world.getBlockMetadata(x - 1, y + 1, z));
						world.setBlockToAir(x - 1, y + 1, z);
						i++;
					}

				}

			}

			if (nbt.getInteger("mysticalLevel") >= 3 && nbt.hasKey("mysticalLevel")) {
				if (ForgeHooks.isToolEffective(itemstack, block, world.getBlockMetadata(x, y, z)) && block != Blocks.stone && block != Blocks.sandstone && block != Blocks.cobblestone) {
					if (world.getBlock(x - 1, y, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z, world.getBlockMetadata(x - 1, y, z));
						world.setBlockToAir(x - 1, y, z);
						i++;
					}
					if (world.getBlock(x + 1, y, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z, world.getBlockMetadata(x + 1, y, z));
						world.setBlockToAir(x + 1, y, z);
						i++;
					}
					if (world.getBlock(x, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y - 1, z, world.getBlockMetadata(x, y - 1, z));
						world.setBlockToAir(x, y - 1, z);
						i++;
					}

					if (world.getBlock(x, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y + 1, z, world.getBlockMetadata(x, y + 1, z));
						world.setBlockToAir(x, y + 1, z);
						i++;
					}
					if (world.getBlock(x, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y, z - 1, world.getBlockMetadata(x, y, z - 1));
						world.setBlockToAir(x, y, z - 1);
						i++;
					}
					if (world.getBlock(x, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y, z + 1, world.getBlockMetadata(x, y, z + 1));
						world.setBlockToAir(x, y, z + 1);
						i++;
					}

					if (world.getBlock(x - 1, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z - 1, world.getBlockMetadata(x - 1, y, z - 1));
						world.setBlockToAir(x - 1, y, z - 1);
						i++;
					}
					if (world.getBlock(x + 1, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z - 1, world.getBlockMetadata(x + 1, y, z - 1));
						world.setBlockToAir(x + 1, y, z - 1);
						i++;
					}
					if (world.getBlock(x, y - 1, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y - 1, z - 1, world.getBlockMetadata(x, y - 1, z - 1));
						world.setBlockToAir(x, y - 1, z - 1);
						i++;
					}

					if (world.getBlock(x, y + 1, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y + 1, z - 1, world.getBlockMetadata(x, y + 1, z - 1));
						world.setBlockToAir(x, y + 1, z - 1);
						i++;
					}

					if (world.getBlock(x - 1, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z + 1, world.getBlockMetadata(x - 1, y, z + 1));
						world.setBlockToAir(x - 1, y, z + 1);
						i++;
					}
					if (world.getBlock(x + 1, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z + 1, world.getBlockMetadata(x + 1, y, z + 1));
						world.setBlockToAir(x + 1, y, z + 1);
						i++;
					}
					if (world.getBlock(x, y - 1, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y - 1, z + 1, world.getBlockMetadata(x, y - 1, z + 1));
						world.setBlockToAir(x, y - 1, z + 1);
						i++;
					}

					if (world.getBlock(x, y + 1, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x, y + 1, z + 1, world.getBlockMetadata(x, y + 1, z + 1));
						world.setBlockToAir(x, y + 1, z + 1);
						i++;
					}

					if (world.getBlock(x + 1, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z - 1, world.getBlockMetadata(x + 1, y, z - 1));
						world.setBlockToAir(x + 1, y, z - 1);
						i++;
					}
					if (world.getBlock(x + 1, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y, z + 1, world.getBlockMetadata(x + 1, y, z + 1));
						world.setBlockToAir(x + 1, y, z + 1);
						i++;
					}
					if (world.getBlock(x + 1, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y - 1, z, world.getBlockMetadata(x + 1, y - 1, z));
						world.setBlockToAir(x + 1, y - 1, z);
						i++;
					}

					if (world.getBlock(x + 1, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y + 1, z, world.getBlockMetadata(x + 1, y + 1, z));
						world.setBlockToAir(x + 1, y + 1, z);
						i++;
					}

					if (world.getBlock(x - 1, y, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z - 1, world.getBlockMetadata(x - 1, y, z - 1));
						world.setBlockToAir(x - 1, y, z - 1);
						i++;
					}
					if (world.getBlock(x - 1, y, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y, z + 1, world.getBlockMetadata(x - 1, y, z + 1));
						world.setBlockToAir(x - 1, y, z + 1);
						i++;
					}
					if (world.getBlock(x - 1, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y - 1, z, world.getBlockMetadata(x - 1, y - 1, z));
						world.setBlockToAir(x - 1, y - 1, z);
						i++;
					}

					if (world.getBlock(x - 1, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y + 1, z, world.getBlockMetadata(x - 1, y + 1, z));
						world.setBlockToAir(x - 1, y + 1, z);
						i++;
					}

					if (world.getBlock(x + 1, y + 1, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y + 1, z - 1, world.getBlockMetadata(x + 1, y + 1, z - 1));
						world.setBlockToAir(x + 1, y + 1, z - 1);
						i++;
					}
					if (world.getBlock(x + 1, y + 1, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y + 1, z + 1, world.getBlockMetadata(x + 1, y + 1, z + 1));
						world.setBlockToAir(x + 1, y + 1, z + 1);
						i++;
					}
					if (world.getBlock(x + 1, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y + 1 - 1, z, world.getBlockMetadata(x + 1, y + 1, z));
						world.setBlockToAir(x + 1, y + 1, z);
						i++;
					}

					if (world.getBlock(x + 1, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y + 1 + 1, z, world.getBlockMetadata(x + 1, y + 1, z));
						world.setBlockToAir(x + 1, y + 1, z);
						i++;
					}

					if (world.getBlock(x - 1, y - 1, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y - 1, z - 1, world.getBlockMetadata(x - 1, y - 1, z - 1));
						world.setBlockToAir(x - 1, y - 1, z - 1);
						i++;
					}
					if (world.getBlock(x - 1, y - 1, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y - 1, z + 1, world.getBlockMetadata(x - 1, y - 1, z + 1));
						world.setBlockToAir(x - 1, y - 1, z + 1);
						i++;
					}
					if (world.getBlock(x - 1, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y - 1, z, world.getBlockMetadata(x - 1, y - 1, z));
						world.setBlockToAir(x - 1, y - 1, z);
						i++;
					}

					if (world.getBlock(x - 1, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y - 1, z, world.getBlockMetadata(x - 1, y - 1, z));
						world.setBlockToAir(x - 1, y - 1, z);
						i++;
					}

					if (world.getBlock(x - 1, y + 1, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y + 1, z - 1, world.getBlockMetadata(x - 1, y + 1, z - 1));
						world.setBlockToAir(x - 1, y + 1, z - 1);
						i++;
					}
					if (world.getBlock(x - 1, y + 1, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y + 1, z + 1, world.getBlockMetadata(x - 1, y + 1, z + 1));
						world.setBlockToAir(x - 1, y + 1, z + 1);
						i++;
					}
					if (world.getBlock(x - 1, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y + 1 - 1, z, world.getBlockMetadata(x - 1, y + 1, z));
						world.setBlockToAir(x - 1, y + 1, z);
						i++;
					}

					if (world.getBlock(x - 1, y + 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x - 1, y + 1 + 1, z, world.getBlockMetadata(x - 1, y + 1, z));
						world.setBlockToAir(x - 1, y + 1, z);
						i++;
					}

					if (world.getBlock(x + 1, y - 1, z - 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y - 1, z - 1, world.getBlockMetadata(x + 1, y - 1, z - 1));
						world.setBlockToAir(x + 1, y - 1, z - 1);
						i++;
					}
					if (world.getBlock(x + 1, y - 1, z + 1) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y - 1, z + 1, world.getBlockMetadata(x + 1, y - 1, z + 1));
						world.setBlockToAir(x + 1, y - 1, z + 1);
						i++;
					}
					if (world.getBlock(x + 1, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y - 1, z, world.getBlockMetadata(x + 1, y - 1, z));
						world.setBlockToAir(x + 1, y - 1, z);
						i++;
					}

					if (world.getBlock(x + 1, y - 1, z) == block) {
						block.harvestBlock(world, (EntityPlayer) entity, x + 1, y - 1, z, world.getBlockMetadata(x + 1, y - 1, z));
						world.setBlockToAir(x + 1, y - 1, z);
						i++;
					}

				}
			}
		}

		itemstack.damageItem(i, entity);
		return true;

	}
}
