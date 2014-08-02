package com.jared.mysticaltrinkets.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockMysticalBrick extends Block {

	protected BlockMysticalBrick() {
		super(Material.iron);
		this.setLightLevel(0.5F);
		this.setHardness(3.0F);
	}

}
