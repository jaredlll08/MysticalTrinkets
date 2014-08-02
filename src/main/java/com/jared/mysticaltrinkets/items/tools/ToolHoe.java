package com.jared.mysticaltrinkets.items.tools;

import net.minecraft.item.ItemHoe;

public class ToolHoe extends ItemHoe {

	public ToolHoe() {
		super(MysticalTools.Mystical_Metal);
		this.setMaxStackSize(1);
	}

	@Override
	public boolean isFull3D() {
		return true;
	}

}
