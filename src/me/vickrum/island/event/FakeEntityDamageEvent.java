package me.vickrum.island.event;

import com.google.common.base.Function;
import com.google.common.base.Functions;
import java.util.EnumMap;
import java.util.Map;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityDamageEvent;

public class FakeEntityDamageEvent extends EntityDamageEvent {
	public FakeEntityDamageEvent(Entity damagee, EntityDamageEvent.DamageCause cause,
			Map<EntityDamageEvent.DamageModifier, Double> modifiers) {
		super(damagee, cause, modifiers, getFunctionModifiers(modifiers));
	}

	@Deprecated
	public FakeEntityDamageEvent(Entity damagee, EntityDamageEvent.DamageCause cause, double damage) {
		super(damagee, cause, damage);
	}

	public static EnumMap<EntityDamageEvent.DamageModifier, Function<? super Double, Double>> getFunctionModifiers(
			Map<EntityDamageEvent.DamageModifier, Double> modifiers) {
		EnumMap<EntityDamageEvent.DamageModifier, Function<? super Double, Double>> modifierFunctions = new EnumMap<EntityDamageEvent.DamageModifier, Function<? super Double, Double>>(
				EntityDamageEvent.DamageModifier.class);
		Function<? super Double, Double> ZERO = Functions.constant(Double.valueOf(-0.0D));
		for (EntityDamageEvent.DamageModifier modifier : modifiers.keySet())
			modifierFunctions.put(modifier, ZERO);
		return modifierFunctions;
	}
}
