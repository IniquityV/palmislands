package me.vickrum.island.gui.types;

import org.bukkit.inventory.Inventory;

import me.vickrum.island.gui.configuration.Clickable;

import java.util.List;
import java.util.stream.Collectors;

public interface IClickableGui {

	List<Clickable> getClickables();

	default List<Clickable> getClickablesFiltered(Inventory inventory) {
		return getClickables().stream()
				.filter(clickable -> clickable.getSlot() >= 0 && clickable.getSlot() < inventory.getSize())
				.collect(Collectors.toList());
	}

	void loadClicks();

}
