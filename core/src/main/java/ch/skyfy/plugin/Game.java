package ch.skyfy.plugin;

import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class Game {

    private static class GameHolder {
        public static Game instance = new Game();
    }

    private Game() {
    }

    public static Game getInstance() {
        return GameHolder.instance;
    }

    public void dropRandomItem(World world, Player player, ItemStack itemStack) {
        world.dropItemNaturally(player.getLocation(), itemStack);
        System.out.println("drop");
    }
}
