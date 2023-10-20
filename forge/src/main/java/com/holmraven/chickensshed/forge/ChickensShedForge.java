package com.holmraven.chickensshed.forge;

import com.holmraven.chickensshed.ChickensShed;
import com.holmraven.chickensshed.client.ScreenConfigHandler;
import com.holmraven.chickensshed.config.ConfigHandler;
import com.holmraven.chickensshed.integration.CompatHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ChickensShed.MODID)
public class ChickensShedForge {
    public ChickensShedForge(){
        if (CompatHandler.cloth_config) {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
            ConfigHandler.initClothConfig();
        }
    }

    private void onClientSetup(FMLClientSetupEvent event){
        ScreenConfigHandler.init();
    }
}
