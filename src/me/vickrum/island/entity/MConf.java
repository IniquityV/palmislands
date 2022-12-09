package me.vickrum.island.entity;

import java.util.List;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;

import com.massivecraft.massivecore.store.Entity;
import com.massivecraft.massivecore.util.MUtil;
import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.entity.object.Inventory;
import me.vickrum.island.entity.object.Level;
import me.vickrum.island.entity.object.LootbagInventory;
import me.vickrum.island.entity.object.Mob;
import me.vickrum.island.entity.object.MobReward;
import me.vickrum.island.entity.object.MobRewardSettings;
import me.vickrum.island.entity.object.MobSkills;
import me.vickrum.island.entity.object.RankUp;
import me.vickrum.island.extra.ItemStackWrapper;
import me.vickrum.island.extra.MetaWrapper;
import me.vickrum.island.gui.configuration.Clickable;
import me.vickrum.island.gui.configuration.GuiDesign;

public class MConf extends Entity<MConf> {

	protected static transient MConf i;

	///////////////////////////////////////////
	// Commands
	///////////////////////////////////////////
	public List<String> cmdIslandAliases = MUtil.list("island", "is", "islands");
	public List<String> cmdIslandResetAliases = MUtil.list("reset", "delete", "remove");
	public List<String> cmdIslandSetAliases = MUtil.list("set");
	public List<String> cmdIslandStatsAliases = MUtil.list("stat", "stats", "info");
	public List<String> cmdIslandTopAliases = MUtil.list("top");
	public List<String> cmdIslandKillAliases = MUtil.list("kill", "killall");
	public List<String> cmdLootbagAliases = MUtil.list("lootbag");

	///////////////////////////////////////////
	// Mob Creation
	///////////////////////////////////////////
	public Set<Level> mobcreation = MUtil.set(new Level(1,
			new Mob("Basic-Zombie-1", "&7Basic Zombie &8[&eLVL 1&8] &c{health} ❤", 150.0), EntityType.ZOMBIE, 100,
			100.0, true, 5000.0, 1,
			new RankUp(MUtil.list("bc &6&lPalm &8❙ &6{player} &7has ranked up to tier &6&l{level}&7!"), true, 5, 30, 5,
					"&6&lIsland", "&7You have ranked up to level &6&l{level}&7!", true, "VILLAGER_YES", 1F, 1F),
			MUtil.list(new MobSkills(2.0D, "ShockWave", 5, 2.0D, 4), new MobSkills(2.0D, "Bleed", 5, 2.0D, 4),
					new MobSkills(2.0D, "Gaderian", 5, 2.0D, 4), new MobSkills(2.0D, "Disorient", 5, 2.0D, 4)),
			5.0));

	public List<String> whitelistedWorlds = MUtil.list("islands");

	public String spawnerHologramDisplayName = "&6&lIsland Spawner";

	public int spawnerDelaySeconds = 5;
	public boolean autoDespawnMob = true;
	public long autoDespawnTimer = 1200;

	public boolean chancesEnabled = true;

	public boolean overloadMobLimiter = true;
	public int overloardMobLimiterSize = 100;

	public List<String> pvpWorldsDoubleXPFor = MUtil.list("islandspvp");
	public int pvpWorldXPBoost = 2;
	
	public double baseChancePrize = 33.3;
	
	///////////////////////////////////////////
	// Mob Rewards
	///////////////////////////////////////////
	public Set<MobRewardSettings> mobrewards = MUtil.set(
			new MobRewardSettings(MUtil.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), MUtil.list(new MobReward(0.5, "$15,000", MUtil.list("eco give {player} 15000")),
					new MobReward(0.5, "$5,000", MUtil.list("eco give {player} 5000")),
					new MobReward(0.5, "Common Pouches (4x)", MUtil.list("givepouch Common {player} 4")),
					new MobReward(0.5, "Unique Pouches (1x)", MUtil.list("givepouch Unique {player} 1")),
					new MobReward(0.5, "Rare Pouches (1x)", MUtil.list("givepouch Rare {player} 1")),
					new MobReward(0.5, "Mythic Pouches (1x)", MUtil.list("givepouch Mythic {player} 1")),
					new MobReward(0.5, "Legendary Pouches (1x)", MUtil.list("givepouch Legendary {player} 1")),
					new MobReward(0.5, "Soul Pouches (1x)", MUtil.list("givepouch Soul {player} 1")),
					new MobReward(0.5, "Solar Pouches (1x)", MUtil.list("givepouch Solar {player} 1")),
					new MobReward(0.5, "Chunkbuster (2x)", MUtil.list("chunkbuster give {player} 2 1")),
					new MobReward(0.5, "Chunkbuster (4x)", MUtil.list("chunkbuster give {player} 4 1")),
					new MobReward(0.5, "Silver Key", MUtil.list("crate give {player} silver 1")),
					new MobReward(0.5, "Collection Chest (1x)", MUtil.list("collectionchest {player}")),
					new MobReward(0.5, "Bless Perk", MUtil.list("voucher give BlessPerk 1 {player}")),
					new MobReward(0.5, "Gold Key", MUtil.list("crate give {player} gold 1")),
					new MobReward(0.5, "100 EXP", MUtil.list("xp give {player} 100")),
					new MobReward(0.5, "250 EXP", MUtil.list("xp give {player} 250")),
					new MobReward(0.5, "500 EXP", MUtil.list("xp give {player} 500")),
					new MobReward(0.5, "Black Scroll", MUtil.list("givescroll black {player} 1")),
					new MobReward(0.5, "White Scroll", MUtil.list("givescroll white {player} 1")),
					new MobReward(0.5, "Transmog Scroll", MUtil.list("givescroll transmog {player} 1")),
					new MobReward(0.5, "3x3 Tray Pickaxe", MUtil.list("trenches give {player} tray-3x3")),
					new MobReward(0.5, "100 Soul Gem", MUtil.list("givesoul gem {player} 100")),
					new MobReward(0.5, "250 Soul Gem", MUtil.list("givesoul gem {player} 250")),
					new MobReward(0.5, "500 Soul Gem", MUtil.list("givesoul gem {player} 500")),
					new MobReward(0.5, "Common Pet", MUtil.list("pet pet Common {player}")),
					new MobReward(0.5, "Zombie Spawner (1x)", MUtil.list("spawner give {player} zombie")),
					new MobReward(0.5, "Slot Crystal", MUtil.list("giveenchant crystal {player} 1")))),	
			
