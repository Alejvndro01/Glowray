package com.alejvndro.glowray.common.entity.animal.stingray;

import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.player.Player;

public final class StingRayAi {
    private StingRayAi() {}

    public static void addGoals(StingRayEntity e) {
        e.goalSelector.addGoal(0, new PanicGoal(e, 1.5D));
        e.goalSelector.addGoal(1, new AvoidEntityGoal<>(e, Player.class, 8.0F, 1.5D, 1.7D));
        e.goalSelector.addGoal(2, new RandomSwimmingGoal(e, 1.0D, 40));
    }
}