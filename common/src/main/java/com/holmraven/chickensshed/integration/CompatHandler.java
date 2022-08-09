package com.holmraven.chickensshed.integration;

import dev.architectury.injectables.annotations.ExpectPlatform;

public class CompatHandler {
    public static final boolean supplementaries;

    static {
        supplementaries = isModLoaded("supplementaries");
    }

    @ExpectPlatform
    public static boolean isModLoaded(String name) {
        throw new AssertionError();
    }

    @ExpectPlatform
    public static String getPlatformString() {
        throw new AssertionError();
    }
}