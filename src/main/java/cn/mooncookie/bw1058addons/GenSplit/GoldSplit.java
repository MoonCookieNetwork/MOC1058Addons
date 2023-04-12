package cn.mooncookie.bw1058addons.GenSplit;

import com.andrei1058.bedwars.BedWars;
import com.andrei1058.bedwars.api.arena.team.ITeam;
import com.andrei1058.bedwars.api.events.player.PlayerGeneratorCollectEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import java.util.Iterator;
import java.util.List;

public class GoldSplit implements Listener {
    public GoldSplit() {
    }

    @EventHandler
    public void onGoldPickup(PlayerGeneratorCollectEvent e) {
        if (!e.isCancelled() && e.getItemStack().getType() == Material.GOLD_INGOT) {
            Location pl = e.getPlayer().getLocation();
            Player p = e.getPlayer();
            List<Entity> nearbyEntities2 = (List) pl.getWorld().getNearbyEntities(pl, 2.0, 2.0, 2.0);
            Iterator var6 = pl.getWorld().getEntities().iterator();

            while (var6.hasNext()) {
                Entity en = (Entity) var6.next();
                if (nearbyEntities2.contains(en) && en instanceof Player) {
                    Player r = (Player) en;
                    if (r.getUniqueId() != p.getUniqueId()) {
                        ITeam pt = BedWars.getAPI().getArenaUtil().getArenaByPlayer(r).getTeam(p);
                        ITeam rt = BedWars.getAPI().getArenaUtil().getArenaByPlayer(r).getTeam(r);
                        if (pt == rt) {
                            ItemStack gold = new ItemStack(e.getItemStack().getType());
                            gold.setAmount(e.getItemStack().getAmount());
                            r.getInventory().addItem(gold);
                            if (Bukkit.getServer().getClass().getPackage().getName().contains("v1_8")) {
                                r.playSound(r.getLocation(), Sound.valueOf("ITEM_PICKUP"), 0.8F, 1.0F);
                            } else {
                                r.playSound(r.getLocation(), Sound.valueOf("ENTITY_ITEM_PICKUP"), 0.8F, 1.0F);
                            }
                        }
                    }
                }
            }
        }

    }
}

