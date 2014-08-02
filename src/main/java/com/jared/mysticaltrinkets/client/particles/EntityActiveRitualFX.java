package com.jared.mysticaltrinkets.client.particles;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityActiveRitualFX extends EntityFX {
	/** the scale of the flame FX */
	private float flameScale;

	private double field_70568_aq;
	private double field_70567_ar;
	private double field_70566_as;

	private double xPos;
	private double yPos;
	private double zPos;

	public EntityActiveRitualFX(World par1World, double par2, double par4, double par6, double par8, double par10, double par12) {
		super(par1World, par2, par4, par6, par8, par10, par12);
		this.motionX = this.motionX * 0.009999999776482582D + par8;
		this.motionY = this.motionY * 0.009999999776482582D + par10;
		this.motionZ = this.motionZ * 0.009999999776482582D + par12;
		this.field_70568_aq = this.posX = par2;
		this.field_70567_ar = this.posY = par4;
		this.field_70566_as = this.posZ = par6;
		double d6 = par2 + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F;
		d6 = par4 + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F;
		d6 = par6 + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F;
		this.flameScale = this.particleScale;
		this.particleTextureIndexX = 0;
		this.particleTextureIndexY = 2;
		this.particleRed = this.particleGreen = this.particleBlue = 1.0F;
		this.particleMaxAge = 40;// (int) (8.0D / (Math.random() * 0.4D + 0.1D))
									// + 2;
		this.noClip = true;

		xPos = par2;
		yPos = par4;
		zPos = par6;
	}

	@Override
	public void renderParticle(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
		float f6 = (this.particleAge + par2) / this.particleMaxAge;
		this.particleScale = this.flameScale / (2.0F - f6 * f6 * 1F);
		par1Tessellator.draw();
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("mysticaltrinkets:textures/particles/particles.png"));
		par1Tessellator.startDrawingQuads();
		par1Tessellator.setBrightness(100);// make sure you have this!!
		super.renderParticle(par1Tessellator, par2, par3, par4, par5, par6, par7);
		par1Tessellator.draw();
		Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation("textures/particle/particles.png"));
		par1Tessellator.startDrawingQuads();
	}

	@Override
	public int getBrightnessForRender(float par1) {
		float f1 = (this.particleAge + par1) / this.particleMaxAge;

		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f1 > 1.0F) {
			f1 = 1.0F;
		}

		int i = super.getBrightnessForRender(par1);
		int j = i & 255;
		int k = i >> 16 & 255;
		j += (int) (f1 * 15.0F * 16.0F);

		if (j > 240) {
			j = 240;
		}

		return j | k << 16;
	}

	/**
	 * Gets how bright this entity is.
	 */
	@Override
	public float getBrightness(float par1) {
		float f1 = (this.particleAge + par1) / this.particleMaxAge;

		if (f1 < 0.0F) {
			f1 = 0.0F;
		}

		if (f1 > 1.0F) {
			f1 = 1.0F;
		}

		float f2 = super.getBrightness(par1);
		return f2 * f1 + (1.0F - f1);
	}

	/**
	 * Called to update the entity's position/logic.
	 */
	// public void onUpdate() {
	// this.prevPosX = this.posX;
	// this.prevPosY = this.posY;
	// this.prevPosZ = this.posZ;
	//
	// if (this.particleAge++ >= this.particleMaxAge) {
	// this.setDead();
	// }
	//
	// this.moveEntity(this.motionX, this.motionY, this.motionZ);
	// this.motionX *= 0.9599999785423279D;
	// this.motionY *= 0.9599999785423279D;
	// this.motionZ *= 0.9599999785423279D;
	//
	// if (this.onGround) {
	// this.motionX *= 0.699999988079071D;
	// this.motionZ *= 0.699999988079071D;
	// }
	// }

	@Override
	public void onUpdate() {
		this.prevPosX = this.posX;
		this.prevPosY = this.posY;
		this.prevPosZ = this.posZ;
		float f = (float) this.particleAge / (float) this.particleMaxAge;
		f = 1.0F - f;
		float f1 = 1.0F * f;
		f1 *= f1;
		f1 *= f1;
		this.posX = this.field_70568_aq + this.motionX * f;
		this.posY = this.field_70567_ar + this.motionY * f - f1 / 1.2F;
		this.posZ = this.field_70566_as + this.motionZ * f;

		if (posX == xPos) {
			if (posY == yPos) {
				if (posZ == zPos) {
					this.setDead();
				}
			}
		}
		if (this.particleAge++ >= this.particleMaxAge) {
			this.setDead();
		}
	}
}