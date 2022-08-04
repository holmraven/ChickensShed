package com.holmraven.chickensshed;

import com.holmraven.chickensshed.config.ConfigHandler;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.gameevent.GameEvent;

public class ChickensShed {
    public static final String MODID = "chickensshed";
    public static ConfigHandler CONFIG;

    public static void initConfig()
    {
        AutoConfig.register(ConfigHandler.class, Toml4jConfigSerializer::new);
        ChickensShed.CONFIG = AutoConfig.getConfigHolder(ConfigHandler.class).getConfig();
    }

    public static void performShedding(Animal animal) {
        Chicken chicken = (Chicken) animal;
        if (chicken.isBaby() && !CONFIG.chicksDropFeathers) {
            return;
        }
        if (!chicken.level.isClientSide && chicken.isAlive() && !chicken.isChickenJockey() && chicken.level.random.nextInt(CONFIG.dropFrequency) == 0) {
            chicken.spawnAtLocation(Items.FEATHER);
        }
    }
}
