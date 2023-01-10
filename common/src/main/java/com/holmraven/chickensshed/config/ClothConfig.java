package com.holmraven.chickensshed.config;

import com.holmraven.chickensshed.ChickensShed;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = ChickensShed.MODID)
@Config.Gui.Background("minecraft:textures/block/white_wool.png")
public class ClothConfig implements ConfigData {
    @Comment("Do baby chickens drop feathers?")
    @ConfigEntry.Gui.Tooltip
    public boolean chicksDropFeathers = ConfigHandler.chicksDropFeathersDefault;

    @Comment("How often will feathers be shed? (Probability of chicken shedding feathers per tick is 1/Drop Chance)")
    @ConfigEntry.Gui.Tooltip(count = 3)
    @ConfigEntry.BoundedDiscrete(min = 6000, max = 108000)
    public int dropChance = ConfigHandler.dropChanceDefault;
}