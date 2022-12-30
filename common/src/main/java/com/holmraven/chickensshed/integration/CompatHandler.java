package com.holmraven.chickensshed.integration;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class CompatHandler {
    public static final boolean supplementaries;

    static {
        supplementaries = isModLoaded("supplementaries");
    }

    @ExpectPlatform
    public static boolean isModLoaded(String id){
        throw new AssertionError();
    }
}
