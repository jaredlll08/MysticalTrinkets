package com.jared.mysticaltrinkets.items.tools;

import net.minecraft.item.ItemPickaxe;

public class ToolPickAxe extends ItemPickaxe {

	public ToolPickAxe(ToolMaterial material) {
		super(material);
		this.setMaxStackSize(1);

	}

	@Override
	public boolean isFull3D() {
		return true;
	}
}
