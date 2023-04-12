package cn.mooncookie.bw1058addons.SpongeAnimation;

import cn.mooncookie.bw1058addons.BedWars1058Addons;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class SpongePlaceListener implements Listener {
    public SpongePlaceListener() {
    }

    @EventHandler
    public void onSpongePlace(BlockPlaceEvent e) {
        if (!e.isCancelled()) {
            if (e.getBlock().getType().equals(Material.SPONGE)) {
                (new SpongeAnimationTask(e.getBlock())).runTaskTimer(BedWars1058Addons.getInstance(), 0L, 8L);
            }
        }
    }
}