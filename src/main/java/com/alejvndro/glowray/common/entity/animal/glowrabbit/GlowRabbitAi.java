package com.alejvndro.glowray.common.entity.animal.glowrabbit;

import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.player.Player;

public final class GlowRabbitAi {
    private GlowRabbitAi() {}

    public static void addGoals(GlowRabbitEntity e) {
        e.goalSelector.addGoal(0, new FloatGoal(e));
        e.goalSelector.addGoal(1, new PanicGoal(e, 1.25D));
        e.goalSelector.addGoal(5, new WaterAvoidingRandomStrollGoal(e, 1.0D));
        e.goalSelector.addGoal(6, new LookAtPlayerGoal(e, Player.class, 8.0F));
        e.goalSelector.addGoal(7, new RandomLookAroundGoal(e));
    }
}