package me.vickrum.island.event;

import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.vickrum.island.entity.object.Level;

public class CustomMobSpawn extends Event {

	private static final HandlerList handlers = new HandlerList();

	private final Level mob;

	private final Location bossLocation;

	public CustomMobSpawn(Level mob, Location bossLocation) {
		this.mob = mob;
		this.bossLocation = bossLocation;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public Location getBossLocation() {
		return bossLocation;
	}

	public Level getMob() {
		return mob;
	}
}