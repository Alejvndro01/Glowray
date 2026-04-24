package com.alejvndro.glowray.client.render.entity.renderer;

import com.alejvndro.glowray.Glowray;
import com.alejvndro.glowray.client.render.entity.model.SnailModel;
import com.alejvndro.glowray.common.entity.animal.snail.SnailEntity;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class SnailRenderer extends MobRenderer<SnailEntity, SnailModel<SnailEntity>> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(Glowray.MOD_ID, "textures/entity/snail.png");

    private static final ResourceLocation GLOW_TEXTURE =
            new ResourceLocation(Glowray.MOD_ID, "textures/entity/snail_glow.png");

    public SnailRenderer(EntityRendererProvider.Context context) {
        super(context, new SnailModel<>(context.bakeLayer(SnailModel.LAYER_LOCATION)), 0.3F);

        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                return RenderType.eyes(GLOW_TEXTURE);
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(SnailEntity entity) {
        return TEXTURE;
    }
}