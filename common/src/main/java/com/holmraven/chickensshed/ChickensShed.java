package com.holmraven.chickensshed;

import com.holmraven.chickensshed.config.ConfigHandler;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;

public class ChickensShed {
    public static final String MODID = "chickensshed";

    public static void performShedding(LivingEntity e) {
        if (e.isBaby() && !ConfigHandler.chicksDropFeathers()) {
            return;
        }
        if (!e.level().isClientSide && e.getRandom().nextInt(ConfigHandler.dropChance()) == 0) {
            e.spawnAtLocation(Items.FEATHER);
        }
    }
}