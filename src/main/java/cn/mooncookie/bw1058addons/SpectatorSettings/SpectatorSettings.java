package cn.mooncookie.bw1058addons.SpectatorSettings;

import cn.mooncookie.bw1058addons.SpectatorSettings.Utils.Data;
import cn.mooncookie.bw1058addons.SpectatorSettings.Utils.SettingsType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collections;

public class SpectatorSettings extends Command implements Listener {
    private Inventory inv;

    public SpectatorSettings() {
        super("specsettings");
    }

    @EventHandler
    public void onMCJoin(final PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        Data.nightVision.put(player, SettingsType.NIGHT_VISION_OFF);
        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        player.setWalkSpeed(0.2f);
        player.setFlySpeed(0.1f);
    }

    @EventHandler
    public void onMCQuit(final PlayerQuitEvent e) {
        final Player player = e.getPlayer();
        Data.nightVision.put(player, SettingsType.NIGHT_VISION_OFF);
        player.removePotionEffect(PotionEffectType.NIGHT_VISION);
        player.setWalkSpeed(0.2f);
        player.setFlySpeed(0.1f);
    }

    public void openMenu(final Player player) {
        this.init(player);
        player.openInventory(this.inv);
    }

    public void init(final Player player) {
        this.inv = Bukkit.createInventory(null, 36, "旁观者设置");
        final ItemStack item1 = new ItemStack(Material.LEATHER_BOOTS, 1);
        final ItemMeta meta1 = item1.getItemMeta();
        meta1.setDisplayName("§a取消速度效果");
        item1.setItemMeta(meta1);
        final ItemStack item2 = new ItemStack(Material.CHAINMAIL_BOOTS, 1);
        final ItemMeta meta2 = item2.getItemMeta();
        meta2.setDisplayName("§a速度I");
        item2.setItemMeta(meta2);
        final ItemStack item3 = new ItemStack(Material.IRON_BOOTS, 1);
        final ItemMeta meta3 = item3.getItemMeta();
        meta3.setDisplayName("§a速度II");
        item3.setItemMeta(meta3);
        final ItemStack item4 = new ItemStack(Material.GOLD_BOOTS, 1);
        final ItemMeta meta4 = item4.getItemMeta();
        meta4.setDisplayName("§a速度III");
        item4.setItemMeta(meta4);
        final ItemStack item5 = new ItemStack(Material.DIAMOND_BOOTS, 1);
        final ItemMeta meta5 = item5.getItemMeta();
        meta5.setDisplayName("§a速度IV");
        item5.setItemMeta(meta5);
        if (Data.autoTeleport.get(player) == SettingsType.AUTO_TELEPORT_OFF) {
            final ItemStack item6 = new ItemStack(Material.COMPASS, 1);
            final ItemMeta meta6 = item6.getItemMeta();
            meta6.setDisplayName("§a启用自动传送");
            meta6.setLore(Collections.singletonList("§7点击启用自动传送。"));
            item6.setItemMeta(meta6);
            this.inv.setItem(20, item6);
        } else if (Data.autoTeleport.get(player) == SettingsType.AUTO_TELEPORT_ON) {
            final ItemStack item7 = new ItemStack(Material.COMPASS, 1);
            final ItemMeta meta7 = item7.getItemMeta();
            meta7.setDisplayName("§c停用自动传送");
            meta7.setLore(Collections.singletonList("§7点击停用自动传送。"));
            item7.setItemMeta(meta7);
            this.inv.setItem(20, item7);
        }
        if (Data.nightVision.get(player) == SettingsType.NIGHT_VISION_OFF) {
            final ItemStack item6 = new ItemStack(Material.EYE_OF_ENDER, 1);
            final ItemMeta meta6 = item6.getItemMeta();
            meta6.setDisplayName("§a启用夜视");
            meta6.setLore(Collections.singletonList("§7点击启用夜视。"));
            item6.setItemMeta(meta6);
            this.inv.setItem(21, item6);
        } else if (Data.nightVision.get(player) == SettingsType.NIGHT_VISION_ON) {
            final ItemStack item7 = new ItemStack(Material.ENDER_PEARL, 1);
            final ItemMeta meta7 = item7.getItemMeta();
            meta7.setDisplayName("§c禁用夜视");
            meta7.setLore(Collections.singletonList("§7点击禁用夜视。"));
            item7.setItemMeta(meta7);
            this.inv.setItem(21, item7);
        }
        if (Data.person.get(player) == SettingsType.FIRST_PERSON) {
            final ItemStack item6 = new ItemStack(Material.WATCH, 1);
            final ItemMeta meta6 = item6.getItemMeta();
            meta6.setDisplayName("§a切换旁观视角(第三人称)");
            meta6.setLore(Collections.singletonList("§7点击切换至第三人称旁观模式。"));
            item6.setItemMeta(meta6);
            this.inv.setItem(23, item6);
        } else if (Data.person.get(player) == SettingsType.THIRD_PERSON) {
            final ItemStack item7 = new ItemStack(Material.WATCH, 1);
            final ItemMeta meta7 = item7.getItemMeta();
            meta7.setDisplayName("§a切换旁观视角(第一人称)");
            meta7.setLore(Collections.singletonList("§7点击切换至第一人称旁观模式。"));
            item7.setItemMeta(meta7);
            this.inv.setItem(23, item7);
        }
        if (Data.hideSpectators.get(player) == SettingsType.HIDE_SPECTATORS_OFF) {
            final ItemStack item6 = new ItemStack(Material.REDSTONE, 1);
            final ItemMeta meta6 = item6.getItemMeta();
            meta6.setDisplayName("§c隐藏旁观者");
            meta6.setLore(Collections.singletonList("§7点击隐藏其他旁观者。"));
            item6.setItemMeta(meta6);
            this.inv.setItem(24, item6);
        } else if (Data.hideSpectators.get(player) == SettingsType.HIDE_SPECTATORS_ON) {
            final ItemStack item7 = new ItemStack(Material.GLOWSTONE_DUST, 1);
            final ItemMeta meta7 = item7.getItemMeta();
            meta7.setDisplayName("§a显示旁观者");
            meta7.setLore(Collections.singletonList("§7点击显示其他旁观者。"));
            item7.setItemMeta(meta7);
            this.inv.setItem(24, item7);
        }
        this.inv.setItem(11, item1);
        this.inv.setItem(12, item2);
        this.inv.setItem(13, item3);
        this.inv.setItem(14, item4);
        this.inv.setItem(15, item5);
        player.openInventory(this.inv);
    }

