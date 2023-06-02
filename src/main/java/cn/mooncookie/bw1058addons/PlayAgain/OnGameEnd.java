package cn.mooncookie.bw1058addons.PlayAgain;

import cn.mooncookie.bw1058addons.BedWars1058Addons;
import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class OnGameEnd implements Listener {
    public static String Group = "";

    @EventHandler
    public void onGameEnd(GameEndEvent e) {
        switch (e.getArena().getGroup()) {
            case "solo":
                Group = "Bw_Solo";
                break;
            case "4v4v4v4":
                Group = "Bw_4v4v4v4";
                break;
            case "rush_doubles":
                Group = "Bw_RushDoubles";
                break;
            case "rush_4v4v4v4":
                Group = "Bw_Rush4v4v4v4";
                break;
        }
        Bukkit.getScheduler().runTaskLater(BedWars1058Addons.getInstance(), () -> e.getArena().getPlayers().forEach((p) -> Bukkit.dispatchCommand(p.getPlayer(), "sj fastjoin " + Group)), 180L);
    }
}
