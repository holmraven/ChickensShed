package com.holmraven.chickensshed.config;

import com.holmraven.chickensshed.integration.CompatHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class ConfigHandler {
    public static ClothConfig CONFIG;

    public static boolean chicksDropFeathersDefault = true;
    public static int dropChanceDefault = 26000;

    public static void initClothConfig()
    {
        AutoConfig.register(ClothConfig.class, JanksonConfigSerializer::new);
        ConfigHandler.CONFIG = AutoConfig.getConfigHolder(ClothConfig.class).getConfig();
    }

    public static boolean chicksDropFeathers() {
        if (CompatHandler.cloth_config) {
            return CONFIG.chicksDropFeathers;
        }
        return chicksDropFeathersDefault;
    }

    public static int dropChance() {
        if (CompatHandler.cloth_config) {
            return CONFIG.dropChance;
        }
        return dropChanceDefault;
    }
}
