package com.icemetalpunk.mita.block;

import net.minecraft.item.ItemBlock;
import net.minecraftforge.event.RegistryEvent;

public interface IBlockMITA {

	/**
	 * @return The ItemBlock associated with this block.
	 */
	public ItemBlock getItemBlock();

	/**
	 * Registers the models for the given block.
	 * 
	 * @return True on success, false on failure.
	 */
	public boolean registerModels();

	/**
	 * Registers this block with the GameRegistry.
	 * 
	 * @param ev
	 *            The proper RegistryEvent during which this is registered, for getting the proper Forge registry.
	 * @return True on success, false on failure.
	 */
	public boolean register(RegistryEvent.Register ev);
}
