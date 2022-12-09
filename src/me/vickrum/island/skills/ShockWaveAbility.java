package me.vickrum.island.skills;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import me.vickrum.island.Main;
import me.vickrum.island.extra.LocationUtil;

public class ShockWaveAbility {
	public static void shockwaveability(Player p, double d) {
		for (Player player : LocationUtil.getNearbyPlayers(p, (int) d)) {
			new BukkitRunnable() {
				public void run() {
					player.setVelocity(player.getVelocity().normalize().add(new Vector(0, 1.4, 0)));
				}
			}.runTaskLater(Main.get(), 1);
		}
		new BukkitRunnable() {
			public void run() {
				p.setVelocity(p.getVelocity().normalize().add(new Vector(0, 1.4, 0)));
			}
		}.runTaskLater(Main.get(), 1);
	}
}
