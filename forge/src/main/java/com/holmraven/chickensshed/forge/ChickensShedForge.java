package com.holmraven.chickensshed.forge;

import com.holmraven.chickensshed.ChickensShed;
import com.holmraven.chickensshed.config.ConfigHandler;
import com.holmraven.chickensshed.forge.client.ScreenConfigHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ChickensShed.MODID)
public class ChickensShedForge {
    public ChickensShedForge(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onClientSetup);
        AutoConfig.register(ConfigHandler.class, Toml4jConfigSerializer::new);
        ChickensShed.initConfig();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void onClientSetup(final FMLClientSetupEvent event){
        ScreenConfigHandler.init();
    }
}
