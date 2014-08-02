package com.jared.mysticaltrinkets.client.render.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.util.ResourceLocation;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderGoblin extends RenderLiving
{
    private static final ResourceLocation texture = new ResourceLocation("mysticaltrinkets:textures/model/Goblin.png");  //refers to:assets/yourmod/textures/entity/yourtexture.png

    public RenderGoblin(ModelBase par1ModelBase, float par2)
    {
        super(par1ModelBase, par2);
    }

   

	@Override
	protected ResourceLocation getEntityTexture(net.minecraft.entity.Entity var1) {
		return texture;
	}
}