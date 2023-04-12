package cn.mooncookie.bw1058addons.GenSplit;

import cn.mooncookie.bw1058addons.BedWars1058Addons;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class ThrownItems implements Listener {
    public ThrownItems() {
    }

    @EventHandler
    public void onThrow(PlayerDropItemEvent e) {
        if (e.getItemDrop().getItemStack().getType() == Material.IRON_INGOT) {
            e.getItemDrop().setMetadata("thrownitem", new FixedMetadataValue(BedWars1058Addons.plugin, "yes"));
        } else {
            if (e.getItemDrop().getItemStack().getType() != Material.GOLD_INGOT) {
                return;
            }

            e.getItemDrop().setMetadata("thrownitem", new FixedMetadataValue(BedWars1058Addons.plugin, "yes"));
        }

    }
}
