package me.vickrum.island.skills;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.vickrum.island.entity.MConf;

public class PoisonAbility {
	public static void poisonAbility(Player p) {
		p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, MConf.get().posionLength * 20,
				MConf.get().posionLevel, true, false));
	}
}