			new MobRewardSettings(MUtil.list(11, 12, 13, 14, 15, 16, 17, 18, 19, 20), MUtil.list(new MobReward(0.5, "$30,000", MUtil.list("eco give {player} 30000")),
					new MobReward(0.5, "$15,000", MUtil.list("eco give {player} 15000")),
					new MobReward(0.5, "Common Pouches (6x)", MUtil.list("givepouch Common {player} 6")),
					new MobReward(0.5, "Unique Pouches (3x)", MUtil.list("givepouch Unique {player} 3")),
					new MobReward(0.5, "Rare Pouches (2x)", MUtil.list("givepouch Rare {player} 2")),
					new MobReward(0.5, "Mythic Pouches (1x)", MUtil.list("givepouch Mythic {player} 1")),
					new MobReward(0.5, "Legendary Pouches (1x)", MUtil.list("givepouch Legendary {player} 1")),
					new MobReward(0.5, "Soul Pouches (1x)", MUtil.list("givepouch Soul {player} 1")),
					new MobReward(0.5, "Solar Pouches (1x)", MUtil.list("givepouch Solar {player} 1")),
					new MobReward(0.5, "Chunkbuster (2x)", MUtil.list("chunkbuster give {player} 2 1")),
					new MobReward(0.5, "Chunkbuster (4x)", MUtil.list("chunkbuster give {player} 4 1")),
					new MobReward(0.5, "Silver Key", MUtil.list("crate give {player} silver 1")),
					new MobReward(0.5, "Collection Chest (1x)", MUtil.list("collectionchest {player}")),
					new MobReward(0.5, "Bless Perk", MUtil.list("voucher give BlessPerk 1 {player}")),
					new MobReward(0.5, "Gold Key", MUtil.list("crate give {player} gold 1")),
					new MobReward(0.5, "100 EXP", MUtil.list("xp give {player} 100")),
					new MobReward(0.5, "250 EXP", MUtil.list("xp give {player} 250")),
					new MobReward(0.5, "500 EXP", MUtil.list("xp give {player} 500")),
					new MobReward(0.5, "Black Scroll", MUtil.list("givescroll black {player} 1")),
					new MobReward(0.5, "White Scroll", MUtil.list("givescroll white {player} 1")),
					new MobReward(0.5, "Transmog Scroll", MUtil.list("givescroll transmog {player} 1")),
					new MobReward(0.5, "5x5 Tray Pickaxe", MUtil.list("trenches give {player} tray-5x5")),
					new MobReward(0.5, "5x5 Trench Pickaxe", MUtil.list("trenches give {player} trench-5x5")),
					new MobReward(0.5, "500 Soul Gem", MUtil.list("givesoul gem {player} 500")),
					new MobReward(0.5, "750 Soul Gem", MUtil.list("givesoul gem {player} 500")),
					new MobReward(0.5, "1000 Soul Gem", MUtil.list("givesoul gem {player} 1000")),
					new MobReward(0.5, "Common Pet", MUtil.list("pet pet Common {player}")),
					new MobReward(0.5, "Rare Pet", MUtil.list("pet pet Rare {player}")),
					new MobReward(0.5, "Weapon Orb", MUtil.list("orb weapon {player}")),
					new MobReward(0.5, "Zombie Spawner (2x)", MUtil.list("spawner give {player} zombie 2")),
					new MobReward(0.5, "Skeleton Spawner (1x)", MUtil.list("spawner give {player} Skeleton 1")),

					new MobReward(0.5, "Slot Crystal", MUtil.list("giveenchant crystal {player} 1")))),
			
