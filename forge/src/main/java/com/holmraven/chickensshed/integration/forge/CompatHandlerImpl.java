package com.holmraven.chickensshed.integration.forge;

import net.minecraftforge.fml.loading.FMLLoader;

public class CompatHandlerImpl {
    public static boolean isModLoaded(String name) {
        return FMLLoader.getLoadingModList().getModFileById(name) != null;
    }

    public static String getPlatformString() {
        return "forge";
    }
}