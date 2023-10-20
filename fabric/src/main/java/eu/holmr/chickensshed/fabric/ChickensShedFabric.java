package eu.holmr.chickensshed.fabric;

import eu.holmr.chickensshed.config.ConfigHandler;
import eu.holmr.chickensshed.integration.CompatHandler;
import net.fabricmc.api.ModInitializer;

public class ChickensShedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        if (CompatHandler.cloth_config) {
            ConfigHandler.initClothConfig();
        }
    }
}
