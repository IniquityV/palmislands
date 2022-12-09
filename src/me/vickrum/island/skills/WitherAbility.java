package me.vickrum.island.skills;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.vickrum.island.entity.MConf;
import me.vickrum.island.extra.LocationUtil;

public class WitherAbility {
	public static void witherability(final LivingEntity player, double level) {
		for (Player p : LocationUtil.getNearbyPlayers(player, (int) level)) {
			p.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, MConf.get().witherLength * 20,
					MConf.get().witherLevel, true, false));
		}
		player.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, MConf.get().witherLength * 20,
				MConf.get().witherLevel, true, false));
	}
}
