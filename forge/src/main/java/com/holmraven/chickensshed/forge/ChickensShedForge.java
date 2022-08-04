package com.holmraven.chickensshed.forge;

import com.holmraven.chickensshed.ChickensShed;
import com.holmraven.chickensshed.forge.client.ScreenConfigHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ChickensShed.MODID)
public class ChickensShedForge {

    public ChickensShedForge(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        ChickensShed.initConfig();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onClientSetup(final FMLClientSetupEvent event){
        ScreenConfigHandler.init();
    }
}
