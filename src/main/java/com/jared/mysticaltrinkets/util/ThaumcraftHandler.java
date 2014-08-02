package com.jared.mysticaltrinkets.util;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import thaumcraft.api.ThaumcraftApi;
import thaumcraft.api.aspects.Aspect;
import thaumcraft.api.aspects.AspectList;

import com.jared.mysticaltrinkets.ModInfo;
import com.jared.mysticaltrinkets.blocks.MysticalBlocks;
import com.jared.mysticaltrinkets.items.MysticalItems;
import com.jared.mysticaltrinkets.items.tools.MysticalTools;

import cpw.mods.fml.common.registry.GameRegistry;

public class ThaumcraftHandler {

	public static void init() {
		registerBlockAspects();
		registerToolAspects();
		registerItemAspects();
	}

	public static void registerItem(Item item, String name, String key) {
		item.setUnlocalizedName(key).setCreativeTab(MysticalItems.tabMysticalTrinkets).setTextureName(ModInfo.modid + ":" + key);
		GameRegistry.registerItem(item, key);
	}

	private static void registerBlockAspects() {
		ThaumcraftApi tapi = new ThaumcraftApi();
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.mysticalOre), new AspectList().add(Aspect.MAGIC, 2).add(Aspect.ELDRITCH, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.mysticalIngot), new AspectList().add(Aspect.MAGIC, 1).add(Aspect.METAL, 4).add(Aspect.ELDRITCH, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.ritualBlock), new AspectList().add(Aspect.ELDRITCH, 8).add(Aspect.MECHANISM, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.airRitualBlock), new AspectList().add(Aspect.AIR, 18).add(Aspect.MAGIC, 9));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.burntRitualBlock), new AspectList().add(Aspect.FIRE, 18).add(Aspect.MAGIC, 9));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.waterRitualBlock), new AspectList().add(Aspect.WATER, 18).add(Aspect.MAGIC, 9));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.natureRitualBlock), new AspectList().add(Aspect.EARTH, 18).add(Aspect.MAGIC, 9));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.burntGlass), new AspectList().add(Aspect.FIRE, 9).add(Aspect.CRYSTAL, 6));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.floatingGlass), new AspectList().add(Aspect.AIR, 9).add(Aspect.CRYSTAL, 6));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.waterGlass), new AspectList().add(Aspect.WATER, 9).add(Aspect.CRYSTAL, 6));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.natureGlass), new AspectList().add(Aspect.EARTH, 9).add(Aspect.CRYSTAL, 6));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.burntShardBlock), new AspectList().add(Aspect.FIRE, 9));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.waterShardBlock), new AspectList().add(Aspect.WATER, 9));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.natureShardBlock), new AspectList().add(Aspect.EARTH, 9));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.floatingShardBlock), new AspectList().add(Aspect.AIR, 9));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.burntShardOre), new AspectList().add(Aspect.MAGIC, 4).add(Aspect.FIRE, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.floatingShardOre), new AspectList().add(Aspect.MAGIC, 4).add(Aspect.AIR, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.waterShardOre), new AspectList().add(Aspect.MAGIC, 4).add(Aspect.WATER, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.natureShardOre), new AspectList().add(Aspect.MAGIC, 4).add(Aspect.EARTH, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.infusedOakLeaves), new AspectList().add(Aspect.MAGIC, 2).add(Aspect.PLANT, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.infusedOakLog), new AspectList().add(Aspect.MAGIC, 2).add(Aspect.TREE, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.infusedOakPlanks), new AspectList().add(Aspect.TREE, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.mysticalBlock), new AspectList().add(Aspect.MAGIC, 36).add(Aspect.MAGIC, 20));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.mysticalBrick), new AspectList().add(Aspect.MAGIC, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.mysticalInfuserActive), new AspectList().add(Aspect.MAGIC, 8).add(Aspect.AURA, 4).add(Aspect.ELDRITCH, 6).add(Aspect.MIND, 4).add(Aspect.CRAFT, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalBlocks.mysticalInfuserInactive), new AspectList().add(Aspect.MAGIC, 2).add(Aspect.AURA, 1).add(Aspect.ELDRITCH, 2).add(Aspect.MIND, 1));
	}

	private static void registerItemAspects() {
		ThaumcraftApi tapi = new ThaumcraftApi();
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.absoptionAmulet), new AspectList().add(Aspect.LIFE, 8).add(Aspect.MAGIC, 4));
	  ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.airShard), new AspectList().add(Aspect.AIR, 4).add(Aspect.MAGIC, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.burntRing), new AspectList().add(Aspect.FIRE, 4).add(Aspect.METAL, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.clippingBelt), new AspectList().add(Aspect.VOID, 10));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.fireResistanceRing), new AspectList().add(Aspect.FIRE, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.fireShard), new AspectList().add(Aspect.FIRE, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.goldAmulet), new AspectList().add(Aspect.GREED, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.goldBelt), new AspectList().add(Aspect.GREED, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.goldRing), new AspectList().add(Aspect.GREED, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.ironAmulet), new AspectList().add(Aspect.METAL, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.ironBelt), new AspectList().add(Aspect.METAL, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.ironRing), new AspectList().add(Aspect.METAL, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.jumpingBelt), new AspectList().add(Aspect.FLIGHT, 4).add(Aspect.AIR, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.lavaSwimmerRing), new AspectList().add(Aspect.FIRE, 10));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.mysticalAmulet), new AspectList().add(Aspect.MAGIC, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.mysticalBelt), new AspectList().add(Aspect.MAGIC, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.mysticalReader), new AspectList().add(Aspect.SENSES, 4).add(Aspect.MIND, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.mysticalRing), new AspectList().add(Aspect.MAGIC, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.natureShard), new AspectList().add(Aspect.EARTH, 4).add(Aspect.MAGIC, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.nightVisionRing), new AspectList().add(Aspect.SENSES, 4).add(Aspect.MAGIC, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.speedBelt), new AspectList().add(Aspect.TRAVEL, 8).add(Aspect.MOTION, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.steppingBelt), new AspectList().add(Aspect.TRAVEL, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.waterBreathingAmulet), new AspectList().add(Aspect.WATER, 8));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.waterShard), new AspectList().add(Aspect.WATER, 4).add(Aspect.MAGIC, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalItems.witherlessAmulet), new AspectList().add(Aspect.ELDRITCH, 8));

	}

	private static void registerToolAspects() {
		ThaumcraftApi tapi = new ThaumcraftApi();
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalTools.mysticalAxe), new AspectList().add(Aspect.TOOL, 3));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalTools.mysticalHoe), new AspectList().add(Aspect.TOOL, 2));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalTools.mysticalPickAxe), new AspectList().add(Aspect.TOOL, 3).add(Aspect.MINE, 4));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalTools.mysticalSpade), new AspectList().add(Aspect.TOOL, 1));
		ThaumcraftApi.registerObjectTag(new ItemStack(MysticalTools.mysticalSword), new AspectList().add(Aspect.TOOL, 2).add(Aspect.WEAPON, 7));
	}

}
