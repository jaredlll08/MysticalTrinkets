package com.jared.mysticaltrinkets.blocks.flower;

import java.util.Random;

import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase.FlowerEntry;

import com.jared.mysticaltrinkets.ModInfo;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFireFlower extends BlockFlower {

	public IIcon icon;
	public BlockFireFlower() {
		super(0);
		this.setLightLevel(0.5F);
		this.setBlockBounds(0, 0, 0, 1F, 1F, 1F);
	}

	
	public int getRenderType() {
		return ModInfo.fireFlowerRenderID;
	}
	
	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		world.spawnParticle("flame", x+0.5, y+1, z+0.5, 0, 0, 0);
		world.spawnParticle("flame", x+0.5, y+1, z+0.5, 0, 0, 0);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {

			icon = par1IconRegister.registerIcon(ModInfo.modid + ":" + "FireFlower");
			FlowerEntry e = new FlowerEntry(this, 0, 20);
			

	}
	@Override
	public IIcon getIcon(int par1, int par2) {
		return icon;
	}
}
