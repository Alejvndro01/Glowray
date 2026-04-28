package com.alejvndro.glowray.client;

import com.alejvndro.glowray.Glowray;
import com.alejvndro.glowray.client.render.model.GlowRabbitModel;
import com.alejvndro.glowray.client.render.model.LuciernagaAbisalModel;
import com.alejvndro.glowray.client.render.model.SnailModel;
import com.alejvndro.glowray.client.render.model.StingRayModel;
import com.alejvndro.glowray.client.render.renderer.GlowRabbitRenderer;
import com.alejvndro.glowray.client.render.renderer.LuciernagaAbisalRenderer;
import com.alejvndro.glowray.client.render.renderer.SnailRenderer;
import com.alejvndro.glowray.client.render.renderer.StingRayRenderer;
import com.alejvndro.glowray.registry.ModEntities;
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
        event.registerEntityRenderer(ModEntities.SNAIL.get(), SnailRenderer::new);
        event.registerEntityRenderer(ModEntities.LUCIERNAGA_ABISAL.get(), LuciernagaAbisalRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(StingRayModel.LAYER_LOCATION, StingRayModel::createBodyLayer);
        event.registerLayerDefinition(GlowRabbitModel.LAYER_LOCATION, GlowRabbitModel::createBodyLayer);
        event.registerLayerDefinition(SnailModel.LAYER_LOCATION, SnailModel::createBodyLayer);
        event.registerLayerDefinition(LuciernagaAbisalModel.LAYER_LOCATION, LuciernagaAbisalModel::createBodyLayer);
    }
}