package com.alejvndro.glowray.common.entity.attribute;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;

public final class EntityAttributeSets {
    private EntityAttributeSets() {}

    public static AttributeSupplier.Builder aquaticPassive(double health, double speed) {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, health)
                .add(Attributes.MOVEMENT_SPEED, speed)
                .add(Attributes.FOLLOW_RANGE, 16.0D);
    }
}