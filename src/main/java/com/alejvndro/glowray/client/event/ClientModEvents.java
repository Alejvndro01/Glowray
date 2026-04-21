package com.alejvndro.glowray.client.event;

import com.alejvndro.glowray.Glowray;
import com.alejvndro.glowray.client.render.entity.model.GlowRabbitModel;
import com.alejvndro.glowray.client.render.entity.model.StingRayModel;
import com.alejvndro.glowray.client.render.entity.renderer.GlowRabbitRenderer;
import com.alejvndro.glowray.client.render.entity.renderer.StingRayRenderer;
import com.alejvndro.glowray.common.registry.ModEntities;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Glowray.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.STING_RAY.get(), StingRayRenderer::new);
        event.registerEntityRenderer(ModEntities.GLOW_RABBIT.get(), GlowRabbitRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(StingRayModel.LAYER_LOCATION, StingRayModel::createBodyLayer);
        event.registerLayerDefinition(GlowRabbitModel.LAYER_LOCATION, GlowRabbitModel::createBodyLayer);
    }
}