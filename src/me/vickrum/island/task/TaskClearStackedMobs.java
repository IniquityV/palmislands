package me.vickrum.island.task;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import com.massivecraft.massivecore.ModuloRepeatTask;
import com.massivecraft.massivecore.mixin.MixinMessage;

import me.vickrum.island.entity.MConf;
import me.vickrum.island.extra.TimeUtil;

public class TaskClearStackedMobs extends ModuloRepeatTask {
	private static TaskClearStackedMobs i = new TaskClearStackedMobs();
	private Integer time = null;

	public static TaskClearStackedMobs get() {
		return i;
	}

	public void invoke(long l) {
		if (MConf.get().clearStackIntervalSeconds != -1) {
			if (this.time == null) {
				this.time = MConf.get().clearStackIntervalSeconds * 60;
			}

			this.time = this.time - 1;
			if (this.time <= 0) {
				for (World worlds : Bukkit.getWorlds()) {
					if (MConf.get().whitelistedWorlds.contains(worlds.getName().toLowerCase())) {
						Iterator<LivingEntity> iterator = worlds.getLivingEntities().iterator();
						while (iterator.hasNext()) {
							Entity ent = iterator.next();
							if (!ent.hasMetadata("island"))
								continue;

							ent.remove();
						}
					}
				}

				this.time = null;
			}

			if (this.time != null && MConf.get().stacksMobWillClearInBroadcastTimesSeconds.contains(this.time)) {
				MixinMessage.get().msgAll(MConf.get().stackedMobsWillClearIn.replace("%time%",
						TimeUtil.formatTime5(TimeUnit.SECONDS.toMillis((long) this.time)).trim()));
			}

		}
	}

	public long getDelayMillis() {
		return 1000L;
	}
}