			new MobRewardSettings(MUtil.list(21, 22, 23, 24, 25, 26, 27, 28, 29, 30), MUtil.list(new MobReward(0.5, "$45,000", MUtil.list("eco give {player} 45000")),
					new MobReward(0.5, "$30,000", MUtil.list("eco give {player} 30000")),
					new MobReward(0.5, "Common Pouches (8x)", MUtil.list("givepouch Common {player} 8")),
					new MobReward(0.5, "Unique Pouches (6x)", MUtil.list("givepouch Unique {player} 6")),
					new MobReward(0.5, "Rare Pouches (4x)", MUtil.list("givepouch Rare {player} 4")),
					new MobReward(0.5, "Mythic Pouches (2x)", MUtil.list("givepouch Mythic {player} 2")),
					new MobReward(0.5, "Legendary Pouches (1x)", MUtil.list("givepouch Legendary {player} 1")),
					new MobReward(0.5, "Soul Pouches (1x)", MUtil.list("givepouch Soul {player} 1")),
					new MobReward(0.5, "Solar Pouches (1x)", MUtil.list("givepouch Solar {player} 1")),
					new MobReward(0.5, "Chunkbuster (2x)", MUtil.list("chunkbuster give {player} 4 1")),
					new MobReward(0.5, "Gold Key", MUtil.list("crate give {player} gold 1")),
					new MobReward(0.5, "Collection Chest (1x)", MUtil.list("collectionchest {player}")),
					new MobReward(0.5, "Bless Perk", MUtil.list("voucher give BlessPerk 1 {player}")),
					new MobReward(0.5, "Jewel Key", MUtil.list("crate give {player} jewel 1")),
					new MobReward(0.5, "100 EXP", MUtil.list("xp give {player} 100")),
					new MobReward(0.5, "250 EXP", MUtil.list("xp give {player} 250")),
					new MobReward(0.5, "500 EXP", MUtil.list("xp give {player} 500")),
					new MobReward(0.5, "Black Scroll (2x)", MUtil.list("givescroll black {player} 2")),
					new MobReward(0.5, "White Scroll (2x)", MUtil.list("givescroll white {player} 2")),
					new MobReward(0.5, "Transmog Scroll", MUtil.list("givescroll transmog {player} 1")),
					new MobReward(0.5, "7x7 Tray Pickaxe", MUtil.list("trenches give {player} tray-7x7")),
					new MobReward(0.5, "7x7 Trench Pickaxe", MUtil.list("trenches give {player} trench-7x7")),
					new MobReward(0.5, "1500 Soul Gem", MUtil.list("givesoul gem {player} 1500")),
					new MobReward(0.5, "1750 Soul Gem", MUtil.list("givesoul gem {player} 1500")),
					new MobReward(0.5, "2000 Soul Gem", MUtil.list("givesoul gem {player} 2000")),
					new MobReward(0.5, "Common Pet", MUtil.list("pet pet Common {player}")),
					new MobReward(0.5, "Rare Pet", MUtil.list("pet pet Rare {player}")),
					new MobReward(0.5, "Weapon Orb", MUtil.list("orb weapon {player}")),
					new MobReward(0.5, "Armor Orb", MUtil.list("orb armor {player}")),
					new MobReward(0.5, "Zombie Spawner (2x)", MUtil.list("spawner give {player} zombie 2")),
					new MobReward(0.5, "Skeleton Spawner (2x)", MUtil.list("spawner give {player} Skeleton 2")),
					new MobReward(0.5, "Wolf Spawner (1x)", MUtil.list("spawner give {player} Wolf 1")),
					new MobReward(0.5, "Random Mask", MUtil.list("mask random {player}")),
					new MobReward(0.5, "Slot Crystal", MUtil.list("giveenchant crystal {player} 1")))),
			
			new MobRewardSettings(MUtil.list(31, 32, 33, 34, 35, 36, 37, 38, 39, 40), MUtil.list(new MobReward(0.5, "$50,000", MUtil.list("eco give {player} 50000")),
					new MobReward(0.5, "$35,000", MUtil.list("eco give {player} 35000")),
					new MobReward(0.5, "Common Pouches (8x)", MUtil.list("givepouch Common {player} 8")),
					new MobReward(0.5, "Unique Pouches (6x)", MUtil.list("givepouch Unique {player} 6")),
					new MobReward(0.5, "Rare Pouches (4x)", MUtil.list("givepouch Rare {player} 4")),
					new MobReward(0.5, "Mythic Pouches (2x)", MUtil.list("givepouch Mythic {player} 2")),
					new MobReward(0.5, "Legendary Pouches (2x)", MUtil.list("givepouch Legendary {player} 2")),
					new MobReward(0.5, "Soul Pouches (2x)", MUtil.list("givepouch Soul {player} 1")),
					new MobReward(0.5, "Solar Pouches (1x)", MUtil.list("givepouch Solar {player} 1")),
					new MobReward(0.5, "Chunkbuster (2x)", MUtil.list("chunkbuster give {player} 4 1")),
					new MobReward(0.5, "Gold Key", MUtil.list("crate give {player} gold 1")),
					new MobReward(0.5, "Collection Chest (1x)", MUtil.list("collectionchest {player}")),
					new MobReward(0.5, "Bless Perk", MUtil.list("voucher give BlessPerk 1 {player}")),
					new MobReward(0.5, "Jewel Key", MUtil.list("crate give {player} jewel 1")),
					new MobReward(0.5, "500 EXP", MUtil.list("xp give {player} 500")),
					new MobReward(0.5, "750 EXP", MUtil.list("xp give {player} 750")),
					new MobReward(0.5, "1000 EXP", MUtil.list("xp give {player} 1000")),
					new MobReward(0.5, "Black Scroll (4x)", MUtil.list("givescroll black {player} 4")),
					new MobReward(0.5, "White Scroll (4x)", MUtil.list("givescroll white {player} 4")),
					new MobReward(0.5, "Transmog Scroll", MUtil.list("givescroll transmog {player} 1")),
					new MobReward(0.5, "9x9 Tray Pickaxe", MUtil.list("trenches give {player} tray-9x9")),
					new MobReward(0.5, "9x9 Trench Pickaxe", MUtil.list("trenches give {player} trench-9x9")),
					new MobReward(0.5, "1500 Soul Gem", MUtil.list("givesoul gem {player} 1500")),
					new MobReward(0.5, "1750 Soul Gem", MUtil.list("givesoul gem {player} 1500")),
					new MobReward(0.5, "2000 Soul Gem", MUtil.list("givesoul gem {player} 2000")),
					new MobReward(0.5, "Common Pet", MUtil.list("pet pet Common {player}")),
					new MobReward(0.5, "Rare Pet", MUtil.list("pet pet Rare {player}")),
					new MobReward(0.5, "Epic Pet", MUtil.list("pet pet Epic {player}")),
					new MobReward(0.5, "Weapon Orb", MUtil.list("orb weapon {player}")),
					new MobReward(0.5, "Zombie Spawner (2x)", MUtil.list("spawner give {player} zombie 2")),
					new MobReward(0.5, "Skeleton Spawner (2x)", MUtil.list("spawner give {player} Skeleton 2")),
					new MobReward(0.5, "Wolf Spawner (2x)", MUtil.list("spawner give {player} Wolf 2")),
					new MobReward(0.5, "Spider Spawner (1x)", MUtil.list("spawner give {player} Spider 1")),
					new MobReward(0.5, "Armor Orb", MUtil.list("orb armor {player}")),
					new MobReward(0.5, "Creeper Egg (4x)", MUtil.list("give {player} creeperegg 4")),
					new MobReward(0.5, "Random Mask", MUtil.list("mask random {player}")),
					new MobReward(0.5, "Blaze Spawner (1x)", MUtil.list("spawner give {player} blaze 1")),
					new MobReward(0.5, "Slot Crystal", MUtil.list("giveenchant crystal {player} 1")))),
			 
