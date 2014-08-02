package com.jared.mysticaltrinkets.world.dimension;

import net.minecraft.entity.EntityList;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

import com.jared.mysticaltrinkets.config.ConfigInfo;

public class GenLayerBiomesMysticalTrinkets extends GenLayer {

	public static BiomeGenBase mystical;
	protected BiomeGenBase[] allowedBiomes = { this.mystical };
	private String name;

	public GenLayerBiomesMysticalTrinkets(long seed, GenLayer genlayer) {
		super(seed);
		this.parent = genlayer;
	}

	public static void Biomes() {
		mystical = new BiomeGenMysticalTrinkets(getBiomeId()).setBiomeName("Mystical Plains").setDisableRain();
		// SkyRegistry.addBiome(getBiomeId());
	}

	public GenLayerBiomesMysticalTrinkets(long seed) {
		super(seed);
	}

	public static int getBiomeId() {
		do
			ConfigInfo.mysticalBiomeID += 1;
		while (EntityList.getStringFromID(ConfigInfo.mysticalBiomeID) != null);
		return ConfigInfo.mysticalBiomeID;
	}

	@Override
	public int[] getInts(int par1, int par2, int par3, int par4) {
		int[] dest = IntCache.getIntCache(par3 * par4);

		for (int i1 = 0; i1 < par4; i1++) {
			for (int j1 = 0; j1 < par3; j1++) {
				this.initChunkSeed(par1 + j1, par2 + i1);
				dest[j1 + i1 * par3] = this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
				// this.initChunkSeed(j1 + x, i1 + z);
				// dest[(j1 + i1 * width)] =
				// this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
			}
			// if(par1 > -par3 && par1 <= 0 && par2 > -par4 && par2 <= 0)
			// {
			// dest[-par1 + par2 * par3] =
			// this.allowedBiomes[nextInt(this.allowedBiomes.length)].biomeID;
			// }
		}
		return dest;
	}
}