package me.vickrum.island.task;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.gmail.filoghost.holographicdisplays.api.HologramsAPI;
import com.gmail.filoghost.holographicdisplays.api.line.TextLine;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;

import com.massivecraft.massivecore.ModuloRepeatTask;
import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.Main;
import me.vickrum.island.entity.MConf;
import me.vickrum.island.entity.SpawnerDataConf;
import me.vickrum.island.entity.object.SpawnerData;
import me.vickrum.island.event.SpawnerNeedSpawning;
import me.vickrum.island.extra.LocationUtil;
import me.vickrum.island.extra.ProgressUtil;

public class TaskHologram extends ModuloRepeatTask {
	private static TaskHologram i = new TaskHologram();

	public static TaskHologram get() {
		return i;
	}

	public long getDelayMillis() {
		return 1000L;
	}

	public HashMap<Location, Hologram> armourstandDB2 = new HashMap<>();

	public void invoke(long now) {
		Set<SpawnerData> hologram = SpawnerDataConf.get().spawners.values().stream().collect(Collectors.toSet());

		if (hologram.size() == 0)
			return;

		hologram.forEach(e -> {
			if (e == null)
				return;

			Location newLoc = LocationUtil.unserializeLocation(e.getSpawnerLocation());

			if (!newLoc.getChunk().isLoaded())
				return;

			newLoc.getWorld().playEffect(newLoc, Effect.MOBSPAWNER_FLAMES, 2);

			Location newloc2 = newLoc.add(0.5, 2, 0.5);

			Hologram hologram2 = HologramsAPI.createHologram(Main.get(), newloc2);

			long l = System.currentTimeMillis() - e.getSpawnerLastSpawned();

			if (armourstandDB2.containsKey(newloc2)) {
				Hologram lol = armourstandDB2.get(newloc2);
				TextLine hologramLines = (TextLine) lol.getLine(1);

				long timeLeft = MConf.get().spawnerDelaySeconds - Integer.parseInt(timeAsString(l));

				hologramLines.setText(Txt.parse(
						ProgressUtil.getProgressBar(Integer.parseInt(timeAsString(l)), MConf.get().spawnerDelaySeconds,
								MConf.get().ProgressBarAmountOfBarsToDisplay, "■", MConf.get().ProgressBarCompleteColor,
								MConf.get().ProgressBarNotCompleteColor) + "&r &7" + timeLeft + "s"));

				if (timeLeft <= 0) {

					e.setSpawnerLastSpawned();
					SpawnerDataConf.get().changed();

					if (!MConf.get().whitelistedWorlds.contains(newloc2.getWorld().getName().toLowerCase()))
						return;

					SpawnerNeedSpawning mobspawn = new SpawnerNeedSpawning(e.getSpawnerLocation(), e.getSpawnerType(),
							e.getSpawnerLastSpawned());
					Bukkit.getPluginManager().callEvent(mobspawn);
				}
			}

			if (!armourstandDB2.containsKey(newloc2)) {
				hologram2.appendTextLine(Txt.parse(MConf.get().spawnerHologramDisplayName.replace("{entityType}",
						Main.get().caps(e.getSpawnerType().name()))));
				hologram2.appendTextLine(Txt.parse(ProgressUtil.getProgressBar(Integer.parseInt(timeAsString(l)),
						MConf.get().spawnerDelaySeconds, MConf.get().ProgressBarAmountOfBarsToDisplay, "■",
						MConf.get().ProgressBarCompleteColor, MConf.get().ProgressBarNotCompleteColor) + "&r &7"
						+ MConf.get().spawnerDelaySeconds + "s"));
				armourstandDB2.put(newloc2, hologram2);
			}
		});
	}

	public static String timeAsString(long timePeriod) {
		long millis = timePeriod;
		String output = "";
		long seconds = TimeUnit.MILLISECONDS.toSeconds(millis);
		if (seconds > 1)
			output += seconds;
		else if (seconds == 1)
			output += seconds;
		else {
			output += "0";
		}
		return output;
	}

	public static String getProgressBar(int current, int max, int totalBars) {
		return getProgressBar(current, max, totalBars, "■", ChatColor.GREEN, ChatColor.RED);
	}

	public static String getProgressBar(int current, int max, int totalBars, String bar, ChatColor progressColor,
			ChatColor leftColor) {
		float percent = current / max;
		int progressBars = (int) (totalBars * percent);
		int leftOver = totalBars - progressBars;
		StringBuilder sb = new StringBuilder();
		sb.append(progressColor);
		int i;
		for (i = 0; i < progressBars; i++)
			sb.append(bar);
		sb.append(leftColor);
		for (i = 0; i < leftOver; i++)
			sb.append(bar);
		return sb.toString();
	}
}
