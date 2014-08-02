package com.jared.mysticaltrinkets.tileentities;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.jared.mysticaltrinkets.blocks.MysticalBlocks;

public class TileEntityMysticalInfuser extends TileEntity {

	public int timer;
	public int activeTimer;
	public ItemStack currentItem;

	public int mysticalBuffer = 0;
	public int fireBuffer = 0;
	public int waterBuffer = 0;
	public int natureBuffer = 0;
	public int airBuffer = 0;
	public int powerCap = 64;

	public int internalMysticalPower = 0;
	public int internalFirePower = 0;
	public int internalWaterPower = 0;
	public int internalAirPower = 0;
	public int internalNaturePower = 0;

	public int getPowerCap() {
		return powerCap;
	}

	public void setPowerCap(int powerCap) {
		this.powerCap = powerCap;
	}

	public int getWaterBuffer() {
		return waterBuffer;
	}

	public void setWaterBuffer(int Buffer) {

		this.waterBuffer = Buffer;

	}

	public int getNatureBuffer() {
		return natureBuffer;
	}

	public void setNatureBuffer(int Buffer) {

		this.natureBuffer = Buffer;

	}

	public int getAirBuffer() {
		return airBuffer;
	}

	public void setAirBuffer(int Buffer) {

		this.airBuffer = Buffer;

	}

	public int getFireBuffer() {
		return fireBuffer;
	}

	public void setFireBuffer(int Buffer) {

		this.fireBuffer = Buffer;

	}

	public int getMysticalBuffer() {
		return mysticalBuffer;
	}

	public void setMysticalBuffer(int Buffer) {

		this.mysticalBuffer = Buffer;

	}

	public ItemStack getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(ItemStack currentItem) {
		this.currentItem = currentItem;
	}

