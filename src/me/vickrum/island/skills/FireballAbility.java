package me.vickrum.island.skills;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class FireballAbility {
	public static void fireballAbility(LivingEntity entity, double damage, double d) {
		Vector vector = entity.getLocation().toVector().subtract(entity.getLocation().toVector());
		entity.setVelocity(vector);

		Fireball fireball = (Fireball) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.FIREBALL);
		fireball.setVelocity(vector.normalize());
		fireball.setIsIncendiary(false);
		fireball.setYield(0);
		entity.damage(damage * d, entity);
	}
}
