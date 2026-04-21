package com.alejvndro.glowray.client.render.entity.renderer;

import com.alejvndro.glowray.Glowray;
import com.alejvndro.glowray.client.render.entity.model.StingRayModel;
import com.alejvndro.glowray.common.entity.animal.stingray.StingRayEntity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.EyesLayer;
import net.minecraft.resources.ResourceLocation;

public class StingRayRenderer extends MobRenderer<StingRayEntity, StingRayModel<StingRayEntity>> {
    
    private static final ResourceLocation TEXTURE = 
            new ResourceLocation(Glowray.MOD_ID, "textures/entity/sting_ray.png");

    // 🌟 1. Definimos la ruta de la textura de brillo (la que editaste con amarillo RGB 255, 255, 0)
    private static final ResourceLocation GLOW_TEXTURE = 
            new ResourceLocation(Glowray.MOD_ID, "textures/entity/sting_ray_glow.png");

    public StingRayRenderer(EntityRendererProvider.Context context) {
        super(context, new StingRayModel<>(context.bakeLayer(StingRayModel.LAYER_LOCATION)), 0.5f);
        
        // 🔥 2. Añadimos la capa de brillo místico
        this.addLayer(new EyesLayer<>(this) {
            @Override
            public RenderType renderType() {
                // Esto hace que la textura ignore las sombras del agua
                return RenderType.eyes(GLOW_TEXTURE);
            }
        });
    }

    @Override
    public ResourceLocation getTextureLocation(StingRayEntity entity) {
        return TEXTURE;
    }
}