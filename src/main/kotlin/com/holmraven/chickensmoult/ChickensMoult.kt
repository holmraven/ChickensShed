package com.holmraven.chickensmoult

import net.minecraftforge.fml.common.Mod
import thedarkcolour.kotlinforforge.forge.FORGE_BUS
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.event.entity.living.LivingEvent
import net.minecraft.entity.passive.ChickenEntity
import net.minecraft.item.Items

@Mod(ChickensMoult.ID)
object ChickensMoult {
    const val ID: String = "chickensmoult"

    init {
        FORGE_BUS.register(this)
        MOD_BUS.register(this)
    }

    @SubscribeEvent
    fun onLivingUpdate(event: LivingEvent.LivingUpdateEvent) {
        val entity = event.entityLiving
        if (entity is ChickenEntity) {
            if (entity.world.rand.nextInt(26000) == 0) {
                entity.entityDropItem(Items.FEATHER, 1)
            }
        }
    }
}