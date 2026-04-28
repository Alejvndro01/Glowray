package com.alejvndro.glowray.registry;

import com.alejvndro.glowray.Glowray;
import com.alejvndro.glowray.common.entity.GlowRabbitEntity;
import com.alejvndro.glowray.common.entity.LuciernagaAbisalEntity;
import com.alejvndro.glowray.common.entity.SnailEntity;
import com.alejvndro.glowray.common.entity.StingRayEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, Glowray.MOD_ID);

    public static final RegistryObject<EntityType<StingRayEntity>> STING_RAY =
            ENTITIES.register("sting_ray",
                    () -> EntityType.Builder.of(StingRayEntity::new, MobCategory.WATER_CREATURE)
                            .sized(1.2f, 0.4f)
                            .build("sting_ray"));

    public static final RegistryObject<EntityType<GlowRabbitEntity>> GLOW_RABBIT =
            ENTITIES.register("glow_rabbit",
                    () -> EntityType.Builder.of(GlowRabbitEntity::new, MobCategory.CREATURE)
                            .sized(0.6F, 0.85F)
                            .build("glow_rabbit"));

    public static final RegistryObject<EntityType<SnailEntity>> SNAIL =
            ENTITIES.register("snail",
                    () -> EntityType.Builder.of(SnailEntity::new, MobCategory.CREATURE)
                            .sized(0.8F, 0.55F)
                            .build("snail"));

    public static final RegistryObject<EntityType<LuciernagaAbisalEntity>> LUCIERNAGA_ABISAL =
            ENTITIES.register("luciernaga_abisal",
                    () -> EntityType.Builder.of(LuciernagaAbisalEntity::new, MobCategory.AMBIENT)
                            .sized(0.4F, 0.3F)
                            .build("luciernaga_abisal"));

    public static void register(IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    private ModEntities() {}
}