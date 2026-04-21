package com.alejvndro.glowray.client.render.entity.renderer;

import com.alejvndro.glowray.Glowray;
import com.alejvndro.glowray.client.render.entity.model.GlowRabbitModel;
import com.alejvndro.glowray.common.entity.animal.glowrabbit.GlowRabbitEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class GlowRabbitRenderer extends MobRenderer<GlowRabbitEntity, GlowRabbitModel<GlowRabbitEntity>> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Glowray.MOD_ID, "textures/entity/glow_rabbit.png");

    private static final ResourceLocation GLOW_TEXTURE =
            new ResourceLocation(Glowray.MOD_ID, "textures/entity/glow_rabbit_glow.png");

    public GlowRabbitRenderer(EntityRendererProvider.Context context) {
        super(context, new GlowRabbitModel<>(context.bakeLayer(GlowRabbitModel.LAYER_LOCATION)), 0.3F);

        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(GLOW_TEXTURE);
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(GlowRabbitEntity entity) {
        return TEXTURE;
    }
}