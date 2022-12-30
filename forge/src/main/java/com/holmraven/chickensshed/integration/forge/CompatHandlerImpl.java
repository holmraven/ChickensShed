package com.holmraven.chickensshed.integration.forge;

import net.minecraftforge.fml.loading.FMLLoader;

public class CompatHandlerImpl {
    public static boolean isModLoaded(String id) {
        return FMLLoader.getLoadingModList().getModFileById(id) != null;
    }
}
