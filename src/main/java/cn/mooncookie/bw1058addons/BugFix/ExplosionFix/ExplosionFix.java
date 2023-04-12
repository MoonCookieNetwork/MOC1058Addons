package cn.mooncookie.bw1058addons.BugFix.ExplosionFix;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

import java.util.ArrayList;
import java.util.List;

public class ExplosionFix implements Listener {
    @EventHandler
    public void onExplode(EntityExplodeEvent e) {
        Location location = e.getLocation().getBlock().getLocation();
        List<Block> blocklist = new ArrayList<>(e.blockList());
        List<Block> glass = new ArrayList<>();
        for (Block block : e.blockList()) {
            if (block.getType() == Material.GLASS || block.getType() == Material.STAINED_GLASS)
                glass.add(block);
        }
        e.blockList().removeAll(glass);
        List<Block> blocks = new ArrayList<>();
        for (Block block2 : e.blockList()) {
            for (Block glassblock : glass) {
                if (location.distance(block2.getLocation()) > location.distance(glassblock.getLocation()) && location.distance(block2.getLocation()) > block2.getLocation().distance(glassblock.getLocation()))
                    blocks.add(block2);
            }
        }
        e.blockList().removeAll(blocks);
        List<Block> addblocks = new ArrayList<>();
        addblocks.add(location.clone().add(0.0D, 1.0D, 0.0D).getBlock());
        addblocks.add(location.clone().add(0.0D, -1.0D, 0.0D).getBlock());
        addblocks.add(location.clone().add(0.0D, 0.0D, 1.0D).getBlock());
        addblocks.add(location.clone().add(0.0D, 0.0D, -1.0D).getBlock());
        addblocks.add(location.clone().add(1.0D, 0.0D, 0.0D).getBlock());
        addblocks.add(location.clone().add(-1.0D, 0.0D, 0.0D).getBlock());
        for (Block block3 : addblocks) {
            if (blocklist.contains(block3) && block3.getType() != Material.GLASS && block3.getType() != Material.STAINED_GLASS)
                e.blockList().add(block3);
        }
    }

    @EventHandler
    public void onExplodeEndStONE(EntityExplodeEvent e) {
        if (e.getEntityType() == EntityType.FIREBALL) {
            Location location = e.getLocation().getBlock().getLocation();
            List<Block> blocklist = new ArrayList<>(e.blockList());
            List<Block> EnderStone = new ArrayList<>();
            for (Block block : e.blockList()) {
                if (block.getType() == Material.ENDER_STONE)
                    EnderStone.add(block);
            }
            e.blockList().removeAll(EnderStone);
            List<Block> blocks = new ArrayList<>();
            for (Block block2 : e.blockList()) {
                for (Block EnderStoneBlock : EnderStone) {
                    if (location.distance(block2.getLocation()) > location.distance(EnderStoneBlock.getLocation()) && location.distance(block2.getLocation()) > block2.getLocation().distance(EnderStoneBlock.getLocation()))
                        blocks.add(block2);
                }
            }
            e.blockList().removeAll(blocks);
            List<Block> addblocks = new ArrayList<>();
            addblocks.add(location.clone().add(0.0D, 1.0D, 0.0D).getBlock());
            addblocks.add(location.clone().add(0.0D, -1.0D, 0.0D).getBlock());
            addblocks.add(location.clone().add(0.0D, 0.0D, 1.0D).getBlock());
            addblocks.add(location.clone().add(0.0D, 0.0D, -1.0D).getBlock());
            addblocks.add(location.clone().add(1.0D, 0.0D, 0.0D).getBlock());
            addblocks.add(location.clone().add(-1.0D, 0.0D, 0.0D).getBlock());
            for (Block block3 : addblocks) {
                if (blocklist.contains(block3) && block3.getType() != Material.ENDER_STONE)
                    e.blockList().add(block3);
            }
        }
    }
}
