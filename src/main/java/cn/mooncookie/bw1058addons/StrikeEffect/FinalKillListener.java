package cn.mooncookie.bw1058addons.StrikeEffect;

import com.andrei1058.bedwars.api.events.player.PlayerKillEvent;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class FinalKillListener implements Listener {
    @EventHandler
    public void onKill(PlayerKillEvent e) {
        if (e.getCause().isFinalKill()) {
            if (e.getKiller().getPlayer() != null) {
                Player p1 = e.getVictim();
                try {
                    p1.getWorld().strikeLightningEffect(p1.getLocation());
                } catch (Exception exception) {
                    // empty catch block
                }
            }
        }
    }
}
