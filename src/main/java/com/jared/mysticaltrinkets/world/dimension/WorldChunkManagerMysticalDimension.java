package com.jared.mysticaltrinkets.world.dimension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeCache;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldChunkManagerMysticalDimension extends WorldChunkManager {

	private BiomeCache mBiomeCache;
	private List biomesToSpawn;
	private GenLayer myGenBiomes;
	private GenLayer myBiomeIndexLayer;

	protected WorldChunkManagerMysticalDimension() {
		this.mBiomeCache = new BiomeCache(this);
		this.biomesToSpawn = new ArrayList();
		this.biomesToSpawn.add(GenLayerBiomesMysticalTrinkets.mystical);
	}

	public WorldChunkManagerMysticalDimension(long par1, float par2, float par3) {
		this();
		GenLayer[] agenlayer = GenLayerMysticalTrinkets.makeTheWorld(par1);
		this.myGenBiomes = agenlayer[0];
		this.myBiomeIndexLayer = agenlayer[1];
	}

	public WorldChunkManagerMysticalDimension(World par1World) {
		this(par1World.getSeed(), 0.5F, 0.5F);
	}

	@Override
	public List getBiomesToSpawnIn() {
		return this.biomesToSpawn;
	}

	@Override
	public BiomeGenBase getBiomeGenAt(int par1, int par2) {
		return this.mBiomeCache.getBiomeGenAt(par1, par2);
	}

	@Override
	public float[] getRainfall(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5) {
		IntCache.resetIntCache();

		if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
			par1ArrayOfFloat = new float[par4 * par5];
		}

		int[] aint = this.myBiomeIndexLayer.getInts(par2, par3, par4, par5);

		for (int i1 = 0; i1 < par4 * par5; ++i1) {
			float f = BiomeGenBase.getBiomeGenArray()[aint[i1]].getIntRainfall() / 65536.0F;

			if (f > 1.0F) {
				f = 1.0F;
			}

			par1ArrayOfFloat[i1] = f;
		}
		return par1ArrayOfFloat;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public float getTemperatureAtHeight(float par1, int par2) {
		return 0.0F;
	}

	public float[] getTemperatures(float[] par1ArrayOfFloat, int par2, int par3, int par4, int par5) {

		if (par1ArrayOfFloat == null || par1ArrayOfFloat.length < par4 * par5) {
			par1ArrayOfFloat = new float[par4 * par5];
		}

		Arrays.fill(par1ArrayOfFloat, 0, par4 * par5, 0.5F);
		return par1ArrayOfFloat;
	}

	@Override
	public BiomeGenBase[] getBiomesForGeneration(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
		IntCache.resetIntCache();

		if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
			par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
		}

		int[] aint = this.myGenBiomes.getInts(par2, par3, par4, par5);

		for (int i1 = 0; i1 < par4 * par5; ++i1) {
			par1ArrayOfBiomeGenBase[i1] = BiomeGenBase.getBiomeGenArray()[aint[i1]];
		}

		return par1ArrayOfBiomeGenBase;
	}

	@Override
	public BiomeGenBase[] loadBlockGeneratorData(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
		return this.getBiomeGenAt(par1ArrayOfBiomeGenBase, par2, par3, par4, par5, true);
	}

	@Override
	public BiomeGenBase[] getBiomeGenAt(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5, boolean par6) {
		IntCache.resetIntCache();

		if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5) {
			par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
		}

		if (par6 && par4 == 16 && par5 == 16 && (par2 & 15) == 0 && (par3 & 15) == 0) {
			BiomeGenBase[] abiomegenbase1 = this.mBiomeCache.getCachedBiomes(par2, par3);
			System.arraycopy(abiomegenbase1, 0, par1ArrayOfBiomeGenBase, 0, par4 * par5);
			return par1ArrayOfBiomeGenBase;
		} else {
			int[] aint = this.myBiomeIndexLayer.getInts(par2, par3, par4, par5);

			for (int i1 = 0; i1 < par4 * par5; ++i1) {
				par1ArrayOfBiomeGenBase[i1] = BiomeGenBase.getBiomeGenArray()[aint[i1]];
			}

			return par1ArrayOfBiomeGenBase;
		}
	}

	@Override
	public boolean areBiomesViable(int par1, int par2, int par3, List par4List) {
		IntCache.resetIntCache();
		int l = par1 - par3 >> 2;
		int i1 = par2 - par3 >> 2;
		int j1 = par1 + par3 >> 2;
		int k1 = par2 + par3 >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.myGenBiomes.getInts(l, i1, l1, i2);

		for (int j2 = 0; j2 < l1 * i2; ++j2) {
			BiomeGenBase biomegenbase = BiomeGenBase.getBiomeGenArray()[aint[j2]];

			if (!par4List.contains(biomegenbase)) {
				return false;
			}
		}

		return true;
	}

	@Override
	public ChunkPosition findBiomePosition(int par1, int par2, int par3, List par4List, Random par5Random) {
		IntCache.resetIntCache();
		int l = par1 - par3 >> 2;
		int i1 = par2 - par3 >> 2;
		int j1 = par1 + par3 >> 2;
		int k1 = par2 + par3 >> 2;
		int l1 = j1 - l + 1;
		int i2 = k1 - i1 + 1;
		int[] aint = this.myGenBiomes.getInts(l, i1, l1, i2);
		ChunkPosition chunkposition = null;
		int j2 = 0;

		for (int k2 = 0; k2 < l1 * i2; ++k2) {
			int l2 = l + k2 % l1 << 2;
			int i3 = i1 + k2 / l1 << 2;
			BiomeGenBase biomegenbase = BiomeGenBase.getBiomeGenArray()[aint[k2]];

			if (par4List.contains(biomegenbase) && (chunkposition == null || par5Random.nextInt(j2 + 1) == 0)) {
				chunkposition = new ChunkPosition(l2, 0, i3);
				++j2;
			}
		}

		return chunkposition;
	}

	@Override
	public void cleanupCache() {
		this.mBiomeCache.cleanupCache();
	}

	// public GenLayer[] getModdedBiomeGenerators(WorldType worldType, long
	// seed, GenLayer[] original)
	// {
	// WorldTypeEvent.InitBiomeGens event = new
	// WorldTypeEvent.InitBiomeGens(worldType, seed, original);
	//
	// }
}
