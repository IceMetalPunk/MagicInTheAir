package com.icemetalpunk.mita;

import com.icemetalpunk.mita.events.RegistryHandler;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = MITA.MODID, version = MITA.VERSION)
public class MITA {
	public static final String MODID = "mita";
	public static final String VERSION = "0.1";

	// Handlers
	public RegistryHandler registryHandler = new RegistryHandler();

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this.registryHandler);
	}
}