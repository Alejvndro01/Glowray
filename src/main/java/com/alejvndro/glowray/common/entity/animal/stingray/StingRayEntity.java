package com.alejvndro.glowray.common.entity.animal.stingray;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class StingRayEntity extends AbstractFish {

    public StingRayEntity(EntityType<? extends AbstractFish> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        StingRayAi.addGoals(this);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return WaterAnimal.createMobAttributes()
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH, 15.0D)
                .add(net.minecraft.world.entity.ai.attributes.Attributes.MOVEMENT_SPEED, 1.2D);
    }

    @Override
    public void aiStep() {
        super.aiStep();
        spawnTrailParticlesClient();
    }

    private void spawnTrailParticlesClient() {
        if (!this.level().isClientSide) return;
        if (!this.isInWater()) return;

        if (this.random.nextInt(10) == 0) {
            this.level().addParticle(
                    ParticleTypes.GLOW,
                    this.getRandomX(0.6D),
                    this.getRandomY(),
                    this.getRandomZ(0.6D),
                    0.0D, 0.05D, 0.0D
            );
        }
    }

    public int getLightValue() {
        return 12;
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.SALMON_FLOP;
    }

    @Override
    public ItemStack getBucketItemStack() {
        return ItemStack.EMPTY;
    }
}