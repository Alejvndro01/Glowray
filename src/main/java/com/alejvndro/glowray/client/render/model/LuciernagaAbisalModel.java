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

public class LuciernagaAbisalModel<T extends Entity> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation(Glowray.MOD_ID, "luciernaga_abisal"), "main");

    private final ModelPart root;
    private final ModelPart cuerpo;
    private final ModelPart cuerpo_trasero;
    private final ModelPart cabeza;
    private final ModelPart antena_der;
    private final ModelPart antena_izq;
    private final ModelPart ojo_der;
    private final ModelPart ojo_izq;
    private final ModelPart ala_der;
    private final ModelPart ala_izq;
    private final ModelPart patas;

    public LuciernagaAbisalModel(ModelPart root) {
        this.root = root.getChild("root");
        this.cuerpo = this.root.getChild("cuerpo");
        this.cuerpo_trasero = this.cuerpo.getChild("cuerpo_trasero");
        this.cabeza = this.cuerpo.getChild("cabeza");
        this.antena_der = this.cabeza.getChild("antena_der");
        this.antena_izq = this.cabeza.getChild("antena_izq");
        this.ojo_der = this.cabeza.getChild("ojo_der");
        this.ojo_izq = this.cabeza.getChild("ojo_izq");
        this.ala_der = this.cuerpo.getChild("ala_der");
        this.ala_izq = this.cuerpo.getChild("ala_izq");
        this.patas = this.cuerpo.getChild("patas");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
                "root",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 24.0F, 0.0F)
        );

        // Main body (thorax) – 4w × 2h × 6d
        PartDefinition cuerpo = root.addOrReplaceChild(
                "cuerpo",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-2.0F, -1.0F, -3.0F, 4.0F, 2.0F, 6.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -2.0F, 0.0F)
        );

        // Abdomen (glowing back body) – 3w × 3h × 4d
        cuerpo.addOrReplaceChild(
                "cuerpo_trasero",
                CubeListBuilder.create()
                        .texOffs(0, 8)
                        .addBox(-1.5F, -1.5F, 0.0F, 3.0F, 3.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -0.5F, 2.5F)
        );

        // Head – 3w × 3h × 3d
        PartDefinition cabeza = cuerpo.addOrReplaceChild(
                "cabeza",
                CubeListBuilder.create()
                        .texOffs(14, 0)
                        .addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, -1.0F, -3.0F)
        );

        // Right antenna – 1w × 3h × 1d
        cabeza.addOrReplaceChild(
                "antena_der",
                CubeListBuilder.create()
                        .texOffs(26, 0)
                        .addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(1.0F, -1.5F, -1.5F, 0.0F, 0.0F, 0.2618F)
        );

        // Left antenna – 1w × 3h × 1d
        cabeza.addOrReplaceChild(
                "antena_izq",
                CubeListBuilder.create()
                        .texOffs(30, 0)
                        .addBox(-0.5F, -3.0F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-1.0F, -1.5F, -1.5F, 0.0F, 0.0F, -0.2618F)
        );

        // Right eye – 1w × 1h × 1d
        cabeza.addOrReplaceChild(
                "ojo_der",
                CubeListBuilder.create()
                        .texOffs(34, 0)
                        .addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(1.2F, 0.0F, -2.7F)
        );

        // Left eye – 1w × 1h × 1d
        cabeza.addOrReplaceChild(
                "ojo_izq",
                CubeListBuilder.create()
                        .texOffs(38, 0)
                        .addBox(-0.5F, -0.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-1.2F, 0.0F, -2.7F)
        );

        // Right wing – 5w × 1h × 4d (thin flat wing)
        cuerpo.addOrReplaceChild(
                "ala_der",
                CubeListBuilder.create()
                        .texOffs(0, 15)
                        .addBox(0.0F, -0.5F, -2.5F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(2.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.2618F)
        );

        // Left wing – 5w × 1h × 4d
        cuerpo.addOrReplaceChild(
                "ala_izq",
                CubeListBuilder.create()
                        .texOffs(0, 20)
                        .addBox(-5.0F, -0.5F, -2.5F, 5.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(-2.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.2618F)
        );

        // Legs (two small leg cubes) – each 1w × 2h × 1d
        PartDefinition patas = cuerpo.addOrReplaceChild(
                "patas",
                CubeListBuilder.create()
                        .texOffs(0, 25).addBox(-2.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                        .texOffs(4, 25).addBox(1.0F, 0.0F, -1.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.0F, 1.0F, 0.0F)
        );

        return LayerDefinition.create(meshdefinition, 64, 32);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks,
                          float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        // Wing flap – fast oscillation
        float flapSpeed = 1.5F;
        float flapAmp = 0.75F;
        float flap = Mth.sin(ageInTicks * flapSpeed) * flapAmp;
        this.ala_der.zRot = 0.2618F + flap;
        this.ala_izq.zRot = -0.2618F - flap;

        // Subtle body bob (add to reset pose y)
        this.root.y += Mth.sin(ageInTicks * 0.1F) * 0.5F;

        // Root sway (side to side)
        this.root.zRot = Mth.sin(ageInTicks * 0.07F) * 0.05F;

        // Head tracking
        this.cabeza.yRot = netHeadYaw * ((float) Math.PI / 180F) * 0.3F;
        this.cabeza.xRot = headPitch * ((float) Math.PI / 180F) * 0.3F;

        // Antenna subtle movement
        float antennaWave = Mth.sin(ageInTicks * 0.3F) * 0.1F;
        this.antena_der.zRot = 0.2618F + antennaWave;
        this.antena_izq.zRot = -0.2618F - antennaWave;

        // Abdomen glow pulse (scale breathing effect)
        float pulse = 1.0F + Mth.sin(ageInTicks * 0.2F) * 0.05F;
        this.cuerpo_trasero.xScale = pulse;
        this.cuerpo_trasero.yScale = pulse;
        this.cuerpo_trasero.zScale = pulse;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight,
                               int packedOverlay, float red, float green, float blue, float alpha) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
