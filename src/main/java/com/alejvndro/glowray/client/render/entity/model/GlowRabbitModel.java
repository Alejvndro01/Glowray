package com.alejvndro.glowray.client.render.entity.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HierarchicalModel;
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

public class GlowRabbitModel<T extends Entity> extends HierarchicalModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION =
            new ModelLayerLocation(new ResourceLocation("glowray", "glow_rabbit"), "main");

    private final ModelPart root;
    private final ModelPart cuerpo;
    private final ModelPart pata_delantera_izquierda;
    private final ModelPart pata_delantera_derecha;
    private final ModelPart head;
    private final ModelPart oreja_izq;
    private final ModelPart oreja_der;
    private final ModelPart hocico;
    private final ModelPart nariz;
    private final ModelPart ojo_izq;
    private final ModelPart ojo_der;
    private final ModelPart cuerpo_trasero;
    private final ModelPart muslo_izq;
    private final ModelPart pata_izq_tra;
    private final ModelPart muslo_der;
    private final ModelPart pata_der_tra;
    private final ModelPart cola;

    public GlowRabbitModel(ModelPart root) {
        this.root = root.getChild("root");
        this.cuerpo = this.root.getChild("cuerpo");
        this.pata_delantera_izquierda = this.cuerpo.getChild("pata_delantera_izquierda");
        this.pata_delantera_derecha = this.cuerpo.getChild("pata_delantera_derecha");
        this.head = this.cuerpo.getChild("head");
        this.oreja_izq = this.head.getChild("oreja_izq");
        this.oreja_der = this.head.getChild("oreja_der");
        this.hocico = this.head.getChild("hocico");
        this.nariz = this.hocico.getChild("nariz");
        this.ojo_izq = this.head.getChild("ojo_izq");
        this.ojo_der = this.head.getChild("ojo_der");
        this.cuerpo_trasero = this.cuerpo.getChild("cuerpo_trasero");
        this.muslo_izq = this.cuerpo_trasero.getChild("muslo_izq");
        this.pata_izq_tra = this.muslo_izq.getChild("pata_izq_tra");
        this.muslo_der = this.cuerpo_trasero.getChild("muslo_der");
        this.pata_der_tra = this.muslo_der.getChild("pata_der_tra");
        this.cola = this.cuerpo_trasero.getChild("cola");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition root = partdefinition.addOrReplaceChild(
                "root",
                CubeListBuilder.create(),
                PartPose.offset(-1.5F, 18.0F, -1.5F) // deja este valor como tú lo calibraste
        );

        PartDefinition cuerpo = root.addOrReplaceChild("cuerpo", CubeListBuilder.create(), PartPose.offset(0.0F, 0.6F, -1.8F));

        cuerpo.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 10)
                        .addBox(-2.5F, -2.5307F, -0.8505F, 5.0F, 5.0F, 5.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

        PartDefinition pata_delantera_izquierda = cuerpo.addOrReplaceChild("pata_delantera_izquierda", CubeListBuilder.create(), PartPose.offset(1.5F, 2.4F, 0.4F));
        pata_delantera_izquierda.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(28, 24)
                        .addBox(-0.8F, -1.4393F, -1.0203F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition pata_delantera_derecha = cuerpo.addOrReplaceChild("pata_delantera_derecha", CubeListBuilder.create(), PartPose.offset(-1.7F, 2.4F, 0.4F));
        pata_delantera_derecha.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(20, 16)
                        .addBox(-1.0F, -1.4775F, -1.1306F, 2.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.2618F, 0.0F, 0.0F));

        PartDefinition head = cuerpo.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0)
                        .addBox(-2.4F, -4.0F, -4.8F, 5.0F, 5.0F, 5.0F, new CubeDeformation(-0.1F))
                        .texOffs(32, 7).addBox(1.5F, -2.0F, -4.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)),
                PartPose.offset(-0.1F, -0.3F, 0.1F));

        head.addOrReplaceChild("oreja_izq", CubeListBuilder.create().texOffs(14, 29)
                        .addBox(-0.9F, -4.2F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(1.6F, -3.5F, -1.3F));

        head.addOrReplaceChild("oreja_der", CubeListBuilder.create().texOffs(0, 29)
                        .addBox(-1.0F, -4.2F, -0.5F, 2.0F, 5.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(-1.5F, -3.5F, -1.3F));

        PartDefinition hocico = head.addOrReplaceChild("hocico", CubeListBuilder.create().texOffs(32, 0)
                        .addBox(-1.5F, -1.0F, -0.8F, 3.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offset(0.1F, 0.0F, -4.8F));

        hocico.addOrReplaceChild("nariz", CubeListBuilder.create().texOffs(32, 3)
                        .addBox(-0.5F, -0.8F, -0.7F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, -0.3F, -0.2F, 0.0F, 0.0F, 0.0035F));

        head.addOrReplaceChild("ojo_izq", CubeListBuilder.create(), PartPose.offset(2.1F, -1.5F, -4.3F));
        head.addOrReplaceChild("ojo_der", CubeListBuilder.create().texOffs(32, 5)
                        .addBox(-0.4F, -0.5F, -0.4F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.01F)),
                PartPose.offset(-1.9F, -1.5F, -4.3F));

        PartDefinition cuerpo_trasero = cuerpo.addOrReplaceChild("cuerpo_trasero", CubeListBuilder.create(), PartPose.offset(0.2F, 0.9F, 3.8F));
        cuerpo_trasero.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 20)
                        .addBox(-2.7F, -1.8556F, -0.7516F, 5.0F, 4.0F, 5.0F, new CubeDeformation(-0.4F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        PartDefinition muslo_izq = cuerpo_trasero.addOrReplaceChild("muslo_izq", CubeListBuilder.create(), PartPose.offset(1.3F, 1.5F, 1.1F));
        muslo_izq.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(20, 8)
                        .addBox(-1.0F, -1.36F, -0.9827F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition pata_izq_tra = muslo_izq.addOrReplaceChild("pata_izq_tra", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 1.5F));
        pata_izq_tra.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(28, 16)
                        .addBox(-1.0F, -0.7F, -0.6F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.15F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition muslo_der = cuerpo_trasero.addOrReplaceChild("muslo_der", CubeListBuilder.create(), PartPose.offset(-1.7F, 1.5F, 1.1F));
        muslo_der.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(20, 0)
                        .addBox(-1.0F, -1.1303F, -0.9827F, 2.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.4363F, 0.0F, 0.0F));

        PartDefinition pata_der_tra = muslo_der.addOrReplaceChild("pata_der_tra", CubeListBuilder.create(), PartPose.offset(0.0F, 3.0F, 1.5F));
        pata_der_tra.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(20, 24)
                        .addBox(-1.0F, -0.7F, -0.6F, 2.0F, 6.0F, 2.0F, new CubeDeformation(-0.15F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

        PartDefinition cola = cuerpo_trasero.addOrReplaceChild("cola", CubeListBuilder.create(), PartPose.offset(-0.2F, 0.5F, 3.6F));
        cola.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(6, 29)
                        .addBox(-1.0F, -1.308F, -0.8546F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3491F, 0.0F, 0.0F));

        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public ModelPart root() {
        return this.root;
    }

    @Override
    public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.root().getAllParts().forEach(ModelPart::resetPose);

        // Velocidades por animación (mantiene el “estilo” del JSON pero sin vibración)
        final float SPEED_IDLE   = 0.025F;
        final float SPEED_LOOKAT = 0.025F;

        final float SPEED_WALK   = 0.0025F;
        final float SPEED_PANIC  = 0.0020F;
        final float SPEED_SWIM   = 0.080F;

        final float SPEED_SHAKE  = 0.080F;

        float animSeconds = ageInTicks / 20.0F;

        // “animTime” por modo (lo definimos después de elegir modo)
        float ty = netHeadYaw;
        float tx = headPitch;

        boolean inWater = entity.isInWater();
        boolean moving = limbSwingAmount > 0.15F;
        boolean panic = entity.isSprinting();

        boolean sleeping = entity.level().isNight() && limbSwingAmount < 0.08F;

        boolean shaking = false;

        enum Mode {SLEEP, SWIM, PANIC, WALK, IDLE, SHAKE}
        Mode mode;
        if (shaking) mode = Mode.SHAKE;
        else if (sleeping) mode = Mode.SLEEP;
        else if (inWater) mode = Mode.SWIM;
        else if (panic) mode = Mode.PANIC;
        else if (moving) mode = Mode.WALK;
        else mode = Mode.IDLE;

        // Tiempo para look_at (siempre)
        float lookTime = animSeconds * SPEED_LOOKAT;

        // LOOK_AT
        this.cuerpo.yRot += ty * 0.2F * ((float)Math.PI / 180F);
        this.cuerpo.zRot += ty * -0.1F * ((float)Math.PI / 180F);

        float headIdleX = Mth.sin(lookTime * 80.0F - 40.0F) * -1.5F;
        this.head.xRot += (Mth.lerp(0.4F, 0.0F, tx) + headIdleX) * ((float)Math.PI / 180F);
        this.head.yRot += (Mth.lerp(0.4F, 0.0F, ty)) * ((float)Math.PI / 180F);
        this.head.zRot += (ty * 0.1F) * ((float)Math.PI / 180F);

        this.oreja_izq.xRot += (Mth.cos(lookTime * 80.0F - 60.0F) * 4.0F) * ((float)Math.PI / 180F);
        this.oreja_izq.yRot += (ty * 0.15F) * ((float)Math.PI / 180F);
        this.oreja_izq.zRot += (2.0F + ty * 0.1F) * ((float)Math.PI / 180F);

        this.oreja_der.xRot += (Mth.cos(lookTime * 80.0F - 65.0F) * 3.5F) * ((float)Math.PI / 180F);
        this.oreja_der.yRot += (ty * 0.15F) * ((float)Math.PI / 180F);
        this.oreja_der.zRot += (-2.0F + ty * 0.1F) * ((float)Math.PI / 180F);

        this.nariz.y += Mth.abs(Mth.sin(lookTime * 600.0F)) * 0.08F;

        // Elegir animTime y walkTime según modo
        float animTime;
        float walkTime;
        switch (mode) {
            case WALK -> {
                animTime = animSeconds * SPEED_WALK;
                walkTime = limbSwing * SPEED_WALK;
            }
            case PANIC -> {
                animTime = animSeconds * SPEED_PANIC;
                walkTime = limbSwing * SPEED_PANIC;
            }
            case SWIM -> {
                animTime = animSeconds * SPEED_SWIM;
                walkTime = limbSwing * SPEED_SWIM;
            }
            case SHAKE -> {
                animTime = animSeconds * SPEED_SHAKE;
                walkTime = limbSwing * SPEED_SHAKE;
            }
            case SLEEP -> {
                animTime = animSeconds * SPEED_IDLE; // sleep viene con *40; con esto queda suave
                walkTime = limbSwing * SPEED_IDLE;
            }
            default -> {
                animTime = animSeconds * SPEED_IDLE;
                walkTime = limbSwing * SPEED_IDLE;
            }
        }

        switch (mode) {
            case IDLE -> {
                this.root.y += Mth.sin(animTime * 80.0F) * 0.05F;

                this.cuerpo.y += Mth.sin(animTime * 80.0F - 10.0F) * 0.02F;
                this.cuerpo.xRot += (Mth.sin(animTime * 80.0F - 20.0F) * 1.2F) * ((float)Math.PI / 180F);

                this.head.xRot += (Mth.sin(animTime * 80.0F - 40.0F) * -1.5F + Mth.sin(animTime * 20.0F) * 1.5F) * ((float)Math.PI / 180F);
                this.head.yRot += (Mth.sin(animTime * 45.0F) * 4.0F) * ((float)Math.PI / 180F);
                this.head.zRot += (Mth.sin(animTime * 45.0F) * 1.5F) * ((float)Math.PI / 180F);

                float earIzqExtra = ((animTime % 6.0F) > 5.7F) ? (Mth.sin(animTime * 1500.0F) * 4.0F) : 0.0F;
                this.oreja_izq.xRot += (Mth.cos(animTime * 80.0F - 60.0F) * 4.0F + earIzqExtra) * ((float)Math.PI / 180F);
                this.oreja_izq.zRot += (2.0F + Mth.sin(animTime * 40.0F) * 2.0F) * ((float)Math.PI / 180F);

                float earDerExtra = ((animTime % 4.5F) > 4.2F) ? (Mth.sin(animTime * 1500.0F) * 3.0F) : 0.0F;
                this.oreja_der.xRot += (Mth.cos(animTime * 80.0F - 65.0F) * 3.5F + earDerExtra) * ((float)Math.PI / 180F);
                this.oreja_der.zRot += (-2.0F + Mth.sin(animTime * 40.0F + (float)Math.PI) * 2.0F) * ((float)Math.PI / 180F);

                float n = Mth.abs(Mth.sin(animTime * 600.0F));
                this.nariz.y += n * 0.08F;
                this.nariz.z += (-0.05F + n * 0.02F);
            }

            case WALK -> {
                float t = walkTime * 1.2F;

                float s360 = Mth.sin(t * 360.0F);
                float s180 = Mth.sin(t * 180.0F);

                this.cuerpo.y += Mth.abs(s360) * 1.2F;
                this.cuerpo.xRot += (s360 * 8.0F) * ((float)Math.PI / 180F);
                this.cuerpo.zRot += (s180 * 2.0F) * ((float)Math.PI / 180F);

                this.head.xRot += (Mth.sin(t * 360.0F - 45.0F) * -10.0F) * ((float)Math.PI / 180F);

                this.pata_delantera_izquierda.xRot += (Mth.sin(t * 360.0F + 90.0F) * 30.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_derecha.xRot += (Mth.sin(t * 360.0F + 120.0F) * 30.0F) * ((float)Math.PI / 180F);

                this.muslo_izq.xRot += (Mth.sin(t * 360.0F - 90.0F) * 40.0F) * ((float)Math.PI / 180F);
                this.muslo_der.xRot += (Mth.sin(t * 360.0F - 90.0F) * 40.0F) * ((float)Math.PI / 180F);

                this.oreja_izq.xRot += (Mth.sin(t * 360.0F - 120.0F) * 25.0F) * ((float)Math.PI / 180F);
                this.oreja_der.xRot += (Mth.sin(t * 360.0F - 120.0F) * 25.0F) * ((float)Math.PI / 180F);
            }

            case PANIC -> {
                float t = animTime * 1.2F;

                this.cuerpo.x += Mth.sin(t * 700.0F) * 0.1F;
                this.cuerpo.y += Mth.abs(Mth.sin(t * 600.0F)) * 0.9F;

                this.cuerpo.xRot += (Mth.sin(t * 600.0F) * 12.0F) * ((float)Math.PI / 180F);
                this.cuerpo.zRot += (Mth.sin(t * 700.0F) * 3.0F) * ((float)Math.PI / 180F);

                this.head.xRot += (Mth.sin(t * 600.0F - 25.0F) * -10.0F) * ((float)Math.PI / 180F);

                this.pata_delantera_izquierda.xRot += (Mth.sin(t * 600.0F + 70.0F) * 36.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_derecha.xRot += (Mth.sin(t * 600.0F + 100.0F) * 36.0F) * ((float)Math.PI / 180F);

                this.muslo_izq.xRot += (Mth.sin(t * 600.0F - 60.0F) * 42.0F) * ((float)Math.PI / 180F);
                this.muslo_der.xRot += (Mth.sin(t * 600.0F - 60.0F) * 42.0F) * ((float)Math.PI / 180F);

                this.oreja_izq.xRot += (-50.0F + Mth.sin(t * 1200.0F) * 3.0F) * ((float)Math.PI / 180F);
                this.oreja_izq.yRot += (18.0F) * ((float)Math.PI / 180F);
                this.oreja_izq.zRot += (Mth.sin(t * 700.0F) * 4.0F) * ((float)Math.PI / 180F);

                this.oreja_der.xRot += (-50.0F + Mth.sin(t * 1200.0F + (float)Math.PI) * 3.0F) * ((float)Math.PI / 180F);
                this.oreja_der.yRot += (-18.0F) * ((float)Math.PI / 180F);
                this.oreja_der.zRot += (Mth.sin(t * 700.0F) * -4.0F) * ((float)Math.PI / 180F);
            }

            case SWIM -> {
                float t = animTime * 0.9F;

                this.root.y += (Mth.sin(t * 120.0F) * 0.5F - 1.0F);
                this.root.xRot += (-15.0F) * ((float)Math.PI / 180F);

                this.cuerpo.y += Mth.sin(t * 120.0F - 20.0F) * 0.1F;

                this.cuerpo.xRot += (Mth.sin(t * 120.0F - 40.0F) * 2.0F) * ((float)Math.PI / 180F);
                this.cuerpo.zRot += (Mth.sin(t * 60.0F) * 1.5F) * ((float)Math.PI / 180F);

                this.head.xRot += (25.0F + Mth.sin(t * 120.0F - 60.0F) * -3.0F) * ((float)Math.PI / 180F);
                this.head.zRot += (Mth.sin(t * 60.0F) * -2.0F) * ((float)Math.PI / 180F);

                this.pata_delantera_izquierda.xRot += (Mth.sin(t * 600.0F) * 40.0F - 20.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_izquierda.zRot += (10.0F) * ((float)Math.PI / 180F);

                this.pata_delantera_derecha.xRot += (Mth.sin(t * 600.0F + (float)Math.PI) * 40.0F - 20.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_derecha.zRot += (-10.0F) * ((float)Math.PI / 180F);

                this.muslo_izq.xRot += (20.0F + Mth.sin(t * 600.0F + ((float)Math.PI / 2F)) * 45.0F) * ((float)Math.PI / 180F);
                this.muslo_der.xRot += (20.0F + Mth.sin(t * 600.0F - ((float)Math.PI / 2F)) * 45.0F) * ((float)Math.PI / 180F);

                this.oreja_izq.xRot += (-45.0F) * ((float)Math.PI / 180F);
                this.oreja_izq.yRot += (10.0F) * ((float)Math.PI / 180F);
                this.oreja_izq.zRot += (15.0F + Mth.sin(t * 120.0F) * 2.0F) * ((float)Math.PI / 180F);

                this.oreja_der.xRot += (-45.0F) * ((float)Math.PI / 180F);
                this.oreja_der.yRot += (-10.0F) * ((float)Math.PI / 180F);
                this.oreja_der.zRot += (-15.0F + Mth.sin(t * 120.0F) * -2.0F) * ((float)Math.PI / 180F);

                this.nariz.y += Mth.abs(Mth.sin(t * 800.0F)) * 0.1F;
                this.nariz.z += -0.05F;
            }

            case SLEEP -> {
                float t = animTime;

                this.root.y += (-3.3F + Mth.sin(t * 40.0F) * 0.04F);
                this.root.zRot += 15.0F * ((float)Math.PI / 180F);

                this.cuerpo.xRot += (2.0F + Mth.sin(t * 40.0F - 20.0F) * 0.5F) * ((float)Math.PI / 180F);

                this.head.y += (-0.2F + Mth.sin(t * 40.0F - 40.0F) * 0.02F);
                this.head.z += -0.1F;
                this.head.xRot += (25.0F + Mth.sin(t * 40.0F) * 0.8F) * ((float)Math.PI / 180F);
                this.head.yRot += (-10.0F) * ((float)Math.PI / 180F);
                this.head.zRot += (-8.0F) * ((float)Math.PI / 180F);

                this.pata_delantera_izquierda.xRot += (-85.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_izquierda.yRot += (10.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_izquierda.zRot += (-15.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_izquierda.y += 0.1F;

                this.pata_delantera_derecha.xRot += (-80.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_derecha.yRot += (-5.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_derecha.zRot += (10.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_derecha.y += 0.1F;

                this.muslo_izq.xRot += (-50.0F) * ((float)Math.PI / 180F);
                this.muslo_izq.y += 1.8F;

                this.muslo_der.xRot += (-40.0F) * ((float)Math.PI / 180F);
                this.muslo_der.y += 1.6F;

                this.pata_izq_tra.xRot += (50.0F) * ((float)Math.PI / 180F);
                this.pata_izq_tra.y += 0.4F;
                this.pata_izq_tra.z += -0.4F;

                this.pata_der_tra.xRot += (40.0F) * ((float)Math.PI / 180F);
                this.pata_der_tra.y += 0.4F;
                this.pata_der_tra.z += -0.4F;

                float earIzq = 80.0F + (((t % 5.0F) > 4.8F) ? (Mth.sin(t * 2000.0F) * 2.0F) : (Mth.sin(t * 30.0F) * 1.0F));
                float earIzqZ = 50.0F + Mth.cos(t * 30.0F) * 0.5F;
                this.oreja_izq.xRot += earIzq * ((float)Math.PI / 180F);
                this.oreja_izq.zRot += earIzqZ * ((float)Math.PI / 180F);

                float earDer = 65.0F + (((t % 7.0F) > 6.7F) ? (Mth.sin(t * 2000.0F) * 3.0F) : (Mth.sin(t * 30.0F + (float)Math.PI) * 1.0F));
                float earDerZ = 40.0F + Mth.cos(t * 30.0F + (float)Math.PI) * 0.5F;
                this.oreja_der.xRot += earDer * ((float)Math.PI / 180F);
                this.oreja_der.zRot += earDerZ * ((float)Math.PI / 180F);
            }

            case SHAKE -> {
                float t = animTime;

                this.root.zRot += (Mth.sin(t * 2500.0F) * 2.0F) * ((float)Math.PI / 180F);
                this.cuerpo.yRot += (Mth.sin(t * 2000.0F) * 15.0F) * ((float)Math.PI / 180F);

                this.head.xRot += (Mth.sin(t * 2000.0F + 40.0F) * 5.0F) * ((float)Math.PI / 180F);
                this.head.yRot += (Mth.sin(t * 2000.0F + 60.0F) * 25.0F) * ((float)Math.PI / 180F);
                this.head.zRot += (Mth.sin(t * 2000.0F) * 10.0F) * ((float)Math.PI / 180F);

                this.oreja_izq.xRot += (30.0F + Mth.sin(t * 2000.0F + 80.0F) * 20.0F) * ((float)Math.PI / 180F);
                this.oreja_izq.zRot += (20.0F + Mth.sin(t * 2000.0F + 80.0F) * 30.0F) * ((float)Math.PI / 180F);

                this.oreja_der.xRot += (30.0F + Mth.sin(t * 2000.0F + 90.0F) * 20.0F) * ((float)Math.PI / 180F);
                this.oreja_der.zRot += (-20.0F + Mth.sin(t * 2000.0F + 90.0F) * 30.0F) * ((float)Math.PI / 180F);

                this.pata_delantera_izquierda.zRot += (Mth.sin(t * 2000.0F) * 5.0F) * ((float)Math.PI / 180F);
                this.pata_delantera_derecha.zRot += (Mth.sin(t * 2000.0F + (float)Math.PI) * 5.0F) * ((float)Math.PI / 180F);

                this.nariz.x += Mth.sin(t * 3000.0F) * 0.2F;
            }
        }
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
                               float red, float green, float blue, float alpha) {
        root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}