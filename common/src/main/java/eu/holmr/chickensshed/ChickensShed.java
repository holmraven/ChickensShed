package eu.holmr.chickensshed;

import eu.holmr.chickensshed.config.ConfigHandler;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class ChickensShed {
    public static final String MODID = "chickensshed";

    public static void performShedding(LivingEntity entity) {
        if (!ConfigHandler.mobList().contains(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString())) {
            return;
        }
        if (entity.isBaby() && !ConfigHandler.chicksDropFeathers()) {
            return;
        }
        if (!entity.level().isClientSide && entity.getRandom().nextInt(ConfigHandler.dropChance()) == 0) {
            entity.spawnAtLocation(BuiltInRegistries.ITEM.get(new ResourceLocation(ConfigHandler.dropItem())));
        }
    }
}
