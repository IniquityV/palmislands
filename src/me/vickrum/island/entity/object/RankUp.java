package me.vickrum.island.entity.object;

import java.util.List;

public class RankUp {

	public List<String> Commands;

	public boolean RankupTitleEnabled;

	public int RankupTitleFadeIn;

	public int RankupTitleStay;

	public int RankupTitleFadeOut;

	public String RankupTitleTitle;

	public String RankupTitleSubTitle;

	public boolean RankupSound;

	public String RankupSoundType;

	public float RankupSoundVolume;

	public float RankupSoundPitch;

	public RankUp(List<String> Commands, boolean RankupTitleEnabled, int RankupTitleFadeIn, int RankupTitleStay,
			int RankupTitleFadeOut, String RankupTitleTitle, String RankupTitleSubTitle, boolean RankupSound,
			String RankupSoundType, float RankupSoundVolume, float RankupSoundPitch) {
		this.Commands = Commands;
		this.RankupTitleEnabled = RankupTitleEnabled;
		this.RankupTitleFadeIn = RankupTitleFadeIn;
		this.RankupTitleStay = RankupTitleStay;
		this.RankupTitleFadeOut = RankupTitleFadeOut;
		this.RankupTitleTitle = RankupTitleTitle;
		this.RankupTitleSubTitle = RankupTitleSubTitle;
		this.RankupSound = RankupSound;
		this.RankupSoundType = RankupSoundType;
		this.RankupSoundVolume = RankupSoundVolume;
		this.RankupSoundPitch = RankupSoundPitch;
	}

	public List<String> getMobRankupCommands() {
		return this.Commands;
	}

	public boolean getRankupTitleEnabled() {
		return this.RankupTitleEnabled;
	}

	public int getRankupTitleFadeIn() {
		return this.RankupTitleFadeIn;
	}

	public int getRankupTitleStay() {
		return this.RankupTitleStay;
	}

	public int getRankupTitleFadeOut() {
		return this.RankupTitleFadeOut;
	}

	public String getRankupTitleTitle() {
		return this.RankupTitleTitle;
	}

	public String getRankupTitleSubTitle() {
		return this.RankupTitleSubTitle;
	}

	public boolean getRankupSound() {
		return this.RankupSound;
	}

	public String getRankupSoundType() {
		return this.RankupSoundType;
	}

	public float getRankupSoundVolume() {
		return this.RankupSoundVolume;
	}

	public float getRankupSoundPitch() {
		return this.RankupSoundPitch;
	}
}
