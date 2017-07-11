package com.icemetalpunk.mita.events;

import com.icemetalpunk.mita.MITA;
import com.icemetalpunk.mita.biome.BiomeMitaSwamp;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class RegistryHandler {
	@SubscribeEvent
	public void onBiomeRegistry(RegistryEvent.Register<Biome> ev) {
		ev.getRegistry().register(new BiomeMitaSwamp(new Biome.BiomeProperties("Swampland").setBaseHeight(-0.2F)
				.setHeightVariation(0.1F).setTemperature(0.8F).setRainfall(0.9F).setWaterColor(14745518)));
	}

	@SubscribeEvent
	public void onModelRegistry(ModelRegistryEvent ev) {
		MITA.proxy.registerModels();
	}

	@SubscribeEvent
	public void onBlockRegistry(RegistryEvent.Register<Block> ev) {
		MITA.proxy.registerBlocks(ev);
	}

	@SubscribeEvent
	public void onItemRegistry(RegistryEvent.Register<Item> ev) {
		MITA.proxy.registerItems(ev);
	}
}
