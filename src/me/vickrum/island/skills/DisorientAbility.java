package me.vickrum.island.skills;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.vickrum.island.entity.MConf;

public class DisorientAbility {
	public static void disorientability(final LivingEntity player, Entity entity, double level, int radius) {
		player.addPotionEffect(
				new PotionEffect(PotionEffectType.CONFUSION, (int) (20 * level), MConf.get().DisorientConfusionLevel));
		player.addPotionEffect(
				new PotionEffect(PotionEffectType.BLINDNESS, (int) (20 * level), MConf.get().DisorientBlindnessLevel));
	}
}
