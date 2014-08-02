package com.jared.mysticaltrinkets.client.render.entities;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelGoblin extends ModelBase
{
  //fields
    ModelRenderer FootRight;
    ModelRenderer FootLeft;
    ModelRenderer LegRight;
    ModelRenderer LegLeft;
    ModelRenderer LowerBody;
    ModelRenderer UpperBody;
    ModelRenderer Head;
    ModelRenderer RightArm;
    ModelRenderer LeftArm;
    ModelRenderer ShoulderRight;
    ModelRenderer ShoulderLeft;
  
  public ModelGoblin()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      FootRight = new ModelRenderer(this, 0, 0);
      FootRight.addBox(0F, 0F, 0F, 3, 2, 8);
      FootRight.setRotationPoint(3F, 22F, -4F);
      FootRight.setTextureSize(128, 64);
      FootRight.mirror = true;
      setRotation(FootRight, 0F, 0F, 0F);
      FootLeft = new ModelRenderer(this, 0, 0);
      FootLeft.addBox(0F, 0F, 0F, 3, 2, 8);
      FootLeft.setRotationPoint(-6F, 22F, -4F);
      FootLeft.setTextureSize(128, 64);
      FootLeft.mirror = true;
      setRotation(FootLeft, 0F, 0F, 0F);
      LegRight = new ModelRenderer(this, 28, 0);
      LegRight.addBox(0F, 0F, 0F, 1, 6, 2);
      LegRight.setRotationPoint(4F, 16F, 1F);
      LegRight.setTextureSize(128, 64);
      LegRight.mirror = true;
      setRotation(LegRight, 0F, 0F, 0F);
      LegLeft = new ModelRenderer(this, 22, 0);
      LegLeft.addBox(0F, 0F, 0F, 1, 6, 2);
      LegLeft.setRotationPoint(-5F, 16F, 1F);
      LegLeft.setTextureSize(128, 64);
      LegLeft.mirror = true;
      setRotation(LegLeft, 0F, 0F, 0F);
      LowerBody = new ModelRenderer(this, 8, 10);
      LowerBody.addBox(0F, 0F, 0F, 12, 5, 5);
      LowerBody.setRotationPoint(-6F, 11F, 0F);
      LowerBody.setTextureSize(128, 64);
      LowerBody.mirror = true;
      setRotation(LowerBody, 0F, 0F, 0F);
      UpperBody = new ModelRenderer(this, 0, 20);
      UpperBody.addBox(0F, 0F, 0F, 14, 12, 7);
      UpperBody.setRotationPoint(-7F, -1F, -1F);
      UpperBody.setTextureSize(128, 64);
      UpperBody.mirror = true;
      setRotation(UpperBody, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 39);
      Head.addBox(0F, 0F, 0F, 10, 9, 9);
      Head.setRotationPoint(-5F, -10F, -2F);
      Head.setTextureSize(128, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 0F, 0F);
      RightArm = new ModelRenderer(this, 46, 0);
      RightArm.addBox(0F, 0F, 0F, 1, 10, 1);
      RightArm.setRotationPoint(7F, 0.5F, 2.5F);
      RightArm.setTextureSize(128, 64);
      RightArm.mirror = true;
      setRotation(RightArm, -0.7853982F, 0F, 0F);
      LeftArm = new ModelRenderer(this, 42, 0);
      LeftArm.addBox(0F, 0F, 0F, 1, 10, 1);
      LeftArm.setRotationPoint(-8F, 0.5F, 2.5F);
      LeftArm.setTextureSize(128, 64);
      LeftArm.mirror = true;
      setRotation(LeftArm, -0.7853982F, 0F, 0F);
      ShoulderRight = new ModelRenderer(this, 0, 57);
      ShoulderRight.addBox(0F, 0F, 0F, 1, 3, 3);
      ShoulderRight.setRotationPoint(7F, 0F, 1F);
      ShoulderRight.setTextureSize(128, 64);
      ShoulderRight.mirror = true;
      setRotation(ShoulderRight, 0F, 0F, 0F);
      ShoulderLeft = new ModelRenderer(this, 8, 57);
      ShoulderLeft.addBox(0F, 0F, 0F, 1, 3, 3);
      ShoulderLeft.setRotationPoint(-8F, 0F, 1F);
      ShoulderLeft.setTextureSize(128, 64);
      ShoulderLeft.mirror = true;
      setRotation(ShoulderLeft, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    FootRight.render(f5);
    FootLeft.render(f5);
    LegRight.render(f5);
    LegLeft.render(f5);
    LowerBody.render(f5);
    UpperBody.render(f5);
    Head.render(f5);
    RightArm.render(f5);
    LeftArm.render(f5);
    ShoulderRight.render(f5);
    ShoulderLeft.render(f5);
  }
  
  public void render(float f5){
	  FootRight.render(f5);
	    FootLeft.render(f5);
	    LegRight.render(f5);
	    LegLeft.render(f5);
	    LowerBody.render(f5);
	    UpperBody.render(f5);
	    Head.render(f5);
	    RightArm.render(f5);
	    LeftArm.render(f5);
	    ShoulderRight.render(f5);
	    ShoulderLeft.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
