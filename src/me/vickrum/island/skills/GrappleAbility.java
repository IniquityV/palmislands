package me.vickrum.island.skills;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class GrappleAbility {
	public static void grappleability(Player p, Entity entity, double e) {
		double d = e;
		Location location = p.getLocation();
		Vector vector = location.toVector().subtract(entity.getLocation().toVector()).normalize().multiply(d).setY(2);
		p.setVelocity(vector);
	}
}
