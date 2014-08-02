package com.jared.mysticaltrinkets.blocks.ores;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

import com.jared.mysticaltrinkets.items.MysticalItems;

public class BlockSoakedShardOre extends Block {

	public BlockSoakedShardOre() {
		super(Material.rock);
	}

	public int getExpDrop(IBlockAccess world, int metadata, int fortune) {
		Random random = new Random();
		return random.nextInt(10);
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return MysticalItems.waterShard;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random p_149745_1_) {
		return p_149745_1_.nextInt(2) + 3;
	}

}
