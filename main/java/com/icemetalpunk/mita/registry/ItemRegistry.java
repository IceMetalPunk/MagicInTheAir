package com.icemetalpunk.mita.registry;

import com.icemetalpunk.mita.item.IItemMITA;

import net.minecraftforge.event.RegistryEvent.Register;

public class ItemRegistry extends MITARegistry<IItemMITA> {

	public ItemRegistry() {
		// TODO: Add items to registry here with this.register(String name, IItemMITA block)
	}

	@Override
	public int registerModels() {
		int ret = 0;
		for (IItemMITA item : this.registry.values()) {
			if (item.registerModels()) {
				++ret;
			}
		}
		return ret;
	}

	@Override
	public int registerAll(Register ev) {
		int ret = 0;
		for (IItemMITA item : this.registry.values()) {
			if (item.register(ev)) {
				++ret;
			}
		}
		return ret;
	}

}
