package cn.mooncookie.bw1058addons.TaskMessage;

import cn.mooncookie.bw1058addons.BedWars1058Addons;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Message extends BukkitRunnable {

    BedWars1058Addons plugin;

    public Message(BedWars1058Addons plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.sendMessage("§c§l如果你断开连接， 可在起床大厅输入/rejoin重新加入游戏。");
        }
    }
}
