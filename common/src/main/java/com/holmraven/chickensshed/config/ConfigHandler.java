package com.holmraven.chickensshed.config;

import com.holmraven.chickensshed.integration.CompatHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;

import java.util.Arrays;
import java.util.List;

public class ConfigHandler {
    public static ClothConfig CONFIG;

    public static boolean chicksDropFeathersDefault = true;
    public static int dropChanceDefault = 26000;
    public static String dropItemDefault = "minecraft:feather";
    public static List<String> mobListDefault = Arrays.asList("minecraft:chicken");

    public static void initClothConfig()
    {
        AutoConfig.register(ClothConfig.class, GsonConfigSerializer::new);
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

    public static String dropItem() {
        if (CompatHandler.cloth_config) {
            return CONFIG.ao.dropItem;
        }
        return dropItemDefault;
    }

    public static List<String> mobList() {
        if (CompatHandler.cloth_config) {
            return CONFIG.ao.mobList;
        }
        return mobListDefault;
    }
}
