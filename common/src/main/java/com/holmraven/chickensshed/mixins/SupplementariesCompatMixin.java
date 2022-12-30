package com.holmraven.chickensshed.mixins;

import com.holmraven.chickensshed.ChickensShed;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "net.mehvahdjukaar.supplementaries.common.misc.mob_container.BuiltinAnimation$ChickenAnim")
public abstract class SupplementariesCompatMixin<M extends Chicken> {
    @Inject(method = "tick", at = @At("HEAD"), remap = false)
    private void tick(M mob, Level level, BlockPos pos, CallbackInfo ci) {
        ChickensShed.performShedding(mob);
    }
}
