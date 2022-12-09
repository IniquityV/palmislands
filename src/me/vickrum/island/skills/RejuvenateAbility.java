package me.vickrum.island.skills;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.entity.MConf;
import me.vickrum.island.extra.LocationUtil;

public class RejuvenateAbility {
	public static void rejuvenateability(final LivingEntity player, Entity entity, double d) {
		LivingEntity livingEnt = (LivingEntity) entity;
		double health = livingEnt.getHealth();
		double maxhealth = livingEnt.getMaxHealth();

		double halfhealth = maxhealth / 2;

		if (health <= halfhealth) {
			livingEnt.setHealth(maxhealth);

			for (Player p2 : LocationUtil.getNearbyPlayers(player, (int) d)) {
				p2.sendMessage(Txt.parse(MConf.get().msgRejuvenateAbilityHappened));
			}

			player.sendMessage(Txt.parse(MConf.get().msgRejuvenateAbilityHappened));
		}
	}
}
