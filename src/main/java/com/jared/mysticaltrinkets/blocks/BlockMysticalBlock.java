package com.jared.mysticaltrinkets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.jared.mysticaltrinkets.tileentities.TileEntityMysticalBlock;

public class BlockMysticalBlock extends Block {

	protected BlockMysticalBlock() {
		super(Material.iron);
		this.setLightLevel(0.5F);
		this.setHardness(3.0F);
	}


	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		if (checkForBlock(world, x - 2, y, z - 2, MysticalBlocks.mysticalBrick)) {
			if (checkForBlock(world, x + 2, y, z + 2, MysticalBlocks.mysticalBrick)) {
				if (checkForBlock(world, x + 2, y, z - 2, MysticalBlocks.mysticalBrick)) {
					if (checkForBlock(world, x - 2, y, z + 2, MysticalBlocks.mysticalBrick)) {

						if (checkForBlock(world, x - 2, y + 1, z - 2, MysticalBlocks.mysticalBrick)) {
							if (checkForBlock(world, x + 2, y + 1, z + 2, MysticalBlocks.mysticalBrick)) {
								if (checkForBlock(world, x + 2, y + 1, z - 2, MysticalBlocks.mysticalBrick)) {
									if (checkForBlock(world, x - 2, y + 1, z + 2, MysticalBlocks.mysticalBrick)) {

										if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.burntRitualBlock) || checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.burntRitualBlock) || checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.burntRitualBlock) || checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.burntRitualBlock)) {
											if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.airRitualBlock) || checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.airRitualBlock) || checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.airRitualBlock) || checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.airRitualBlock)) {
												if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.natureRitualBlock) || checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.natureRitualBlock) || checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.natureRitualBlock) || checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.natureRitualBlock)) {
													if (checkForBlock(world, x - 2, y + 2, z - 2, MysticalBlocks.waterRitualBlock) || checkForBlock(world, x + 2, y + 2, z + 2, MysticalBlocks.waterRitualBlock) || checkForBlock(world, x + 2, y + 2, z - 2, MysticalBlocks.waterRitualBlock) || checkForBlock(world, x - 2, y + 2, z + 2, MysticalBlocks.waterRitualBlock)) {
														world.setBlock(x, y, z, MysticalBlocks.mysticalInfuserInactive);

													}
												}
											}
										}
									}
								}
							}

						}
					}
				}
			}
		}

	}

	public boolean checkForBlock(World world, int x, int y, int z, Block block) {
		if (world.getBlock(x, y, z) == block) {
			return true;
		} else {
			return false;
		}

	}
}