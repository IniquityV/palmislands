package me.vickrum.island.skills;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitRunnable;

import me.vickrum.island.Main;
import me.vickrum.island.entity.MConf;

public class CageAbility {
	public static List<Location> blocks = new ArrayList<Location>();

	public static void cageability(final LivingEntity player, Location paramLocation, double level) {

		for (int x = -1; x <= 1; x++) {
			for (int y = -1; y <= 2; y++) {
				for (int z = -1; z <= 1; z++) {
					if (x == 0 && z == 0 && y != 2 && y != -1)
						continue;

					if (player.getWorld()
							.getBlockAt(new Location(player.getWorld(), player.getLocation().getX() + x,
									player.getLocation().getY() + y, player.getLocation().getZ() + z)) == null
							|| player.getWorld()
									.getBlockAt(new Location(player.getWorld(), player.getLocation().getX() + x,
											player.getLocation().getY() + y, player.getLocation().getZ() + z))
									.getType().equals(Material.AIR)) {
						player.getLocation().getWorld()
								.getBlockAt(
										new Location(player.getLocation().getWorld(), player.getLocation().getX() + x,
												player.getLocation().getY() + y, player.getLocation().getZ() + z))
								.setType(MConf.get().cage_wall);
						blocks.add(new Location(player.getLocation().getWorld(), player.getLocation().getX() + x,
								player.getLocation().getY() + y, player.getLocation().getZ() + z));
						Main.get().cageblocks
								.add(new Location(player.getLocation().getWorld(), player.getLocation().getX() + x,
										player.getLocation().getY() + y, player.getLocation().getZ() + z));

					}
				}
			}
		}

		player.teleport(paramLocation);

		new BukkitRunnable() {
			@Override
			public void run() {
				for (Location loc : blocks) {
					loc.getWorld().getBlockAt(loc).setType(Material.AIR);
					Main.get().cageblocks.remove(loc);
				}

			}
		}.runTaskLater(Main.get(), (long) (level * 20));
	}
}
