package me.vickrum.island.cmd;

import java.text.NumberFormat;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;
import com.massivecraft.massivecore.command.type.primitive.TypeInteger;

import me.vickrum.island.cmd.type.TypeMPlayer;
import me.vickrum.island.entity.MConf;
import me.vickrum.island.entity.MPlayer;

public class CmdIslandSet extends MassiveCommand {

	public CmdIslandSet() {
		setDesc("Sets a players island level");
		setAliases(MConf.get().cmdIslandSetAliases);

		addParameter(TypeMPlayer.get(), "player");
		addParameter(TypeInteger.get(), "amount", "1");
		addRequirements(RequirementIsPlayer.get());

		addRequirements(RequirementHasPerm.get("island.set"));
	}

	@Override
	public void perform() throws MassiveException {
		MPlayer mplayer = this.readArgAt(0);
		int amount = this.readArgAt(1, 1);

		if (amount < 0 || amount > MConf.get().mobcreation.size()) {
			if (!MConf.get().msgNumberLowHigh.isEmpty())
				msg(MConf.get().msgNumberLowHigh.replace("{higest}",
						NumberFormat.getInstance().format(MConf.get().mobcreation.size())));
			return;
		}

		if (mplayer.getLevel() == amount) {
			if (!MConf.get().msgPlayerAlreadyThisLevel.isEmpty())
				msg(MConf.get().msgPlayerAlreadyThisLevel.replace("{level}", NumberFormat.getInstance().format(amount))
						.replace("{player}", mplayer.getName()));
			return;
		}

		mplayer.setLevel(amount);

		if (!MConf.get().msgPlayerLevelSetStaff.isEmpty())
			msg(MConf.get().msgPlayerLevelSetStaff.replace("{player}", mplayer.getName()).replace("{level}",
					NumberFormat.getInstance().format(amount)));

		if (!MConf.get().msgPlayerLevelSetPlayer.isEmpty())
			msg(MConf.get().msgPlayerLevelSetPlayer.replace("{player}", me.getName()).replace("{level}",
					NumberFormat.getInstance().format(amount)));

		return;
	}

}
