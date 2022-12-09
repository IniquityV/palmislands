package me.vickrum.island.extra;

import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.entity.MConf;

import java.util.stream.IntStream;

public class ProgressUtil {

	public static String getProgressBar(int current, int max, int totalBars, String symbol, String completedColor,
			String notCompletedColor) {
		// Calculate percentage
		float percent = (float) current / max;

		// Calculate amount of bars
		int progressBars = (int) (totalBars * percent);
		int leftOver = (totalBars - progressBars);

		// Initialize a StringBuilder
		StringBuilder sb = new StringBuilder();

		// Completed bars
		sb.append(completedColor);
		IntStream.range(0, progressBars).mapToObj(i -> symbol).forEach(sb::append);

		// Not completed bars
		sb.append(notCompletedColor);
		IntStream.range(0, leftOver).mapToObj(i -> symbol).forEach(sb::append);

		// Format and return progress bar
		return Txt.parse(MConf.get().ProgressBarFormat.replace("{bars}", sb.toString()));
	}
}