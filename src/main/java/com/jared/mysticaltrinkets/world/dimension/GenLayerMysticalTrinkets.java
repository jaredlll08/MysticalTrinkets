package com.jared.mysticaltrinkets.world.dimension;

import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerVoronoiZoom;
import net.minecraft.world.gen.layer.GenLayerZoom;

public abstract class GenLayerMysticalTrinkets extends GenLayer {

	public GenLayerMysticalTrinkets(long par1) {
		super(par1);
	}

	public static GenLayer[] makeTheWorld(long seed) {
		GenLayer biomes = new GenLayerBiomesMysticalTrinkets(1L);
		biomes = new GenLayerZoom(2000L, biomes);
		biomes = new GenLayerZoom(2001L, biomes);
		biomes = new GenLayerZoom(2002L, biomes);
		biomes = new GenLayerZoom(2003L, biomes);
		biomes = new GenLayerZoom(2004L, biomes);

		GenLayer genlayervoronoizoom = new GenLayerVoronoiZoom(10L, biomes);

		biomes.initWorldGenSeed(seed);
		genlayervoronoizoom.initWorldGenSeed(seed);

		return new GenLayer[] { biomes, genlayervoronoizoom };
	}

}
