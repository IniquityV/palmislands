package me.vickrum.island.skills;

import org.bukkit.entity.Player;

public class FireAbility {
	public static void fireAbility(Player p, double d) {
		p.setFireTicks((int) d * 20);
	}
}
