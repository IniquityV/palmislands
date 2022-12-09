package me.vickrum.island.entity.object;

import org.bukkit.entity.EntityType;

public class SpawnerData {

	public String spawnerLocation;

	public EntityType spawnerEntityType;

	public long spawnerLastSpawned;

	public SpawnerData(String spawnerLocation, EntityType spawnerEntityType, long spawnerLastSpawned) {
		this.spawnerLocation = spawnerLocation;
		this.spawnerEntityType = spawnerEntityType;
		this.spawnerLastSpawned = spawnerLastSpawned;
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

	public void setSpawnerLastSpawned() {
		this.spawnerLastSpawned = System.currentTimeMillis();
	}
}
