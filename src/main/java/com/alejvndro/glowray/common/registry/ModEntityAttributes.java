package com.alejvndro.glowray.common.registry;

import com.alejvndro.glowray.Glowray;
import com.alejvndro.glowray.common.entity.animal.glowrabbit.GlowRabbitEntity;
import com.alejvndro.glowray.common.entity.animal.stingray.StingRayEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Glowray.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModEntityAttributes {

    @SubscribeEvent
    public static void onEntityAttributeCreation(EntityAttributeCreationEvent event) {
        event.put(ModEntities.STING_RAY.get(), StingRayEntity.createAttributes().build());
        event.put(ModEntities.GLOW_RABBIT.get(), GlowRabbitEntity.createAttributes().build());
    }

    private ModEntityAttributes() {}
}