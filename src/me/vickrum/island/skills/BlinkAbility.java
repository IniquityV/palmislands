package me.vickrum.island.skills;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

public class BlinkAbility {
	public static void blinkability(final LivingEntity player, Entity entity) {
		Location lBoss = entity.getLocation();

		Random random = new Random();

		lBoss.add(random.nextInt(3), 0, random.nextInt(3));

		entity.teleport(lBoss);
	}
}
