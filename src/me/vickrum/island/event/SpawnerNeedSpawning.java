package me.vickrum.island.event;

import org.bukkit.entity.EntityType;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class SpawnerNeedSpawning extends Event {

	private static final HandlerList handlers = new HandlerList();

	private final String spawnerLocation;

	private final EntityType spawnerEntityType;

	private final long spawnerLastSpawned;

	public SpawnerNeedSpawning(String spawnerLocation, EntityType spawnerEntityType, long spawnerLastSpawned) {
		this.spawnerLocation = spawnerLocation;
		this.spawnerEntityType = spawnerEntityType;
		this.spawnerLastSpawned = spawnerLastSpawned;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public HandlerList getHandlers() {
		return handlers;
	}

	public String getSpawnerLocation() {
		return this.spawnerLocation;
	}

	public EntityType getSpawnerType() {
		return this.spawnerEntityType;
	}

	public long getSpawnerLastSpawned() {
		return this.spawnerLastSpawned;
	}
}