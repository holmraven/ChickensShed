package com.holmraven.chickensshed.config;

import com.holmraven.chickensshed.ChickensShed;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = ChickensShed.MODID)
public class ConfigHandler implements ConfigData{
    @Comment("Do baby chickens drop feathers?")
    public boolean chicksDropFeathers = true;
    @Comment("How often will feathers be shed? (min: 6000)")
    @ConfigEntry.BoundedDiscrete(min = 6000, max = Integer.MAX_VALUE)
    public int dropFrequency = 26000;
}
