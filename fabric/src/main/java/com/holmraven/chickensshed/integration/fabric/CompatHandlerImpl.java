package com.holmraven.chickensshed.integration.fabric;

import net.fabricmc.loader.api.FabricLoader;

public class CompatHandlerImpl {
    public static boolean isModLoaded(String id) {
        return FabricLoader.getInstance().isModLoaded(id);
    }
}
