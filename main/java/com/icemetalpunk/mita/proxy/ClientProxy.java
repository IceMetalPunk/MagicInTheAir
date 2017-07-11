package com.icemetalpunk.mita.proxy;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {
	public void preInit(FMLPreInitializationEvent ev) {

	}

	public void init(FMLInitializationEvent ev) {

	}

	public void postInit(FMLPostInitializationEvent ev) {

	}

	@Override
	public void registerModels() {
		this.blocks.registerModels();
		this.items.registerModels();
	}
}
