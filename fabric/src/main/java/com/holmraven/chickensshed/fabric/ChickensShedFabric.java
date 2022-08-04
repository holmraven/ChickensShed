package com.holmraven.chickensshed.fabric;

import com.holmraven.chickensshed.ChickensShed;
import net.fabricmc.api.ModInitializer;

public class ChickensShedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ChickensShed.initConfig();
    }
}