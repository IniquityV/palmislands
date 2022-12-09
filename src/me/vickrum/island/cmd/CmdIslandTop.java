package me.vickrum.island.cmd;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.type.primitive.TypeInteger;
import com.massivecraft.massivecore.mson.Mson;
import com.massivecraft.massivecore.pager.Msonifier;
import com.massivecraft.massivecore.pager.Pager;
import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.entity.MConf;
import me.vickrum.island.entity.MPlayer;
import me.vickrum.island.entity.MPlayerColl;

public class CmdIslandTop extends MassiveCommand {

	public CmdIslandTop() {
		setDesc("Sees the top island players");
		setAliases(MConf.get().cmdIslandTopAliases);

		addParameter(TypeInteger.get(), "page", "1");

		addRequirements(RequirementHasPerm.get("island.top"));
	}

	@Override
	public void perform() throws MassiveException {
		int page = readArgAt(1, 1);

		final List<Mson> statsList = new ArrayList<Mson>();

		List<MPlayer> sortedPlayerStats = new ArrayList<>(MPlayerColl.get().getAll());
		sortedPlayerStats.sort((o1, o2) -> Long.compare(o2.getTotalMobKills(), o1.getTotalMobKills()));

		for (MPlayer playerStats : sortedPlayerStats) {
			Mson mson = mson(Txt.parse("&e%s &8» &eLevel: &f%s", playerStats.getName(),
					NumberFormat.getInstance().format(playerStats.getTotalMobKills())));
			statsList.add(mson);
		}

		final Pager<Mson> pager = new Pager<>(this, Txt.parse("<i>Island Mob Kills Top"), page, statsList,
				(Msonifier<Mson>) (item, index) -> mson(Txt.parse("<a>%s. ", (index + 1))).add(statsList.get(index)));

		// Pager Message
		pager.message();
		return;
	}

}
