package com.holmraven.chickensshed.mixin;

import com.holmraven.chickensshed.ChickensShed;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnimalEntity.class)
public abstract class ChickensShedMixin extends PassiveEntity {
    protected ChickensShedMixin(EntityType<? extends PassiveEntity> entityType, World world) {
        super(entityType, world);
    }

    @Inject(method = "mobTick", at = @At("RETURN"))
    private void mobTick(final CallbackInfo ci) {
        ChickensShed.performShedding(this);
    }
}
