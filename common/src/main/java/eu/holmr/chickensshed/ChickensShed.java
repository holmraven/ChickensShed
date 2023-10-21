package eu.holmr.chickensshed;

import dev.architectury.event.events.common.TickEvent;
import eu.holmr.chickensshed.config.ConfigHandler;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;

public class ChickensShed {
    public static final String MODID = "chickensshed";

    public static void init() {
        TickEvent.SERVER_LEVEL_PRE.register(level -> {
            for (var entity : level.getAllEntities()) {
                if (entity instanceof LivingEntity) {
                    handleLivingEntityShedding((LivingEntity) entity);
                }
            }
        });
    }

    public static void handleLivingEntityShedding(LivingEntity entity) {
        if (!ConfigHandler.mobList().contains(BuiltInRegistries.ENTITY_TYPE.getKey(entity.getType()).toString())) {
            return;
        }
        if (entity.isBaby() && !ConfigHandler.chicksDropFeathers()) {
            return;
        }
        if (!entity.level().isClientSide && entity.getRandom().nextInt(ConfigHandler.dropChance()) == 0) {
            entity.spawnAtLocation(BuiltInRegistries.ITEM.get(new ResourceLocation(ConfigHandler.droppedItem())));
        }
    }
}
