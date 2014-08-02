package com.jared.mysticaltrinkets.items.tools;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class ToolSword extends ItemSword {

	public ToolSword(ToolMaterial material) {
		super(material);
		this.setMaxStackSize(1);

	}


	@Override
	public boolean isFull3D() {
		return true;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack) {
		return EnumAction.block;
	}

}
