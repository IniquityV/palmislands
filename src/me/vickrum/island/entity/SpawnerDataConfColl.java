package me.vickrum.island.entity;

import com.massivecraft.massivecore.MassiveCore;
import com.massivecraft.massivecore.store.Coll;

public class SpawnerDataConfColl extends Coll<SpawnerDataConf> {

	private static SpawnerDataConfColl i = new SpawnerDataConfColl();

	public static SpawnerDataConfColl get() {
		return i;
	}

	@Override
	public void onTick() {
		super.onTick();
	}

	@Override
	public void setActive(boolean active) {
		super.setActive(active);
		if (!active)
			return;
		SpawnerDataConf.i = this.get(MassiveCore.INSTANCE, true);
	}
}