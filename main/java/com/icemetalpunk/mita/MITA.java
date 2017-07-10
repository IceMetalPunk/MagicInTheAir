package com.icemetalpunk.mita;

import com.icemetalpunk.mita.events.RegistryHandler;
import com.icemetalpunk.mita.world.WorldGenTest;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MITA.MODID, version = MITA.VERSION)
public class MITA {
	public static final String MODID = "mita";
	public static final String VERSION = "0.1";

	// Handlers
	public RegistryHandler registryHandler = new RegistryHandler();
	public static IWorldGenerator worldGen = new WorldGenTest();

	@EventHandler
	public void preinit(FMLPreInitializationEvent event) {
		MinecraftForge.EVENT_BUS.register(this.registryHandler);
		GameRegistry.registerWorldGenerator(worldGen, 1000);
	}
}