package me.vickrum.island.entity;

import java.util.Map;

import com.google.common.collect.Maps;
import com.massivecraft.massivecore.store.Entity;

import me.vickrum.island.entity.object.SpawnerData;

public class SpawnerDataConf extends Entity<SpawnerDataConf> {

	protected static transient SpawnerDataConf i;
	///////////////////////////////////////////
	public Map<String, SpawnerData> spawners = Maps.newHashMap();

	public void saveBlocks(Map<String, SpawnerData> blocks) {
		this.spawners = blocks;
	}

	///////////////////////////////////////////
	public static SpawnerDataConf get() {
		return i;
	}

	public SpawnerDataConf load(SpawnerDataConf that) {
		super.load(that);
		return this;
	}
}
