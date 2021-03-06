package com.jared.mysticaltrinkets.blocks;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.oredict.OreDictionary;

import com.jared.mysticaltrinkets.ModInfo;
import com.jared.mysticaltrinkets.blocks.flower.BlockFireFlower;
import com.jared.mysticaltrinkets.blocks.ores.BlockBurntShardOre;
import com.jared.mysticaltrinkets.blocks.ores.BlockFloatingShardOre;
import com.jared.mysticaltrinkets.blocks.ores.BlockMysticalOre;
import com.jared.mysticaltrinkets.blocks.ores.BlockNatureShardOre;
import com.jared.mysticaltrinkets.blocks.ores.BlockSoakedShardOre;
import com.jared.mysticaltrinkets.blocks.ritualblocks.BlockRitualBlock;
import com.jared.mysticaltrinkets.blocks.ritualblocks.BlockRitualBlockAir;
import com.jared.mysticaltrinkets.blocks.ritualblocks.BlockRitualBlockBurnt;
import com.jared.mysticaltrinkets.blocks.ritualblocks.BlockRitualBlockNature;
import com.jared.mysticaltrinkets.blocks.ritualblocks.BlockRitualWater;
import com.jared.mysticaltrinkets.blocks.trees.BlockInfusedOakFence;
import com.jared.mysticaltrinkets.blocks.trees.BlockInfusedOakLeaves;
import com.jared.mysticaltrinkets.blocks.trees.BlockInfusedOakLog;
import com.jared.mysticaltrinkets.blocks.trees.BlockInfusedOakPlank;
import com.jared.mysticaltrinkets.items.MysticalItems;
import com.jared.mysticaltrinkets.tileentities.TileEntityMysticalBlock;
import com.jared.mysticaltrinkets.tileentities.TileEntityMysticalInfuser;
import com.jared.mysticaltrinkets.tileentities.TileEntityMysticalInfuserInactive;
import com.jared.mysticaltrinkets.tileentities.TileEntityRitual;

import cpw.mods.fml.common.registry.GameRegistry;


public class MysticalBlocks {

	public static void init() {
		registerBlocks();
		registerTileEntities();
		registerOreDict();
	}

	public static Block mysticalOre = new BlockMysticalOre();
	public static Block mysticalBlock = new BlockMysticalBlock();

	public static Block ritualBlock = new BlockRitualBlock();
	public static Block burntRitualBlock = new BlockRitualBlockBurnt();
	public static Block waterRitualBlock = new BlockRitualWater();
	public static Block airRitualBlock = new BlockRitualBlockAir();
	public static Block natureRitualBlock = new BlockRitualBlockNature();

	public static Block mysticalBrick = new BlockMysticalBrick();

	public static Block mysticalInfuserInactive = new BlockMysticalInfuserInactive();
	public static Block mysticalInfuserActive = new BlockMysticalInfuser();

	public static Block infusedOakLog = new BlockInfusedOakLog();
	public static Block infusedOakLeaves = new BlockInfusedOakLeaves();
	public static Block infusedOakPlanks = new BlockInfusedOakPlank();
	public static Block infusedOakFence = new BlockInfusedOakFence(ModInfo.modid + ":Infused_Oak_Planks", Material.wood);

	public static Block burntShardOre = new BlockBurntShardOre();
	public static Block floatingShardOre = new BlockFloatingShardOre();
	public static Block natureShardOre = new BlockNatureShardOre();
	public static Block waterShardOre = new BlockSoakedShardOre();

	public static Block burntShardBlock = new BlockShardBlock(0);
	public static Block floatingShardBlock = new BlockShardBlock(1);
	public static Block natureShardBlock = new BlockShardBlock(2);
	public static Block waterShardBlock = new BlockShardBlock(3);

	public static Block burntGlass = new BlockShardGlass(0);
	public static Block floatingGlass = new BlockShardGlass(1);
	public static Block natureGlass = new BlockShardGlass(2);
	public static Block waterGlass = new BlockShardGlass(3);
	

	

	public static Block portal = new BlockPortal();

	public static Block fireFlower = new BlockFireFlower();

