package me.vickrum.island.entity.object;

public class MobSkills {

	private double chance;

	private String skillName;

	private double skillLevel;

	private double skilldamage;

	private int skillRadius;

	public MobSkills(double chance, String skillName, double skillLevel, double skilldamage, int skillRadius) {
		this.chance = chance;
		this.skillName = skillName;
		this.skillLevel = skillLevel;
		this.skilldamage = skilldamage;
		this.skillRadius = skillRadius;
	}

	public double getChance() {
		return this.chance;
	}

	public String getSkillName() {
		return this.skillName;
	}

	public double getSkillLevel() {
		return this.skillLevel;
	}

	public double getSkillDamage() {
		return this.skilldamage;
	}

	public int getSkillRadius() {
		return this.skillRadius;
	}
}
