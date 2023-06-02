package cn.mooncookie.bw1058addons.StrikeEffect;

import com.andrei1058.bedwars.api.events.player.PlayerBedBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class BedDestoryListener implements Listener {
    @EventHandler
    public void onBreak(PlayerBedBreakEvent e) {
        e.getArena().getWorld().strikeLightningEffect(e.getVictimTeam().getBed().getBlock().getLocation());
    }
}
