package cn.mooncookie.bw1058addons;

import cn.mooncookie.bw1058addons.AfkKick.AFK;
import cn.mooncookie.bw1058addons.BugFix.ExplosionFix.ExplosionFix;
import cn.mooncookie.bw1058addons.BugFix.SharpSwordFix.SharpSwordFix;
import cn.mooncookie.bw1058addons.GenSplit.GoldSplit;
import cn.mooncookie.bw1058addons.GenSplit.IronSplit;
import cn.mooncookie.bw1058addons.GenSplit.ThrownItems;
import cn.mooncookie.bw1058addons.IronGolemDamageEdit.IronGolemDamageEdit;
import cn.mooncookie.bw1058addons.PlayAgain.OnGameEnd;
import cn.mooncookie.bw1058addons.PlayAgain.PlayAgainCommand;
import cn.mooncookie.bw1058addons.Player.FastSpawn;
import cn.mooncookie.bw1058addons.Player.WaterWorkerHelmet;
import cn.mooncookie.bw1058addons.SpectatorSettings.SpectatorSettings;
import cn.mooncookie.bw1058addons.SpongeAnimation.Particle.ParticleSupport;
import cn.mooncookie.bw1058addons.SpongeAnimation.Particle.versions.Older;
import cn.mooncookie.bw1058addons.SpongeAnimation.SpongePlaceListener;
import cn.mooncookie.bw1058addons.StrikeEffect.BedDestoryListener;
import cn.mooncookie.bw1058addons.StrikeEffect.FinalKillListener;
import cn.mooncookie.bw1058addons.TaskMessage.Message;
import com.andrei1058.bedwars.BedWars;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;

public class BedWars1058Addons extends JavaPlugin {
    public static BedWars1058Addons instance;
    public static BedWars1058Addons plugin;
    //海绵动画所需变量
    private static String splash;
    private static String woodClick;
    private static ParticleSupport ParticleSupport;

    public static BedWars1058Addons getInstance() {
        return instance;
    }

    public static String getSplash() {
        return splash;
    }

    public static String getWoodClick() {
        return woodClick;
    }

    public static ParticleSupport getParticleSupport() {
        return ParticleSupport;
    }

    @Override
    public void onLoad() {
        getLogger().info(ChatColor.GREEN + "MOC1058Addon 加载中....");
    }

    @Override
    public void onEnable() {
        instance = this;
        plugin = this;
        getLogger().info(ChatColor.LIGHT_PURPLE + "————————M0onCo0kie————————");
        getLogger().info(ChatColor.GREEN + "插件已启用");
        getLogger().info(ChatColor.LIGHT_PURPLE + "————————M0onCo0kie————————");
        getServer().getPluginManager().registerEvents(new SharpSwordFix(), this); // 掉落剑附魔
        getServer().getPluginManager().registerEvents(new FastSpawn(), this); // 快速重生
        getServer().getPluginManager().registerEvents(new ExplosionFix(), this); // 防爆玻璃&末地石修复
        getServer().getPluginManager().registerEvents(new IronGolemDamageEdit(), this); // 铁傀儡伤害修改
        getServer().getPluginManager().registerEvents(new OnGameEnd(), this); // 游戏结束时自动重开
        getServer().getPluginManager().registerEvents(new SpectatorSettings(), this); // 旁观者设置
        getServer().getPluginManager().registerEvents(new SpongePlaceListener(), this); // 海绵动画
        getServer().getPluginManager().registerEvents(new WaterWorkerHelmet(), this); // 水下呼吸头盔
        getServer().getPluginManager().registerEvents(new FinalKillListener(), this); // 击杀闪电效果
        getServer().getPluginManager().registerEvents(new BedDestoryListener(), this); // 床破坏闪电效果
        getServer().getPluginManager().registerEvents(new RemakeMessage(), this);
        new Message(BedWars1058Addons.getInstance()).runTaskTimer(BedWars1058Addons.getInstance(), 2400L, 3600L);
        AFK AFK = new AFK(this); //AFK检查
        AFK.startAFKCheck();
        registerCommand(); //注册指令

        getServer().getPluginManager().registerEvents(new IronSplit(), this); // 铁资源分摊
        getServer().getPluginManager().registerEvents(new GoldSplit(), this); // 金资源分摊
        getServer().getPluginManager().registerEvents(new ThrownItems(), this); // 掉落物分摊
        //隐身脚印已移至起床战争插件本体。
        //海绵动画所需变量
        splash = BedWars.getForCurrentVersion("SPLASH", "ENTITY_PLAYER_SPLASH", "ENTITY_PLAYER_SPLASH");
        woodClick = BedWars.getForCurrentVersion("WOOD_CLICK", "BLOCK_WOOD_BUTTON_CLICK_ON", "BLOCK_WOODEN_BUTTON_CLICK_ON");
        ParticleSupport = new Older();
    }

    void registerCommand() {
        Arrays.asList(
                new SpectatorSettings(),
                new PlayAgainCommand()).forEach(this::registerCommand);
    }

    private void registerCommand(final Command cmd) {
        MinecraftServer.getServer().server.getCommandMap().register(cmd.getName(), this.getName(), cmd);
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.LIGHT_PURPLE + "————————M0onCo0kie————————");
        getLogger().info(ChatColor.GREEN + "插件已关闭");
        getLogger().info(ChatColor.LIGHT_PURPLE + "————————M0onCo0kie————————");
    }
}

