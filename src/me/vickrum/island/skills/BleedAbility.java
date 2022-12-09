package me.vickrum.island.skills;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.entity.MConf;
import me.vickrum.island.extra.LocationUtil;
import me.vickrum.island.task.TaskBleed;

public class BleedAbility {
	public static void bleedability(final LivingEntity player, Entity entity, double d, int radius) {
		for (Player p : LocationUtil.getNearbyPlayers(player, radius)) {
			if (isNPCEntity(p) == true)
				continue;

			TaskBleed.add(p, (int) d);
			p.sendMessage(Txt.parse(MConf.get().Bleeding_Started));
		}

		TaskBleed.add(player, (int) d);
		player.sendMessage(Txt.parse(MConf.get().Bleeding_Started));
	}

	public static boolean isNPCEntity(Entity entity) {
		return (entity == null || entity.hasMetadata("NPC") || entity instanceof org.bukkit.entity.NPC
				|| entity.getClass().getName().equalsIgnoreCase("cofh.entity.PlayerFake"));
	}
}
