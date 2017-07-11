package com.icemetalpunk.mita.item;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;

public interface IItemMITA {

	/**
	 * Registers the models for the given block.
	 * 
	 * @return True on success, false on failure.
	 */
	public boolean registerModels();

	/**
	 * Registers this item with the GameRegistry.
	 * 
	 * @return True on success, false on failure.
	 */
	public boolean register(RegistryEvent.Register<Item> ev);
}
