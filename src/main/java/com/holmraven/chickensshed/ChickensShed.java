package com.holmraven.chickensshed;

import com.holmraven.chickensshed.config.ConfigHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.item.Items;

public class ChickensShed implements ModInitializer {

    public static ConfigHandler CONFIG = new ConfigHandler();

    @Override
    public void onInitialize() {
        AutoConfig.register(ConfigHandler.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ConfigHandler.class).getConfig();
    }

    public static void performShedding(final Entity ent) {
        final LivingEntity entity = (LivingEntity) ent;
        if (entity.world.isClient || !(entity instanceof ChickenEntity)) { return; }
        if (entity.isBaby() && !CONFIG.chicksDropFeathers) { return; }
        final ChickenEntity chicken = (ChickenEntity) entity;
        if (chicken.world.random.nextInt(CONFIG.dropFrequency) == 0) { chicken.dropItem(Items.FEATHER, 1); }
    }
}