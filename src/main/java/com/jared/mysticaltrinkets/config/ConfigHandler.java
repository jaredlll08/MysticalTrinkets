package com.jared.mysticaltrinkets.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler extends ConfigInfo {

	public static void init(File file) {
		Configuration config = new Configuration(file);

		config.load();

		String blocks = "DISABLE BLOCKS";
		String items = "DISABLE ITEMS";
		String recipeMode = "RECIPE MODE";
		String worldGen = "WORLD GEN";

		String trollItems = "TROLL ITEMS";

		airRitualHight = config.get("RITUAL CONFIG", "Air Ritual minimum hight", 128).getInt();
		render3DItems = config.get("RENDER", "Render all items as if they were tools", false).getBoolean(false);
		ConfigInfo.trollItems = config.get(trollItems, "Disable Troll Items", true).getBoolean(true);

		mysticalBiomeID = config.get("WORLD", "Mystical Biome ID", 150).getInt();

		mysticalOreGenChancePerChunk = config.get(worldGen, "Mystical Ore Generation: chance per chunk", 4).getInt();
		mysticalOreGenHeight = config.get(worldGen, "Mystical Ore Generation: height", 64).getInt();
		MysticalOreGenClusterSize = config.get(worldGen, "Mystical Ore Generation: cluster size", 3).getInt();

		fireShardOreGenChancePerChunk = config.get(worldGen, "Burnt Shard Ore Generation: chance per chunk", 4).getInt();
		fireShardOreGenHeight = config.get(worldGen, "Burnt Shard Ore Generation: height", 64).getInt();
		fireShardOreGenClusterSize = config.get(worldGen, "Burnt Shard Ore Generation: cluster size", 3).getInt();

		floatingShardOreGenChancePerChunk = config.get(worldGen, "Floating Shard Ore Generation: chance per chunk", 4).getInt();
		floatingShardOreGenHeight = config.get(worldGen, "Floating Shard Ore Generation: height", 128).getInt();
		floatingShardOreGenClusterSize = config.get(worldGen, "Floating Shard Ore Generation: cluster size", 3).getInt();

		waterShardOreGenChancePerChunk = config.get(worldGen, "Water Shard Ore Generation: chance per chunk", 4).getInt();
		waterShardOreGenHeight = config.get(worldGen, "Water Shard Ore Generation: height", 64).getInt();
		waterShardOreGenClusterSize = config.get(worldGen, "Water Shard Ore Generation: cluster size", 3).getInt();

		natureShardOreGenChancePerChunk = config.get(worldGen, "Nature Shard Ore Generation: chance per chunk", 4).getInt();
		natureShardOreGenHeight = config.get(worldGen, "Nature Shard Ore Generation: height", 64).getInt();
		natureShardOreGenClusterSize = config.get(worldGen, "Nature Shard Ore Generation: cluster size", 3).getInt();

		config.save();

	}
}
