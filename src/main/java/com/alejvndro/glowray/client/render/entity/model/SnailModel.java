package com.alejvndro.glowray.client.render.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;

public class SnailModel<T extends Entity> extends EntityModel<T> {
    // Se hornea en ClientModEvents.registerLayerDefinitions(...)
    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation("glowray", "snail"), "main");

    private final ModelPart root;
    private final ModelPart cuerpo;
    private final ModelPart cabeza;
    private final ModelPart antena_izq;
    private final ModelPart ojo_izq;
    private final ModelPart parpado_izq;
    private final ModelPart antena_der;
    private final ModelPart ojo_der;
    private final ModelPart parpado_der;
    private final ModelPart caparazon;

    public SnailModel(ModelPart root) {
        this.root = root.getChild("root");
        this.cuerpo = this.root.getChild("cuerpo");
        this.cabeza = this.cuerpo.getChild("cabeza");
        this.antena_izq = this.cabeza.getChild("antena_izq");
        this.ojo_izq = this.antena_izq.getChild("ojo_izq");
        this.parpado_izq = this.ojo_izq.getChild("parpado_izq");
        this.antena_der = this.cabeza.getChild("antena_der");
        this.ojo_der = this.antena_der.getChild("ojo_der");
        this.parpado_der = this.ojo_der.getChild("parpado_der");
        this.caparazon = this.cuerpo.getChild("caparazon");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
                "root",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 24.0F, 1.0F)
        );

        PartDefinition cuerpo = root.addOrReplaceChild(
                "cuerpo",
                CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-1.75F, -0.5F, -4.2F, 3.0F, 1.5F, 10.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -1.0F, 0.0F)
        );

        PartDefinition cabeza = cuerpo.addOrReplaceChild(
                "cabeza",
                CubeListBuilder.create().texOffs(24, 12)
                        .addBox(-1.5F, -1.5F, -3.0F, 2.5F, 2.5F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 0.0F, -4.0F)
        );

        PartDefinition antena_izq = cabeza.addOrReplaceChild(
                "antena_izq",
                CubeListBuilder.create().texOffs(16, 25)
                        .addBox(-0.4492F, -2.9657F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(0.5F, -1.3F, -2.1F, 0.0F, 0.0F, 0.0611F)
        );

        PartDefinition ojo_izq = antena_izq.addOrReplaceChild(
                "ojo_izq",
                CubeListBuilder.create().texOffs(24, 23)
                        .addBox(-0.9492F, -2.0657F, -1.0F, 2.0F, 2.5F, 2.0F, new CubeDeformation(-0.4F)),
                PartPose.offsetAndRotation(0.0F, -2.7F, 0.0F, 0.0F, 0.0F, -0.0873F)
        );

        PartDefinition parpado_izq = ojo_izq.addOrReplaceChild(
                "parpado_izq",
                CubeListBuilder.create().texOffs(8, 25)
                        .addBox(-0.9492F, -0.7657F, -1.0F, 2.0F, 1.5F, 1.5F, new CubeDeformation(-0.35F)),
                PartPose.offset(0.0F, -0.8F, 0.0F)
        );

        PartDefinition antena_der = cabeza.addOrReplaceChild(
                "antena_der",
                CubeListBuilder.create().texOffs(20, 25)
                        .addBox(-0.4295F, -0.1162F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(-0.1F)),
                PartPose.offsetAndRotation(-1.3F, -4.2F, -2.1F, 0.0F, 0.0F, -0.0611F)
        );

        PartDefinition ojo_der = antena_der.addOrReplaceChild(
                "ojo_der",
                CubeListBuilder.create().texOffs(24, 18)
                        .addBox(-0.9295F, -2.1162F, -1.0F, 2.0F, 2.5F, 2.0F, new CubeDeformation(-0.4F)),
                PartPose.offsetAndRotation(0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0873F)
        );

        PartDefinition parpado_der = ojo_der.addOrReplaceChild(
                "parpado_der",
                CubeListBuilder.create().texOffs(0, 25)
                        .addBox(-1.0295F, -0.8162F, -1.0F, 2.0F, 1.5F, 1.5F, new CubeDeformation(-0.35F)),
                PartPose.offset(0.1F, -0.8F, 0.0F)
        );

        cuerpo.addOrReplaceChild(
                "caparazon",
                CubeListBuilder.create().texOffs(0, 12)
                        .addBox(-2.5F, -6.0F, -3.5F, 4.5F, 6.0F, 7.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -0.5F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        // Reset a pose “base” si luego animas más cosas
        this.cabeza.xRot = 0.0F;
        this.cabeza.yRot = 0.0F;
        this.cabeza.zRot = 0.0F;

        // Head look (suave)
        this.cabeza.yRot = netHeadYaw * (Mth.PI / 180F) * 0.25F;
        this.cabeza.xRot = headPitch * (Mth.PI / 180F) * 0.25F;

        // Idle: antenas
        float t = ageInTicks * 0.1F;
        this.antena_izq.xRot = Mth.sin(t) * 0.10F;
        this.antena_izq.zRot = 0.0611F + Mth.cos(t) * 0.08F;

        this.antena_der.xRot = Mth.cos(t) * 0.10F;
        this.antena_der.zRot = -0.0611F + Mth.sin(t) * 0.08F;

        // Walk: “bamboleo” del cuerpo (cuando se mueve)
        float walk = Mth.sin(limbSwing * 0.8F) * limbSwingAmount;
        this.cuerpo.xRot = walk * 0.10F;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer,
                               int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}