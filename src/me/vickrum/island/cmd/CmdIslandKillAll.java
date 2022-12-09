package me.vickrum.island.cmd;

import java.util.Iterator;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;

import com.massivecraft.massivecore.MassiveException;
import com.massivecraft.massivecore.command.MassiveCommand;
import com.massivecraft.massivecore.command.requirement.RequirementHasPerm;
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer;

import me.vickrum.island.entity.MConf;

public class CmdIslandKillAll extends MassiveCommand {

	public CmdIslandKillAll() {
		setDesc("Kill all custom island mobs");
		setAliases(MConf.get().cmdIslandKillAliases);

		addRequirements(RequirementIsPlayer.get());

		addRequirements(RequirementHasPerm.get("island.killall"));
	}

	@Override
	public void perform() throws MassiveException {
		Iterator<LivingEntity> iterator = me.getLocation().getWorld().getLivingEntities().iterator();
		while (iterator.hasNext()) {
			Entity ent = iterator.next();
			if (!ent.hasMetadata("island"))
				continue;

			ent.remove();
		}

		if (!MConf.get().msgPlayerRemovedMobs.isEmpty())
			msg(MConf.get().msgPlayerRemovedMobs);

		return;
	}

}
