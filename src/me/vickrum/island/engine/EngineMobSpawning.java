package me.vickrum.island.engine;

import java.text.NumberFormat;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.EntityDeathEvent;

import com.gmail.filoghost.holographicdisplays.api.Hologram;
import com.massivecraft.massivecore.Engine;
import com.massivecraft.massivecore.util.Txt;

import io.netty.util.internal.ThreadLocalRandom;
import me.vickrum.island.Main;
import me.vickrum.island.entity.MConf;
import me.vickrum.island.entity.MPlayer;
import me.vickrum.island.entity.SpawnerDataConf;
import me.vickrum.island.entity.object.Level;
import me.vickrum.island.entity.object.MobReward;
import me.vickrum.island.entity.object.MobRewardSettings;
import me.vickrum.island.entity.object.MobSkills;
import me.vickrum.island.entity.object.SpawnerData;
import me.vickrum.island.event.PlayerKilledCustomMob;
import me.vickrum.island.event.SpawnerNeedSpawning;
import me.vickrum.island.extra.LocationUtil;
import me.vickrum.island.extra.MobUtil;
import me.vickrum.island.extra.TitleAPI;
import me.vickrum.island.skills.*;
import me.vickrum.island.task.TaskHologram;
import me.vickrum.island.task.TaskSell;

public class EngineMobSpawning extends Engine {

	private static EngineMobSpawning i = new EngineMobSpawning();

	public static EngineMobSpawning get() {
		return i;
	}

	public double getRandomInteger(double lower, double upper) {
		return ThreadLocalRandom.current().nextDouble(lower, upper);
	}

	private ThreadLocalRandom random = ThreadLocalRandom.current();

	@EventHandler
	public void onBow(EntityDamageByEntityEvent e) {
		if (!MConf.get().whitelistedWorlds.contains(e.getEntity().getLocation().getWorld().getName().toLowerCase()))
			return;

		if (!(e.getDamager() instanceof Arrow))
			return;

		Arrow a = (Arrow) e.getDamager();

		if (a.getShooter() instanceof Player)
			return;

		Entity lol = (Entity) a.getShooter();

		if (lol == null)
			return;

		if (!lol.hasMetadata("island"))
			return;

		Level spawnerEntity = Main.get().getKeyByMobId(lol.getMetadata("island").get(0).asString());

		if (spawnerEntity == null)
			return;

		e.setDamage(spawnerEntity.getMobDamage());

		return;
	}

	@EventHandler
	public void onMobDamage(EntityDamageByEntityEvent e) {
		if (!MConf.get().whitelistedWorlds.contains(e.getEntity().getLocation().getWorld().getName().toLowerCase()))
			return;

		if (e.getDamager() instanceof Player)
			return;

		if (!e.getDamager().hasMetadata("island"))
			return;

		Level spawnerEntity = Main.get().getKeyByMobId(e.getDamager().getMetadata("island").get(0).asString());

		if (spawnerEntity == null)
			return;

		e.setDamage(spawnerEntity.getMobDamage());

		return;
	}

