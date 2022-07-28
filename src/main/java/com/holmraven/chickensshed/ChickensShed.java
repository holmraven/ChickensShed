package com.holmraven.chickensshed;

import com.holmraven.chickensshed.client.GUIConfigHandler;
import com.holmraven.chickensshed.config.ConfigHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(ChickensShed.MODID)
public class ChickensShed {
    public static final String MODID = "chickensshed";

    public static ConfigHandler CONFIG = new ConfigHandler();

    public ChickensShed(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::preInitClient);
        AutoConfig.register(ConfigHandler.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ConfigHandler.class).getConfig();
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void preInitClient(final FMLClientSetupEvent event){
        GUIConfigHandler.init();
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent.LivingTickEvent event) {
        LivingEntity entity = event.getEntity();
        if (!entity.level.isClientSide && entity instanceof Chicken chicken) {
            if (chicken.isBaby() && !CONFIG.chicksDropFeathers) {
                return;
            }
            if (chicken.level.random.nextInt(CONFIG.dropFrequency) == 0) {
                chicken.spawnAtLocation(Items.FEATHER, 1);
            }
        }
    }
}
