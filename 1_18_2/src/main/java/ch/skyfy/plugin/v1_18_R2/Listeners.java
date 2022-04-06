package ch.skyfy.plugin.v1_18_R2;

import ch.skyfy.plugin.core.CancelRegistration;
import ch.skyfy.plugin.core.FactoryProvider;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

@SuppressWarnings("ClassCanBeRecord")
@CancelRegistration
public class Listeners implements Listener {

    private final FactoryProvider provider;

    public Listeners(FactoryProvider provider) {
        this.provider = provider;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        var list = new ArrayList<ItemStack>() {{
            add(new ItemStack(Material.DEEPSLATE, 64));
        }};
        this.provider.getGlobalListener().onPlayerInteract(event, list);
        System.out.println("code 1-18-2 only");
    }

}
