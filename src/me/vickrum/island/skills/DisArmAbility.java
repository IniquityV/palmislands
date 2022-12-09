package me.vickrum.island.skills;

import org.bukkit.inventory.ItemStack;

import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.entity.MConf;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.*;

public class DisArmAbility {
	public static void disarmability(Player p) {
		ItemStack itemStack;
		int i = getRandomNumber();
		switch (i) {
		case 0:
			itemStack = p.getEquipment().getItemInHand();
			p.getEquipment().setItemInHand(new ItemStack(Material.AIR));
			break;
		case 1:
			itemStack = p.getEquipment().getHelmet();
			p.getEquipment().setHelmet(new ItemStack(Material.AIR));
			break;
		case 2:
			itemStack = p.getEquipment().getChestplate();
			p.getEquipment().setChestplate(new ItemStack(Material.AIR));
			break;
		case 3:
			itemStack = p.getEquipment().getLeggings();
			p.getEquipment().setLeggings(new ItemStack(Material.AIR));
			break;
		default:
			itemStack = p.getEquipment().getBoots();
			p.getEquipment().setBoots(new ItemStack(Material.AIR));
			break;
		}
		if (itemStack == null || itemStack.getType() == Material.AIR)
			return;
		p.getWorld().dropItemNaturally(p.getLocation(), itemStack);
		p.sendMessage(Txt.parse(MConf.get().msgDisarmed));
	}

	private static int getRandomNumber() {
		Random random = new Random();
		return random.nextInt(5);
	}
}
