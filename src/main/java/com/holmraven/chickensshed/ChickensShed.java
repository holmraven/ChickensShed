package com.holmraven.chickensshed;

import com.holmraven.chickensshed.config.ConfigHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.Items;
import net.minecraftforge.client.ConfigGuiHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;

@Mod(ChickensShed.MODID)
public class ChickensShed {
    public static final String MODID = "chickensshed";

    public static ConfigHandler CONFIG = new ConfigHandler();

    public ChickensShed(){
        AutoConfig.register(ConfigHandler.class, JanksonConfigSerializer::new);
        CONFIG = AutoConfig.getConfigHolder(ConfigHandler.class).getConfig();
        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () -> new ConfigGuiHandler.ConfigGuiFactory((client, parent) -> AutoConfig.getConfigScreen(ConfigHandler.class, parent).get()));
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingUpdate(final LivingEvent.LivingUpdateEvent event) {
        final LivingEntity entity = event.getEntityLiving();
        if (entity.level.isClientSide || !(entity instanceof Chicken)) { return; }
        if (entity.isBaby() && !CONFIG.chicksDropFeathers) { return; }
        final Chicken chicken = (Chicken) entity;
        if (chicken.level.random.nextInt(CONFIG.dropFrequency) == 0) { chicken.spawnAtLocation(Items.FEATHER, 1); }
    }
}
