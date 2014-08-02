package com.jared.mysticaltrinkets.tileentities;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.jared.mysticaltrinkets.blocks.MysticalBlocks;

public class TileEntityRitual extends TileEntity {

	public int timer;
	public int ritualTimer;
	public ItemStack currentItem;

	public TileEntityRitual() {
		timer = 1;
		ritualTimer = 100;
	}

	public ItemStack getCurrentItem() {
		return currentItem;
	}

	public int getRitualTimer() {
		return ritualTimer;
	}

	public void setRitualTimer(int ritualTimer) {
		this.ritualTimer = ritualTimer;
	}

	public void setCurrentItem(ItemStack currentItem) {
		this.currentItem = currentItem;
	}

	@Override
	public void updateEntity() {
		ItemStack heldItem = currentItem;
		/* FIRE */
		if (timer == 0 && !worldObj.isRemote) {
			timer = 1;
			if (worldObj.provider.isHellWorld) {
				if (heldItem != null && heldItem.getItem() == Items.blaze_rod) {
					if (checkForBlock(xCoord, yCoord - 1, zCoord, Blocks.lava) || checkForBlock(xCoord, yCoord - 1, zCoord, Blocks.flowing_lava)) {
						if (checkForBlock(xCoord - 1, yCoord, zCoord, Blocks.lava) || checkForBlock(xCoord - 1, yCoord, zCoord, Blocks.flowing_lava)) {
							if (checkForBlock(xCoord + 1, yCoord, zCoord, Blocks.lava) || checkForBlock(xCoord + 1, yCoord, zCoord, Blocks.flowing_lava)) {
								if (checkForBlock(xCoord, yCoord, zCoord + 1, Blocks.lava) || checkForBlock(xCoord, yCoord, zCoord + 1, Blocks.flowing_lava)) {
									if (checkForBlock(xCoord, yCoord, zCoord - 1, Blocks.lava) || checkForBlock(xCoord, yCoord, zCoord - 1, Blocks.flowing_lava)) {
										worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.burntRitualBlock);

										worldObj.setBlock(xCoord, yCoord - 1, zCoord, Blocks.air);
										worldObj.setBlock(xCoord + 1, yCoord, zCoord, Blocks.air);
										worldObj.setBlock(xCoord - 1, yCoord, zCoord, Blocks.air);
										worldObj.setBlock(xCoord, yCoord, zCoord + 1, Blocks.air);
										worldObj.setBlock(xCoord, yCoord, zCoord - 1, Blocks.air);

									}

								}
							}
						}
					}
				}
			}

			/* NATURE */
			if (checkForBlock(xCoord + 2, yCoord + 2, zCoord + 2, MysticalBlocks.infusedOakLog)) {
				if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2, MysticalBlocks.infusedOakLog)) {
					if (checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2, MysticalBlocks.infusedOakLog)) {
						if (checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2, MysticalBlocks.infusedOakLog)) {

							if (checkForBlock(xCoord + 2, yCoord + 1, zCoord + 2, MysticalBlocks.mysticalBrick)) {
								if (checkForBlock(xCoord - 2, yCoord + 1, zCoord - 2, MysticalBlocks.mysticalBrick)) {
									if (checkForBlock(xCoord + 2, yCoord + 1, zCoord - 2, MysticalBlocks.mysticalBrick)) {
										if (checkForBlock(xCoord - 2, yCoord + 1, zCoord + 2, MysticalBlocks.mysticalBrick)) {

											if (checkForBlock(xCoord + 2, yCoord, zCoord + 2, MysticalBlocks.mysticalBrick)) {
												if (checkForBlock(xCoord - 2, yCoord, zCoord - 2, MysticalBlocks.mysticalBrick)) {
													if (checkForBlock(xCoord + 2, yCoord, zCoord - 2, MysticalBlocks.mysticalBrick)) {
														if (checkForBlock(xCoord - 2, yCoord, zCoord + 2, MysticalBlocks.mysticalBrick)) {

															if (ritualTimer == 0) {
																worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.natureRitualBlock);

																worldObj.setBlock(xCoord + 2, yCoord + 2, zCoord + 2, Blocks.air);
																worldObj.setBlock(xCoord - 2, yCoord + 2, zCoord - 2, Blocks.air);
																worldObj.setBlock(xCoord - 2, yCoord + 2, zCoord + 2, Blocks.air);
																worldObj.setBlock(xCoord + 2, yCoord + 2, zCoord - 2, Blocks.air);
																ritualTimer--;
															} else {
																ritualTimer--;
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

			/* AIR */

			if (heldItem != null && heldItem.getItem() == Items.glowstone_dust) {
				if (checkForBlock(xCoord + 2, yCoord + 2, zCoord + 2, Blocks.glass)) {
					if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2, Blocks.glass)) {
						if (checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2, Blocks.glass)) {
							if (checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2, Blocks.glass)) {

								if (checkForBlock(xCoord + 2, yCoord + 1, zCoord + 2, MysticalBlocks.mysticalBrick)) {
									if (checkForBlock(xCoord - 2, yCoord + 1, zCoord - 2, MysticalBlocks.mysticalBrick)) {
										if (checkForBlock(xCoord + 2, yCoord + 1, zCoord - 2, MysticalBlocks.mysticalBrick)) {
											if (checkForBlock(xCoord - 2, yCoord + 1, zCoord + 2, MysticalBlocks.mysticalBrick)) {

												if (checkForBlock(xCoord + 2, yCoord, zCoord + 2, MysticalBlocks.mysticalBrick)) {
													if (checkForBlock(xCoord - 2, yCoord, zCoord - 2, MysticalBlocks.mysticalBrick)) {
														if (checkForBlock(xCoord + 2, yCoord, zCoord - 2, MysticalBlocks.mysticalBrick)) {
															if (checkForBlock(xCoord - 2, yCoord, zCoord + 2, MysticalBlocks.mysticalBrick)) {

																if (ritualTimer == 0) {
																	worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.airRitualBlock);

																	worldObj.setBlock(xCoord + 2, yCoord + 2, zCoord + 2, Blocks.air);
																	worldObj.setBlock(xCoord - 2, yCoord + 2, zCoord - 2, Blocks.air);
																	worldObj.setBlock(xCoord - 2, yCoord + 2, zCoord + 2, Blocks.air);
																	worldObj.setBlock(xCoord + 2, yCoord + 2, zCoord - 2, Blocks.air);
																	ritualTimer--;
																} else {
																	ritualTimer--;
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
			}
			/* WATER */

			if (heldItem != null && heldItem.getItem() == Items.fish) {
				if (checkForBlock(xCoord + 1, yCoord, zCoord, Blocks.water) || checkForBlock(xCoord + 1, yCoord, zCoord, Blocks.flowing_water)) {
					if (checkForBlock(xCoord - 1, yCoord, zCoord, Blocks.water) || checkForBlock(xCoord - 1, yCoord, zCoord, Blocks.flowing_water)) {
						if (checkForBlock(xCoord, yCoord - 1, zCoord, Blocks.water) || checkForBlock(xCoord, yCoord - 1, zCoord, Blocks.flowing_water)) {
							if (checkForBlock(xCoord, yCoord, zCoord + 1, Blocks.water) || checkForBlock(xCoord, yCoord, zCoord + 1, Blocks.flowing_water)) {
								if (checkForBlock(xCoord, yCoord, zCoord - 1, Blocks.water) || checkForBlock(xCoord, yCoord, zCoord - 1, Blocks.flowing_water)) {

									if (ritualTimer == 0) {
										ritualTimer = 100;
										worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.waterRitualBlock);

										worldObj.setBlock(xCoord - 1, yCoord, zCoord, Blocks.air);
										worldObj.setBlock(xCoord + 1, yCoord, zCoord, Blocks.air);
										worldObj.setBlock(xCoord, yCoord - 1, zCoord, Blocks.air);
										worldObj.setBlock(xCoord, yCoord, zCoord + 1, Blocks.air);
										worldObj.setBlock(xCoord, yCoord, zCoord - 1, Blocks.air);
									} else {
										ritualTimer--;
									}
								}
							}
						}
					}
				}
			}
		}
		timer--;
	}

	public boolean checkForBlock(int x, int y, int z, Block block) {
		if (worldObj.getBlock(x, y, z) == block) {
			return true;
		} else {
			return false;
		}

	}

	public void registerRitual(World world, int x, int y, int z, Block cornerBlocks, Block newBlock, ItemStack itemstack, Item item) {
		if (!world.isRemote) {
			if (itemstack != null && itemstack.getItem() == item) {
				if (world.getBlock(x - 2, y + 2, z - 2) == cornerBlocks) {
					if (world.getBlock(x + 2, y + 2, z + 2) == cornerBlocks) {
						if (world.getBlock(x + 2, y + 2, z - 2) == cornerBlocks) {
							if (world.getBlock(x - 2, y + 2, z + 2) == cornerBlocks) {
								world.setBlock(x, y, z, newBlock);
							}
						}
					}
				}

			}
		}

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("timer", timer);
		nbt.setInteger("ritualTimer", ritualTimer);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.timer = nbt.getInteger("timer");
		this.ritualTimer = nbt.getInteger("ritualTimer");

	}

}
