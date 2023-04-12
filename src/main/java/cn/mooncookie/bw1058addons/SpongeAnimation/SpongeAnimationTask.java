package cn.mooncookie.bw1058addons.SpongeAnimation;

import cn.mooncookie.bw1058addons.BedWars1058Addons;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;

public class SpongeAnimationTask extends BukkitRunnable {
    private final Block block;
    private final Location loc;
    private int radius = 1;
    private int pitch = 17;

    public SpongeAnimationTask(Block block) {
        this.block = block;
        this.loc = block.getLocation();
    }

    public void run() {
        if (this.radius > 4) {
            this.cancel();
            this.block.setType(Material.AIR);
            this.loc.getWorld().playSound(this.loc, Sound.valueOf(BedWars1058Addons.getSplash()), 1.0F, 1.0F);
        } else {
            this.getParticles(this.loc, this.radius).forEach((loc) -> BedWars1058Addons.getParticleSupport().play(loc));
            this.loc.getWorld().playSound(this.loc, Sound.valueOf(BedWars1058Addons.getWoodClick()), 1.0F, (float) this.pitch / 10.0F);
            ++this.radius;
            ++this.pitch;
        }
    }

    public List<Location> getParticles(Location loc, int radius) {
        List<Location> result = new ArrayList<>();
        Block start = loc.getWorld().getBlockAt(loc);
        int iterations = radius * 2 + 1;
        List<Block> blocks = new ArrayList<>(iterations * iterations * iterations);

        for (int x = -radius; x <= radius; ++x) {
            for (int y = -radius; y <= radius; ++y) {
                for (int z = -radius; z <= radius; ++z) {
                    blocks.add(start.getRelative(x, y, z));
                }
            }
        }

        blocks.stream().filter((b) -> b.getType().equals(Material.AIR)).forEach((b) -> result.add(b.getLocation()));
        return result;
    }
}
