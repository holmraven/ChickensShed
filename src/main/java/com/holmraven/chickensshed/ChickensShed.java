package com.holmraven.chickensshed;

import com.holmraven.chickensshed.config.ConfigHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;

@Mod(ChickensShed.MODID)
public class ChickensShed {
    public static final String MODID = "chickensshed";

    public ChickensShed(){
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, ConfigHandler.COMMON_SPEC);
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingUpdate(final LivingEvent.LivingUpdateEvent event) {
        final LivingEntity entity = event.getEntityLiving();
        if (entity.level.isClientSide || !(entity instanceof Chicken)) { return; }
        if (entity.isBaby() && !ConfigHandler.COMMON.chicksDropFeathers.get()) { return; }
        final Chicken chicken = (Chicken) entity;
        if (chicken.level.random.nextInt(ConfigHandler.COMMON.dropFrequency.get()) == 0) { chicken.spawnAtLocation(Items.FEATHER, 1); }
    }
}
