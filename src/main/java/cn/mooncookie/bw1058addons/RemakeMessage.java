package cn.mooncookie.bw1058addons;

import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class RemakeMessage implements Listener {
    @EventHandler
    public void onGameStart(GameStateChangeEvent e) {
        if (e.getNewState().equals(GameState.playing)) {
            Bukkit.getScheduler().runTaskLater(BedWars1058Addons.getInstance(), () -> e.getArena().getPlayers().forEach((p) -> p.sendMessage("起床战争插件重写工作已开始， 在此期间不接受任何起床本身BUG反馈/建议。感谢您的支持以及理解！")), 1L);
        }
    }
}
