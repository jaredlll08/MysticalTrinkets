package com.jared.mysticaltrinkets.tileentities;

import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityMysticalForgeActive extends TileEntity {

	public int timer;
	public int activeTimer;

	public TileEntityMysticalForgeActive() {
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
