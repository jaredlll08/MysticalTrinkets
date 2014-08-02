package com.jared.mysticaltrinkets.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.jared.mysticaltrinkets.ModInfo;
import com.jared.mysticaltrinkets.TabMysticalTrinkets;
import com.jared.mysticaltrinkets.blocks.MysticalBlocks;
import com.jared.mysticaltrinkets.config.ConfigInfo;
import com.jared.mysticaltrinkets.items.amulets.ItemAbsorptionAmulet;
import com.jared.mysticaltrinkets.items.amulets.ItemAmulet;
import com.jared.mysticaltrinkets.items.amulets.ItemWaterBreathingAmulet;
import com.jared.mysticaltrinkets.items.amulets.ItemWitherlessAmulet;
import com.jared.mysticaltrinkets.items.belts.ItemBelt;
import com.jared.mysticaltrinkets.items.belts.ItemClippingBelt;
import com.jared.mysticaltrinkets.items.belts.ItemJumpingBelt;
import com.jared.mysticaltrinkets.items.belts.ItemSlowFallBelt;
import com.jared.mysticaltrinkets.items.belts.ItemSpeedBelt;
import com.jared.mysticaltrinkets.items.belts.ItemSteppingBelt;
import com.jared.mysticaltrinkets.items.rings.ItemAutoClickerRing;
import com.jared.mysticaltrinkets.items.rings.ItemBurntRing;
import com.jared.mysticaltrinkets.items.rings.ItemFireResistanceRing;
import com.jared.mysticaltrinkets.items.rings.ItemHungerRing;
import com.jared.mysticaltrinkets.items.rings.ItemLavaSwimmerRing;
import com.jared.mysticaltrinkets.items.rings.ItemNightVisionRing;
import com.jared.mysticaltrinkets.items.rings.ItemRing;
import com.jared.mysticaltrinkets.items.tools.MysticalTools;

import cpw.mods.fml.common.registry.GameRegistry;

public class MysticalItems {

	public static void init() {
		registerItems();
		registerRecipes();

	}

	public static Item ironRing = new ItemRing(0);
	public static Item ironBelt = new ItemBelt(0);
	public static Item ironAmulet = new ItemAmulet(0);
	public static Item burntRing = new ItemBurntRing();


	public static Item goldRing = new ItemRing(0);
	public static Item goldAmulet = new ItemAmulet(1);
	public static Item goldBelt = new ItemBelt(1);

	public static Item mysticalReader = new ItemMysticalReader();

	public static Item fireShard = new ItemShard(0);
	public static Item airShard = new ItemShard(1);
	public static Item natureShard = new ItemShard(2);
	public static Item waterShard = new ItemShard(3);

	public static Item mysticalRing = new ItemRing(2);
	public static Item fireResistanceRing = new ItemFireResistanceRing();
	public static Item nightVisionRing = new ItemNightVisionRing();
	public static Item lavaSwimmerRing = new ItemLavaSwimmerRing();

	public static Item mysticalAmulet = new ItemAmulet(2);
	public static Item waterBreathingAmulet = new ItemWaterBreathingAmulet();
	public static Item witherlessAmulet = new ItemWitherlessAmulet();

	public static Item mysticalBelt = new ItemBelt(2);
	public static Item speedBelt = new ItemSpeedBelt();
	public static Item jumpingBelt = new ItemJumpingBelt();
	public static Item steppingBelt = new ItemSteppingBelt();

	public static Item mysticalIngot = new ItemMysticalIngot();

	public static Item hungerRing = new ItemHungerRing();
	public static Item absoptionAmulet = new ItemAbsorptionAmulet();
	public static Item autoClickerRing = new ItemAutoClickerRing();
	public static Item clippingBelt = new ItemClippingBelt();

	public static Item slowFallBelt = new ItemSlowFallBelt();

	// public static Item mysticalCompendium = new ItemMysticalCompendium();

	// public static Item mysticalHelm = new ItemMysticalArmor(0);
	// public static Item mysticalChest = new ItemMysticalArmor(1);
	// public static Item mysticalLeggings = new ItemMysticalArmor(2);
	// public static Item mysticalBoots = new ItemMysticalArmor(3);

	public static CreativeTabs tabMysticalTrinkets = new TabMysticalTrinkets("Mystical Trinkets");