			new MobRewardSettings(MUtil.list(41, 42, 43, 44, 45, 46, 47, 48, 49, 50), MUtil.list(new MobReward(0.5, "$75,000", MUtil.list("eco give {player} 75000")),
					new MobReward(0.5, "$50,000", MUtil.list("eco give {player} 50000")),
					new MobReward(0.5, "Common Pouches (8x)", MUtil.list("givepouch Common {player} 8")),
					new MobReward(0.5, "Unique Pouches (6x)", MUtil.list("givepouch Unique {player} 6")),
					new MobReward(0.5, "Rare Pouches (4x)", MUtil.list("givepouch Rare {player} 4")),
					new MobReward(0.5, "Mythic Pouches (2x)", MUtil.list("givepouch Mythic {player} 2")),
					new MobReward(0.5, "Legendary Pouches (2x)", MUtil.list("givepouch Legendary {player} 2")),
					new MobReward(0.5, "Soul Pouches (1x)", MUtil.list("givepouch Soul {player} 1")),
					new MobReward(0.5, "Solar Pouches (1x)", MUtil.list("givepouch Solar {player} 1")),
					new MobReward(0.5, "Chunkbuster (2x)", MUtil.list("chunkbuster give {player} 4 1")),
					new MobReward(0.5, "Gold Key", MUtil.list("crate give {player} gold 1")),
					new MobReward(0.5, "Collection Chest (1x)", MUtil.list("collectionchest {player}")),
					new MobReward(0.5, "Bless Perk", MUtil.list("voucher give BlessPerk 1 {player}")),
					new MobReward(0.5, "Jewel Key", MUtil.list("crate give {player} jewel 1")),
					new MobReward(0.5, "500 EXP", MUtil.list("xp give {player} 500")),
					new MobReward(0.5, "750 EXP", MUtil.list("xp give {player} 750")),
					new MobReward(0.5, "1000 EXP", MUtil.list("xp give {player} 1000")),
					new MobReward(0.5, "Black Scroll (6x)", MUtil.list("givescroll black {player} 6")),
					new MobReward(0.5, "White Scroll (4x)", MUtil.list("givescroll white {player} 4")),
					new MobReward(0.5, "Zombie Spawner (2x)", MUtil.list("spawner give {player} zombie 2")),
					new MobReward(0.5, "Skeleton Spawner (2x)", MUtil.list("spawner give {player} Skeleton 2")),
					new MobReward(0.5, "Wolf Spawner (2x)", MUtil.list("spawner give {player} Wolf 2")),
					new MobReward(0.5, "Spider Spawner (2x)", MUtil.list("spawner give {player} Spider 2")),
					new MobReward(0.5, "Cave Spider Spawner (1x)", MUtil.list("spawner give {player} caveSpider 1")),
					new MobReward(0.5, "Transmog Scroll", MUtil.list("givescroll transmog {player} 1")),
					new MobReward(0.5, "9x9 Tray Pickaxe", MUtil.list("trenches give {player} tray-9x9")),
					new MobReward(0.5, "9x9 Trench Pickaxe", MUtil.list("trenches give {player} trench-9x9")),
					new MobReward(0.5, "1500 Soul Gem", MUtil.list("givesoul gem {player} 1500")),
					new MobReward(0.5, "1750 Soul Gem", MUtil.list("givesoul gem {player} 1750")),
					new MobReward(0.5, "3000 Soul Gem", MUtil.list("givesoul gem {player} 3000")),
					new MobReward(0.5, "Rare Pet", MUtil.list("pet pet Rare {player}")),
					new MobReward(0.5, "Epic Pet", MUtil.list("pet pet Epic {player}")),
					new MobReward(0.5, "Legendary Pet", MUtil.list("pet pet Legendary {player}")),
					new MobReward(0.5, "Weapon Orb", MUtil.list("orb weapon {player}")),
					new MobReward(0.5, "Armor Orb", MUtil.list("orb armor {player}")),
					new MobReward(0.5, "Creeper Egg (8x)", MUtil.list("give {player} creeperegg 8")),
					new MobReward(0.5, "Random Mask", MUtil.list("mask random {player}")),
					new MobReward(0.5, "Blaze Spawner (2x)", MUtil.list("spawner give {player} blaze 2")),
					new MobReward(0.5, "Random Ability Item (1x)", MUtil.list("abilityitem random {player} 1")),
					new MobReward(0.5, "Slot Crystal", MUtil.list("giveenchant crystal {player} 1")))),
			
