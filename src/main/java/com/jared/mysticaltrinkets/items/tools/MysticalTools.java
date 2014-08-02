package com.jared.mysticaltrinkets.items.tools;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.jared.mysticaltrinkets.ModInfo;
import com.jared.mysticaltrinkets.items.MysticalItems;
import com.jared.mysticaltrinkets.items.armor.ItemMysticalBoots;
import com.jared.mysticaltrinkets.items.armor.ItemMysticalChestplate;
import com.jared.mysticaltrinkets.items.armor.ItemMysticalHelmet;
import com.jared.mysticaltrinkets.items.armor.ItemMysticalLeggings;

import cpw.mods.fml.common.registry.GameRegistry;

public class MysticalTools {

	public static void init() {
		registerTools();
		RegisterRecipes();
	}

	public static final Item.ToolMaterial Mystical_Metal = EnumHelper.addToolMaterial("Mystical_Metal", 3, 512, 6.0F, 2.0F, 0);
	public static final Item.ToolMaterial Mystical_Metal_Sword = EnumHelper.addToolMaterial("Mystical_Metal", 3, 512, 4.5F, 2.5F, 0);

	public static final ArmorMaterial Mystical_Metal_Armor = EnumHelper.addArmorMaterial("Mystical Metal", 300, new int[] { 2, 6, 4, 2 }, 0);
	public static Item mysticalSword = new ToolSword(Mystical_Metal_Sword);
	public static Item mysticalPickAxe = new ToolPickAxe(Mystical_Metal);
	public static Item mysticalAxe = new ToolAxe(Mystical_Metal);
	public static Item mysticalSpade = new ToolSpade(Mystical_Metal);
	public static Item mysticalHoe = new ToolHoe();
	// public static Item mysticalHammer = new ToolHammer(Mystical_Metal);

	public static Item mysticalHeadNormal = new ItemMysticalHelmet(-1);
	public static Item mysticalHeadFire = new ItemMysticalHelmet(0);
	public static Item mysticalHeadAir = new ItemMysticalHelmet(1);
	public static Item mysticalHeadNature = new ItemMysticalHelmet(2);
	public static Item mysticalHeadWater = new ItemMysticalHelmet(3);

	public static Item mysticalChestNormal = new ItemMysticalChestplate(-1);
	public static Item mysticalChestFire = new ItemMysticalChestplate(0);
	public static Item mysticalChestAir = new ItemMysticalChestplate(1);
	public static Item mysticalChestNature = new ItemMysticalChestplate(2);
	public static Item mysticalChestWater = new ItemMysticalChestplate(3);

	public static Item mysticalLeggsNormal = new ItemMysticalLeggings(-1);
	public static Item mysticalLeggsFire = new ItemMysticalLeggings(0);
	public static Item mysticalLeggsAir = new ItemMysticalLeggings(1);
	public static Item mysticalLeggsNature = new ItemMysticalLeggings(2);
	public static Item mysticalLeggsWater = new ItemMysticalLeggings(3);
	
