package me.vickrum.island.skills;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class TeleportAbility {
	public static void teleportability(Player p, Entity entity, double e) {
		double d1 = e * 5;
		p.teleport(entity.getLocation().add(0.0D, d1, 0.0D));
	}
}