	public TileEntityMysticalInfuser() {
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

		if (worldObj.provider.dimensionId == 29) {
			setPowerCap(640);
			if (!worldObj.isRemote) {

				if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2, MysticalBlocks.burntRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord + 2, MysticalBlocks.burntRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2, MysticalBlocks.burntRitualBlock) || checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2, MysticalBlocks.burntRitualBlock)) {
					if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2, MysticalBlocks.airRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord + 2, MysticalBlocks.airRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2, MysticalBlocks.airRitualBlock) || checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2, MysticalBlocks.airRitualBlock)) {
						if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2, MysticalBlocks.natureRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord + 2, MysticalBlocks.natureRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2, MysticalBlocks.natureRitualBlock) || checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2, MysticalBlocks.natureRitualBlock)) {
							if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2, MysticalBlocks.waterRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord + 2, MysticalBlocks.waterRitualBlock) || checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2, MysticalBlocks.waterRitualBlock) || checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2, MysticalBlocks.waterRitualBlock)) {
								if (activeTimer == 0) {
									activeTimer = 20;
									if (getFireBuffer() < powerCap)
										if (internalFirePower == 10) {
											setFireBuffer(getFireBuffer() + 5);
											internalFirePower = 0;
										} else {
											internalFirePower++;
										}
									if (getMysticalBuffer() < powerCap)
										if (internalMysticalPower == 10) {
											setMysticalBuffer(getMysticalBuffer() + 5);
											internalMysticalPower = 0;
										} else {
											internalMysticalPower++;
										}

									if (getWaterBuffer() < powerCap)
										if (internalWaterPower == 10) {
											setWaterBuffer(getWaterBuffer() + 5);
											internalWaterPower = 0;
											
										} else {
											internalWaterPower++;
										}

									if (getNatureBuffer() < powerCap)
										if (internalNaturePower == 10) {
											setNatureBuffer(getNatureBuffer() + 5);
											internalNaturePower = 0;
										} else {
											internalNaturePower++;
										}

									if (getAirBuffer() < powerCap)
										if (internalAirPower == 10) {
											setAirBuffer(getAirBuffer() + 5);
											internalAirPower=0;
										} else {
											internalAirPower++;
										}

								} else {
									activeTimer--;
								}
							}
						}
					}
				}
			}

		}

		// ItemStack heldItem = currentItem;

		// if (heldItem != null && heldItem.getItem() ==
		// Item.getItemFromBlock(Blocks.anvil)) {
		// if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2,
		// MysticalBlocks.burntRitualBlock) || checkForBlock(xCoord + 2, yCoord
		// + 2, zCoord + 2, MysticalBlocks.burntRitualBlock) ||
		// checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2,
		// MysticalBlocks.burntRitualBlock) || checkForBlock(xCoord - 2, yCoord
		// + 2, zCoord + 2, MysticalBlocks.burntRitualBlock)) {
		// if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2,
		// MysticalBlocks.airRitualBlock) || checkForBlock(xCoord + 2, yCoord +
		// 2, zCoord + 2, MysticalBlocks.airRitualBlock) || checkForBlock(xCoord
		// + 2, yCoord + 2, zCoord - 2, MysticalBlocks.airRitualBlock) ||
		// checkForBlock(xCoord - 2, yCoord + 2, zCoord + 2,
		// MysticalBlocks.airRitualBlock)) {
		// if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2,
		// MysticalBlocks.natureRitualBlock) || checkForBlock(xCoord + 2, yCoord
		// + 2, zCoord + 2, MysticalBlocks.natureRitualBlock) ||
		// checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2,
		// MysticalBlocks.natureRitualBlock) || checkForBlock(xCoord - 2, yCoord
		// + 2, zCoord + 2, MysticalBlocks.natureRitualBlock)) {
		// if (checkForBlock(xCoord - 2, yCoord + 2, zCoord - 2,
		// MysticalBlocks.waterRitualBlock) || checkForBlock(xCoord + 2, yCoord
		// + 2, zCoord + 2, MysticalBlocks.waterRitualBlock) ||
		// checkForBlock(xCoord + 2, yCoord + 2, zCoord - 2,
		// MysticalBlocks.waterRitualBlock) || checkForBlock(xCoord - 2, yCoord
		// + 2, zCoord + 2, MysticalBlocks.waterRitualBlock)) {
		// if (activeTimer == 0) {
		//
		// activeTimer = 100;
		// } else {
		// activeTimer--;
		// }
		// }
		// }
		// }
		// }
		//
		//
		//
		// }

		timer = 1;
		if (!checkForBlock(xCoord - 2, yCoord, zCoord - 2, MysticalBlocks.mysticalBrick)) {
			worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.mysticalInfuserInactive);
		} else if (!checkForBlock(xCoord + 2, yCoord, zCoord + 2, MysticalBlocks.mysticalBrick)) {
			worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.mysticalInfuserInactive);
		} else if (!checkForBlock(xCoord + 2, yCoord, zCoord - 2, MysticalBlocks.mysticalBrick)) {
			worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.mysticalInfuserInactive);
		} else if (!checkForBlock(xCoord - 2, yCoord, zCoord + 2, MysticalBlocks.mysticalBrick)) {
			worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.mysticalInfuserInactive);
		} else if (!checkForBlock(xCoord - 2, yCoord + 1, zCoord - 2, MysticalBlocks.mysticalBrick)) {
			worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.mysticalInfuserInactive);
		} else if (!checkForBlock(xCoord + 2, yCoord + 1, zCoord + 2, MysticalBlocks.mysticalBrick)) {
			worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.mysticalInfuserInactive);
		} else if (!checkForBlock(xCoord + 2, yCoord + 1, zCoord - 2, MysticalBlocks.mysticalBrick)) {
			worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.mysticalInfuserInactive);
		} else if (!checkForBlock(xCoord - 2, yCoord + 1, zCoord + 2, MysticalBlocks.mysticalBrick)) {
			worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.mysticalInfuserInactive);
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

		nbt.setInteger("mysticalBuffer", mysticalBuffer);

		nbt.setInteger("airBuffer", airBuffer);
		nbt.setInteger("fireBuffer", fireBuffer);
		nbt.setInteger("waterBuffer", waterBuffer);
		nbt.setInteger("natureBuffer", natureBuffer);

	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.timer = nbt.getInteger("timer");
		this.activeTimer = nbt.getInteger("ritualTimer");
		this.mysticalBuffer = nbt.getInteger("mysticalBuffer");

		this.airBuffer = nbt.getInteger("airBuffer");
		this.fireBuffer = nbt.getInteger("fireBuffer");
		this.waterBuffer = nbt.getInteger("waterBuffer");
		this.natureBuffer = nbt.getInteger("natureBuffer");

	}

}
