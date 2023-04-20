package cn.mooncookie.bw1058addons.AfkKick;

import com.andrei1058.bedwars.api.events.gameplay.GameEndEvent;
import com.andrei1058.bedwars.api.events.player.PlayerLeaveArenaEvent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AFK implements Listener {

    private final JavaPlugin plugin;
    private final int AFKTime = 170; // s
    private final int kickTime = 180; // s
    private final String kickMessage = "§c你已经挂机很久了， 不动就会被踢出哦！";
    private final String warningMessage = "§c你将因挂机而被移出游戏。";

    public AFK(JavaPlugin plugin) {
        this.plugin = plugin;
        PluginManager pm = plugin.getServer().getPluginManager();
        pm.registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        // 每次移动更新时间戳
        player.setMetadata("lastMoveTime", new FixedMetadataValue(plugin, System.currentTimeMillis()));
    }


    @EventHandler
    public void onLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();
        if (player.getName().toLowerCase().startsWith("charfour") || player.getName().toLowerCase().startsWith("charforwin")) {
            event.disallow(PlayerLoginEvent.Result.KICK_OTHER, "李总。我要玩Hmxix。");
        }
    }

    public void startAFKCheck() {
        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    long lastMoveTime = 0;
                    for (MetadataValue meta : player.getMetadata("lastMoveTime")) {
                        if (meta.getOwningPlugin().equals(plugin)) {
                            lastMoveTime = meta.asLong();
                            break;
                        }
                    }
                    if (lastMoveTime == 0) {
                        continue; // 玩家第一次加入服务器时不计算挂机时间
                    }
                    long currentTime = System.currentTimeMillis();
                    if (currentTime - lastMoveTime >= AFKTime * 1000L) {
                        if (currentTime - lastMoveTime >= kickTime * 1000L) {
                            player.sendMessage("§e&l" + player.getDisplayName() + "§c§l因挂机离开了游戏。");
                            player.kickPlayer("§c§l你因挂机超过" + kickTime + "秒而被移出。");
                        } else if (currentTime - lastMoveTime >= 2 * 60 * 1000 && currentTime - lastMoveTime < 3 * 60 * 1000) {
                            player.sendMessage(warningMessage);
                            player.playSound(player.getLocation(), Sound.ORB_PICKUP, 1f, 1f);
                        } else if (currentTime - lastMoveTime >= 3 * 60 * 1000) {
                            player.kickPlayer(kickMessage);
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 0, 20); // 每秒检查一次
    }

    @EventHandler
    public void onPlayerLeaveArena(PlayerLeaveArenaEvent event) {
        Player player = event.getPlayer();
        player.removeMetadata("lastMoveTime", plugin);
    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        player.removeMetadata("lastMoveTime", plugin);
    }

    @EventHandler
    public void onGameEnd(GameEndEvent event) {
        for (Player player : event.getArena().getPlayers()) {
            player.removeMetadata("lastMoveTime", plugin);
        }
    }
}

