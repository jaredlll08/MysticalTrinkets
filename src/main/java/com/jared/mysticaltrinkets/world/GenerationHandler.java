package com.jared.mysticaltrinkets.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.jared.mysticaltrinkets.blocks.MysticalBlocks;
import com.jared.mysticaltrinkets.config.ConfigInfo;
import com.jared.mysticaltrinkets.world.tree.WorldGenOakTree;

import cpw.mods.fml.common.IWorldGenerator;

public class GenerationHandler implements IWorldGenerator {
	public boolean gen = true;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch (world.provider.dimensionId) {
		case -1:
			generateNether(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 0:
			generateSurface(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 1:
			generateEnd(world, random, chunkX * 16, chunkZ * 16);
			break;
		case 29:
			generateMystical(world, random, chunkX * 16, chunkZ * 16);
			break;
		}
	}

	private void generateMystical(World world, Random rand, int chunkX, int chunkZ) {
		for (int k = 0; k < ConfigInfo.mysticalOreGenChancePerChunk; k++) {
			int oreXCoord = chunkX + rand.nextInt(16);
			int oreYCoord = rand.nextInt(ConfigInfo.mysticalOreGenHeight);
			int oreZCoord = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(MysticalBlocks.mysticalOre, ConfigInfo.MysticalOreGenClusterSize)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
		}
		for (int k = 0; k < ConfigInfo.fireShardOreGenChancePerChunk; k++) {
			int oreXCoord = chunkX + rand.nextInt(16);
			int oreYCoord = rand.nextInt(ConfigInfo.fireShardOreGenHeight);
			int oreZCoord = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(MysticalBlocks.burntShardOre, ConfigInfo.fireShardOreGenClusterSize)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
		}
		for (int k = 0; k < ConfigInfo.floatingShardOreGenChancePerChunk; k++) {
			int oreXCoord = chunkX + rand.nextInt(16);
			int oreYCoord = rand.nextInt(ConfigInfo.floatingShardOreGenHeight);
			int oreZCoord = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(MysticalBlocks.floatingShardOre, ConfigInfo.floatingShardOreGenClusterSize)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
		}
		for (int k = 0; k < ConfigInfo.natureShardOreGenChancePerChunk; k++) {
			int oreXCoord = chunkX + rand.nextInt(16);
			int oreYCoord = rand.nextInt(ConfigInfo.natureShardOreGenHeight);
			int oreZCoord = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(MysticalBlocks.natureShardOre, ConfigInfo.natureShardOreGenClusterSize)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
		}
		for (int k = 0; k < ConfigInfo.waterShardOreGenChancePerChunk; k++) {
			int oreXCoord = chunkX + rand.nextInt(16);
			int oreYCoord = rand.nextInt(ConfigInfo.waterShardOreGenHeight);
			int oreZCoord = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(MysticalBlocks.waterShardOre, ConfigInfo.waterShardOreGenClusterSize)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
		}
		for (int i = 0; i < 2; i++) {
			int Xcoord1 = chunkX + rand.nextInt(16);
			int Ycoord1 = rand.nextInt(90);
			int Zcoord1 = chunkZ + rand.nextInt(16);
			(new WorldGenOakTree(false, 6, 0, 0, false)).generate(world, rand, Xcoord1, Ycoord1, Zcoord1);
		}
		int Xcoord1 = chunkX + rand.nextInt(16);
		int Ycoord1 = rand.nextInt(80);
		int Zcoord1 = chunkZ + rand.nextInt(16);
		String biome = world.getBiomeGenForCoords(Xcoord1, Zcoord1).biomeName;
		if (!biome.toLowerCase().startsWith("ocean") || !biome.toLowerCase().startsWith("river")) {

			if (biome.toLowerCase().startsWith("mystical"))
				if (rand.nextInt(50) == 1) {
					while (world.isAirBlock(Xcoord1, Ycoord1, Zcoord1)) {
						Ycoord1--;
					}
					while (!world.isAirBlock(Xcoord1, Ycoord1 + 1, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 2, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 3, Zcoord1)) {
						Ycoord1++;
					}
					(new WorldGenMineShaft()).generate(world, rand, Xcoord1, Ycoord1, Zcoord1);
				}

		}
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) {
		for (int k = 0; k < ConfigInfo.mysticalOreGenChancePerChunk; k++) {
			int oreXCoord = chunkX + rand.nextInt(16);
			int oreYCoord = rand.nextInt(ConfigInfo.mysticalOreGenHeight);
			int oreZCoord = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(MysticalBlocks.mysticalOre, ConfigInfo.MysticalOreGenClusterSize)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
		}
		for (int k = 0; k < ConfigInfo.fireShardOreGenChancePerChunk; k++) {
			int oreXCoord = chunkX + rand.nextInt(16);
			int oreYCoord = rand.nextInt(ConfigInfo.fireShardOreGenHeight);
			int oreZCoord = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(MysticalBlocks.burntShardOre, ConfigInfo.fireShardOreGenClusterSize)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
		}
		for (int k = 0; k < ConfigInfo.floatingShardOreGenChancePerChunk; k++) {
			int oreXCoord = chunkX + rand.nextInt(16);
			int oreYCoord = rand.nextInt(ConfigInfo.floatingShardOreGenHeight);
			int oreZCoord = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(MysticalBlocks.floatingShardOre, ConfigInfo.floatingShardOreGenClusterSize)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
		}
		for (int k = 0; k < ConfigInfo.natureShardOreGenChancePerChunk; k++) {
			int oreXCoord = chunkX + rand.nextInt(16);
			int oreYCoord = rand.nextInt(ConfigInfo.natureShardOreGenHeight);
			int oreZCoord = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(MysticalBlocks.natureShardOre, ConfigInfo.natureShardOreGenClusterSize)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
		}
		for (int k = 0; k < ConfigInfo.waterShardOreGenChancePerChunk; k++) {
			int oreXCoord = chunkX + rand.nextInt(16);
			int oreYCoord = rand.nextInt(ConfigInfo.waterShardOreGenHeight);
			int oreZCoord = chunkZ + rand.nextInt(16);
			(new WorldGenMinable(MysticalBlocks.waterShardOre, ConfigInfo.waterShardOreGenClusterSize)).generate(world, rand, oreXCoord, oreYCoord, oreZCoord);
		}
		for (int i = 0; i < 2; i++) {
			int Xcoord1 = chunkX + rand.nextInt(16);
			int Ycoord1 = rand.nextInt(90);
			int Zcoord1 = chunkZ + rand.nextInt(16);
			(new WorldGenOakTree(false, 6, 0, 0, false)).generate(world, rand, Xcoord1, Ycoord1, Zcoord1);
		}
		// int Xcoord1 = chunkX + rand.nextInt(16);
		// int Ycoord1 = rand.nextInt(90);
		// int Ycoord1 = rand.nextInt(80);
		// int Zcoord1 = chunkZ + rand.nextInt(16);
		//
		// if(world.canBlockSeeTheSky(Xcoord1, Ycoord1,
		// Zcoord1)&&world.getBlock(Xcoord1, Ycoord1, Zcoord1) == Blocks.grass){
		// new WorldGenMineShaft().generate(world, rand, 0, Ycoord1, 0);
		// }

		int Xcoord1 = chunkX + rand.nextInt(16);
		int Ycoord1 = rand.nextInt(80);
		int Zcoord1 = chunkZ + rand.nextInt(16);
		String biome = world.getBiomeGenForCoords(Xcoord1, Zcoord1).biomeName;
		if (!biome.toLowerCase().startsWith("ocean") || !biome.toLowerCase().startsWith("river")) {

			if (biome.toLowerCase().startsWith("mystical")) {

				if (rand.nextInt(15) == 1) {
					while (world.isAirBlock(Xcoord1, Ycoord1, Zcoord1)) {
						Ycoord1--;
					}
					while (!world.isAirBlock(Xcoord1, Ycoord1 + 1, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 2, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 3, Zcoord1)) {
						Ycoord1++;
					}
					(new WorldGenMineShaft()).generate(world, rand, Xcoord1, Ycoord1, Zcoord1);

				}
			} else {

				if (rand.nextInt(100) == 1) {
					while (world.isAirBlock(Xcoord1, Ycoord1, Zcoord1)) {
						Ycoord1--;
						
					}
					while (!world.isAirBlock(Xcoord1, Ycoord1 + 1, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 2, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 3, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 4, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 5, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 6, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 7, Zcoord1) && !world.isAirBlock(Xcoord1, Ycoord1 + 8, Zcoord1)) {
						Ycoord1++;
					}

					new WorldGenMineShaft().generate(world, rand, Xcoord1, Ycoord1, Zcoord1);
				}
			}
		} else{
			
		}
		
		

	}

	private void generateNether(World world, Random rand, int chunkX, int chunkZ) {
	}
}