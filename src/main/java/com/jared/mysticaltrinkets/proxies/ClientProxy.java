package com.jared.mysticaltrinkets.proxies;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {



	}

	@Override
	public int registerArmorRenderPrefix() {
		return RenderingRegistry.addNewArmourRendererPrefix("mystical");
	}
}