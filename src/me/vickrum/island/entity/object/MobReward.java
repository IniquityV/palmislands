package me.vickrum.island.entity.object;

import java.util.List;

public class MobReward {	
	private double chance;

	private String playerRewardName;

	public List<String> playerRewards;

	public MobReward(double chance, String playerRewardName, List<String> playerRewards) {
		this.chance = chance;
		this.playerRewardName = playerRewardName;
		this.playerRewards = playerRewards;
	}

	public double getChance() {
		return this.chance;
	}

	public String getRewardName() {
		return this.playerRewardName;
	}

	public List<String> getPlayerRewardCommands() {
		return this.playerRewards;
	}
}
