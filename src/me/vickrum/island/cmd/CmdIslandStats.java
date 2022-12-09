package me.vickrum.island.cmd;

import java.text.NumberFormat;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;

import me.vickrum.island.Main;
import me.vickrum.island.cmd.type.TypeMPlayer;
import me.vickrum.island.entity.MConf;
import me.vickrum.island.entity.MPlayer;
import me.vickrum.island.entity.object.Level;

public class CmdIslandStats extends MassiveCommand {

	public CmdIslandStats() {
		setDesc("Sees a players island stats");
		setAliases(MConf.get().cmdIslandStatsAliases);

		addParameter(TypeMPlayer.get(), "player", "me");
		addRequirements(RequirementIsPlayer.get());

		addRequirements(RequirementHasPerm.get("island.stats"));
	}

	@Override
	public void perform() throws MassiveException {
		MPlayer mplayer = this.readArgAt(0, MPlayer.get(me));

		Level spawnerEntity = Main.get().getKeyByLevel(mplayer.getLevel());

		for (String s : MConf.get().msgPlayerStats)
			msg(s.replace("{total_mobs_xp_needed}", NumberFormat.getInstance().format(spawnerEntity.getXPRequired()))
					.replace("{your_xp}", NumberFormat.getInstance().format(mplayer.getEXP()))
					.replace("{current_mob}", spawnerEntity.getMobType().name())
					.replace("{mob_kills}", NumberFormat.getInstance().format(mplayer.getTotalMobKills()))
					.replace("{level}", NumberFormat.getInstance().format(mplayer.getLevel()))
					.replace("{player}", mplayer.getName()));

		return;

	}

}
