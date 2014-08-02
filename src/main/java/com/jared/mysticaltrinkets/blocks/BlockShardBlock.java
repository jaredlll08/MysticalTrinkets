package com.jared.mysticaltrinkets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.IBlockAccess;

import com.jared.mysticaltrinkets.ModInfo;

public class BlockShardBlock extends Block {
	private int color;

	protected BlockShardBlock(int color) {
		super(Material.iron);
		this.setLightLevel(0.5F);
		this.setHardness(3.0F);
		this.color = color;
	}

	public void registerBlockIcons(IIconRegister icon) {
		this.blockIcon = icon.registerIcon(ModInfo.modid + ":Shard_Block");
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

}
