package com.jared.mysticaltrinkets.client.render.block;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelShard extends ModelBase {
	// fields
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;
	ModelRenderer Shape13;

	public ModelShard() {
		textureWidth = 128;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 34, 15);
		Shape1.addBox(0F, 0F, 0F, 16, 1, 1);
		Shape1.setRotationPoint(-8F, 23F, 7F);
		Shape1.setTextureSize(128, 64);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 15);
		Shape2.addBox(0F, 0F, 0F, 16, 1, 1);
		Shape2.setRotationPoint(-8F, 23F, -8F);
		Shape2.setTextureSize(128, 64);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, 0F, 0F);
		Shape3 = new ModelRenderer(this, 68, 30);
		Shape3.addBox(0F, 0F, 0F, 1, 1, 16);
		Shape3.setRotationPoint(-8F, 23F, -8F);
		Shape3.setTextureSize(128, 64);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, 0F, 0F);
		Shape4 = new ModelRenderer(this, 72, 47);
		Shape4.addBox(0F, 0F, 0F, 1, 1, 16);
		Shape4.setRotationPoint(7F, 23F, -8F);
		Shape4.setTextureSize(128, 64);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 68, 47);
		Shape5.addBox(0F, 0F, 0F, 1, 16, 1);
		Shape5.setRotationPoint(-8F, 8F, 7F);
		Shape5.setTextureSize(128, 64);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 64, 47);
		Shape6.addBox(0F, 0F, 0F, 1, 16, 1);
		Shape6.setRotationPoint(7F, 8F, 7F);
		Shape6.setTextureSize(128, 64);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 60, 47);
		Shape7.addBox(0F, 0F, 0F, 1, 16, 1);
		Shape7.setRotationPoint(-8F, 8F, -8F);
		Shape7.setTextureSize(128, 64);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 56, 47);
		Shape8.addBox(0F, 0F, 0F, 1, 16, 1);
		Shape8.setRotationPoint(7F, 8F, -8F);
		Shape8.setTextureSize(128, 64);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 34, 17);
		Shape9.addBox(0F, 0F, 0F, 16, 1, 1);
		Shape9.setRotationPoint(-8F, 8F, 7F);
		Shape9.setTextureSize(128, 64);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 0, 17);
		Shape10.addBox(0F, 0F, 0F, 16, 1, 1);
		Shape10.setRotationPoint(-8F, 8F, -8F);
		Shape10.setTextureSize(128, 64);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 34, 19);
		Shape11.addBox(0F, 0F, 0F, 1, 1, 16);
		Shape11.setRotationPoint(-8F, 8F, -8F);
		Shape11.setTextureSize(128, 64);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 0, 19);
		Shape12.addBox(0F, 0F, 0F, 1, 1, 16);
		Shape12.setRotationPoint(7F, 8F, -8F);
		Shape12.setTextureSize(128, 64);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
		Shape13 = new ModelRenderer(this, 3, 40);
		Shape13.addBox(0F, 0F, 0F, 12, 12, 12);
		Shape13.setRotationPoint(-6F, 10F, -6F);
		Shape13.setTextureSize(128, 64);
		Shape13.mirror = true;
		setRotation(Shape13, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
	}

	public void render(float f5) {
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
		Shape13.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	}

}
