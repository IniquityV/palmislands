package me.vickrum.island.entity.object;

import com.massivecraft.massivecore.store.EntityInternal;

public class Mob extends EntityInternal<Mob> {

	private String name;

	private String mobDisplayName;

	public double mobHealth;

	public Mob(String name, String mobDisplayName, double mobHealth) {
		this.name = name;
		this.mobDisplayName = mobDisplayName;
		this.mobHealth = mobHealth;
	}

	public String getName() {
		return this.name;
	}

	public String getMobDisplayName() {
		return this.mobDisplayName;
	}

	public double getMobHealth() {
		return this.mobHealth;
	}
}
