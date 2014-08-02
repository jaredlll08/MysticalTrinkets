package com.jared.mysticaltrinkets.api;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.item.ItemStack;

public class MysticalTrinketsAPI {

	public static MysticalTrinketsAPI instance;

	public MysticalTrinketsAPI() {
	}

	private List canReadPower = new ArrayList();

	/**
	 * @param itemstack
	 *            The item that will read power.
	 */
	public void setCanReadPower(ItemStack itemstack) {
		canReadPower.add(itemstack.getItem());
	}

	/**
	 * @param itemstack
	 *            The item that can will read power.
	 */
	public boolean canReadPower(ItemStack itemstack) {
		if (canReadPower.contains(itemstack.getItem())) {
			return true;
		} else {
			return false;
		}

	}
}