	public static Item mysticalBootsNormal = new ItemMysticalBoots(-1);
	public static Item mysticalBootsFire= new ItemMysticalBoots(0);
	public static Item mysticalBootsAir= new ItemMysticalBoots(1);
	public static Item mysticalBootsNature= new ItemMysticalBoots(2);
	public static Item mysticalBootsWater = new ItemMysticalBoots(3);

	
	private static void registerTools() {
		RegisterTool(mysticalSword, "Mystical Sword", "Mystical_Sword", 500);
		RegisterTool(mysticalPickAxe, "Mystical Pickaxe", "Mystical_Pickaxe", 500, "pickaxe", 2);
		RegisterTool(mysticalAxe, "Mystical Axe", "Mystical_Axe", 500, "axe", 2);
		RegisterTool(mysticalSpade, "Mystical Shovel", "Mystical_Spade", 500, "shovel", 2);
		RegisterTool(mysticalHoe, "Mystical Hoe", "Mystical_Hoe", 500, "hoe", 3);
		// RegisterTool(mysticalHammer, "Mystical Hammer", "Mystical_Hammer",
		// 1000, "pickaxe", 2);
		RegisterTool(mysticalHeadNormal, "Mystical Helmet", "Mystical_Helmet");
		RegisterTool(mysticalHeadFire, "Fire Infused Mystical Helmet", "Mystical_Helmet_Fire");
		RegisterTool(mysticalHeadAir, "Air Infused Mystical Helmet", "Mystical_Helmet_Air");
		RegisterTool(mysticalHeadNature, "Nature Infused Mystical Helmet", "Mystical_Helmet_Nature");
		RegisterTool(mysticalHeadWater, "Water Infused Mystical Helmet", "Mystical_Helmet_Water");

		RegisterTool(mysticalChestNormal, "Mystical Chestplate", "Mystical_ChestPlate");
		RegisterTool(mysticalChestFire, "Fire Infused Mystical Chestplate", "Mystical_ChestPlate_Fire");
		RegisterTool(mysticalChestAir, "Air Infused Mystical Chestplate", "Mystical_ChestPlate_Air");
		RegisterTool(mysticalChestNature, "Nature Infused Mystical Chestplate", "Mystical_ChestPlate_Nature");
		RegisterTool(mysticalChestWater, "Water Infused Mystical Chestplate", "Mystical_ChestPlate_Water");

		RegisterTool(mysticalLeggsNormal, "Mystical Leggings", "Mystical_Leggings");
		RegisterTool(mysticalLeggsFire, "Fire Infused Mystical Leggings", "Mystical_Leggings_Fire");
		RegisterTool(mysticalLeggsAir, "Air Infused Mystical Leggings", "Mystical_Leggings_Air");
		RegisterTool(mysticalLeggsNature, "Nature Infused Mystical Leggings", "Mystical_Leggings_Nature");
		RegisterTool(mysticalLeggsWater, "Water Infused Mystical Leggings", "Mystical_Leggings_Water");
		
		RegisterTool(mysticalBootsNormal, "Mystical Boots", "Mystical_Boots");
		RegisterTool(mysticalBootsFire, "Fire Infused Mystical Boots", "Mystical_Boots_Fire");
		RegisterTool(mysticalBootsAir, "Air Infused Mystical Boots", "Mystical_Boots_Air");
		RegisterTool(mysticalBootsNature, "Nature Infused Mystical Boots", "Mystical_Boots_Nature");
		RegisterTool(mysticalBootsWater, "Water Infused Mystical Boots", "Mystical_Boots_Water");

	}

	private static void RegisterTool(Item tool, String name, String key, int durability) {
		tool.setUnlocalizedName(key).setCreativeTab(MysticalItems.tabMysticalTrinkets).setTextureName(ModInfo.modid + ":" + key).setMaxDamage(durability);
		GameRegistry.registerItem(tool, key);
	}

	private static void RegisterTool(Item tool, String name, String key) {
		tool.setUnlocalizedName(key).setCreativeTab(MysticalItems.tabMysticalTrinkets).setTextureName(ModInfo.modid + ":" + key);
		GameRegistry.registerItem(tool, key);
	}

	public static void RegisterTool(Item tool, String name, String key, int durability, String toolType, int level) {
		tool.setUnlocalizedName(key).setCreativeTab(MysticalItems.tabMysticalTrinkets).setTextureName(ModInfo.modid + ":" + key).setMaxDamage(durability).setHarvestLevel(toolType, level);
		GameRegistry.registerItem(tool, key);
	}

	public static void registerTool(Item tool, String name, String key, int durability, String toolType, int level) {
		tool.setUnlocalizedName(key).setCreativeTab(MysticalItems.tabMysticalTrinkets).setMaxDamage(durability).setHarvestLevel(toolType, level);
		GameRegistry.registerItem(tool, key);
	}

	public static void RegisterRecipes() {

	}

}
