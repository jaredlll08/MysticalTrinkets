package com.jared.mysticaltrinkets.items.rings;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import cpw.mods.fml.common.Loader;

public class ItemFireResistanceRing extends Item implements IBauble {

	World world;

	public ItemFireResistanceRing() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean par4) {
		info.add(EnumChatFormatting.YELLOW + "Tier: 2");
		info.add(EnumChatFormatting.RED + "Removes the fire effect from the wearer.");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) {
		if (Loader.isModLoaded("Baubles")) {
			if (entity instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer) entity;
				if (!world.isRemote) {
					player.extinguish();

					if (player.inventory.getCurrentItem() != null && player.inventory.getCurrentItem().getItem() == this) {

						if (world.getBlock((int) player.posX, (int) player.posY, (int) player.posZ) == Blocks.fire) {
							player.extinguish();
							world.setBlock((int) player.posX, (int) player.posY, (int) player.posZ, Blocks.air);
						}
						if (world.getBlock((int) player.posX + 1, (int) player.posY, (int) player.posZ) == Blocks.fire) {
							player.extinguish();
							world.setBlock((int) player.posX + 1, (int) player.posY, (int) player.posZ, Blocks.air);
						}
						if (world.getBlock((int) player.posX - 1, (int) player.posY, (int) player.posZ) == Blocks.fire) {
							player.extinguish();
							world.setBlock((int) player.posX - 1, (int) player.posY, (int) player.posZ, Blocks.air);
						}
						if (world.getBlock((int) player.posX, (int) player.posY, (int) player.posZ + 1) == Blocks.fire) {
							player.extinguish();
							world.setBlock((int) player.posX, (int) player.posY, (int) player.posZ + 1, Blocks.air);
						}
						if (world.getBlock((int) player.posX, (int) player.posY, (int) player.posZ - 1) == Blocks.fire) {
							player.extinguish();
							world.setBlock((int) player.posX, (int) player.posY, (int) player.posZ - 1, Blocks.air);
						}

						if (world.getBlock((int) player.posX + 1, (int) player.posY, (int) player.posZ + 1) == Blocks.fire) {
							player.extinguish();
							world.setBlock((int) player.posX + 1, (int) player.posY, (int) player.posZ + 1, Blocks.air);
						}

						if (world.getBlock((int) player.posX - 1, (int) player.posY, (int) player.posZ - 1) == Blocks.fire) {
							player.extinguish();
							world.setBlock((int) player.posX - 1, (int) player.posY, (int) player.posZ - 1, Blocks.air);
						}

						if (world.getBlock((int) player.posX - 1, (int) player.posY, (int) player.posZ + 1) == Blocks.fire) {
							player.extinguish();
							world.setBlock((int) player.posX - 1, (int) player.posY, (int) player.posZ + 1, Blocks.air);
						}

						if (world.getBlock((int) player.posX + 1, (int) player.posY + 1, (int) player.posZ - 1) == Blocks.fire) {
							player.extinguish();
							world.setBlock((int) player.posX + 1, (int) player.posY, (int) player.posZ - 1, Blocks.air);
						}
					}

				}
			}
		}

	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.uncommon;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {
		player.extinguish();
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

}