	@EventHandler
	public void skills(EntityDamageByEntityEvent e) {
		if (!MConf.get().whitelistedWorlds.contains(e.getEntity().getLocation().getWorld().getName().toLowerCase()))
			return;

		if (!e.getEntity().hasMetadata("island"))
			return;

		Entity damager = e.getDamager();
		if (!(damager instanceof Player))
			return;

		Level spawnerEntity = Main.get().getKeyByMobId(e.getEntity().getMetadata("island").get(0).asString());

		if (spawnerEntity == null)
			return;

		if (MConf.get().halfPlayerDamageToIslandMobs) {
			double newdamage = e.getDamage() % 2;
			e.setDamage(newdamage);
		}

		if (spawnerEntity.getMobSkills().size() == 0)
			return;

		if (!MConf.get().mobSkillsEnabled)
			return;

		for (MobSkills skills : spawnerEntity.getMobSkills()) {
			if (this.random.nextInt(100) > skills.getChance())
				continue;
			if (skills.getSkillName().equalsIgnoreCase("SelfDestruct")) {
				SelfDestructAbility.selfdestructability((Player) e.getDamager(), e.getEntity());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Rejuvenate")) {
				RejuvenateAbility.rejuvenateability((Player) e.getDamager(), e.getEntity(), skills.getSkillRadius());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Poison")) {
				PoisonAbility.poisonAbility((Player) e.getDamager());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Bleed")) {
				BleedAbility.bleedability((Player) damager, e.getEntity(), skills.getSkillLevel(),
						skills.getSkillRadius());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Fireball")) {
				FireballAbility.fireballAbility(((Player) damager), skills.getSkillDamage(), skills.getSkillLevel());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Thunder")) {
				ThunderAbility.thunderAbility(((Player) damager), skills.getSkillDamage(), skills.getSkillLevel());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Disarm")) {
				DisArmAbility.disarmability((Player) damager);
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Grapple")) {
				GrappleAbility.grappleability((Player) damager, e.getEntity(), skills.getSkillLevel());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Fire")) {
				FireAbility.fireAbility((Player) damager, skills.getSkillLevel());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("KnockBack")) {
				KnockBackAbility.knockbackability((Player) damager, e.getEntity(), skills.getSkillLevel());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Teleport")) {
				TeleportAbility.teleportability((Player) damager, e.getEntity(), skills.getSkillLevel());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Wrap")) {
				WrapAbility.wrapability((Player) damager, e.getEntity());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Cage")) {
				CageAbility.cageability((Player) damager, damager.getLocation(), skills.getSkillLevel());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("ShockWave")) {
				ShockWaveAbility.shockwaveability((Player) damager, skills.getSkillLevel());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Block")) {
				e.setDamage(0);
				damager.sendMessage(Txt.parse(MConf.get().msgBlockedHit));
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Wither")) {
				WitherAbility.witherability((Player) damager, skills.getSkillLevel());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Gaderian")) {
				GaderianAbility.gaderianability((Player) damager, e.getEntity());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("CalltoAction")) {
				CalltoActionAbility.calltoactionability((Player) damager, e.getEntity(), skills.getSkillLevel());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Blink")) {
				BlinkAbility.blinkability((Player) damager, e.getEntity());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("Disorient")) {
				DisorientAbility.disorientability((Player) damager, e.getEntity(), skills.getSkillLevel(),
						skills.getSkillRadius());
				return;
			}
			if (skills.getSkillName().equalsIgnoreCase("FakeWeb")) {
				FakeWebAbility.fakewebability((Player) damager, e.getEntity(), skills.getSkillLevel(),
						skills.getSkillRadius());
				return;
			}
		}
	}