	private static void registerItems() {

		registerItem(ironAmulet, "Iron Amulet", "Iron_Amulet");
		registerItem(ironBelt, "Iron Belt", "Iron_Belt");
		registerItem(ironRing, "Iron Ring", "Iron_Ring");

		registerItem(goldAmulet, "Gold Amulet", "Gold_Amulet");
		registerItem(goldBelt, "Gold Belt", "Gold_Belt");
		registerItem(goldRing, "Gold Ring", "Gold_Ring");

		registerItem(burntRing, "Burnt Ring", "Burnt_Ring");

		registerItem(mysticalRing, "Mystical Ring", "Mystical_Ring");
		registerItem(fireResistanceRing, "Ring of Fire Resistance", "Ring_Of_Fire_Resistance");
		registerItem(nightVisionRing, "Night Vision Ring", "Ring_Of_Night_Vision");
		registerItem(lavaSwimmerRing, "Lava Swimming Ring", "Ring_Of_The_Lava_Swimmer");

		registerItem(mysticalAmulet, "Mystical Amulet", "Mystical_Amulet");
		registerItem(waterBreathingAmulet, "Water Breathing Amulet", "Amulet_Of_Water_Breathing");
		registerItem(witherlessAmulet, "Witherless Amulet", "Witherless_Amulet");
		registerItem(absoptionAmulet, "Absorbtion Amulet", "Absorbtion_Amulet");

		registerItem(mysticalBelt, "Mystical Belt", "Mystical_Belt");
		registerItem(speedBelt, "Speed Belt", "Speed_Belt");
		registerItem(jumpingBelt, "Jumping Belt", "Jumping_Belt");
		registerItem(steppingBelt, "Stepping Belt", "Stepping_Belt");
		registerItem(clippingBelt, "Clipping Belt", "Clipping_Belt");

		registerItem(mysticalIngot, "Mystical Ingot", "Mystical_Ingot");

		registerItem(airShard, "Air Shard", "Air_Shard");
		registerItem(fireShard, "Fire Shard", "Fire_Shard");
		registerItem(natureShard, "Nature Shard", "Nature_Shard");
		registerItem(waterShard, "Water Shard", "Water_Shard");

		registerItem(mysticalReader, "Mystical Reader", "Mystical_Reader");

		registerItem(slowFallBelt, "Slow Fall Belt", "Slow_Fall_Belt");

		if (!ConfigInfo.trollItems) {
			registerItem(hungerRing, "Hunger Ring", "Hunger_Ring");
			registerItem(autoClickerRing, "Auto-Clicking Ring", "Auto_Clicking_Ring");
		}

	}

	public static void registerItem(Item item, String name, String key) {
		item.setUnlocalizedName(key).setCreativeTab(tabMysticalTrinkets).setTextureName(ModInfo.modid + ":" + key);
		GameRegistry.registerItem(item, key);
	}

