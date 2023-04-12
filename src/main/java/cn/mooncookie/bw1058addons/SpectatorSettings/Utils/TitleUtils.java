package cn.mooncookie.bw1058addons.SpectatorSettings.Utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class TitleUtils {
    public static void sendTitle(final Player player, final String title, final String subtitle, final int fadeIn, final int stay, final int fadeOut) {
        if (player != null) {
            final CraftPlayer p = (CraftPlayer) player;
            PacketPlayOutTitle titleU = new PacketPlayOutTitle(fadeIn, stay, fadeOut);
            IChatBaseComponent chat = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + title + "\"}");
            p.getHandle().playerConnection.sendPacket(titleU);
            titleU = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, chat);
            chat = IChatBaseComponent.ChatSerializer.a("{\"text\":\"" + subtitle + "\"}");
            p.getHandle().playerConnection.sendPacket(titleU);
            titleU = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, chat);
            p.getHandle().playerConnection.sendPacket(titleU);
        }
    }

}
