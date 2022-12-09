package me.vickrum.island.skills;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.entity.MConf;
import me.vickrum.island.extra.LocationUtil;

public class SelfDestructAbility {
	public static void selfdestructability(final LivingEntity player, Entity entity) {
		for (Player p : LocationUtil.getNearbyPlayers(player, 7)) {
			if (isNPCEntity(p) == true)
				continue;

			double distance = p.getLocation().distance(entity.getLocation());

			if (distance <= 3) {
				p.damage(MConf.get().damageSelfdestructWithin3Blocks);

				p.sendMessage(Txt.parse(MConf.get().msgKilledBySelfDestruct));

				continue;
			}

			if (distance <= 6) {
				p.damage(MConf.get().damageSelfdestructWithin6Blocks);

				p.sendMessage(Txt.parse(MConf.get().msgTookDamageBySelfDestruct));

				continue;
			}
		}

		double distance = player.getLocation().distance(entity.getLocation());

		if (distance <= 3) {
			player.damage(MConf.get().damageSelfdestructWithin3Blocks);

			player.sendMessage(Txt.parse(MConf.get().msgKilledBySelfDestruct));

			return;
		}

		if (distance <= 6) {
			player.damage(MConf.get().damageSelfdestructWithin6Blocks);

			player.sendMessage(Txt.parse(MConf.get().msgTookDamageBySelfDestruct));

			return;
		}
	}

	public static boolean isNPCEntity(Entity entity) {
		return (entity == null || entity.hasMetadata("NPC") || entity instanceof org.bukkit.entity.NPC
				|| entity.getClass().getName().equalsIgnoreCase("cofh.entity.PlayerFake"));
	}
}
