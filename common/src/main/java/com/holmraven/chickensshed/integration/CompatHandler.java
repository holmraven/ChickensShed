package com.holmraven.chickensshed.integration;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class CompatHandler {
    public static final boolean supplementaries;
    public static final boolean cloth_config;

    static {
        supplementaries = isModLoaded("supplementaries");
        cloth_config = (isModLoaded("cloth_config") || isModLoaded("cloth-config"));
    }

    @ExpectPlatform
    public static boolean isModLoaded(String id){
        throw new AssertionError();
    }
}
