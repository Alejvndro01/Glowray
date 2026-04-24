package com.alejvndro.glowray.util;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public final class EntityAttributeSets {
    private EntityAttributeSets() {}

    /** Perfil base para mobs acuáticos pasivos (no tamables). */
    public static AttributeSupplier.Builder aquaticPassive(double health, double speed) {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, health)
                .add(Attributes.MOVEMENT_SPEED, speed)
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }

    /** Perfil base para mobs terrestres pasivos. */
    public static AttributeSupplier.Builder landPassive(double health, double speed, double followRange) {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, health)
                .add(Attributes.MOVEMENT_SPEED, speed)
                .add(Attributes.FOLLOW_RANGE, followRange);
    }
}