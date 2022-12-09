package me.vickrum.island.entity.object;

import java.util.List;

import org.bukkit.entity.EntityType;

import com.massivecraft.massivecore.store.EntityInternal;

public class Level extends EntityInternal<Level> {

	public int level;

	public Mob mob;

	public EntityType mobType;

	public long xpTillNextRankup;

	public double spawnChance;

	public boolean moneyonkillStatus;

	public double moneyonkillAmount;

	public long xpPerMobKill;

	public RankUp mobRankup;

	public List<MobSkills> mobSkills;

	public double mobDamage;

	public Level(int level, Mob mob, EntityType mobType, int xpTillNextRankup, double spawnChance,
			boolean moneyonkillStatus, double moneyonkillAmount, long xpPerMobKill, RankUp mobRankup,
			List<MobSkills> mobSkills, double mobDamage) {
		this.level = level;
		this.mob = mob;
		this.mobType = mobType;
		this.xpTillNextRankup = xpTillNextRankup;
		this.spawnChance = spawnChance;
		this.moneyonkillStatus = moneyonkillStatus;
		this.moneyonkillAmount = moneyonkillAmount;
		this.xpPerMobKill = xpPerMobKill;
		this.mobRankup = mobRankup;
		this.mobSkills = mobSkills;
		this.mobDamage = mobDamage;
	}

	public double getMobDamage() {
		return this.mobDamage;
	}

	public RankUp getMobRankup() {
		return this.mobRankup;
	}

	public List<MobSkills> getMobSkills() {
		return this.mobSkills;
	}

	public long getXPPerMobKill() {
		return this.xpPerMobKill;
	}

	public double getMoneyOnKillAmount() {
		return this.moneyonkillAmount;
	}

	public boolean getMoneyOnKillStatus() {
		return this.moneyonkillStatus;
	}

	public int getLevel() {
		return this.level;
	}

	public Mob getMob() {
		return this.mob;
	}

	public EntityType getMobType() {
		return this.mobType;
	}

	public long getXPRequired() {
		return this.xpTillNextRankup;
	}

	public double getSpawnChance() {
		return this.spawnChance;
	}
}
