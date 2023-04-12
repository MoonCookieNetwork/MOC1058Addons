package cn.mooncookie.bw1058addons.IronGolemDamageEdit;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class IronGolemDamageEdit implements Listener {
    @EventHandler
    public void onHit(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType() == EntityType.IRON_GOLEM)
            e.setDamage(1.5D);
    }
}
