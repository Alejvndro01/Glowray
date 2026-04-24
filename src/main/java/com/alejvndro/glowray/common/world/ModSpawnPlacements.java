package com.alejvndro.glowray.common.world;

import com.alejvndro.glowray.Glowray;
import com.alejvndro.glowray.common.entity.GlowRabbitEntity;
import com.alejvndro.glowray.common.entity.SnailEntity;
import com.alejvndro.glowray.common.entity.StingRayEntity;
import com.alejvndro.glowray.registry.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Glowray.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public final class ModSpawnPlacements {

    private ModSpawnPlacements() {}

    @SubscribeEvent
    public static void onRegisterSpawnPlacements(SpawnPlacementRegisterEvent event) {

        // Snail (swamp/jungle, tierra)
        event.register(
                ModEntities.SNAIL.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModSpawnPlacements::snailSpawnRules,
                SpawnPlacementRegisterEvent.Operation.OR
        );

        // Glow Rabbit (plains/forest, tierra)
        event.register(
                ModEntities.GLOW_RABBIT.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModSpawnPlacements::glowRabbitSpawnRules,
                SpawnPlacementRegisterEvent.Operation.OR
        );

        // Sting Ray (ocean/river, agua)
        event.register(
                ModEntities.STING_RAY.get(),
                SpawnPlacements.Type.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModSpawnPlacements::stingRaySpawnRules,
                SpawnPlacementRegisterEvent.Operation.OR
        );
    }

    private static boolean snailSpawnRules(EntityType<SnailEntity> type, LevelAccessor level,
                                           MobSpawnType reason, BlockPos pos, RandomSource random) {
        // simple y "común": que haya superficie y no sea súper iluminado
        return level.getRawBrightness(pos, 0) <= 12
                && level.getBlockState(pos.below()).isSolidRender(level, pos.below());
    }

    private static boolean glowRabbitSpawnRules(EntityType<GlowRabbitEntity> type, LevelAccessor level,
                                                MobSpawnType reason, BlockPos pos, RandomSource random) {
        return level.getRawBrightness(pos, 0) > 8
                && level.getBlockState(pos.below()).isSolidRender(level, pos.below());
    }

    private static boolean stingRaySpawnRules(EntityType<StingRayEntity> type, LevelAccessor level,
                                              MobSpawnType reason, BlockPos pos, RandomSource random) {
        // Debe estar en agua (y normalmente con bloque de agua en la cabeza también)
        return level.getFluidState(pos).is(FluidTags.WATER)
                && level.getFluidState(pos.above()).is(FluidTags.WATER);
    }
}