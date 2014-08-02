package com.jared.mysticaltrinkets.blocks.ritualblocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.jared.mysticaltrinkets.blocks.MysticalBlocks;
import com.jared.mysticaltrinkets.client.render.RenderParticles;
import com.jared.mysticaltrinkets.config.ConfigInfo;
import com.jared.mysticaltrinkets.tileentities.TileEntityRitual;

public class BlockRitualBlock extends BlockContainer {

	public static ItemStack currentPlayerItem = null;

	public BlockRitualBlock() {
		super(Material.anvil);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntityRitual();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		world.getTileEntity(x, y, z);
		TileEntityRitual tile = (TileEntityRitual) world.getTileEntity(x, y, z);
		currentPlayerItem = player.getHeldItem();
		if (currentPlayerItem != null && currentPlayerItem.getItem() == Items.blaze_rod) {
			if (world.provider.isHellWorld) {
				if (world.getBlock(x, y - 1, z) == Blocks.lava || world.getBlock(x, y - 1, z) == Blocks.flowing_lava) {
					if (world.getBlock(x - 1, y, z) == Blocks.lava || world.getBlock(x - 1, y, z) == Blocks.flowing_lava) {
						if (world.getBlock(x + 1, y, z) == Blocks.lava || world.getBlock(x + 1, y, z) == Blocks.flowing_lava) {
							if (world.getBlock(x, y, z - 1) == Blocks.lava || world.getBlock(x, y, z - 1) == Blocks.flowing_lava) {
								if (world.getBlock(x, y, z + 1) == Blocks.lava || world.getBlock(x, y, z + 1) == Blocks.flowing_lava) {
									tile.setCurrentItem(new ItemStack(Items.blaze_rod));
									player.inventory.consumeInventoryItem(currentPlayerItem.getItem());
								}
							}
						}

					}
				}
			}
		}

		if (currentPlayerItem != null && currentPlayerItem.getItem() == Items.fish) {
			if (world.getBlock(x, y - 1, z) == Blocks.water || world.getBlock(x, y - 1, z) == Blocks.flowing_water) {
				if (world.getBlock(x - 1, y, z) == Blocks.water || world.getBlock(x - 1, y, z) == Blocks.flowing_water) {
					if (world.getBlock(x + 1, y, z) == Blocks.water || world.getBlock(x + 1, y, z) == Blocks.flowing_water) {
						if (world.getBlock(x, y, z - 1) == Blocks.water || world.getBlock(x, y, z - 1) == Blocks.flowing_water) {
							if (world.getBlock(x, y, z + 1) == Blocks.water || world.getBlock(x, y, z + 1) == Blocks.flowing_water) {
								tile.setCurrentItem(new ItemStack(Items.fish));
								player.inventory.consumeInventoryItem(Items.fish);
							}
						}
					}
				}
			}
		}
		if (y >= ConfigInfo.airRitualHight) {
			if (currentPlayerItem != null && currentPlayerItem.getItem() == Items.glowstone_dust) {
				if (world.getBlock(x + 2, y + 2, z + 2) == Blocks.glass) {
					if (world.getBlock(x - 2, y + 2, z - 2) == Blocks.glass) {
						if (world.getBlock(x + 2, y + 2, z - 2) == Blocks.glass) {
							if (world.getBlock(x - 2, y + 2, z - 2) == Blocks.glass) {
								tile.setCurrentItem(new ItemStack(Items.glowstone_dust));
								player.inventory.consumeInventoryItem(Items.glowstone_dust);
							}
						}
					}
				}
			}
		}

		return false;
	}

	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random random) {
		world.getTileEntity(x, y, z);
		TileEntityRitual tile = (TileEntityRitual) world.getTileEntity(x, y, z);
		if (world.provider.isHellWorld) {
			if (world.getBlock(x, y - 1, z) == Blocks.lava || world.getBlock(x, y - 1, z) == Blocks.flowing_lava) {
				if (world.getBlock(x - 1, y, z) == Blocks.lava || world.getBlock(x - 1, y, z) == Blocks.flowing_lava) {
					if (world.getBlock(x + 1, y, z) == Blocks.lava || world.getBlock(x + 1, y, z) == Blocks.flowing_lava) {
						if (world.getBlock(x, y, z - 1) == Blocks.lava || world.getBlock(x, y, z - 1) == Blocks.flowing_lava) {
							if (world.getBlock(x, y, z + 1) == Blocks.lava || world.getBlock(x, y, z + 1) == Blocks.flowing_lava) {
								if (random.nextInt(15) == 0) {
									RenderParticles.spawnParticle("blazerod", x + 0.5, y + 1.5, z + 0.5, 0, 0, 0);
								}
								RenderParticles.spawnParticle("ritual", x + 0.5, y + 1, z + 0.5, +2, 2, -2);
								RenderParticles.spawnParticle("ritual", x + 0.5, y + 1, z + 0.5, -2, 2, +2);
								RenderParticles.spawnParticle("ritual", x + 0.5, y + 1, z + 0.5, +2, 2, +2);
								RenderParticles.spawnParticle("ritual", x + 0.5, y + 1, z + 0.5, -2, 2, -2);

							}

						}
					}
				}
			}
		}

		if (y >= ConfigInfo.airRitualHight) {

			if (world.getBlock(x + 2, y, z + 2) == MysticalBlocks.mysticalBrick) {
				if (world.getBlock(x - 2, y, z - 2) == MysticalBlocks.mysticalBrick) {
					if (world.getBlock(x - 2, y, z + 2) == MysticalBlocks.mysticalBrick) {
						if (world.getBlock(x + 2, y, z - 2) == MysticalBlocks.mysticalBrick) {

							if (world.getBlock(x + 2, y + 1, z - 2) == MysticalBlocks.mysticalBrick) {
								if (world.getBlock(x - 2, y + 1, z + 2) == MysticalBlocks.mysticalBrick) {
									if (world.getBlock(x - 2, y + 1, z - 2) == MysticalBlocks.mysticalBrick) {
										if (world.getBlock(x + 2, y + 1, z + 2) == MysticalBlocks.mysticalBrick) {

											if (world.getBlock(x + 2, y + 2, z - 2) == Blocks.glass) {
												if (world.getBlock(x - 2, y + 2, z + 2) == Blocks.glass) {
													if (world.getBlock(x - 2, y + 2, z - 2) == Blocks.glass) {
														if (world.getBlock(x + 2, y + 2, z + 2) == Blocks.glass) {

															if (random.nextInt(15) == 0) {
																RenderParticles.spawnParticle("glowstone", x + 0.5, y + 1.5, z + 0.5, 0, 0, 0);
															}
															RenderParticles.spawnParticle("activeRitual", x + 0.5, y + 1, z + 0.5, +2, 2, -2);
															RenderParticles.spawnParticle("activeRitual", x + 0.5, y + 1, z + 0.5, -2, 2, +2);
															RenderParticles.spawnParticle("activeRitual", x + 0.5, y + 1, z + 0.5, +2, 2, +2);
															RenderParticles.spawnParticle("activeRitual", x + 0.5, y + 1, z + 0.5, -2, 2, -2);
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

		if (world.getBlock(x, y - 1, z) == Blocks.water || world.getBlock(x, y - 1, z) == Blocks.flowing_water) {
			if (world.getBlock(x - 1, y, z) == Blocks.water || world.getBlock(x - 1, y, z) == Blocks.flowing_water) {
				if (world.getBlock(x + 1, y, z) == Blocks.water || world.getBlock(x + 1, y, z) == Blocks.flowing_water) {
					if (world.getBlock(x, y, z - 1) == Blocks.water || world.getBlock(x, y, z - 1) == Blocks.flowing_water) {
						if (world.getBlock(x, y, z + 1) == Blocks.water || world.getBlock(x, y, z + 1) == Blocks.flowing_water) {
							if (random.nextInt(15) == 0) {
								RenderParticles.spawnParticle("fish", x + 0.5, y + 1.5, z + 0.5, 0, 0, 0);
							}
							RenderParticles.spawnParticle("activeRitual", x + 0.5, y + 1, z + 0.5, +2, 2, -2);
							RenderParticles.spawnParticle("activeRitual", x + 0.5, y + 1, z + 0.5, -2, 2, +2);
							RenderParticles.spawnParticle("activeRitual", x + 0.5, y + 1, z + 0.5, +2, 2, +2);
							RenderParticles.spawnParticle("activeRitual", x + 0.5, y + 1, z + 0.5, -2, 2, -2);
						}

					}
				}
			}
		}

	}

}
