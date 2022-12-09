package me.vickrum.island.skills;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

public class FakeWebAbility {
	@SuppressWarnings("deprecation")
	public static void fakewebability(final LivingEntity player, Entity entity, double level, int radius) {
		Block block = player.getLocation().getBlock();
		Player pAttacker = (Player) player;

		BlockFace[] bfs = new BlockFace[] { BlockFace.SELF, BlockFace.UP, BlockFace.EAST, BlockFace.WEST,
				BlockFace.SOUTH, BlockFace.NORTH };

		for (BlockFace bf : bfs) {
			if (block.getRelative(bf).getType() == Material.AIR) {
				pAttacker.sendBlockChange(block.getRelative(bf).getLocation(), Material.WEB, (byte) 0x0);
			}
		}
	}
}
