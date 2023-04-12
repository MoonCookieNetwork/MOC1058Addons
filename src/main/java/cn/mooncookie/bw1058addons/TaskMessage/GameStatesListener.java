package cn.mooncookie.bw1058addons.TaskMessage;

import cn.mooncookie.bw1058addons.BedWars1058Addons;
import com.andrei1058.bedwars.api.arena.GameState;
import com.andrei1058.bedwars.api.events.gameplay.GameStateChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.scheduler.BukkitTask;

public class GameStatesListener implements Listener {

    @EventHandler
    public void onGameStart(GameStateChangeEvent e) {
        if (e.getNewState().equals(GameState.playing)) {
            BukkitTask RejoinMessage = new Message(BedWars1058Addons.getInstance()).runTaskTimer(BedWars1058Addons.getInstance(), 2400L, 3600L);
        }
    }

    @EventHandler
    public void onGameEnd(GameStateChangeEvent e) {
        if (e.getNewState().equals(GameState.restarting)) {
            Bukkit.getScheduler().cancelAllTasks();
        }
    }
}
