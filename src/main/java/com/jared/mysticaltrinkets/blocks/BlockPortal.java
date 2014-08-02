package com.jared.mysticaltrinkets.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

public class BlockPortal extends Block {

	protected BlockPortal() {
		super(Material.portal);
		this.setBlockBounds(0.0F, 0.0F, 0.4F, 1F, 1.0F, 0.6F);
	}

	public boolean isCollidable() {
		return true;
	}

	public boolean isBlockNormalCube() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	public int quantityDropped(Random p_149745_1_) {
		return 0;
	}

	/**
	 * Triggered whenever an entity collides with this block (enters into the
	 * block). Args: world, x, y, z, entity
	 */
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.travelToDimension(29);
	}

}