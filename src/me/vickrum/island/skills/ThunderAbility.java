package me.vickrum.island.skills;

import org.bukkit.entity.LivingEntity;

public class ThunderAbility {
	public static void thunderAbility(LivingEntity entity, double damage, double d) {
		entity.getWorld().strikeLightning(entity.getLocation());
		entity.damage(damage * d, entity);
	}
}
