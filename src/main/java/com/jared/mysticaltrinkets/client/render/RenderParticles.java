package com.jared.mysticaltrinkets.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.world.World;

import com.jared.mysticaltrinkets.client.particles.EntityActiveRitualFX;
import com.jared.mysticaltrinkets.client.particles.EntityAirFX;
import com.jared.mysticaltrinkets.client.particles.EntityBlazeFX;
import com.jared.mysticaltrinkets.client.particles.EntityFireForgeFX;
import com.jared.mysticaltrinkets.client.particles.EntityFireRitualFX;
import com.jared.mysticaltrinkets.client.particles.EntityFishFX;
import com.jared.mysticaltrinkets.client.particles.EntityGlowstoneFX;
import com.jared.mysticaltrinkets.client.particles.EntityGreenBallFX;
import com.jared.mysticaltrinkets.client.particles.EntityHitFX;
import com.jared.mysticaltrinkets.client.particles.EntityLeafFX;
import com.jared.mysticaltrinkets.client.particles.EntityRitualFX;
import com.jared.mysticaltrinkets.client.particles.EntityWaterForgeFX;
import com.jared.mysticaltrinkets.client.particles.EntityWaterRitualFX;

public class RenderParticles {
	private static Minecraft mc = Minecraft.getMinecraft();
	private static World theWorld = mc.theWorld;

	public static EntityFX spawnParticle(String particleName, double par2, double par4, double par6, double par8, double par10, double par12) {
		if (mc != null && mc.renderViewEntity != null && mc.effectRenderer != null) {
			int var14 = mc.gameSettings.particleSetting;

			if (var14 == 1 && theWorld.rand.nextInt(3) == 0) {
				var14 = 2;
			}

			double var15 = mc.renderViewEntity.posX - par2;
			double var17 = mc.renderViewEntity.posY - par4;
			double var19 = mc.renderViewEntity.posZ - par6;
			EntityFX var21 = null;
			double var22 = 16.0D;

			if (var15 * var15 + var17 * var17 + var19 * var19 > var22 * var22) {
				return null;
			} else if (var14 > 1) {
				return null;
			} else {
				if (particleName.equals("fireRitual")) {
					var21 = new EntityFireRitualFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("greenBall")) {
					var21 = new EntityGreenBallFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("ritual")) {
					var21 = new EntityRitualFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("activeRitual")) {
					var21 = new EntityActiveRitualFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("waterRitual")) {
					var21 = new EntityWaterRitualFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("fireForge")) {
					var21 = new EntityFireForgeFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("waterForge")) {
					var21 = new EntityWaterForgeFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("leaf")) {
					var21 = new EntityLeafFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("air")) {
					var21 = new EntityAirFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("glowstone")) {
					var21 = new EntityGlowstoneFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("blazerod")) {
					var21 = new EntityBlazeFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				} else if (particleName.equals("fish")) {
					var21 = new EntityFishFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				}else if (particleName.equals("hit")) {
					var21 = new EntityHitFX(theWorld, par2, par4, par6, (float) par8, (float) par10, (float) par12);
				}

				if (var21 != null) {
					mc.effectRenderer.addEffect(var21);
				}
				return var21;
			}
		}
		return null;
	}
}