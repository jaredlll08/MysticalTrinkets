package com.jared.mysticaltrinkets;

import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;

import com.jared.mysticaltrinkets.blocks.MysticalBlocks;
import com.jared.mysticaltrinkets.config.ConfigHandler;
import com.jared.mysticaltrinkets.items.MysticalItems;
import com.jared.mysticaltrinkets.items.tools.MysticalTools;
import com.jared.mysticaltrinkets.proxies.CommonProxy;
import com.jared.mysticaltrinkets.util.ThaumcraftHandler;
import com.jared.mysticaltrinkets.world.GenerationHandler;
import com.jared.mysticaltrinkets.world.dimension.GenLayerBiomesMysticalTrinkets;
import com.jared.mysticaltrinkets.world.dimension.WorldProviderMysticalDimension;

import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = ModInfo.modid, name = ModInfo.name, version = ModInfo.version, dependencies = "after:Baubles;after:Thaumcraft", canBeDeactivated = false)
public class MysticalTrinkets {

	@Instance("mysticaltrinkets")
	public static MysticalTrinkets instance;
	@SidedProxy(clientSide = "com.jared.mysticaltrinkets.proxies.ClientProxy", serverSide = "com.jared.mysticaltrinkets.proxies.CommonProxy")
	public static CommonProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		ConfigHandler.init(e.getSuggestedConfigurationFile());

		MysticalBlocks.init();

		MysticalTools.init();
		MysticalItems.init();

		proxy.registerRenderers();

		if (Loader.isModLoaded("Thaumcraft")) {
			ThaumcraftHandler.init();

		}

	}
	@EventHandler
	public void init(FMLInitializationEvent e) {
		GameRegistry.registerWorldGenerator(new GenerationHandler(), 0);
		MinecraftForge.EVENT_BUS.register(new com.jared.mysticaltrinkets.util.EventHandler());
		GenLayerBiomesMysticalTrinkets.Biomes();
		DimensionManager.registerProviderType(29, WorldProviderMysticalDimension.class, false);
		DimensionManager.registerDimension(29, 29);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		

	}
	public static int createArmorRenderPrefix() {
		return proxy.registerArmorRenderPrefix();
	}

}
