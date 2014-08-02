package com.jared.mysticaltrinkets.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.jared.mysticaltrinkets.tileentities.TileEntityMysticalInfuserInactive;

public class BlockMysticalInfuserInactive extends BlockContainer {

	protected BlockMysticalInfuserInactive() {
		super(Material.iron);
		this.setLightLevel(0.5F);
		this.setHardness(3.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		// TODO Auto-generated method stub
		return new TileEntityMysticalInfuserInactive();
	}

}
