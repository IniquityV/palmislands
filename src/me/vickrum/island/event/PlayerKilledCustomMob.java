package me.vickrum.island.event;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import me.vickrum.island.entity.object.Level;

public class PlayerKilledCustomMob extends Event {

	private static final HandlerList handlers = new HandlerList();

	private final Entity killer;

	private final Location mobDeathLocation;

	private final Level bossType;

	public PlayerKilledCustomMob(Entity entity, Location mobDeathLocation, Level bossType) {
		this.killer = entity;
		this.mobDeathLocation = mobDeathLocation;
		this.bossType = bossType;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public Entity getKiller() {
		return killer;
	}

	public Location getMobDeathLocation() {
		return mobDeathLocation;
	}

	public Level getMobType() {
		return bossType;
	}
}
