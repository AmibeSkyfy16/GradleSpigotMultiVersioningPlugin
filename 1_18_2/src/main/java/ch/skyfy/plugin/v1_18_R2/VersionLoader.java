package ch.skyfy.plugin.v1_18_R2;

import ch.skyfy.plugin.core.FactoryProvider;
import ch.skyfy.plugin.core.IVersionLoader;

@SuppressWarnings("unused")
public class VersionLoader implements IVersionLoader {

    @Override
    public void load(FactoryProvider provider) {
        provider.getPlugin().getServer().getPluginManager().registerEvents(new Listeners(provider), provider.getPlugin());
    }
}
