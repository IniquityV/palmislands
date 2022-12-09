package me.vickrum.island.cmd;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.MassiveCommandVersion;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;

import me.vickrum.island.Main;
import me.vickrum.island.entity.MConf;
import me.vickrum.island.entity.object.Inventory;
import me.vickrum.island.inventory.MenuInventory;

public class CmdIsland extends MassiveCommand {

	private static CmdIsland i = new CmdIsland();

	public CmdIsland() {
		setDesc("Island base command");

		setAliases(MConf.get().cmdIslandAliases);

		addRequirements(RequirementHasPerm.get("island.basecommand"));

		addChild(new CmdIslandReset());
		addChild(new CmdIslandSet());
		addChild(new CmdIslandStats());
		addChild(new CmdIslandTop());
		addChild(new CmdIslandKillAll());
		addChild((MassiveCommandVersion) new MassiveCommandVersion(Main.get()));
	}

	public static CmdIsland get() {
		return i;
	}

	public void perform() throws MassiveException {
		new MenuInventory(this.me, getKeyByName(MConf.get().mainMenuName).getGui(),
				getKeyByName(MConf.get().mainMenuName).getClickables()).open();
	}

	public Inventory getKeyByName(String name) {
		return MConf.get().inventory.stream().filter(damageSet -> damageSet.getName().equalsIgnoreCase(name))
				.findFirst().orElse(null);
	}
}
