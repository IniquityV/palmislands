package me.vickrum.island.entity;

import com.massivecraft.massivecore.store.SenderEntity;

public class MPlayer extends SenderEntity<MPlayer> {

	private int level = 1;

	private long xp = 0;

	private int totalMobKills = 0;

	public static MPlayer get(Object oid) {
		return (MPlayer) MPlayerColl.get().get(oid);
	}

	public MPlayer load(MPlayer that) {
		super.load(that);
		setLevel(that.level);
		setEXP(that.xp);
		setTotalMobKills(that.totalMobKills);
		return this;
	}

	///////////////////////////////////////

	public int getTotalMobKills() {
		return totalMobKills;
	}

	public void setTotalMobKills(int amount) {
		this.totalMobKills = amount;
		changed();
	}

	public void addTotalMobKills(int amount) {
		this.totalMobKills = this.getTotalMobKills() + amount;
		changed();
	}

	public void removeTotalMobKills(int amount) {
		int newAmount = this.getTotalMobKills() - amount;

		if (newAmount <= 0) {
			this.totalMobKills = 0;
			changed();
			return;
		}

		this.totalMobKills = totalMobKills - amount;
		changed();
	}

	public boolean hasMobTotalKills(int amount) {
		return getTotalMobKills() >= amount;
	}

	///////////////////////////////////////

	public long getEXP() {
		return xp;
	}

	public void setEXP(long amount) {
		this.xp = amount;
		changed();
	}

	public void addEXP(long amount) {
		this.xp = xp + amount;
		changed();
	}

	public void removeEXP(long amount) {
		long newAmount = this.getEXP() - amount;

		if (newAmount <= 0) {
			this.xp = 0;
			changed();
			return;
		}

		this.xp = xp - amount;
		changed();
	}

	public boolean hasEXP(long amount) {
		return getEXP() >= amount;
	}

	///////////////////////////////////////

	public int getLevel() {
		return level;
	}

	public void setLevel(int amount) {
		this.level = amount;
		changed();
	}

	public void addLevel(int amount) {
		this.level = level + amount;
		changed();
	}

	public void removeLevel(int amount) {
		double newAmount = this.getLevel() - amount;

		if (newAmount <= 0) {
			this.level = 0;
			changed();
			return;
		}

		this.level = level - amount;
		changed();
	}

	public boolean hasLevel(int amount) {
		return getLevel() >= amount;
	}
}
