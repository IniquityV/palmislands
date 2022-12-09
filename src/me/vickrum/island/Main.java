package me.vickrum.island;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.plugin.RegisteredServiceProvider;

import com.massivecraft.massivecore.MassivePlugin;

import me.vickrum.island.entity.MConf;
import me.vickrum.island.entity.object.Level;
import me.vickrum.island.entity.object.MobRewardSettings;
import me.vickrum.island.gui.EngineGui;
import me.vickrum.island.skills.CageAbility;
import me.vickrum.island.task.TaskHologram;
import net.milkbowl.vault.economy.Economy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import com.gmail.filoghost.holographicdisplays.api.Hologram;

public class Main extends MassivePlugin {

	public ArrayList<Location> cageblocks = new ArrayList<Location>();

	private static Main i;

	public static Economy economy = null;

	public Main() {
		i = this;
	}

	public static Main get() {
		economy = null;
		return i;
	}

	public void onEnableInner() {
		setupEconomy();
		activateAuto();
		activate(EngineGui.class);
	}

	public void onDisable() {
		for (Entry<Location, Hologram> entry : TaskHologram.get().armourstandDB2.entrySet()) {
			Hologram key = entry.getValue();
			key.delete();
		}
		for (World worlds : Bukkit.getWorlds()) {
			Iterator<LivingEntity> iterator = worlds.getLivingEntities().iterator();
			while (iterator.hasNext()) {
				Entity ent = iterator.next();

				if (!ent.hasMetadata("island"))
					continue;

				ent.remove();
			}
		}
		if (CageAbility.blocks.size() >= 1) {
			for (Location block : CageAbility.blocks) {
				if (block.getBlock().getType().equals(MConf.get().cage_wall))
					block.getBlock().setType(Material.AIR);
			}
		}
		super.onDisable();
	}

	public boolean isVersionSynchronized() {
		return false;
	}

	public Level getKeyByName(EntityType name) {
		return MConf.get().mobcreation.stream().filter(damageSet -> damageSet.getMobType().equals(name)).findFirst()
				.orElse(null);
	}

	public Level getKeyByLevel(int level) {
		return MConf.get().mobcreation.stream().filter(damageSet -> damageSet.getLevel() == level).findFirst()
				.orElse(null);
	}

	public MobRewardSettings getRewards(int level) {
		return MConf.get().mobrewards.stream().filter(damageSet -> damageSet.getLevels().contains(level)).findFirst()
				.orElse(null);
	}

	public Level getKeyByMobId(String name) {
		return MConf.get().mobcreation.stream().filter(damageSet -> damageSet.getMob().getName().equalsIgnoreCase(name))
				.findFirst().orElse(null);
	}

	public static Economy getEconomy() {
		return economy;
	}

	public String caps(final String string) {
		final String[] list = string.split("_");
		String s = "";
		String[] array;
		for (int length = (array = list).length, i = 0; i < length; ++i) {
			final String st = array[i];
			s = String.valueOf(String.valueOf(s)) + st.substring(0, 1).toUpperCase() + st.substring(1).toLowerCase()
					+ " ";
		}
		return s.substring(0, s.length() - 1);
	}

	private boolean setupEconomy() {
		if (getServer().getPluginManager().getPlugin("Vault") == null)
			return false;
		RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
		if (rsp == null)
			return false;
		economy = (Economy) rsp.getProvider();
		return (economy != null);
	}
}
