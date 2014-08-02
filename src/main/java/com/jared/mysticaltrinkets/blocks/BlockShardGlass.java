package com.jared.mysticaltrinkets.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.Facing;
import net.minecraft.world.IBlockAccess;

import com.jared.mysticaltrinkets.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockShardGlass extends Block {
	private int color;
	protected BlockShardGlass(int color) {
		super(Material.glass);
		this.setLightLevel(0.5F);
		this.setHardness(1.0F);
		this.color = color;
	}
	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon(ModInfo.modid + ":Shard_Glass");
	}

	@Override
	public int getBlockColor() {
		if (color == 0) {
			return (255 << 16) | (80 << 8) | 65;
		}
		if (color == 1) {
			return (255 << 16) | (212 << 8) | 0;
		}
		if (color == 2) {
			return (12 << 16) | (255 << 8) | 45;
		}
		if (color == 3) {
			return (0 << 16) | (140 << 8) | 255;
		}

		return (255 << 16) | (80 << 8) | 65;
	}

	@Override
	public int colorMultiplier(IBlockAccess par1iBlockAccess, int par2, int par3, int par4) {
		if (color == 0) {
			return (255 << 16) | (80 << 8) | 65;
		}
		if (color == 1) {
			return (255 << 16) | (212 << 8) | 0;
		}
		if (color == 2) {
			return (12 << 16) | (255 << 8) | 45;
		}
		if (color == 3) {
			return (0 << 16) | (140 << 8) | 255;
		}
		return (255 << 16) | (80 << 8) | 65;
	}

	@Override
	public int getRenderColor(int par1) {
		return getBlockColor();
	}
	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return 0;
	}

	/**
	 * Return true if a player with Silk Touch can harvest this block directly,
	 * and not its normal drops.
	 */
	@Override
	protected boolean canSilkHarvest() {
		return true;
	}

	@Override
	public int getRenderType() {
		return 0;
	}

	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * Returns true if the given side of this block type should be rendered, if
	 * the adjacent block is at the given coordinates. Args: blockAccess, x, y,
	 * z, side
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
		Block block = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_);

		if (p_149646_1_.getBlockMetadata(p_149646_2_, p_149646_3_, p_149646_4_) != p_149646_1_.getBlockMetadata(p_149646_2_ - Facing.offsetsXForSide[p_149646_5_], p_149646_3_ - Facing.offsetsYForSide[p_149646_5_], p_149646_4_ - Facing.offsetsZForSide[p_149646_5_])) {
			return true;
		}

		if (block == this) {
			return false;
		}

		return !false && block == this ? false : super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
	}

	/**
	 * Returns which pass should this block be rendered on. 0 for solids and 1
	 * for alpha
	 */
	@Override
	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

}
