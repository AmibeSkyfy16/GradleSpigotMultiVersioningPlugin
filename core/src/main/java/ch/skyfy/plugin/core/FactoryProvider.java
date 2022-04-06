package ch.skyfy.plugin.core;

import ch.skyfy.plugin.Game;
import ch.skyfy.plugin.GlobalListener;
import ch.skyfy.plugin.GradleSpigotMultiVersioningPlugin;

public class FactoryProvider {

    private final GradleSpigotMultiVersioningPlugin plugin;
    private final GlobalListener listener;

    public FactoryProvider(GradleSpigotMultiVersioningPlugin plugin) {
        this.plugin = plugin;
        this.listener = new GlobalListener();
    }

    public GlobalListener getGlobalListener() {
        return listener;
    }

    public GradleSpigotMultiVersioningPlugin getPlugin() {
        return plugin;
    }

    public Game getGame() {
        return Game.getInstance();
    }
}
