package com.jared.mysticaltrinkets.blocks.trees;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.jared.mysticaltrinkets.ModInfo;
import com.jared.mysticaltrinkets.blocks.MysticalBlocks;
import com.jared.mysticaltrinkets.client.render.RenderParticles;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockInfusedOakLog extends Block {

	@SideOnly(Side.CLIENT)
	private IIcon topIcon;
	@SideOnly(Side.CLIENT)
	private IIcon botIcon;
	@SideOnly(Side.CLIENT)
	private IIcon sideIcons;

	public BlockInfusedOakLog() {
		super(Material.wood);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setStepSound(soundTypeWood);
	}

	/**
	 * The type of render function that is called for this block
	 */
	@Override
	public int getRenderType() {
		return 31;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random par1Random) {
		return 1;
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
		byte b0 = 4;
		int j1 = b0 + 1;

		if (par1World.checkChunksExist(par2 - j1, par3 - j1, par4 - j1, par2 + j1, par3 + j1, par4 + j1)) {
			for (int k1 = -b0; k1 <= b0; ++k1) {
				for (int l1 = -b0; l1 <= b0; ++l1) {
					for (int i2 = -b0; i2 <= b0; ++i2) {
						Block j2 = par1World.getBlock(par2 + k1, par3 + l1, par4 + i2);

						if (j2 != null) {
							j2.beginLeavesDecay(par1World, par2 + k1, par3 + l1, par4 + i2);
						}
					}
				}
			}
		}
	}

	/**
	 * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
	 * side, hitX, hitY, hitZ, block metadata
	 */
	// public int onBlockPlaced(World par1World, int par2, int par3, int par4,
	// int par5, float par6, float par7, float par8, int par9) {
	// int j1 = par9 & 3;
	// byte b0 = 0;
	//
	// switch (par5) {
	// case 0:
	// case 1:
	// b0 = 0;
	// break;
	// case 2:
	// case 3:
	// b0 = 8;
	// break;
	// case 4:
	// case 5:
	// b0 = 4;
	// }
	//
	// return j1 | b0;
	// }

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Determines the damage on the item the block drops. Used in cloth and wood.
	 */
	public int damageDropped(int par1) {
		return par1 & 3;
	}

	/**
	 * returns a number between 0 and 3
	 */
	public static int limitToValidMetadata(int par0) {
		return par0 & 3;
	}

	@Override
	@SideOnly(Side.CLIENT)
	/**
	 * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage
	 * and is ignored for blocks which do not support subtypes. Blocks which cannot be harvested should return null.
	 */
	protected ItemStack createStackedBlock(int par1) {
		return new ItemStack(this, 1, limitToValidMetadata(par1));
	}

	@Override
	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	// @Override
	// public boolean isWood(IBlockAccess world, int x, int y, int z) {
	// return true;
	// }

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.topIcon = par1IconRegister.registerIcon(ModInfo.modid + ":" + "Infused_Oak_Log_Top");

		this.sideIcons = par1IconRegister.registerIcon(ModInfo.modid + ":" + "Infused_Oak_Log");
		this.botIcon = par1IconRegister.registerIcon(ModInfo.modid + ":" + "Infused_Oak_Log_Top");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		if (par5 == 1) {
			return this.topIcon;
		}
		if (par5 == 0) {
			return this.sideIcons;
		}
		return sideIcons;

	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return par1 == 1 ? this.topIcon : (par1 == 0 ? this.topIcon : this.sideIcons);
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (world.getBlock(x, y - 2, z) == MysticalBlocks.mysticalBrick) {
			if (world.getBlock(x, y - 1, z) == MysticalBlocks.mysticalBrick) {
				if (world.getBlock(x + 2, y - 2, z + 2) == MysticalBlocks.ritualBlock) {
					RenderParticles.spawnParticle("leaf", x + 1, y, z + 1, 0.1, -0.1, 0.1);

				} else if (world.getBlock(x - 2, y - 2, z - 2) == MysticalBlocks.ritualBlock) {
					RenderParticles.spawnParticle("leaf", x, y, z, -0.1, -0.1, -0.1);
				} else if (world.getBlock(x - 2, y - 2, z + 2) == MysticalBlocks.ritualBlock) {
					RenderParticles.spawnParticle("leaf", x, y, z + 1, -0.1, -0.1, 0.1);
				} else if (world.getBlock(x + 2, y - 2, z - 2) == MysticalBlocks.ritualBlock) {
					RenderParticles.spawnParticle("leaf", x + 1, y, z, 0.1, -0.1, -0.1);
				}
			}
		}
	}
}
