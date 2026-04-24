package com.alejvndro.glowray.client.render.model;

import com.alejvndro.glowray.Glowray;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class StingRayModel<T extends Entity> extends HierarchicalModel<T> {

    // ✅ CORRECCIÓN: usa Glowray.MOD_ID en lugar de "glowray" hardcodeado
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation(Glowray.MOD_ID, "sting_ray"), "main");

    private final ModelPart root;
    private final ModelPart body;
    private final ModelPart bodyTop;
    private final ModelPart eyeLeft;
    private final ModelPart eyeRight;
    private final ModelPart wingLeft;
    private final ModelPart wingRight;
    private final ModelPart bodyBack;
    private final ModelPart finBackLeft;
    private final ModelPart finBackRight;
    private final ModelPart tailBase;
    private final ModelPart tailMid;
    private final ModelPart tailTip;

    public StingRayModel(ModelPart root) {
        this.root = root.getChild("root");
        this.body = this.root.getChild("body");
        this.bodyTop = this.body.getChild("body_top");
        this.eyeLeft = this.bodyTop.getChild("eye_left");
        this.eyeRight = this.bodyTop.getChild("eye_right");
        this.wingLeft = this.body.getChild("wing_left");
        this.wingRight = this.body.getChild("wing_right");
        this.bodyBack = this.body.getChild("body_back");
        this.finBackLeft = this.bodyBack.getChild("fin_back_left");
        this.finBackRight = this.bodyBack.getChild("fin_back_right");
        this.tailBase = this.body.getChild("tail_base");
        this.tailMid = this.tailBase.getChild("tail_mid");
        this.tailTip = this.tailMid.getChild("tail_tip");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));
        PartDefinition body = root.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 0).addBox(-5.5F, -3.0F, -8.0F, 11.0F, 3.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body_top = body.addOrReplaceChild("body_top", CubeListBuilder.create().texOffs(0, 18).addBox(-4.5F, -5.3F, -6.3F, 9.0F, 3.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        body_top.addOrReplaceChild("eye_left", CubeListBuilder.create().texOffs(42, 28).addBox(3.53F, -3.7F, -4.3F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        body_top.addOrReplaceChild("eye_right", CubeListBuilder.create().texOffs(48, 28).addBox(-4.53F, -3.7F, -4.3F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        body.addOrReplaceChild("wing_left", CubeListBuilder.create().texOffs(0, 33).addBox(4.5F, -2.99F, -7.99F, 4.0F, 2.98F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        body.addOrReplaceChild("wing_right", CubeListBuilder.create().texOffs(36, 33).addBox(-8.5F, -2.99F, -7.99F, 4.0F, 2.98F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition body_back = body.addOrReplaceChild("body_back", CubeListBuilder.create().texOffs(42, 18).addBox(-3.0F, -4.1F, 4.7F, 6.0F, 4.0F, 6.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition fin_back_left = body_back.addOrReplaceChild("fin_back_left", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        fin_back_left.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(52, 0).addBox(-2.0813F, -0.8F, 0.6075F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.5F, -1.5F, 6.5F, 0.0F, 0.7941F, 0.0F));
        PartDefinition fin_back_right = body_back.addOrReplaceChild("fin_back_right", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));
        fin_back_right.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(52, 6).addBox(-1.8727F, -0.9F, 0.6439F, 4.0F, 2.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.5F, -1.5F, 6.5F, 0.0F, -0.7941F, 0.0F));

        PartDefinition tail_base = body.addOrReplaceChild("tail_base", CubeListBuilder.create().texOffs(22, 50).addBox(-1.5F, -3.5F, 9.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        PartDefinition tail_mid = tail_base.addOrReplaceChild("tail_mid", CubeListBuilder.create().texOffs(42, 50).addBox(-1.5F, -3.5F, 15.0F, 3.0F, 3.0F, 7.0F, new CubeDeformation(-0.03F)), PartPose.offset(0.0F, 0.0F, 0.0F));
        tail_mid.addOrReplaceChild("tail_tip", CubeListBuilder.create().texOffs(0, 50).addBox(-1.5F, -3.5F, 21.0F, 3.0F, 3.0F, 8.0F, new CubeDeformation(-0.06F)), PartPose.offset(0.0F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 128, 128);
    }

    @Override
    public ModelPart root() { return this.root; }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        this.body.xRot = headPitch * ((float)Math.PI / 180F);

        float swimSpeed = 0.6F;
        float moveWave = Mth.sin(limbSwing * swimSpeed) * limbSwingAmount;

        float idleSpeed = 0.1F;
        float idleWave = Mth.sin(ageInTicks * idleSpeed) * 0.1F;

        this.wingLeft.zRot = (moveWave * 0.8F) + idleWave;
        this.wingRight.zRot = -(moveWave * 0.8F) - idleWave;

        this.finBackLeft.zRot = (moveWave * 0.3F) + (idleWave * 0.5F);
        this.finBackRight.zRot = -(moveWave * 0.3F) - (idleWave * 0.5F);

        float tailMoveSpeed = 0.5F;
        this.tailBase.xRot = Mth.sin(limbSwing * tailMoveSpeed) * 0.1F * limbSwingAmount;
        this.tailMid.xRot = Mth.sin((limbSwing * tailMoveSpeed) - 1F) * 0.15F * limbSwingAmount;
        this.tailTip.xRot = Mth.sin((limbSwing * tailMoveSpeed) - 2F) * 0.2F * limbSwingAmount;
        this.tailTip.xRot += Mth.sin(ageInTicks * 0.05F) * 0.02F;

        this.body.y += Mth.cos(ageInTicks * 0.1F) * 1.5F;
        this.body.xRot += moveWave * 0.1F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}