	private static void registerBlocks() {
		registerBlock(mysticalOre, "Mystical Ore", "Mystical_Ore", 3.0F, "pickaxe", 2);
		registerBlock(mysticalBlock, "Mystical Block", "Mystical_Block", 3.0F, "pickaxe", 2);
		registerBlock(ritualBlock, "Ritual Block", "Ritual_Block", 2.0F, "pickaxe", 2);
		registerBlock(burntRitualBlock, "Burnt Ritual Block", "Ritual_Block_Burnt", 2.0F, "pickaxe", 2);
		registerBlock(waterRitualBlock, "Water Ritual Block", "Water_Ritual_Block", 2.0F, "pickaxe", 2);
		registerBlock(airRitualBlock, "Ritual Block Air", "Ritual_Block_Air", 2.0F, "pickaxe", 2);
		registerBlock(natureRitualBlock, "Ritual Block Nature", "Ritual_Block_Nature", 2.0F, "pickaxe", 2);

		registerBlock(mysticalBrick, "Mystical Brick", "Mystical_Brick", 2.0F, "pickaxe", 2);

		registerBlock(mysticalInfuserInactive, "Inactive Mystical Infuser", "Mystical_Infuser_Inactive", 2.0F, "pickaxe", 2);
		registerBlock(mysticalInfuserActive, "Mystical Infuser", "Mystical_Infuser", 2.0F, "pickaxe", 2);

		registerBlock(infusedOakLog, "Infused Oak Wood", 2.0F, "axe", 2, "Infused_Oak_Wood");
		registerBlock(infusedOakLeaves, "Infused Oak Leaves", "Infused_Oak_Leaves", 0.5F, "axe", 0);
		registerBlock(infusedOakPlanks, "Infused Oak Planks", "Infused_Oak_Planks", 2.0F, "axe", 2);
		registerBlock(infusedOakFence, "Infused Oak Fence", 2.0F, "axe", 0, "Infused_Oak_Fence");

		registerBlock(burntShardOre, "Burnt Shard Ore", "Burnt_Shard_Ore", 2.0F, "pickaxe", 2);
		registerBlock(floatingShardOre, "Floating Shard Ore", "Floating_Shard_Ore", 2.0F, "pickaxe", 2);
		registerBlock(natureShardOre, "Nature Shard Ore", "Nature_Shard_Ore", 2.0F, "pickaxe", 2);
		registerBlock(waterShardOre, "Soaked Shard Ore", "Soaked_Shard_Ore", 2.0F, "pickaxe", 2);

		registerBlock(burntShardBlock, "Burnt Shard Block", "Burnt_Shard_Block", 2.0F, "pickaxe", 2);
		registerBlock(floatingShardBlock, "Floating Shard Block", "Floating_Shard_Block", 2.0F, "pickaxe", 2);
		registerBlock(natureShardBlock, "Nature Shard Block", "Nature_Shard_Block", 2.0F, "pickaxe", 2);
		registerBlock(waterShardBlock, "Soaked Shard Block", "Soaked_Shard_Block", 2.0F, "pickaxe", 2);

		registerBlock(burntGlass, "Burnt Glass", "Burnt_Glass", 2.0F, "pickaxe", 0);
		registerBlock(floatingGlass, "Floating Glass", "Floating_Glass", 2.0F, "pickaxe", 0);
		registerBlock(natureGlass, "Nature Glass", "Nature_Glass", 2.0F, "pickaxe", 0);
		registerBlock(waterGlass, "Soaked Glass", "Soaked_Glass", 2.0F, "pickaxe", 0);


		registerBlock(portal, "Portal", "Portal", 10F, "pickaxe", 4);
		
		// registerBlock(fireFlower, "Fire Flower", "FireFlower", 0.2F);

	}

	public static void registerBlock(Block block, String name, String key, float hardness, String toolClass, int level) {
		block.setBlockName(name).setCreativeTab(MysticalItems.tabMysticalTrinkets).setBlockTextureName(ModInfo.modid + ":" + key).setHardness(hardness).setHarvestLevel(toolClass, level);
		GameRegistry.registerBlock(block, name);
	}

	public static void registerBlock(Block block, String name, float hardness, String toolClass, int level, String key) {
		block.setBlockName(name).setCreativeTab(MysticalItems.tabMysticalTrinkets).setHardness(hardness).setHarvestLevel(toolClass, level);
		GameRegistry.registerBlock(block, name);
	}

	public static void registerBlock(Block block, String name, float hardness, String key) {
		block.setBlockName(name).setCreativeTab(MysticalItems.tabMysticalTrinkets).setHardness(hardness);
		GameRegistry.registerBlock(block, name);
	}

	public static void registerBlock(Block block, String name, String key, float hardness) {
		block.setBlockName(name).setCreativeTab(MysticalItems.tabMysticalTrinkets).setHardness(hardness).setBlockTextureName(ModInfo.modid + ":" + key);
		GameRegistry.registerBlock(block, name);
	}

	public static void registerTileEntities() {
		GameRegistry.registerTileEntity(TileEntityRitual.class, "ritualTileEntity");

		GameRegistry.registerTileEntity(TileEntityMysticalBlock.class, "mysticalBlock");

		GameRegistry.registerTileEntity(TileEntityMysticalInfuser.class, "mysticalInfuser");
		GameRegistry.registerTileEntity(TileEntityMysticalInfuserInactive.class, "mysticalInfuserInactive");
//		GameRegistry.registerTileEntity(TileEntityFireFlower.class, "fireFlower");

	}

	private static void registerOreDict() {
		OreDictionary.registerOre("plankWood", infusedOakPlanks);
		OreDictionary.registerOre("logWood", infusedOakLog);
	}
}