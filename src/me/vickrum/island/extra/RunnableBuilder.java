package me.vickrum.island.extra;

import lombok.RequiredArgsConstructor;
import me.vickrum.island.Main;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;

@RequiredArgsConstructor
public class RunnableBuilder {

	public static final BukkitScheduler scheduler = Bukkit.getScheduler();
	private Runnable runnable;

	private int taskId;

	public static RunnableBuilder forPlugin(Main plugin) {
		return new RunnableBuilder();
	}

	public static RunnableBuilder bind(Runnable runnable) {
		return forPlugin(Main.get()).with(runnable);
	}

	public RunnableBuilder with(Runnable runnable) {
		this.runnable = runnable;
		return this;
	}

	public void cancel() {
		scheduler.cancelTask(taskId);
		taskId = -1;
	}

	public boolean isCancelled() {
		return taskId == -1;
	}

	public boolean isQueued() {
		return !isCancelled() && scheduler.isQueued(taskId);
	}

	public boolean isRunning() {
		return !isCancelled() && scheduler.isCurrentlyRunning(taskId);
	}

	public int runSync() {
		return taskId = scheduler.runTask(Main.get(), runnable).getTaskId();
	}

	public int runSyncLater(long delay) {
		return taskId = scheduler.runTaskLater(Main.get(), runnable, delay).getTaskId();
	}

	public int runSyncTimer(long delay, long interval) {
		return taskId = scheduler.runTaskTimer(Main.get(), runnable, delay, interval).getTaskId();
	}

	public int runAsync() {
		return taskId = scheduler.runTaskAsynchronously(Main.get(), runnable).getTaskId();
	}

	public int runAsyncLater(long delay) {
		return taskId = scheduler.runTaskLaterAsynchronously(Main.get(), runnable, delay).getTaskId();
	}

	public int runAsyncTimer(long delay, long interval) {
		return taskId = scheduler.runTaskTimerAsynchronously(Main.get(), runnable, delay, interval).getTaskId();
	}
}
