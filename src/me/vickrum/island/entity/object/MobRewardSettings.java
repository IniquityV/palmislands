package me.vickrum.island.entity.object;

import java.util.List;

public class MobRewardSettings {

	private List<Integer> levels;
	
	private List<MobReward> mobReward;
	
	public MobRewardSettings (List<Integer> levels, List<MobReward> mobReward) {
		this.levels = levels;
		this.mobReward = mobReward;
	}
	
	public List<MobReward> getRewards() {
		return this.mobReward;
	}
	
	public List<Integer> getLevels() {
		return this.levels;
	}
}
