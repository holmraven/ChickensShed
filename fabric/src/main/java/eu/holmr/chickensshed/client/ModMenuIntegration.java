package eu.holmr.chickensshed.client;

import eu.holmr.chickensshed.config.ClothConfig;
import eu.holmr.chickensshed.integration.CompatHandler;
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