	@EventHandler(priority = EventPriority.NORMAL, ignoreCancelled = true)
	public void onBlockBreak(BlockBreakEvent event) {
		Block block = event.getBlock();
		if (event.isCancelled())
			return;
		if (!block.getType().equals(Material.MOB_SPAWNER))
			return;
		if (!MConf.get().whitelistedWorlds.contains(event.getPlayer().getWorld().getName().toLowerCase()))
			return;

		if (TaskHologram.get().armourstandDB2.containsKey(block.getLocation().add(0.5, 2, 0.5))) {
			Hologram lol = TaskHologram.get().armourstandDB2.get(block.getLocation().add(0.5, 2, 0.5));
			lol.delete();
		}

		String blockLocStr = LocationUtil.serializeLocation(block.getLocation());
		if (SpawnerDataConf.get().spawners.containsKey(blockLocStr)) {
			SpawnerDataConf.get().spawners.remove(blockLocStr);
			SpawnerDataConf.get().changed();
			return;
		}
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void fOnBlockPlaced(BlockPlaceEvent event) {
		if (event.isCancelled() || event.getBlock() == null)
			return;
		if (!event.getBlock().getType().equals(Material.MOB_SPAWNER))
			return;
		if (!MConf.get().whitelistedWorlds.contains(event.getPlayer().getWorld().getName().toLowerCase()))
			return;
		Block vBlock = event.getBlock();
		if (vBlock == null)
			return;

		String blockLocStr = LocationUtil.serializeLocation(vBlock.getLocation());

		if (SpawnerDataConf.get().spawners.containsKey(blockLocStr)) {
			event.setCancelled(true);
			return;
		}

		CreatureSpawner cs = (CreatureSpawner) event.getBlock().getState();

		SpawnerDataConf.get().spawners.put(blockLocStr,
				new SpawnerData(blockLocStr, cs.getSpawnedType(), System.currentTimeMillis()));
		SpawnerDataConf.get().changed();

		return;
	}

	@EventHandler
	public void SpawnerSpawnEvent(org.bukkit.event.entity.SpawnerSpawnEvent event) {
		if (event.getSpawner() == null || event.getSpawner().getBlock() == null
				|| event.getSpawner().getBlock().getState() == null)
			return;

		if (!MConf.get().whitelistedWorlds.contains(event.getSpawner().getWorld().getName().toLowerCase()))
			return;

		String blockLocStr = LocationUtil.serializeLocation(event.getSpawner().getLocation());

		if (SpawnerDataConf.get().spawners.containsKey(blockLocStr)) {
			event.setCancelled(true);
			return;
		}
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onEntityDamage(EntityDamageEvent event) {
		if (!MConf.get().whitelistedWorlds.contains(event.getEntity().getLocation().getWorld().getName().toLowerCase()))
			return;

		if (!event.getEntity().hasMetadata("island"))
			return;

		Level spawnerEntity = Main.get().getKeyByMobId(event.getEntity().getMetadata("island").get(0).asString());

		LivingEntity tm = (LivingEntity) event.getEntity();
		tm.setCustomName(Txt.parse(spawnerEntity.getMob().getMobDisplayName().replace("{health}",
				String.valueOf(Math.round(tm.getHealth())))));

		if (event.getCause().equals(DamageCause.ENTITY_ATTACK)) {
			EntityDamageByEntityEvent entityEvent = (EntityDamageByEntityEvent) event;
			MPlayer mplayer = MPlayer.get(entityEvent.getDamager());

			if (mplayer.hasLevel(spawnerEntity.getLevel()))
				return;

			if (!MConf.get().msgLowLevel.isEmpty())
				mplayer.msg(MConf.get().msgLowLevel.replace("{level}",
						NumberFormat.getInstance().format(spawnerEntity.getLevel())));

			event.setCancelled(true);
			return;
		}
	}

	@EventHandler
	public void rewards(PlayerKilledCustomMob e) {
		MobRewardSettings rewards = Main.get().getRewards(e.getMobType().getLevel());

		if (rewards == null)
			return;

		if (!(getRandomInteger(0.0D, 100.0D) <= MConf.get().baseChancePrize))
			return;
		
		for (MobReward drops : rewards.getRewards()) {
			if (!(getRandomInteger(0.0D, 100.0D) <= drops.getChance()))
				continue;

			for (String s : drops.getPlayerRewardCommands())
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), s.replace("{player}", e.getKiller().getName()));
			
			return;
		}
	}

