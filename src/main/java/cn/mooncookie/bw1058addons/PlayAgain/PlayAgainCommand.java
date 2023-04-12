package cn.mooncookie.bw1058addons.PlayAgain;

import com.andrei1058.bedwars.arena.Arena;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayAgainCommand extends Command {
    public static String Group = "";

    public PlayAgainCommand() {
        super("playagain");
    }

    @Override
    public boolean execute(CommandSender sender, String s, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player p = (Player) sender;
        switch (Arena.getArenaByPlayer(p).getGroup()) {
            case "solo":
                Group = "Bw_Solo";
                break;
            case "doubles":
                Group = "Bw_Doubles";
                break;
            case "4v4v4v4":
                Group = "Bw_4v4v4v4";
                break;
            case "rush_doubles":
                Group = "Bw_RushDoubles";
                break;
            case "rush_4v4v4v4":
                Group = "Bw_RushFourFour";
                break;
        }
        Bukkit.dispatchCommand(p.getPlayer(), "sj fastjoin " + Group);
        return true;
    }
}
