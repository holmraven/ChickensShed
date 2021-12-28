package com.holmraven.chickensshed.client;

import com.holmraven.chickensshed.config.ConfigHandler;
import me.shedaniel.autoconfig.AutoConfig;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;

@OnlyIn(Dist.CLIENT)
public class GUIConfigHandler {

    public static void init(){
        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () -> new ConfigGuiHandler.ConfigGuiFactory((client, parent) -> AutoConfig.getConfigScreen(ConfigHandler.class, parent).get()));
        MinecraftForge.EVENT_BUS.register(new GUIConfigHandler());
    }
}
