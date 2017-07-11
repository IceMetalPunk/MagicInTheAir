package com.icemetalpunk.mita.registry;

import com.icemetalpunk.mita.block.IBlockMITA;

import net.minecraftforge.event.RegistryEvent;

public class BlockRegistry extends MITARegistry<IBlockMITA> {

	public BlockRegistry() {
		// TODO: Add blocks to registry here with this.register(String name, IBlockMITA block)
	}

	@Override
	public int registerModels() {
		int ret = 0;
		for (IBlockMITA block : this.registry.values()) {
			if (block.registerModels()) {
				++ret;
			}
		}
		return ret;
	}

	@Override
	public int registerAll(RegistryEvent.Register ev) {
		int ret = 0;
		for (IBlockMITA block : this.registry.values()) {
			if (block.register(ev)) {
				++ret;
			}
		}
		return ret;
	}

}
