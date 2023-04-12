package cn.mooncookie.bw1058addons.SpongeAnimation.Particle.versions;

import cn.mooncookie.bw1058addons.SpongeAnimation.Particle.ParticleSupport;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;

public class Older implements ParticleSupport {
    public Older() {
    }

    public void play(Location loc) {
        PacketPlayOutWorldParticles pwp = new PacketPlayOutWorldParticles(EnumParticle.CLOUD, true, (float) loc.getX(), (float) loc.getY(), (float) loc.getZ(), 0.0F, 0.0F, 0.0F, 0.1F, 1);
        Bukkit.getOnlinePlayers().forEach((p) -> ((CraftPlayer) p).getHandle().playerConnection.sendPacket(pwp));
    }
}
