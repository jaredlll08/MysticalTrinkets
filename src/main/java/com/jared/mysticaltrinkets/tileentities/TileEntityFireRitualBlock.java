package com.jared.mysticaltrinkets.tileentities;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

import com.jared.mysticaltrinkets.blocks.MysticalBlocks;

public class TileEntityFireRitualBlock extends TileEntity {

	public int timer;
	public int activeTimer;

	public int fireBuffer = 512;

	public int getFireBuffer() {
		return fireBuffer;
	}

	public void setFireBuffer(int fireBuffer) {
		this.fireBuffer = fireBuffer;
	}

	public TileEntityFireRitualBlock() {
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

			if (getFireBuffer() == 0) {
				worldObj.setBlock(xCoord, yCoord, zCoord, MysticalBlocks.ritualBlock);
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
		nbt.setInteger("fireBuffer", fireBuffer);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		this.timer = nbt.getInteger("timer");
		this.activeTimer = nbt.getInteger("ritualTimer");
		this.fireBuffer = nbt.getInteger("fireBuffer");
	}

}
