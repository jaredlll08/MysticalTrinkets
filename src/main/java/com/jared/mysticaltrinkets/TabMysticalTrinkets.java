package com.jared.mysticaltrinkets;

import net.minecraft.creativetab.CreativeTabs;
//import net.minecraft.init.Blocks;
import net.minecraft.item.Item;

import com.jared.mysticaltrinkets.items.MysticalItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabMysticalTrinkets extends CreativeTabs {

	public TabMysticalTrinkets(String tabLabel) {
		super(tabLabel);

	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem() {
		return MysticalItems.fireResistanceRing;
	}

}