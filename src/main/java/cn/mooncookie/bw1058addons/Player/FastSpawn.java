package cn.mooncookie.bw1058addons.Player;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.entity.PlayerDeathEvent;

public class FastSpawn implements org.bukkit.event.Listener {

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onDeath(final PlayerDeathEvent e) {
        final Player player = e.getEntity();
        player.spigot().respawn();
    }
}