			new MobRewardSettings(MUtil.list(51, 52, 53, 54, 55, 56, 57, 58, 59, 60), MUtil.list(new MobReward(0.5, "$75,000", MUtil.list("eco give {player} 75000")),
					new MobReward(0.5, "$50,000", MUtil.list("eco give {player} 50000")),
					new MobReward(0.5, "Common Pouches (8x)", MUtil.list("givepouch Common {player} 8")),
					new MobReward(0.5, "Unique Pouches (6x)", MUtil.list("givepouch Unique {player} 6")),
					new MobReward(0.5, "Rare Pouches (4x)", MUtil.list("givepouch Rare {player} 4")),
					new MobReward(0.5, "Mythic Pouches (2x)", MUtil.list("givepouch Mythic {player} 2")),
					new MobReward(0.5, "Legendary Pouches (2x)", MUtil.list("givepouch Legendary {player} 2")),
					new MobReward(0.5, "Soul Pouches (2x)", MUtil.list("givepouch Soul {player} 2")),
					new MobReward(0.5, "Solar Pouches (2x)", MUtil.list("givepouch Solar {player} 2")),
					new MobReward(0.5, "Chunkbuster (2x)", MUtil.list("chunkbuster give {player} 4 1")),
					new MobReward(0.5, "Gold Key", MUtil.list("crate give {player} gold 1")),
					new MobReward(0.5, "Collection Chest (1x)", MUtil.list("collectionchest {player}")),
					new MobReward(0.5, "Bless Perk", MUtil.list("voucher give BlessPerk 1 {player}")),
					new MobReward(0.5, "Jewel Key", MUtil.list("crate give {player} jewel 1")),
					new MobReward(0.5, "Black Scroll (8x)", MUtil.list("givescroll black {player} 6")),
					new MobReward(0.5, "White Scroll (6x)", MUtil.list("givescroll white {player} 6")),
					new MobReward(0.5, "Transmog Scroll", MUtil.list("givescroll transmog {player} 1")),
					new MobReward(0.5, "9x9 Tray Pickaxe", MUtil.list("trenches give {player} tray-9x9")),
					new MobReward(0.5, "9x9 Trench Pickaxe", MUtil.list("trenches give {player} trench-11x11")),
					new MobReward(0.5, "1500 Soul Gem", MUtil.list("givesoul gem {player} 1500")),
					new MobReward(0.5, "2000 Soul Gem", MUtil.list("givesoul gem {player} 2000")),
					new MobReward(0.5, "Zombie Spawner (2x)", MUtil.list("spawner give {player} zombie 2")),
					new MobReward(0.5, "Skeleton Spawner (2x)", MUtil.list("spawner give {player} Skeleton 2")),
					new MobReward(0.5, "Wolf Spawner (2x)", MUtil.list("spawner give {player} Wolf 2")),
					new MobReward(0.5, "Spider Spawner (2x)", MUtil.list("spawner give {player} Spider 2")),
					new MobReward(0.5, "Cave Spider Spawner (2x)", MUtil.list("spawner give {player} caveSpider 2")),
					new MobReward(0.5, "Pigman Spawner (1x)", MUtil.list("spawner give {player} pigman 1")),
					new MobReward(0.5, "5000 Soul Gem", MUtil.list("givesoul gem {player} 5000")),
					new MobReward(0.5, "Epic Pet", MUtil.list("pet pet Epic {player}")),
					new MobReward(0.5, "Legendary Pet", MUtil.list("pet pet Legendary {player}")),
					new MobReward(0.5, "Weapon Orb", MUtil.list("orb weapon {player}")),
					new MobReward(0.5, "Armor Orb", MUtil.list("orb armor {player}")),
					new MobReward(0.5, "Creeper Egg (16x)", MUtil.list("give {player} creeperegg 16")),
					new MobReward(0.5, "Random Mask", MUtil.list("mask random {player}")),
					new MobReward(0.5, "Blaze Spawner (4x)", MUtil.list("spawner give {player} blaze 4")),
					new MobReward(0.5, "Creeper Spawner (1x)", MUtil.list("spawner give {player} Creeper 1")),
					new MobReward(0.5, "Random Ability Item (2x)", MUtil.list("abilityitem random {player} 2")),
					new MobReward(0.5, "Slot Crystal", MUtil.list("giveenchant crystal {player} 1")))),
			
