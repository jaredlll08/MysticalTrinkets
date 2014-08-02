package com.jared.mysticaltrinkets.util;

import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;

import com.jared.mysticaltrinkets.config.ConfigInfo;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

	public EventHandler() {
		MinecraftForge.EVENT_BUS.register(this);
	}

	// TODO Take this out
	@SubscribeEvent
	public void make3D(ItemTooltipEvent event) {
		if (ConfigInfo.render3DItems) {
			Item item = event.entityPlayer.getHeldItem().getItem();
			item.setFull3D();
		}
	}
}
