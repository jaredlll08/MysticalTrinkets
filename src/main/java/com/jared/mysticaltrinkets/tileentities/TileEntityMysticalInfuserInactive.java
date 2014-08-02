package com.jared.mysticaltrinkets.tileentities;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.jared.mysticaltrinkets.blocks.MysticalBlocks;

public class TileEntityMysticalInfuserInactive extends TileEntity {

	public int timer;
	public int activeTimer;

	public TileEntityMysticalInfuserInactive() {
		timer = 1;
		activeTimer = 100;
	}

	public int getRitualTimer() {
		return activeTimer;
	}

	public void setRitualTimer(int ritualTimer) {
		this.activeTimer = ritualTimer;
	}

	@Override
	public void updateEntity() {

		if (timer == 0 && !worldObj.isRemote) {
			timer = 1;

			if (checkForBlock(xCoord - 2, yCoord, zCoord - 2, MysticalBlocks.mysticalBrick)) {
				if (checkForBlock(xCoord + 2, yCoord, zCoord + 2, MysticalBlocks.mysticalBrick)) {
					if (checkForBlock(xCoord + 2, yCoord, zCoord - 2, MysticalBlocks.mysticalBrick)) {
						if (checkForBlock(xCoord - 2, yCoord, zCoord + 2, MysticalBlocks.mysticalBrick)) {

							if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2, MysticalBlocks.burntRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord + 2, MysticalBlocks.burntRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2, MysticalBlocks.burntRitualBlock) || checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2, MysticalBlocks.burntRitualBlock)) {
								if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2, MysticalBlocks.airRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord + 2, MysticalBlocks.airRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2, MysticalBlocks.airRitualBlock) || checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2, MysticalBlocks.airRitualBlock)) {
									if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2, MysticalBlocks.natureRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord + 2, MysticalBlocks.natureRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2, MysticalBlocks.natureRitualBlock) || checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2, MysticalBlocks.natureRitualBlock)) {
										if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2, MysticalBlocks.waterRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord + 2, MysticalBlocks.waterRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2, MysticalBlocks.waterRitualBlock) || checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2, MysticalBlocks.waterRitualBlock)) {
											if (activeTimer == 0) {
												worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.mysticalInfuserActive);

												activeTimer = 100;
											} else {
												activeTimer--;
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

		timer--;
	}

	public boolean checkForBlock(int x, int y, int z, Block block) {
		if (worldObj.getBlock(x, y, z) == block) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("timer", timer);
		nbt.setInteger("ritualTimer", activeTimer);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.timer = nbt.getInteger("timer");
		this.activeTimer = nbt.getInteger("ritualTimer");

	}

}
