package com.jared.mysticaltrinkets.world.dimension;

import net.minecraft.world.WorldProvider;
import net.minecraft.world.WorldType;
import net.minecraft.world.chunk.IChunkProvider;

public class WorldProviderMysticalDimension extends WorldProvider {

	public WorldType wt;

	@Override
	public void registerWorldChunkManager() {
		// this.worldChunkMgr = new WorldChunkManagerHell(SkyDimension.sky,
		// ConfigManager.dimensionID, ConfigManager.dimensionID);
		this.worldChunkMgr = new WorldChunkManagerMysticalDimension(worldObj.getSeed(), 0.5F, 0.5F);
		this.dimensionId = 29;

	}

	public int getSpawnFuzz() {
		return 0;
	}

	@Override
	public double getHorizon() {
		return 0.0D;

	}

	@Override
	public String getDimensionName() {
		return "Mystical Dimension";
	}

	@Override
	public boolean canRespawnHere() {
		return false;

	}

	@Override
	public float getCloudHeight() {
		return 0.5F;
	}

	@Override
	public IChunkProvider createChunkGenerator() {
		return new ChunkProviderMysticalDimension(worldObj, worldObj.getSeed(), false);
	}

	@Override
	public String getSaveFolder() {
		return "Mystical Dimension";
	}

}
