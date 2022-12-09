package me.vickrum.island.skills;

import java.util.Random;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;

import me.vickrum.island.entity.MConf;

public class CalltoActionAbility {
	public static void calltoactionability(final LivingEntity player, Entity entity, double d) {
		int amount = (int) (MConf.get().CalltoActionPerLevelAmount * d);
		for (int i = 0; i <= amount; i++) {
			EntityType mob = MConf.get().CalltoActionMobType
					.get(new Random().nextInt(MConf.get().CalltoActionMobType.size()));

			entity.getWorld().spawnEntity(entity.getLocation(), mob);
		}
	}
}
