package com.holmraven.chickensshed.config;

import com.holmraven.chickensshed.ChickensShed;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = ChickensShed.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigHandler {
    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;
    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static boolean chicksDropFeathers;
    public static int dropFrequency;

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if(configEvent.getConfig().getSpec() == ConfigHandler.CLIENT_SPEC) {
            bakeConfig();
        }
    }

    public static void bakeConfig() {
        chicksDropFeathers = CLIENT.chicksDropFeathers.get();
        dropFrequency = CLIENT.dropFrequency.get();
    }

    public static class ClientConfig {
        public final ForgeConfigSpec.BooleanValue chicksDropFeathers;
        public final ForgeConfigSpec.IntValue dropFrequency;
        public ClientConfig(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            chicksDropFeathers = builder
                    .comment("Do baby chickens drop feathers?")
                    .define("chicksDropFeathers", true);
            dropFrequency = builder
                    .comment("How often will feathers be shed?")
                    .defineInRange("dropFrequency", 26000, 6000, Integer.MAX_VALUE);
            builder.pop();
        }
    }
}
