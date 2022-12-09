package me.vickrum.island.task;

import com.massivecraft.massivecore.ModuloRepeatTask;
import com.massivecraft.massivecore.collections.MassiveMap;
import me.vickrum.island.entity.MConf;

import org.bukkit.Bukkit;

public class TaskSell extends ModuloRepeatTask {

	private static TaskSell i = new TaskSell();
	private MassiveMap<String, Double> toAdd = new MassiveMap<>();

	public static TaskSell get() {
		return i;
	}

	@Override
	public long getDelayMillis() {
		return 1000 * MConf.get().rewardMoneyEveryXSeconds;
	}

	public void addToSell(String player, double amount) {
		if (amount <= 0)
			return;

		if (!toAdd.containsKey(player)) {
			toAdd.put(player, amount);
		} else {
			double newAmount = toAdd.get(player) + amount;
			toAdd.remove(player);
			toAdd.put(player, newAmount);
		}
	}

	@Override
	public void invoke(long l) {
		if (toAdd.isEmpty())
			return;

		toAdd.forEach((key, value) -> {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "eco give " + key + " " + value);
		});

		toAdd.clear();
	}
}