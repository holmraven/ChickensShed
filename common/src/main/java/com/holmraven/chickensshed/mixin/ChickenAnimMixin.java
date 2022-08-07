package com.holmraven.chickensshed.mixin;

import com.holmraven.chickensshed.ChickensShed;
import net.mehvahdjukaar.supplementaries.common.capabilities.mob_container.DefaultCatchableMobCap;
import net.minecraft.world.entity.animal.Chicken;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultCatchableMobCap.ChickenAnim.class)
public abstract class ChickenAnimMixin extends DefaultCatchableMobCap<Chicken>{
    protected ChickenAnimMixin(Chicken entity) {
        super(entity);
    }

    @Inject(method = "tickInsideContainer", at = @At("HEAD"), remap = false)
    private void tickInsideContainer(CallbackInfo ci) {
        ChickensShed.performShedding(this.mob);
    }
}