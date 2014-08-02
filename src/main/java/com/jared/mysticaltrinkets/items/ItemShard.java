package com.jared.mysticaltrinkets.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.jared.mysticaltrinkets.ModInfo;

public class ItemShard extends Item {

	private int color;
	private IIcon shard;
	private IIcon other;

	public ItemShard(int color) {
		this.color = color;
	}

	public int getRenderPasses(int metadata) {
		return 1;
	}

	@Override
	public int getColorFromItemStack(ItemStack par1ItemStack, int par2) {
		if (color == 0) {
			return (255 << 16) | (80 << 8) | 65;
		}
		if (color == 1) {
			return (255 << 16) | (212 << 8) | 0;
		}
		if (color == 2) {
			return (12 << 16) | (255 << 8) | 45;
		}
		if (color == 3) {
			return (0 << 16) | (140 << 8) | 255;
		}
		return (180 << 16) | (180 << 8) | 180;
	}

	public void registerIcons(IIconRegister icon) {
		this.other = icon.registerIcon(ModInfo.modid + ":Shard");
		this.itemIcon = icon.registerIcon(ModInfo.modid + ":Shard");

		this.shard = icon.registerIcon(ModInfo.modid + ":Mystical_Pickaxe");
	}

}
