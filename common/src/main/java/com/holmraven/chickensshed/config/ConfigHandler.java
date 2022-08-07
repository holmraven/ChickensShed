package com.holmraven.chickensshed.config;

import com.holmraven.chickensshed.ChickensShed;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = ChickensShed.MODID)
@Config.Gui.Background("minecraft:textures/block/white_wool.png")
public class ConfigHandler implements ConfigData {
    @ConfigEntry.Gui.Tooltip
    public boolean chicksDropFeathers = true;

    @ConfigEntry.Gui.Tooltip
    @ConfigEntry.BoundedDiscrete(min = 6000, max = Integer.MAX_VALUE)
    public int dropFrequency = 26000;
}