package com.jared.mysticaltrinkets.entities;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.world.World;
import net.minecraftforge.common.ISpecialArmor;

public class EntityMysticalWolf extends EntityWolf implements IEntityAdditionalSpawnData{

	public EntityMysticalWolf(World world) {
		super(world);
	}

	@Override
	public void writeSpawnData(ByteBuf buffer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void readSpawnData(ByteBuf additionalData) {
		// TODO Auto-generated method stub
		
	}

}