    @EventHandler
    public void onClick(final InventoryClickEvent e) {
        final Player player = (Player) e.getWhoClicked();
        if (e.getCurrentItem() == null) {
            return;
        }
        if (e.getCurrentItem().getItemMeta() == null) {
            return;
        }
        if (e.getCurrentItem().getItemMeta().getDisplayName() == null) {
            return;
        }
        if (!e.getView().getTitle().equalsIgnoreCase("旁观者设置")) {
            return;
        }
        player.playSound(player.getLocation(), Sound.CLICK, 100.0f, 2.0f);
        player.closeInventory();
        if (e.getSlot() == 11) {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.sendMessage("§c你不再拥有速度效果。");
        }
        if (e.getSlot() == 12) {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 0));
            player.sendMessage("§a你获得了速度I。");
        }
        if (e.getSlot() == 13) {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 1));
            player.sendMessage("§a你获得了速度II。");
        }
        if (e.getSlot() == 14) {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 2));
            player.sendMessage("§a你获得了速度III。");
        }
        if (e.getSlot() == 15) {
            player.removePotionEffect(PotionEffectType.SPEED);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 99999, 3));
            player.sendMessage("§a你获得了速度IV。");
        }
        if (e.getSlot() == 20) {
            if (Data.autoTeleport.get(player) == SettingsType.AUTO_TELEPORT_OFF) {
                Data.autoTeleport.put(player, SettingsType.AUTO_TELEPORT_ON);
                player.sendMessage("§a你现在将会自动传送至你所旁观的目标！");
            } else if (Data.autoTeleport.get(player) == SettingsType.AUTO_TELEPORT_ON) {
                Data.autoTeleport.put(player, SettingsType.AUTO_TELEPORT_OFF);
                player.sendMessage("§c你现在不会被自动传送了！");
            }
        }
        if (e.getSlot() == 21) {
            if (Data.nightVision.get(player) == SettingsType.NIGHT_VISION_OFF) {
                Data.nightVision.put(player, SettingsType.NIGHT_VISION_ON);
                player.addPotionEffect(PotionEffectType.NIGHT_VISION.createEffect(99999, 255));
                player.sendMessage("§a你获得了夜视效果！");
            } else if (Data.nightVision.get(player) == SettingsType.NIGHT_VISION_ON) {
                Data.nightVision.put(player, SettingsType.NIGHT_VISION_OFF);
                player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                player.sendMessage("§c你停用了夜视效果！");
            }
        }
        if (e.getSlot() == 23) {
            if (Data.person.get(player) == SettingsType.FIRST_PERSON) {
                Data.person.put(player, SettingsType.THIRD_PERSON);
                player.sendMessage("§a你现在将以第三人称旁观你选择的目标！");
            } else if (Data.person.get(player) == SettingsType.THIRD_PERSON) {
                Data.person.put(player, SettingsType.FIRST_PERSON);
                player.sendMessage("§a你现在将以第一人称旁观你所选择的目标！");
            }
        }
        if (e.getSlot() == 24) {
            if (Data.hideSpectators.get(player) == SettingsType.HIDE_SPECTATORS_OFF) {
                Data.hideSpectators.put(player, SettingsType.HIDE_SPECTATORS_ON);
                player.sendMessage("§c你现在将不会看到其他旁观者！");
            } else if (Data.hideSpectators.get(player) == SettingsType.HIDE_SPECTATORS_ON) {
                Data.hideSpectators.put(player, SettingsType.HIDE_SPECTATORS_OFF);
                player.sendMessage("§a你现在可以看到其他旁观者了！");
            }
        }
    }

    public boolean execute(final CommandSender commandSender, final String s, final String[] strings) {

        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("§c此命令需要玩家执行！");
            return true;
        }
        this.openMenu((Player) commandSender);
        return false;
    }

}