	@EventHandler
	public void entityDamageEntity(EntityDeathEvent e) {
		if (!MConf.get().whitelistedWorlds.contains(e.getEntity().getLocation().getWorld().getName().toLowerCase()))
			return;

		if (!(e.getEntity().getKiller() instanceof Player))
			return;
		if (!e.getEntity().hasMetadata("island"))
			return;

		Level spawnerEntity = Main.get().getKeyByMobId(e.getEntity().getMetadata("island").get(0).asString());

		if (spawnerEntity == null)
			return;

		PlayerKilledCustomMob mobKilled = new PlayerKilledCustomMob(e.getEntity().getKiller(),
				e.getEntity().getLocation(), spawnerEntity);
		Bukkit.getPluginManager().callEvent(mobKilled);

		e.getDrops().clear();

		MPlayer mplayer = MPlayer.get(e.getEntity().getKiller());

		if (!mplayer.hasLevel(spawnerEntity.getLevel()))
			return;

		mplayer.addTotalMobKills(1);

		if (spawnerEntity.getMoneyOnKillStatus()) {
			TaskSell.get().addToSell(mplayer.getName(), spawnerEntity.getMoneyOnKillAmount());
		}

		long xp = spawnerEntity.getXPPerMobKill();

		if (MConf.get().pvpWorldsDoubleXPFor.contains(e.getEntity().getWorld().getName().toLowerCase())) {
			xp = spawnerEntity.getXPPerMobKill() * MConf.get().pvpWorldXPBoost;
		}

		mplayer.addEXP(xp);

		if (mplayer.getEXP() >= spawnerEntity.getXPRequired() && mplayer.getLevel() < MConf.get().mobcreation.size()) {
			mplayer.addLevel(1);
			mplayer.setEXP(0);

			if (spawnerEntity.getMobRankup().RankupSound) {
				mplayer.getPlayer().getLocation().getWorld().playSound(mplayer.getPlayer().getLocation(),
						Sound.valueOf(spawnerEntity.getMobRankup().RankupSoundType),
						spawnerEntity.getMobRankup().RankupSoundVolume, spawnerEntity.getMobRankup().RankupSoundPitch);
			}

			if (spawnerEntity.getMobRankup().RankupTitleEnabled) {
				TitleAPI.sendTitle(mplayer.getPlayer(), spawnerEntity.getMobRankup().RankupTitleFadeIn,
						spawnerEntity.getMobRankup().RankupTitleStay, spawnerEntity.getMobRankup().RankupTitleFadeOut,
						spawnerEntity.getMobRankup().RankupTitleTitle.replace("{level}",
								NumberFormat.getInstance().format(mplayer.getLevel())),
						spawnerEntity.getMobRankup().RankupTitleSubTitle.replace("{level}",
								NumberFormat.getInstance().format(mplayer.getLevel())));
			}

			for (String s : spawnerEntity.getMobRankup().getMobRankupCommands())
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(),
						s.replace("{level}", NumberFormat.getInstance().format(mplayer.getLevel())).replace("{player}",
								mplayer.getName()));
		}
	}

	@EventHandler
	public void spawnMobEvent(SpawnerNeedSpawning event) {
		Location loc = LocationUtil.unserializeLocation(event.getSpawnerLocation());
		if (!loc.getChunk().isLoaded())
			return;

		if (MConf.get().overloadMobLimiter) {
			if (LocationUtil.unserializeLocation(event.getSpawnerLocation()).getWorld().getLivingEntities()
					.size() >= MConf.get().overloardMobLimiterSize)
				return;
		}

		Player player = LocationUtil.randomPlayerByLocation(
				LocationUtil.unserializeLocation(event.getSpawnerLocation()), MConf.get().radiusSpawner);

		if (player == null)
			return;

		Level playerLevelSpawner = Main.get().getKeyByLevel(MPlayer.get(player).getLevel());

		if (playerLevelSpawner != null) {
			if (MConf.get().chancesEnabled) {
				if (!(getRandomInteger(0.0D, 100.0D) <= playerLevelSpawner.getSpawnChance()))
					return;
			}

			if (playerLevelSpawner.getMobType().name().equalsIgnoreCase("MAGMA_CUBE")) {
				MobUtil.MagmaCubeCustomMob(loc, playerLevelSpawner);
			} else if (playerLevelSpawner.getMobType().name().equalsIgnoreCase("PIG_ZOMBIE")) {
				MobUtil.PigZombieCustomMob(loc, playerLevelSpawner);
			} else if (playerLevelSpawner.getMobType().name().equalsIgnoreCase("WITHER")) {
				MobUtil.WitherCustomMob(loc, playerLevelSpawner);
			} else if (playerLevelSpawner.getMobType().name().equalsIgnoreCase("Zombie")) {
				MobUtil.CustomMobZombie(loc, playerLevelSpawner);
			} else if (playerLevelSpawner.getMobType().name().equalsIgnoreCase("WITHER_SKELETON")) {
				MobUtil.WitherSkeletonCustomMob(loc, playerLevelSpawner);
			} else if (playerLevelSpawner.getMobType().name().equalsIgnoreCase("SPIDER")) {
				MobUtil.CustomSpider(loc, playerLevelSpawner);
			} else if (playerLevelSpawner.getMobType().name().equalsIgnoreCase("WOLF")) {
				MobUtil.CustomWolf(loc, playerLevelSpawner);
			} else {
				MobUtil.CustomMob(loc, playerLevelSpawner);
			}

			return;
		}
	}
}
