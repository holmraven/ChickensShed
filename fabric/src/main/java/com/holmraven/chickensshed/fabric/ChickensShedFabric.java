package com.holmraven.chickensshed.fabric;

import com.holmraven.chickensshed.config.ConfigHandler;
import com.holmraven.chickensshed.integration.CompatHandler;
import net.fabricmc.api.ModInitializer;

public class ChickensShedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        if (CompatHandler.cloth_config) {
            ConfigHandler.initClothConfig();
        }
    }
}
