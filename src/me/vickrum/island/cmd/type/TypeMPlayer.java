package me.vickrum.island.cmd.type;

import me.vickrum.island.entity.MPlayer;
import me.vickrum.island.entity.MPlayerColl;

import com.massivecraft.massivecore.command.type.Type;

public class TypeMPlayer {
	// -------------------------------------------- //
	// INSTANCE
	// -------------------------------------------- //

	public static Type<MPlayer> get() {
		return MPlayerColl.get().getTypeEntity();
	}
}
