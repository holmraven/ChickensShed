package com.holmraven.chickensshed.config;

import com.holmraven.chickensshed.ChickensShed;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

import java.util.*;

@Config(name = ChickensShed.MODID)
@Config.Gui.Background("minecraft:textures/block/white_wool.png")
public class ClothConfig implements ConfigData {

    @ConfigEntry.Gui.Tooltip
    public boolean chicksDropFeathers = ConfigHandler.chicksDropFeathersDefault;

    @ConfigEntry.Gui.Tooltip(count = 2)
    @ConfigEntry.BoundedDiscrete(min = 6000, max = 108000)
    public int dropChance = ConfigHandler.dropChanceDefault;

    @ConfigEntry.Gui.CollapsibleObject
    AdvancedOptions ao = new AdvancedOptions();

    static class AdvancedOptions {
        @ConfigEntry.Gui.Tooltip
        public String dropItem = ConfigHandler.dropItemDefault;

        @ConfigEntry.Gui.Tooltip
        public List<String> mobList = ConfigHandler.mobListDefault;
    }
}