	public static void registerRecipes() {
		// GameRegistry.addRecipe(new ItemStack(stone), new Object[] { "s", "s",
		GameRegistry.addSmelting(MysticalBlocks.mysticalOre, new ItemStack(mysticalIngot), 1);

		GameRegistry.addRecipe(new ItemStack(ironRing), new Object[] { " s ", "s s", " s ", 's', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ironBelt), new Object[] { "sss", "s s", "sss", 's', new ItemStack(Items.iron_ingot) });
		GameRegistry.addRecipe(new ItemStack(ironAmulet), new Object[] { " ss", "lss", "ll ", 's', new ItemStack(Blocks.iron_bars), 'l', new ItemStack(Items.iron_ingot) });

		GameRegistry.addRecipe(new ItemStack(goldRing), new Object[] { " s ", "s s", " s ", 's', new ItemStack(Items.gold_ingot) });
		GameRegistry.addRecipe(new ItemStack(goldBelt), new Object[] { "sss", "s s", "sss", 's', new ItemStack(Items.gold_ingot) });
		GameRegistry.addRecipe(new ItemStack(goldAmulet), new Object[] { " ss", "lss", "ll ", 's', new ItemStack(Blocks.iron_bars), 'l', new ItemStack(Items.gold_ingot) });

		GameRegistry.addRecipe(new ItemStack(Items.fish), new Object[] { "sss", "sbs", "sss", 's', new ItemStack(waterShard), 'b', new ItemStack(Items.beef) });

		if (!ConfigInfo.trollItems) {
			GameRegistry.addRecipe(new ItemStack(hungerRing), new Object[] { "lml", "mrm", "lml", 'l', new ItemStack(Items.cake), 'm', new ItemStack(mysticalIngot), 'r', new ItemStack(mysticalRing) });
			GameRegistry.addRecipe(new ItemStack(autoClickerRing), new Object[] { "lml", "mrm", "lml", 'l', new ItemStack(Blocks.wool), 'm', new ItemStack(mysticalIngot), 'r', new ItemStack(mysticalRing) });

		}

		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.mysticalBlock), new Object[] { "mmm", "mmm", "mmm", 'm', new ItemStack(mysticalIngot) });
		GameRegistry.addRecipe(new ItemStack(mysticalIngot, 9), new Object[] { "m", 'm', new ItemStack(MysticalBlocks.mysticalBlock) });

		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.ritualBlock), new Object[] { "oio", "igi", "oio", 'o', new ItemStack(Blocks.obsidian), 'i', new ItemStack(Items.iron_ingot), 'g', new ItemStack(Items.gold_ingot) });
		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.mysticalBrick), new Object[] { "mm", "mm", 'm', new ItemStack(mysticalIngot) });

		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.waterShardBlock), new Object[] { "mmm", "mmm", "mmm", 'm', new ItemStack(waterShard) });
		GameRegistry.addRecipe(new ItemStack(waterShard, 9), new Object[] { "m", 'm', new ItemStack(MysticalBlocks.waterShardBlock) });

		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.floatingShardBlock), new Object[] { "mmm", "mmm", "mmm", 'm', new ItemStack(airShard) });
		GameRegistry.addRecipe(new ItemStack(airShard, 9), new Object[] { "m", 'm', new ItemStack(MysticalBlocks.floatingShardBlock) });

		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.burntShardBlock), new Object[] { "mmm", "mmm", "mmm", 'm', new ItemStack(fireShard) });
		GameRegistry.addRecipe(new ItemStack(fireShard, 9), new Object[] { "m", 'm', new ItemStack(MysticalBlocks.burntShardBlock) });

		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.natureShardBlock), new Object[] { "mmm", "mmm", "mmm", 'm', new ItemStack(natureShard) });
		GameRegistry.addRecipe(new ItemStack(natureShard, 9), new Object[] { "m", 'm', new ItemStack(MysticalBlocks.natureShardBlock) });

		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.natureGlass), new Object[] { "mmm", "m m", "mmm", 'm', new ItemStack(natureShard) });
		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.floatingGlass), new Object[] { "mmm", "m m", "mmm", 'm', new ItemStack(airShard) });
		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.burntGlass), new Object[] { "mmm", "m m", "mmm", 'm', new ItemStack(fireShard) });
		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.waterGlass), new Object[] { "mmm", "m m", "mmm", 'm', new ItemStack(waterShard) });

		GameRegistry.addRecipe(new ItemStack(mysticalReader), new Object[] { "m m", "mmm", " m ", 'm', new ItemStack(mysticalIngot) });

		GameRegistry.addRecipe(new ItemStack(MysticalTools.mysticalAxe), new Object[] { "mm ", "ms ", " s ", 'm', new ItemStack(mysticalIngot), 's', new ItemStack(Items.stick) });
		GameRegistry.addRecipe(new ItemStack(MysticalTools.mysticalAxe), new Object[] { " mm", " sm", " s ", 'm', new ItemStack(mysticalIngot), 's', new ItemStack(Items.stick) });

		GameRegistry.addRecipe(new ItemStack(MysticalTools.mysticalHoe), new Object[] { "mm ", " s ", " s ", 'm', new ItemStack(mysticalIngot), 's', new ItemStack(Items.stick) });

		GameRegistry.addRecipe(new ItemStack(MysticalTools.mysticalPickAxe), new Object[] { "mmm", " s ", " s ", 'm', new ItemStack(mysticalIngot), 's', new ItemStack(Items.stick) });

		GameRegistry.addRecipe(new ItemStack(MysticalTools.mysticalSpade), new Object[] { " m ", " s ", " s ", 'm', new ItemStack(mysticalIngot), 's', new ItemStack(Items.stick) });

		GameRegistry.addRecipe(new ItemStack(MysticalTools.mysticalSword), new Object[] { " m ", " m ", " s ", 'm', new ItemStack(mysticalIngot), 's', new ItemStack(Items.stick) });

		GameRegistry.addRecipe(new ItemStack(MysticalBlocks.infusedOakPlanks, 4), new Object[] { "m", 'm', new ItemStack(MysticalBlocks.infusedOakLog) });

	}
}
