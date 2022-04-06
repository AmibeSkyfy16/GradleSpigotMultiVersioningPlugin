package ch.skyfy.plugin.v1_17_R1;

import ch.skyfy.plugin.core.FactoryProvider;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

@SuppressWarnings("ClassCanBeRecord")
public class Listeners implements Listener {

    private final FactoryProvider provider;

    public Listeners(FactoryProvider provider) {
        this.provider = provider;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        var list = new ArrayList<ItemStack>() {{
            add(new ItemStack(Material.DIAMOND, 1));
        }};
        this.provider.getGlobalListener().onPlayerInteract(event, list);
        System.out.println("code 1-17-1 only");
    }
}
