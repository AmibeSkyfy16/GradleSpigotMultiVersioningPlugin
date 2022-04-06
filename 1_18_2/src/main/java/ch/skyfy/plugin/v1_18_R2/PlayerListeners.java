package ch.skyfy.plugin.v1_18_R2;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerListeners implements Listener {

    @EventHandler
    public void player(PlayerJoinEvent event){
        event.getPlayer().sendMessage("Welcome on the server little smart buddy");
    }

}
