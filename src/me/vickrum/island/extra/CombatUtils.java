package me.vickrum.island.extra;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Event;
import org.bukkit.event.entity.EntityDamageEvent;

import com.google.common.collect.ImmutableMap;

import me.vickrum.island.event.FakeEntityDamageByEntityEvent;
import me.vickrum.island.event.FakeEntityDamageEvent;

public class CombatUtils {
	@Deprecated
	public static void dealDamage(LivingEntity target, double damage) {
		dealDamage(target, damage, EntityDamageEvent.DamageCause.CUSTOM, (Entity) null);
	}

	@Deprecated
	public static void dealDamage(LivingEntity target, double damage, LivingEntity attacker) {
		dealDamage(target, damage, EntityDamageEvent.DamageCause.ENTITY_ATTACK, (Entity) attacker);
	}

	public static void dealDamage(LivingEntity target, double damage,
			Map<EntityDamageEvent.DamageModifier, Double> modifiers, LivingEntity attacker) {
		if (target.isDead())
			return;
		target.damage(callFakeDamageEvent((Entity) attacker, (Entity) target, damage, modifiers));
	}

	@Deprecated
	public static void dealDamage(LivingEntity target, double damage, EntityDamageEvent.DamageCause cause,
			Entity attacker) {
		if (target.isDead())
			return;
		target.damage(callFakeDamageEvent(attacker, (Entity) target, cause, damage));
	}

	@Deprecated
	public static double callFakeDamageEvent(Entity attacker, Entity target, double damage) {
		return callFakeDamageEvent(attacker, target, EntityDamageEvent.DamageCause.ENTITY_ATTACK,
				new EnumMap<EntityDamageEvent.DamageModifier, Double>(
						(Map<EntityDamageEvent.DamageModifier, ? extends Double>) ImmutableMap
								.of(EntityDamageEvent.DamageModifier.BASE, Double.valueOf(damage))));
	}

	@Deprecated
	public static double callFakeDamageEvent(Entity attacker, Entity target, EntityDamageEvent.DamageCause damageCause,
			double damage) {
		EntityDamageEvent damageEvent = (attacker == null)
				? (EntityDamageEvent) new FakeEntityDamageEvent(target, damageCause, damage)
				: (EntityDamageEvent) new FakeEntityDamageByEntityEvent(attacker, target, damageCause, damage);
		Bukkit.getServer().getPluginManager().callEvent((Event) damageEvent);
		if (damageEvent.isCancelled())
			return 0.0D;
		return damageEvent.getFinalDamage();
	}

	public static double callFakeDamageEvent(Entity attacker, Entity target,
			Map<EntityDamageEvent.DamageModifier, Double> modifiers) {
		return callFakeDamageEvent(attacker, target, EntityDamageEvent.DamageCause.ENTITY_ATTACK, modifiers);
	}

	public static double callFakeDamageEvent(Entity attacker, Entity target, double damage,
			Map<EntityDamageEvent.DamageModifier, Double> modifiers) {
		return callFakeDamageEvent(attacker, target, EntityDamageEvent.DamageCause.ENTITY_ATTACK,
				getScaledModifiers(damage, modifiers));
	}

	public static double callFakeDamageEvent(Entity attacker, Entity target, EntityDamageEvent.DamageCause cause,
			Map<EntityDamageEvent.DamageModifier, Double> modifiers) {
		EntityDamageEvent damageEvent = (attacker == null)
				? (EntityDamageEvent) new FakeEntityDamageEvent(target, cause, modifiers)
				: (EntityDamageEvent) new FakeEntityDamageByEntityEvent(attacker, target, cause, modifiers);
		Bukkit.getServer().getPluginManager().callEvent((Event) damageEvent);
		if (damageEvent.isCancelled())
			return 0.0D;
		return damageEvent.getFinalDamage();
	}

	private static Map<EntityDamageEvent.DamageModifier, Double> getScaledModifiers(double damage,
			Map<EntityDamageEvent.DamageModifier, Double> modifiers) {
		Map<EntityDamageEvent.DamageModifier, Double> scaledModifiers = new HashMap<EntityDamageEvent.DamageModifier, Double>();
		for (EntityDamageEvent.DamageModifier modifier : modifiers.keySet()) {
			if (modifier == EntityDamageEvent.DamageModifier.BASE) {
				scaledModifiers.put(modifier, Double.valueOf(damage));
				continue;
			}
			scaledModifiers.put(modifier, Double.valueOf(damage * ((Double) modifiers.get(modifier)).doubleValue()));
		}
		return scaledModifiers;
	}
}
