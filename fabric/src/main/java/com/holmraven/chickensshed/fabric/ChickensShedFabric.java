package com.holmraven.chickensshed.fabric;

import com.holmraven.chickensshed.ChickensShed;
import com.holmraven.chickensshed.config.ConfigHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.GsonConfigSerializer;
import net.fabricmc.api.ModInitializer;

public class ChickensShedFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        AutoConfig.register(ConfigHandler.class, GsonConfigSerializer::new);
        ChickensShed.initConfig();
    }
}