package ch.skyfy.plugin;

import ch.skyfy.plugin.core.VersionManaged;
import org.bukkit.Location;
import org.bukkit.block.Sign;
import org.bukkit.entity.EntityType;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;

import static ch.skyfy.plugin.GradleSpigotMultiVersioningPlugin.VERSION;

public class GlobalListener implements Listener {

    @VersionManaged
    public boolean onPlayerInteract(PlayerInteractEvent event, List<ItemStack> itemStacks) {
        var p = event.getPlayer();
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK) return false;
        var block = event.getClickedBlock();
        if (block.getType().name().contains("SIGN")) {
            var sign = (Sign) block.getState();
            var line = sign.getLine(0);
            System.out.println("Sign clicked");

            var world = p.getWorld();

            for (var itemStack : itemStacks)
                world.dropItemNaturally(p.getLocation(), itemStack);

            world.spawnEntity(new Location(world, p.getLocation().getX(), p.getLocation().getY() + 1, p.getLocation().getZ()), EntityType.BEE);
            p.sendMessage(VERSION);
            return true;
        }
        return false;
    }

}
