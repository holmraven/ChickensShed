package com.holmraven.chickensshed.config;

import com.holmraven.chickensshed.ChickensShed;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = ChickensShed.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConfigHandler {
    public static final Common COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }

    public static class Common {
        public final ForgeConfigSpec.BooleanValue chicksDropFeathers;
        public final ForgeConfigSpec.IntValue dropFrequency;
        public Common(ForgeConfigSpec.Builder builder) {
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
