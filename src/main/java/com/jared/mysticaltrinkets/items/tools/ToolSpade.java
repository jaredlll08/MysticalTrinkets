package com.jared.mysticaltrinkets.items.tools;

import net.minecraft.item.ItemSpade;

public class ToolSpade extends ItemSpade {

	public ToolSpade(ToolMaterial material) {
		super(material);
		this.setMaxStackSize(1);
	}

	@Override
	public boolean isFull3D() {
		return true;
	}

}
