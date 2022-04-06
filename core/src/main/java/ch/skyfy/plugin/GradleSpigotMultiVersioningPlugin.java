package ch.skyfy.plugin;

import ch.skyfy.plugin.core.CancelRegistration;
import ch.skyfy.plugin.core.FactoryProvider;
import ch.skyfy.plugin.core.IVersionLoader;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

@SuppressWarnings("unused")
public class GradleSpigotMultiVersioningPlugin extends JavaPlugin {

    public static final String VERSION;

    static {
        var version = Bukkit.getServer().getClass().getPackage().getName().split("\\.");
        VERSION = version[version.length - 1].split("-")[0].replace(".", "_");
    }

    @Override
    public void onEnable() {
        load();
        getServer().getPluginManager().registerEvents(new GlobalListener(), this);
    }

    private void load() {
        var provider = new FactoryProvider(this);
        try {
            var className = String.format("%s.%s.VersionLoader", GradleSpigotMultiVersioningPlugin.class.getPackageName(), VERSION);
            IVersionLoader.class.getMethod("load", FactoryProvider.class)
                    .invoke(GradleSpigotMultiVersioningPlugin.class.getClassLoader().loadClass(className).getConstructor().newInstance(), provider);
        } catch (ReflectiveOperationException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Unsupported version : " + VERSION + " !");
        }

        var reflections = new Reflections("%s.%s".formatted(GradleSpigotMultiVersioningPlugin.class.getPackageName(), VERSION));
        for (var listenerClass : reflections.getSubTypesOf(Listener.class)) {
            try {
                if (listenerClass.getAnnotation(CancelRegistration.class) != null) continue;

                Listener listener;
                try {
                    listener = listenerClass.getConstructor(FactoryProvider.class).newInstance(provider);
                }catch (NoSuchMethodException noSuchMethodException){
                    listener = listenerClass.getConstructor().newInstance();
                }

                getServer().getPluginManager().registerEvents(listener, this);
            } catch (ReflectiveOperationException e) {
                e.printStackTrace();
            }
        }

    }

}
