package me.vickrum.island.inventory;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.vickrum.island.event.MenuInventoryEvent;
import me.vickrum.island.extra.ItemBuilder;
import me.vickrum.island.gui.BaseGui;
import me.vickrum.island.gui.configuration.Clickable;
import me.vickrum.island.gui.configuration.GuiDesign;
import me.vickrum.island.gui.types.IClickableGui;

public class MenuInventory extends BaseGui implements IClickableGui {

	public final List<Clickable> click;

	public MenuInventory(Player player, GuiDesign design, List<Clickable> click) {
		super(player, design);

		this.click = click;
	}

	@Override
	public List<Clickable> getClickables() {
		return click;
	}

	@Override
	public void loadClicks() {
		getClickablesFiltered(this.inventory).forEach(clickable -> {
			int slot = clickable.getSlot();

			if (!clickable.getDisplayItem().getBaseItem().getType().equals(Material.SKULL_ITEM)) {
				ItemStack itemStack = clickable.getDisplayItem().toItemStack();

				this.inventory.setItem(slot, itemStack);

				player.closeInventory();

				if (clickable.getCommand() != null) {
					setClickable(slot, event -> {
						MenuInventoryEvent confClicked = new MenuInventoryEvent(this.player, clickable.getCommand());
						Bukkit.getPluginManager().callEvent(confClicked);
					});
				}
			} else {
				try {
					ItemStack itemLol = new ItemBuilder(Material.SKULL_ITEM).durability(3)
							.name(clickable.getDisplayItem().getMeta().getDisplayName())
							.texture(clickable.getTexture());

					this.inventory.setItem(slot, itemLol);

					if (clickable.getCommand() != null) {
						setClickable(slot, event -> {
							MenuInventoryEvent confClicked = new MenuInventoryEvent(this.player,
									clickable.getCommand());
							Bukkit.getPluginManager().callEvent(confClicked);
						});
					}
				} catch (Exception ignore) {
				}
			}
		});
	}
}