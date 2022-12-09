package me.vickrum.island.skills;

import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;

import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.entity.MConf;

public class GaderianAbility {
	public static void gaderianability(final LivingEntity player, Entity entity) {
		for (int i = 0; i <= MConf.get().GaderianAmount; i++) {
			Skeleton env = (Skeleton) entity.getWorld().spawnEntity(entity.getLocation(), EntityType.SKELETON);
			((Skeleton) env).setSkeletonType(SkeletonType.WITHER);

			env.setMaxHealth(MConf.get().GaderianHealth);
			env.setHealth(MConf.get().GaderianHealth);
			env.setCustomName(Txt.parse(MConf.get().GaderianName));
			env.setCustomNameVisible(true);
		}
	}
}
