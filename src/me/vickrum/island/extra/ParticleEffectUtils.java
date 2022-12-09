package me.vickrum.island.extra;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.LivingEntity;

import me.vickrum.island.entity.MConf;

public final class ParticleEffectUtils {
	public static void playBleedEffect(LivingEntity livingEntity) {
		if (!MConf.get().Bleed)
			return;
		livingEntity.getWorld().playEffect(livingEntity.getEyeLocation(), Effect.STEP_SOUND, Material.REDSTONE_WIRE);
	}

	public static void playSmokeEffect(LivingEntity livingEntity) {
		Location location = livingEntity.getEyeLocation();
		World world = livingEntity.getWorld();
		world.playEffect(location, Effect.SMOKE, BlockFace.SOUTH_EAST);
		world.playEffect(location, Effect.SMOKE, BlockFace.SOUTH);
		world.playEffect(location, Effect.SMOKE, BlockFace.SOUTH_WEST);
		world.playEffect(location, Effect.SMOKE, BlockFace.EAST);
		world.playEffect(location, Effect.SMOKE, BlockFace.SELF);
		world.playEffect(location, Effect.SMOKE, BlockFace.WEST);
		world.playEffect(location, Effect.SMOKE, BlockFace.NORTH_EAST);
		world.playEffect(location, Effect.SMOKE, BlockFace.NORTH);
		world.playEffect(location, Effect.SMOKE, BlockFace.NORTH_WEST);
	}
}
