package me.vickrum.island.skills;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class KnockBackAbility {
	public static void knockbackability(Player p, Entity entity, double e) {
		double d1 = e;
		Location location1 = entity.getLocation();
		Location location2 = p.getEyeLocation();
		double d2 = location2.getX() - location1.getX();
		double d3 = location2.getY() - location1.getY();
		double d4 = location2.getZ() - location1.getZ();
		Vector vector = new Vector(d2, d3, d4);
		vector.normalize().multiply(d1);
		p.setVelocity(vector);
	}
}
