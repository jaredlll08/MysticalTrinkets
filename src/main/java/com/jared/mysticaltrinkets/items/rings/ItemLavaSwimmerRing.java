package com.jared.mysticaltrinkets.items.rings;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import baubles.api.BaubleType;
import baubles.api.IBauble;
import cpw.mods.fml.relauncher.ReflectionHelper;

public class ItemLavaSwimmerRing extends Item implements IBauble {

	World world;
	public static final String[] IS_IMMUNE_TO_FIRE = new String[] { "isImmuneToFire", "field_70178_ae", "ag" };

	public ItemLavaSwimmerRing() {
		super();
		this.setMaxStackSize(1);
		this.setMaxDamage(1);
	}

	@Override
	public void addInformation(ItemStack itemstack, EntityPlayer player, List info, boolean par4) {
		info.add(EnumChatFormatting.YELLOW + "Tier: 3");
		info.add(EnumChatFormatting.DARK_RED + "Gives the wearer Fire Resistance.");
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.RING;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player) {
		double d0 = player.posX - player.posX;
		double d1 = player.boundingBox.minY + player.height / 2.0F - (player.posY + player.height / 2.0F);
		double d2 = player.posZ - player.posZ;
		float f1 = MathHelper.sqrt_float(1F) * 0.5F;
		EntitySmallFireball entitysmallfireball = new EntitySmallFireball(world, player, d0 + world.rand.nextGaussian() * f1, d1, d2 + world.rand.nextGaussian() * f1);
		// EntitySmallFireball entitysmallfireball = new
		// EntitySmallFireball(world, player, player.cameraYaw,
		// player.cameraPitch, player.cameraYaw );

		entitysmallfireball.posY = player.posY + player.height / 2.0F + 0.5D;
		world.spawnEntityInWorld(entitysmallfireball);

		// world.spawnEntityInWorld(new EntityLargeFireball(world, player.posX,
		// player.posY, player.posZ, (double)player.cameraYaw,
		// (double)player.cameraPitch, (double)player.cameraYaw));
		return itemstack;
	}

	@Override
	public void onUpdate(ItemStack itemstack, World world, Entity entity, int par4, boolean par5) {
		entity.extinguish();
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

		setFireImmune(player, true);

	}

	public void setFireImmune(Entity entity, boolean isImmune) {
		ReflectionHelper.setPrivateValue(Entity.class, entity, isImmune, IS_IMMUNE_TO_FIRE);
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		setFireImmune(player, false);

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
