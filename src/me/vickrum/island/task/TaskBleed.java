package me.vickrum.island.task;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.massivecraft.massivecore.ModuloRepeatTask;

import me.vickrum.island.entity.MConf;
import me.vickrum.island.extra.CombatUtils;
import me.vickrum.island.extra.ParticleEffectUtils;

public class TaskBleed extends ModuloRepeatTask {
	private static TaskBleed i = new TaskBleed();

	public static TaskBleed get() {
		return i;
	}

	private static Map<LivingEntity, Integer> bleedList = new HashMap<LivingEntity, Integer>();

	public static String color(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public long getDelayMillis() {
		return 1000L;
	}

	@SuppressWarnings("deprecation")
	public void invoke(long l) {
		for (Iterator<Map.Entry<LivingEntity, Integer>> bleedIterator = bleedList.entrySet().iterator(); bleedIterator
				.hasNext();) {
			Map.Entry<LivingEntity, Integer> entry = bleedIterator.next();
			LivingEntity entity = entry.getKey();
			if (((Integer) entry.getValue()).intValue() <= 0 || !entity.isValid()) {
				bleedIterator.remove();
				continue;
			}
			if (entity instanceof Player) {
				double d = MConf.get().Bleed_DamagePlayer;
				Player player = (Player) entity;
				if (!player.isOnline())
					continue;
				if (player.getHealth() - d > 0.0D) {
					player.damage(MConf.get().Bleed_DamagePlayer);
					CombatUtils.dealDamage((LivingEntity) player, d);
					ParticleEffectUtils.playBleedEffect(entity);
				}
				entry.setValue(Integer.valueOf(((Integer) entry.getValue()).intValue() - 1));
				if (((Integer) entry.getValue()).intValue() <= 0)
					player.sendMessage(color(MConf.get().Bleeding_Stopped));
				continue;
			}
			double damage = MConf.get().Bleed_DamageMobs;
			if (entity.getHealth() - damage > 0.0D) {
				entry.setValue(Integer.valueOf(((Integer) entry.getValue()).intValue() - 1));
			} else {
				bleedIterator.remove();
			}
			CombatUtils.dealDamage(entity, damage);
			ParticleEffectUtils.playBleedEffect(entity);
		}
	}

	@SuppressWarnings("deprecation")
	public static void bleedOut(LivingEntity entity) {
		if (bleedList.containsKey(entity)) {
			CombatUtils.dealDamage(entity, (((Integer) bleedList.get(entity)).intValue() * 2));
			bleedList.remove(entity);
		}
	}

	public static void remove(LivingEntity entity) {
		if (bleedList.containsKey(entity))
			bleedList.remove(entity);
	}

	public static void add(LivingEntity entity, int ticks) {
		int newTicks = ticks;
		if (bleedList.containsKey(entity)) {
			newTicks += ((Integer) bleedList.get(entity)).intValue();
			bleedList.put(entity, Integer.valueOf(Math.min(newTicks, 10)));
		} else {
			bleedList.put(entity, Integer.valueOf(Math.min(newTicks, 10)));
		}
	}

	public static boolean isBleeding(LivingEntity entity) {
		return bleedList.containsKey(entity);
	}
}