			new MobRewardSettings(MUtil.list(61, 62, 63, 64, 65, 66, 67, 68, 69, 70), MUtil.list(new MobReward(0.5, "$75,000", MUtil.list("eco give {player} 75000")),
					new MobReward(0.5, "$50,000", MUtil.list("eco give {player} 50000")),
					new MobReward(0.5, "Common Pouches (8x)", MUtil.list("givepouch Common {player} 8")),
					new MobReward(0.5, "Unique Pouches (6x)", MUtil.list("givepouch Unique {player} 6")),
					new MobReward(0.5, "Rare Pouches (4x)", MUtil.list("givepouch Rare {player} 4")),
					new MobReward(0.5, "Mythic Pouches (2x)", MUtil.list("givepouch Mythic {player} 2")),
					new MobReward(0.5, "Legendary Pouches (2x)", MUtil.list("givepouch Legendary {player} 2")),
					new MobReward(0.5, "Soul Pouches (2x)", MUtil.list("givepouch Soul {player} 2")),
					new MobReward(0.5, "Solar Pouches (2x)", MUtil.list("givepouch Solar {player} 2")),
					new MobReward(0.5, "Chunkbuster (2x)", MUtil.list("chunkbuster give {player} 4 1")),
					new MobReward(0.5, "Gold Key", MUtil.list("crate give {player} gold 1")),
					new MobReward(0.5, "Collection Chest (1x)", MUtil.list("collectionchest {player}")),
					new MobReward(0.5, "Bless Perk", MUtil.list("voucher give BlessPerk 1 {player}")),
					new MobReward(0.5, "Jewel Key", MUtil.list("crate give {player} jewel 1")),
					new MobReward(0.5, "Black Scroll (8x)", MUtil.list("givescroll black {player} 8")),
					new MobReward(0.5, "White Scroll (6x)", MUtil.list("givescroll white {player} 6")),
					new MobReward(0.5, "Transmog Scroll", MUtil.list("givescroll transmog {player} 1")),
					new MobReward(0.5, "9x9 Tray Pickaxe", MUtil.list("trenches give {player} tray-11x11")),
					new MobReward(0.5, "9x9 Trench Pickaxe", MUtil.list("trenches give {player} trench-11x11")),
					new MobReward(0.5, "2000 Soul Gem", MUtil.list("givesoul gem {player} 2000")),
					new MobReward(0.5, "5000 Soul Gem", MUtil.list("givesoul gem {player} 5000")),
					new MobReward(0.5, "Epic Pet", MUtil.list("pet pet Epic {player}")),
					new MobReward(0.5, "Legendary Pet", MUtil.list("pet pet Legendary {player}")),
					new MobReward(0.5, "Weapon Orb", MUtil.list("orb weapon {player}")),
					new MobReward(0.5, "Armor Orb", MUtil.list("orb armor {player}")),
					new MobReward(0.5, "Depth Strider Shard", MUtil.list("giveshard depth {player}")),
					new MobReward(0.5, "Creeper Egg (16x)", MUtil.list("give {player} creeperegg 16")),
					new MobReward(0.5, "Zombie Spawner (2x)", MUtil.list("spawner give {player} zombie 2")),
					new MobReward(0.5, "Skeleton Spawner (2x)", MUtil.list("spawner give {player} Skeleton 2")),
					new MobReward(0.5, "Wolf Spawner (2x)", MUtil.list("spawner give {player} Wolf 2")),
					new MobReward(0.5, "Spider Spawner (2x)", MUtil.list("spawner give {player} Spider 2")),
					new MobReward(0.5, "Cave Spider Spawner (2x)", MUtil.list("spawner give {player} caveSpider 2")),
					new MobReward(0.5, "Pigman Spawner (2x)", MUtil.list("spawner give {player} pigman 2")),
					new MobReward(0.5, "Witch Spawner (1x)", MUtil.list("spawner give {player} Witch 1")),
					new MobReward(0.5, "Random Mask", MUtil.list("mask random {player}")),
					new MobReward(0.5, "Blaze Spawner (6x)", MUtil.list("spawner give {player} blaze 6")),
					new MobReward(0.5, "Creeper Spawner (2x)", MUtil.list("spawner give {player} Creeper 2")),
					new MobReward(0.5, "Random Ability Item (4x)", MUtil.list("abilityitem random {player} 4")),
					new MobReward(0.5, "Slot Crystal", MUtil.list("giveenchant crystal {player} 1")))),
			
