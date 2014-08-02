package com.jared.mysticaltrinkets.blocks.ritualblocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.jared.mysticaltrinkets.blocks.MysticalBlocks;
import com.jared.mysticaltrinkets.client.render.RenderParticles;

public class BlockRitualBlockBurnt extends Block {

	public static ItemStack currentPlayerItem = null;

	public BlockRitualBlockBurnt() {
		super(Material.anvil);
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {

		if (world.getBlock(x, y - 2, z) == MysticalBlocks.mysticalBrick) {
			if (world.getBlock(x, y - 1, z) == MysticalBlocks.mysticalBrick) {
				if (world.getBlock(x + 2, y - 2, z + 2) == Blocks.anvil || world.getBlock(x + 2, y - 2, z + 2) == MysticalBlocks.mysticalInfuserActive || world.getBlock(x + 2, y - 2, z + 2) == MysticalBlocks.mysticalInfuserInactive) {
					RenderParticles.spawnParticle("fireForge", x + 1, y, z + 1, 0.1, -0.1, 0.1);

				} else if (world.getBlock(x - 2, y - 2, z - 2) == Blocks.anvil || world.getBlock(x - 2, y - 2, z - 2) == MysticalBlocks.mysticalInfuserActive || world.getBlock(x - 2, y - 2, z - 2) == MysticalBlocks.mysticalInfuserInactive) {
					RenderParticles.spawnParticle("fireForge", x, y, z, -0.1, -0.1, -0.1);
				} else if (world.getBlock(x - 2, y - 2, z + 2) == Blocks.anvil || world.getBlock(x - 2, y - 2, z + 2) == MysticalBlocks.mysticalInfuserActive || world.getBlock(x - 2, y - 2, z + 2) == MysticalBlocks.mysticalInfuserInactive) {
					RenderParticles.spawnParticle("fireForge", x, y, z + 1, -0.1, -0.1, 0.1);
				} else if (world.getBlock(x + 2, y - 2, z - 2) == Blocks.anvil || world.getBlock(x + 2, y - 2, z - 2) == MysticalBlocks.mysticalInfuserActive || world.getBlock(x + 2, y - 2, z - 2) == MysticalBlocks.mysticalInfuserInactive) {
					RenderParticles.spawnParticle("fireForge", x + 1, y, z, 0.1, -0.1, -0.1);
				} else {
					RenderParticles.spawnParticle("fireRitual", x + 0.5, y + 1, z + 0.5, 0.0, +0.1, 0.0);
				}
			}
		} else {
			RenderParticles.spawnParticle("fireRitual", x + 0.5, y + 1, z + 0.5, 0.0, +0.1, 0.0);
		}

	}

}
