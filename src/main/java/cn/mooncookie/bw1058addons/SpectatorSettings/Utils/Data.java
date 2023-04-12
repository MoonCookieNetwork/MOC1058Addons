package cn.mooncookie.bw1058addons.SpectatorSettings.Utils;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class Data {

    public static HashMap<Player, SettingsType> autoTeleport;
    public static HashMap<Player, SettingsType> nightVision;
    public static HashMap<Player, SettingsType> person;
    public static HashMap<Player, SettingsType> hideSpectators;

    static {
        Data.autoTeleport = new HashMap<>();
        Data.nightVision = new HashMap<>();
        Data.person = new HashMap<>();
        Data.hideSpectators = new HashMap<>();
    }

}
