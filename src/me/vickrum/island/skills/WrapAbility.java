package me.vickrum.island.skills;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class WrapAbility {
	public static void wrapability(Player p, Entity entity) {
		entity.teleport(p);
	}
}
