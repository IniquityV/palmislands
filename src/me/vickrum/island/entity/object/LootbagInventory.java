package me.vickrum.island.entity.object;

import java.util.List;

import com.massivecraft.massivecore.store.EntityInternal;

import me.vickrum.island.gui.configuration.Clickable;
import me.vickrum.island.gui.configuration.GuiDesign;

public class LootbagInventory extends EntityInternal<LootbagInventory> {
	private GuiDesign Gui;

	private List<Clickable> clickables;

	public LootbagInventory(GuiDesign Gui, List<Clickable> clickables) {
		this.Gui = Gui;
		this.clickables = clickables;
	}

	public GuiDesign getActionInventoryGUI() {
		return this.Gui;
	}

	public List<Clickable> getClickables() {
		return this.clickables;
	}
}
