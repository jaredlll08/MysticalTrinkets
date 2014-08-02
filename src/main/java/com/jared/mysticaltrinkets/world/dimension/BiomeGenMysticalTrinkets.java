package com.jared.mysticaltrinkets.world.dimension;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.jared.mysticaltrinkets.world.tree.WorldGenOakTree;

public class BiomeGenMysticalTrinkets extends BiomeGenBase {

	public BiomeGenMysticalTrinkets(int par1) {
		super(par1);

		this.topBlock = Blocks.mycelium;
		this.fillerBlock = Blocks.dirt;
		this.theBiomeDecorator.mushroomsPerChunk = 0;
		this.spawnableCaveCreatureList.clear();
		this.spawnableCreatureList.clear();
		this.spawnableMonsterList.clear();
		this.spawnableWaterCreatureList.clear();

	}

	public WorldGenerator getRandomWorldGenForTrees(Random random) {
		if (random.nextInt(50) == 0) {
			return new WorldGenOakTree(true);
		}

		return new WorldGenOakTree(false);
	}

}
