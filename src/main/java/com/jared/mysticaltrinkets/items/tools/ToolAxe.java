package com.jared.mysticaltrinkets.items.tools;

import net.minecraft.item.ItemAxe;

public class ToolAxe extends ItemAxe {

	
	
	public ToolAxe(ToolMaterial material) {
		super(material);
		this.setMaxStackSize(1);
	}

	@Override
	public boolean isFull3D() {
		return true;
	}

}
