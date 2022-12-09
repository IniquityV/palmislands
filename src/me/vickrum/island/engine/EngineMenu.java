package me.vickrum.island.engine;

import org.bukkit.event.EventHandler;

import com.massivecraft.massivecore.Engine;

import me.vickrum.island.event.MenuInventoryEvent;

public class EngineMenu extends Engine {

	private static EngineMenu i = new EngineMenu();

	public static EngineMenu get() {
		return i;
	}

	@EventHandler
	public void playerMenuClick(MenuInventoryEvent e) {
		e.getPlayer().chat("/" + e.getCommand());
	}
}
