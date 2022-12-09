package me.vickrum.island.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MenuInventoryEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	private final Player player;

	private final String command;

	public MenuInventoryEvent(Player player, String command) {
		this.player = player;
		this.command = command;
	}

	public Player getPlayer() {
		return this.player;
	}

	public String getCommand() {
		return this.command;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	public HandlerList getHandlers() {
		return handlers;
	}
}
