package me.vickrum.island.extra;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtil {
	public static String serializeLocation(Location location) {
		return location.getWorld().getName() + ":" + location.getX() + ":" + location.getY() + ":" + location.getZ();
	}

	public static Location unserializeLocation(String string) {
		String[] args = string.split(":");
		return new Location(Bukkit.getWorld(args[0]), Double.parseDouble(args[1]), Double.parseDouble(args[2]),
				Double.parseDouble(args[3]));
	}

	public static Player randomPlayerByLocation(Location loc, final long radius) {
		final World world = loc.getWorld();
		final long radiusSquared = radius * radius;

		for (final Player player : Bukkit.getWorld(loc.getWorld().getName()).getPlayers()) {
			final Location playerLoc = player.getLocation();
			if (playerLoc.getWorld() != world)
				continue;

			final long delta = (long) playerLoc.distanceSquared(loc);
			if (delta < radiusSquared)
				return player;
		}

		return null;
	}

	public static List<Player> getNearbyPlayers(Entity entity, int radius) {
		ArrayList<Player> players = new ArrayList<Player>();
		List<Entity> entities = entity.getNearbyEntities(radius, radius, radius);
		for (Entity e : entities) {
			if (e instanceof Player) {
				players.add((Player) e);
			}
		}
		return players;
	}

	public static Player getRandomPlayerInRadius(Entity entity, int radius) {
		List<Player> players = getNearbyPlayers(entity, radius);
		if (players.isEmpty())
			return null;
		if (players.size() == 1)
			return players.get(1);
		return players.get(((int) (Math.random() * players.size())));
	}
}