package me.vickrum.island.cmd;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.type.primitive.TypeInteger;

import me.vickrum.island.entity.MConf;
import me.vickrum.island.inventory.LootBagInventory;

public class CmdLootBag extends MassiveCommand {
	private static final CmdLootBag i = new CmdLootBag();

	public static CmdLootBag get() {
		return i;
	}

	public CmdLootBag() {
		addRequirements(RequirementHasPerm.get("island.lootbag"));
		setAliases(MConf.get().cmdLootbagAliases);
		setDesc("Opens the lootbag inventory");

		addParameter(TypeInteger.get(), "1", "1");
	}

	public void perform() throws MassiveException {
		int amount = this.readArgAt(0, 1);

		new LootBagInventory(this.me, MConf.get().lootbagLayout.getActionInventoryGUI(),
				MConf.get().lootbagLayout.getClickables(), amount).open();
	}

}