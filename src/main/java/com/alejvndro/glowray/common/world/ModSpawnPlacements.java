package com.alejvndro.glowray.common.world;

import com.alejvndro.glowray.Glowray;
import com.alejvndro.glowray.common.entity.animal.snail.SnailEntity;
import com.alejvndro.glowray.common.registry.ModEntities;
import net.minecraft.core.BlockPos;
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
        event.register(
                ModEntities.SNAIL.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                ModSpawnPlacements::snailSpawnRules,
                SpawnPlacementRegisterEvent.Operation.OR
        );
    }

    private static boolean snailSpawnRules(EntityType<SnailEntity> type, LevelAccessor level, MobSpawnType reason, BlockPos pos, RandomSource random) {
    return true;
}
}