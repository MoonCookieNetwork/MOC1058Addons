package cn.mooncookie.bw1058addons.BugFix.SharpSwordFix;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SharpSwordFix implements Listener {
    public SharpSwordFix() {
    }

    @EventHandler
    public void onSwordDrop(PlayerDropItemEvent event) {
        Material it = event.getItemDrop().getItemStack().getType();
        if ((it == Material.STONE_SWORD || it == Material.IRON_SWORD || it == Material.DIAMOND_SWORD) && event.getItemDrop().getItemStack().getEnchantments().containsKey(Enchantment.DAMAGE_ALL)) {
            Inventory inv = event.getPlayer().getInventory();

            for (int i = 0; i < inv.getSize(); ++i) {
                ItemStack item = inv.getItem(i);
                if (item != null && item.getType() == Material.WOOD_SWORD) {
                    item.addEnchantment(Enchantment.DAMAGE_ALL, 1);
                }
            }
        }

    }
}
