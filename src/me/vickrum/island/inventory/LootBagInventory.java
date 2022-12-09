package me.vickrum.island.inventory;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.massivecraft.massivecore.util.Txt;

import me.vickrum.island.Main;
import me.vickrum.island.entity.object.MobReward;
import me.vickrum.island.entity.object.MobRewardSettings;
import me.vickrum.island.extra.ItemBuilder;
import me.vickrum.island.gui.configuration.Clickable;
import me.vickrum.island.gui.configuration.GuiDesign;
import me.vickrum.island.gui.types.RefreshGui;

public class LootBagInventory extends RefreshGui {

	public final List<Clickable> click;
	
	public final int amount;

	public LootBagInventory(Player player, GuiDesign design, List<Clickable> click, int amount) {
		super(player, design);

		this.click = click;
		this.amount = amount;
	}

	@Override
	public long getRefreshTicks() {
		return 0;
	}

	@Override
	public void refresh() {
		click.stream()
				.filter(actionButton -> actionButton.getSlot() >= 0 && actionButton.getSlot() < inventory.getSize())
				.forEach(actionButton -> {
					int slot = actionButton.getSlot();
					ItemStack itemStack = actionButton.getDisplayItem().toItemStack();

					this.inventory.setItem(slot, itemStack);
				});
		
		MobRewardSettings rewards = Main.get().getRewards(amount);

		if (rewards != null)
		for (MobReward drops : rewards.getRewards()) {
			ItemBuilder lol = new ItemBuilder(Material.COMMAND).name(Txt.parse("&6&l" + drops.getRewardName()));
			
			inventory.addItem(lol);
		}
		
	};

}
