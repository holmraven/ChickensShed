package eu.holmr.chickensshed.integration;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class CompatHandler {
    public static final boolean cloth_config;

    static {
        cloth_config = (isModLoaded("cloth_config") || isModLoaded("cloth-config"));
    }

    @ExpectPlatform
    public static boolean isModLoaded(String id){
        throw new AssertionError();
    }
}
