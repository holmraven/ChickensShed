package com.holmraven.chickensshed.client;

import com.holmraven.chickensshed.config.ClothConfig;
import com.holmraven.chickensshed.integration.CompatHandler;
import com.terraformersmc.modmenu.api.ConfigScreenFactory;
import com.terraformersmc.modmenu.api.ModMenuApi;
import me.shedaniel.autoconfig.AutoConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ModMenuIntegration implements ModMenuApi {
    @Override
    public ConfigScreenFactory<?> getModConfigScreenFactory() {
        if (CompatHandler.cloth_config) {
            return (parent -> AutoConfig.getConfigScreen(ClothConfig.class, parent).get());
        }
        return (screen -> null);
    }
}
