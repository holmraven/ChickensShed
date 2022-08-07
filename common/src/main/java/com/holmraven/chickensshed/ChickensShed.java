package com.holmraven.chickensshed;

import com.holmraven.chickensshed.config.ConfigHandler;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;

public class ChickensShed {
    public static final String MODID = "chickensshed";
    public static ConfigHandler CONFIG;

    public static void initConfig()
    {
        ChickensShed.CONFIG = AutoConfig.getConfigHolder(ConfigHandler.class).getConfig();
    }

    public static void performShedding(LivingEntity e) {
        if (e.isBaby() && !CONFIG.chicksDropFeathers) {
            return;
        }
        if (!e.level.isClientSide && e.level.random.nextInt(CONFIG.dropFrequency) == 0) {
            e.spawnAtLocation(Items.FEATHER);
        }
    }
}