package com.jared.mysticaltrinkets.blocks.ritualblocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.jared.mysticaltrinkets.blocks.MysticalBlocks;
import com.jared.mysticaltrinkets.client.render.RenderParticles;

public class BlockRitualWater extends BlockContainer {

	public static ItemStack currentPlayerItem = null;

	public BlockRitualWater() {
		super(Material.anvil);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return null;
	}

	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		if (world.getBlock(x, y - 2, z) == MysticalBlocks.mysticalBrick) {
			if (world.getBlock(x, y - 1, z) == MysticalBlocks.mysticalBrick) {
				if (world.getBlock(x + 2, y - 2, z + 2) == MysticalBlocks.mysticalInfuserActive || world.getBlock(x + 2, y - 2, z + 2) == MysticalBlocks.mysticalInfuserInactive) {
					RenderParticles.spawnParticle("waterRitual", x + 1, y, z + 1, 0.1, -0.1, 0.1);

				} else if (world.getBlock(x - 2, y - 2, z - 2) == MysticalBlocks.mysticalInfuserActive || world.getBlock(x - 2, y - 2, z - 2) == MysticalBlocks.mysticalInfuserInactive) {
					RenderParticles.spawnParticle("waterRitual", x, y, z, -0.1, -0.1, -0.1);
				} else if (world.getBlock(x - 2, y - 2, z + 2) == MysticalBlocks.mysticalInfuserActive || world.getBlock(x - 2, y - 2, z + 2) == MysticalBlocks.mysticalInfuserInactive) {
					RenderParticles.spawnParticle("waterRitual", x, y, z + 1, -0.1, -0.1, 0.1);
				} else if (world.getBlock(x + 2, y - 2, z - 2) == MysticalBlocks.mysticalInfuserActive || world.getBlock(x + 2, y - 2, z - 2) == MysticalBlocks.mysticalInfuserInactive) {
					RenderParticles.spawnParticle("waterRitual", x + 1, y, z, 0.1, -0.1, -0.1);
				} else {
					RenderParticles.spawnParticle("waterRitual", x + 0.5, y + 1, z + 0.5, 0.0, +0.1, 0.0);
				}
			}
		} else {
			RenderParticles.spawnParticle("waterRitual", x + 0.5, y + 1, z + 0.5, 0.0, +0.1, 0.0);
		}

	}

}
