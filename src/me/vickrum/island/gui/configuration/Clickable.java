package me.vickrum.island.gui.configuration;

import me.vickrum.island.extra.ItemStackWrapper;

public class Clickable {
	private final ItemStackWrapper displayItem;

	private final String skullName;

	private final String texture;

	private final String command;

	private final int slot;

	public Clickable(int slot, ItemStackWrapper itemStackWrapper, String texture, String command) {
		this(slot, itemStackWrapper, texture, command, null);
	}

	public Clickable(int slot, ItemStackWrapper itemStackWrapper) {
		this(slot, itemStackWrapper, null, null, null);
	}

	public Clickable(int slot, ItemStackWrapper itemStackWrapper, String texture) {
		this(slot, itemStackWrapper, texture, null, null);
	}

	public Clickable(int slot, ItemStackWrapper itemStackWrapper, String texture, String command, String skullName) {
		this.slot = slot;
		this.displayItem = itemStackWrapper;
		this.texture = texture;
		this.command = command;
		this.skullName = skullName;
	}

	public int getSlot() {
		return this.slot;
	}

	public ItemStackWrapper getDisplayItem() {
		return this.displayItem;
	}

	public String getSkullName() {
		return this.skullName;
	}

	public String getTexture() {
		return this.texture;
	}

	public String getCommand() {
		return this.command;
	}
}