package com.holmraven.chickensshed.integration.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class CompatHandlerImpl {
    public static boolean isModLoaded(String name) {
        return FabricLoader.getInstance().isModLoaded(name);
    }

    public static String getPlatformString() {
        return "fabric";
    }
}