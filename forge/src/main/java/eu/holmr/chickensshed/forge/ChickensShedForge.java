package eu.holmr.chickensshed.forge;

import eu.holmr.chickensshed.ChickensShed;
import eu.holmr.chickensshed.client.ScreenConfigHandler;
import eu.holmr.chickensshed.config.ConfigHandler;
import eu.holmr.chickensshed.integration.CompatHandler;
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