			new MobRewardSettings(MUtil.list(71, 72, 73, 74, 75, 76, 77, 78, 79, 80), MUtil.list(new MobReward(0.5, "$75,000", MUtil.list("eco give {player} 75000")),
					new MobReward(0.5, "$50,000", MUtil.list("eco give {player} 50000")),
					new MobReward(0.5, "Common Pouches (8x)", MUtil.list("givepouch Common {player} 8")),
					new MobReward(0.5, "Unique Pouches (6x)", MUtil.list("givepouch Unique {player} 6")),
					new MobReward(0.5, "Rare Pouches (4x)", MUtil.list("givepouch Rare {player} 4")),
					new MobReward(0.5, "Mythic Pouches (2x)", MUtil.list("givepouch Mythic {player} 2")),
					new MobReward(0.5, "Legendary Pouches (2x)", MUtil.list("givepouch Legendary {player} 2")),
					new MobReward(0.5, "Soul Pouches (2x)", MUtil.list("givepouch Soul {player} 2")),
					new MobReward(0.5, "Solar Pouches (2x)", MUtil.list("givepouch Solar {player} 2")),
					new MobReward(0.5, "Chunkbuster (2x)", MUtil.list("chunkbuster give {player} 4 1")),
					new MobReward(0.5, "Gold Key", MUtil.list("crate give {player} gold 1")),
					new MobReward(0.5, "Collection Chest (1x)", MUtil.list("collectionchest {player}")),
					new MobReward(0.5, "Bless Perk", MUtil.list("voucher give BlessPerk 1 {player}")),
					new MobReward(0.5, "Jewel Key", MUtil.list("crate give {player} jewel 1")),
					new MobReward(0.5, "Black Scroll (8x)", MUtil.list("givescroll black {player} 8")),
					new MobReward(0.5, "White Scroll (8x)", MUtil.list("givescroll white {player} 8")),
					new MobReward(0.5, "Transmog Scroll", MUtil.list("givescroll transmog {player} 1")),
					new MobReward(0.5, "9x9 Tray Pickaxe", MUtil.list("trenches give {player} tray-11x11")),
					new MobReward(0.5, "9x9 Trench Pickaxe", MUtil.list("trenches give {player} trench-11x11")),
					new MobReward(0.5, "2000 Soul Gem", MUtil.list("givesoul gem {player} 2000")),
					new MobReward(0.5, "5000 Soul Gem", MUtil.list("givesoul gem {player} 5000")),
					new MobReward(0.5, "Epic Pet", MUtil.list("pet pet Epic {player}")),
					new MobReward(0.5, "Legendary Pet", MUtil.list("pet pet Legendary {player}")),
					new MobReward(0.5, "Weapon Orb", MUtil.list("orb weapon {player}")),
					new MobReward(0.5, "Armor Orb", MUtil.list("orb armor {player}")),
					new MobReward(0.5, "Depth Strider Shard", MUtil.list("giveshard depth {player}")),
					new MobReward(0.5, "Creeper Egg (32x)", MUtil.list("give {player} creeperegg 32")),
					new MobReward(0.5, "Random Mask", MUtil.list("mask random {player}")),
					new MobReward(0.5, "Blaze Spawner (8x)", MUtil.list("spawner give {player} blaze 8")),
					new MobReward(0.5, "Creeper Spawner (4x)", MUtil.list("spawner give {player} Creeper 8")),
					new MobReward(0.5, "Ghast Spawner (1x)", MUtil.list("spawner give {player} Ghast 1")),
					new MobReward(0.5, "Zombie Spawner (2x)", MUtil.list("spawner give {player} zombie 2")),
					new MobReward(0.5, "Skeleton Spawner (2x)", MUtil.list("spawner give {player} Skeleton 2")),
					new MobReward(0.5, "Wolf Spawner (2x)", MUtil.list("spawner give {player} Wolf 2")),
					new MobReward(0.5, "Spider Spawner (2x)", MUtil.list("spawner give {player} Spider 2")),
					new MobReward(0.5, "Cave Spider Spawner (2x)", MUtil.list("spawner give {player} caveSpider 2")),
					new MobReward(0.5, "Pigman Spawner (2x)", MUtil.list("spawner give {player} pigman 2")),
					new MobReward(0.5, "Witch Spawner (2x)", MUtil.list("spawner give {player} Witch 2")),
					new MobReward(0.5, "Blaze Spawner (1x)", MUtil.list("spawner give {player} Blaze 1")),
					new MobReward(0.5, "Random Ability Item (6x)", MUtil.list("abilityitem random {player} 6")),
					new MobReward(0.5, "Slot Crystal", MUtil.list("giveenchant crystal {player} 1"))))
			
			
			);
	
	
	public LootbagInventory lootbagLayout = new LootbagInventory(
			new GuiDesign("&8Island Loot",
					MUtil.map('#', new ItemStackWrapper(Material.STAINED_GLASS_PANE, 1, (short) 7, "&r"), '-',
							new ItemStackWrapper(Material.AIR)),
					MUtil.list("#########", "#-------#", "#-------#", "#-------#", "#-------#", "#########")),
			MUtil.list(new Clickable(60, new ItemStackWrapper(Material.BARRIER, 1, (short) 0, "&c&lExit",
					MUtil.list("&7Close the lootbag GUI")), "EXIT")));

	///////////////////////////////////////////
	// Message
	///////////////////////////////////////////
	public String msgLowLevel = "&6&lPalm &8❙ &7You are to much of a low level to kill this mob! (Required: &6{level}&7)";
	public String msgPlayerResetStaff = "&6&lPalm &8❙ &7You have resetted &6{player}&7 stats!";
	public String msgPlayerResetPlayer = "&6&lPalm &8❙ &7Your stats have been resetted by &6{player}&7!";
	public String msgNumberLowHigh = "&6&lPalm &8❙ &7This Number is either to low or high please choose number from &61-{higest}&7.";
	public String msgPlayerAlreadyThisLevel = "&6&lPalm &8❙ &6{player}&7 is already level &6{level}&7!";
	public String msgPlayerLevelSetStaff = "&6&lPalm &8❙ &7You have set &6{player}&7 level to &6{level}&7!";
	public String msgPlayerLevelSetPlayer = "&6&lPalm &8❙ &7Your level has been set to &6{level}&7 by&6 {player}&7!";
	public List<String> msgPlayerStats = MUtil.list("&7&m-----------------------------------",
			"&6&l{player}'s Island Stats", " &6❙ &fLevel: &e{level}", " &6❙ &fMob Kills: &e{mob_kills}",
			" &6❙ &fRankup: &e{your_xp} &7/ &e{total_mobs_xp_needed}", " &6❙ &fCurrent Mob: &e{current_mob}",
			"&7&m-----------------------------------");
	public String msgPlayerRemovedMobs = "&6&lPalm &8❙ &7You have killed all Island mobs!";

	public int rewardMoneyEveryXSeconds = 10;
	public int radiusSpawner = 5;
	public boolean mobSkillsEnabled = true;

	public boolean halfPlayerDamageToIslandMobs = true;

	///////////////////////////////////////////
	// Skills
	///////////////////////////////////////////
	public Material cage_wall = Material.STAINED_GLASS;
	public int witherLength = 4;
	public int witherLevel = 3;
	public int posionLength = 4;
	public int posionLevel = 3;
	public String GaderianName = "&e&lGaderian Warriors";
	public int GaderianHealth = 20;
	public int GaderianAmount = 4;
	public int CalltoActionPerLevelAmount = 2;
	public List<EntityType> CalltoActionMobType = MUtil.list(EntityType.BLAZE, EntityType.SPIDER);
	public boolean Bleed = true;
	public double Bleed_DamageMobs = 2.0;
	public double Bleed_DamagePlayer = 1.0;
	public String Bleeding_Stopped = "&7The bleeding has &cStopped&7.";
	public String Bleeding_Started = "&7You are bleeding...";
	public int DisorientConfusionLevel = 1;
	public int DisorientBlindnessLevel = 1;
	public double damageSelfdestructWithin3Blocks = 20;
	public double damageSelfdestructWithin6Blocks = 10;
	public String msgKilledBySelfDestruct = "&cYou were killed by self destruction!";
	public String msgTookDamageBySelfDestruct = "&cYou took damage due to Self destruction!";
	public String msgRejuvenateAbilityHappened = "&aThe Rejuvenate Ability happened... healing mob..";
	public String msgDisarmed = "&c&l&n(!)&r &7YOU HAVE BEEN DISARMED! CHECK THE GROUND AROUND YOU FOR YOUR ITEM!";
	public String msgBlockedHit = "&cThe boss has blocked your attack!";

	///////////////////////////////////////////////////
	// Inventory Creating
	///////////////////////////////////////////////////
	public String mainMenuName = "MAIN";

	public Set<Inventory> inventory = MUtil.set(new Inventory("MAIN",
			new GuiDesign("&8Islands",
					MUtil.map('#', new ItemStackWrapper(Material.STAINED_GLASS_PANE, 1, (short) 7, "&r"), '-',
							new ItemStackWrapper(Material.AIR),

							'!',
							new ItemStackWrapper(Material.BOOK, 1, (short) 0, "&6&lPalmPvP Island",
									MUtil.list("&7", "&7View different features of the server!"))),
					MUtil.list("####!####", "#-------#", "#########")),
			MUtil.list(new Clickable(11, geHeadItem("&9&lBasic Island"),
					"eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvMTNlYzMyNzA4YThhYTFjN2Y3YTBmODAxMjZhMWMwNGI4ZDg1YWQ1ZTAzZDVjYjgxZjBjOTc3OTViNDk4NGUifX19",
					"armorsets"))));

	private ItemStackWrapper geHeadItem(String Displayname) {
		ItemStackWrapper itemStackWrapper = new ItemStackWrapper(Material.SKULL_ITEM, 1, (short) 3);
		MetaWrapper metaWrapper = new MetaWrapper();

		metaWrapper.setDisplayName(Txt.parse(Displayname));

		itemStackWrapper.setMeta(metaWrapper);

		return itemStackWrapper;
	}

	///////////////////////////////////////////
	// Auto Clear
	///////////////////////////////////////////
	public boolean doFinalBroadCastOnRemoval = true;
	public int clearStackIntervalSeconds = 20;
	public List<Integer> stacksMobWillClearInBroadcastTimesSeconds = MUtil.list(5, 30, 60);
	public String stackedMobsWillClearIn = "&6&lPalm &8❙ &7Island mobs will clear in &e%time%&7!";
	public String stackedMobsCleared = "&6&lPalm &8❙ &7All Island mobs have been cleared!";
	///////////////////////////////////////////
	// Inventory Messages
	///////////////////////////////////////////
	public String ProgressBarCompleteColor = "&a";
	public String ProgressBarNotCompleteColor = "&c";
	public String ProgressBarFormat = "&7[{bars}&7]";
	public String ProgressBarSymbol = "|";
	public int ProgressBarAmountOfBarsToDisplay = 5;

	public String msgGuiNameNotSet = "&6&lPalm &8❙ &7The gui name is not setup for that gui.";
	public String msgGuiFormatNotSet = "&6&lPalm &8❙ &7The gui format is not setup for that gui.";
	public String msgGuiRowLengthNotSame = "&6&lPalm &8❙ &7The gui is not setup correctly. Row lengths do not match.";
	public String msgGuiTooManyRows = "&6&lPalm &8❙ &7There is too many rows configured for this gui type.";
	public String msgGuiDesignNotSet = "&6&lPalm &8❙ &7The gui design is not set! Please contact the developer.";
	public String msgGuiLeaveWindowToEdit = "&6&lPalm &8❙ &7You cannot do that while you're within a gui window.";
	public String failedGuiDisplay = "&6&lPalm &8❙ &7ERROR 404";
	public long guiClickThrottleDelayMs = 200L;

	///////////////////////////////////////////
	public static MConf get() {
		return i;
	}

	public MConf load(MConf that) {
		super.load(that);
		return this;
	}

}
