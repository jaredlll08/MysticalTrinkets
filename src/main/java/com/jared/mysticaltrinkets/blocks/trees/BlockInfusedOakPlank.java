package com.jared.mysticaltrinkets.blocks.trees;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockInfusedOakPlank extends Block {

	public BlockInfusedOakPlank() {
		super(Material.wood);
		this.setHardness(2.0F);
		this.setStepSound(soundTypeWood);
	}

}
