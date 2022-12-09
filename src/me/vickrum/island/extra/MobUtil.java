package me.vickrum.island.extra;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.MagmaCube;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Skeleton.SkeletonType;
import org.bukkit.entity.Spider;
import org.bukkit.entity.Wither;
import org.bukkit.entity.Wolf;
import org.bukkit.entity.Zombie;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.Main;
import me.vickrum.island.entity.MConf;
import me.vickrum.island.entity.object.Level;

public class MobUtil {

	public static void CustomMob(Location spawner, Level spawnerEntity) {

		LivingEntity entity = (LivingEntity) spawner.getWorld().spawnEntity(spawner.add(0, 2, 0),
				spawnerEntity.getMobType());

		if (entity == null)
			return;

		entity.setMaxHealth(spawnerEntity.getMob().getMobHealth());
		entity.setHealth(spawnerEntity.getMob().getMobHealth());

		entity.setMetadata("island",
				(MetadataValue) new FixedMetadataValue(Main.get(), spawnerEntity.getMob().getName()));

		entity.setCustomName(Txt.parse(spawnerEntity.getMob().getMobDisplayName().replace("{health}",
				String.valueOf(Math.round(spawnerEntity.getMob().getMobHealth())))));

		if (MConf.get().autoDespawnMob)
			RunnableBuilder.forPlugin(Main.get()).with(entity::remove).runSyncLater(MConf.get().autoDespawnTimer);
	}

	public static void MagmaCubeCustomMob(Location spawner, Level spawnerEntity) {
		MagmaCube entity = (MagmaCube) spawner.getWorld().spawnEntity(spawner.add(0, 2, 0), EntityType.MAGMA_CUBE);

		if (entity == null)
			return;

		entity.setMaxHealth(spawnerEntity.getMob().getMobHealth());
		entity.setHealth(spawnerEntity.getMob().getMobHealth());

		entity.setMetadata("island",
				(MetadataValue) new FixedMetadataValue(Main.get(), spawnerEntity.getMob().getName()));

		entity.setCustomName(Txt.parse(spawnerEntity.getMob().getMobDisplayName().replace("{health}",
				String.valueOf(Math.round(spawnerEntity.getMob().getMobHealth())))));
	}

	public static void PigZombieCustomMob(Location spawner, Level spawnerEntity) {
		PigZombie entity = (PigZombie) spawner.getWorld().spawnEntity(spawner.add(0, 2, 0), EntityType.PIG_ZOMBIE);

		if (entity == null)
			return;

		entity.setMaxHealth(spawnerEntity.getMob().getMobHealth());
		entity.setHealth(spawnerEntity.getMob().getMobHealth());

		entity.setMetadata("island",
				(MetadataValue) new FixedMetadataValue(Main.get(), spawnerEntity.getMob().getName()));

		entity.setCustomName(Txt.parse(spawnerEntity.getMob().getMobDisplayName().replace("{health}",
				String.valueOf(Math.round(spawnerEntity.getMob().getMobHealth())))));
	}

	public static void CustomSpider(Location spawner, Level spawnerEntity) {
		Spider entity = spawner.getWorld().spawn(spawner.add(0, 2, 0), Spider.class);

		if (entity == null)
			return;

		entity.setMaxHealth(spawnerEntity.getMob().getMobHealth());
		entity.setHealth(spawnerEntity.getMob().getMobHealth());

		entity.setMetadata("island",
				(MetadataValue) new FixedMetadataValue(Main.get(), spawnerEntity.getMob().getName()));

		entity.setCustomName(Txt.parse(spawnerEntity.getMob().getMobDisplayName().replace("{health}",
				String.valueOf(Math.round(spawnerEntity.getMob().getMobHealth())))));
	}

	public static void WitherCustomMob(Location spawner, Level spawnerEntity) {
		Wither entity = (Wither) spawner.getWorld().spawnEntity(spawner.add(0, 2, 0), EntityType.WITHER);

		if (entity == null)
			return;

		entity.setMaxHealth(spawnerEntity.getMob().getMobHealth());
		entity.setHealth(spawnerEntity.getMob().getMobHealth());

		entity.setMetadata("island",
				(MetadataValue) new FixedMetadataValue(Main.get(), spawnerEntity.getMob().getName()));

		entity.setCustomName(Txt.parse(spawnerEntity.getMob().getMobDisplayName().replace("{health}",
				String.valueOf(Math.round(spawnerEntity.getMob().getMobHealth())))));
	}
	
	public static void CustomWolf(Location spawner, Level spawnerEntity) {
		Wolf entity = spawner.getWorld().spawn(spawner.add(0, 2, 0), Wolf.class);

		if (entity == null)
			return;

		entity.setAngry(true);

		entity.setMaxHealth(spawnerEntity.getMob().getMobHealth());
		entity.setHealth(spawnerEntity.getMob().getMobHealth());

		entity.setMetadata("island",
				(MetadataValue) new FixedMetadataValue(Main.get(), spawnerEntity.getMob().getName()));

		entity.setCustomName(Txt.parse(spawnerEntity.getMob().getMobDisplayName().replace("{health}",
				String.valueOf(Math.round(spawnerEntity.getMob().getMobHealth())))));
	}

	public static void CustomMobZombie(Location spawner, Level spawnerEntity) {
		Zombie entity = spawner.getWorld().spawn(spawner.add(0, 2, 0), Zombie.class);

		if (entity == null)
			return;

		entity.setBaby(false);

		entity.setMaxHealth(spawnerEntity.getMob().getMobHealth());
		entity.setHealth(spawnerEntity.getMob().getMobHealth());

		entity.setMetadata("island",
				(MetadataValue) new FixedMetadataValue(Main.get(), spawnerEntity.getMob().getName()));

		entity.setCustomName(Txt.parse(spawnerEntity.getMob().getMobDisplayName().replace("{health}",
				String.valueOf(Math.round(spawnerEntity.getMob().getMobHealth())))));
	}

	public static void WitherSkeletonCustomMob(Location spawner, Level spawnerEntity) {
		Skeleton entity = (Skeleton) spawner.getWorld().spawnEntity(spawner.add(0, 2, 0), EntityType.SKELETON);

		if (entity == null)
			return;

		((Skeleton) entity).setSkeletonType(SkeletonType.WITHER);

		entity.setMaxHealth(spawnerEntity.getMob().getMobHealth());
		entity.setHealth(spawnerEntity.getMob().getMobHealth());

		entity.setMetadata("island",
				(MetadataValue) new FixedMetadataValue(Main.get(), spawnerEntity.getMob().getName()));

		entity.setCustomName(Txt.parse(spawnerEntity.getMob().getMobDisplayName().replace("{health}",
				String.valueOf(Math.round(spawnerEntity.getMob().getMobHealth())))));
	}
}
