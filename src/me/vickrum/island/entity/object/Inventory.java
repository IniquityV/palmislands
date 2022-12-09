package me.vickrum.island.entity.object;

import java.util.List;

import com.massivecraft.massivecore.store.EntityInternal;

import me.vickrum.island.gui.configuration.Clickable;
import me.vickrum.island.gui.configuration.GuiDesign;

public class Inventory extends EntityInternal<Inventory> {

	private String name;

	private GuiDesign Gui;

	private List<Clickable> clickables;

	public Inventory(String name, GuiDesign Gui, List<Clickable> clickables) {
		this.name = name;
		this.Gui = Gui;
		this.clickables = clickables;
	}

	public String getName() {
		return this.name;
	}

	public GuiDesign getGui() {
		return this.Gui;
	}

	public List<Clickable> getClickables() {
		return this.clickables;
	}
}
