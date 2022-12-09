package me.vickrum.island.cmd;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;

import me.vickrum.island.cmd.type.TypeMPlayer;
import me.vickrum.island.entity.MConf;
import me.vickrum.island.entity.MPlayer;

public class CmdIslandReset extends MassiveCommand {

	public CmdIslandReset() {
		setDesc("Resets players island stats");
		setAliases(MConf.get().cmdIslandResetAliases);

		addParameter(TypeMPlayer.get(), "player");

		addRequirements(RequirementIsPlayer.get());

		addRequirements(RequirementHasPerm.get("island.reset"));
	}

	@Override
	public void perform() throws MassiveException {
		MPlayer mplayer = this.readArg();

		mplayer.setLevel(1);
		mplayer.setEXP(0);
		mplayer.setTotalMobKills(0);

		if (!MConf.get().msgPlayerResetStaff.isEmpty())
			msg(MConf.get().msgPlayerResetStaff.replace("{player}", mplayer.getName()));

		if (!MConf.get().msgPlayerResetPlayer.isEmpty())
			mplayer.msg(MConf.get().msgPlayerResetPlayer.replace("{player}", me.getName()));

		return;
	}

}
