package com.icemetalpunk.mita.proxy;

import com.icemetalpunk.mita.registry.BlockRegistry;
import com.icemetalpunk.mita.registry.ItemRegistry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {

	public BlockRegistry blocks = new BlockRegistry();
	public ItemRegistry items = new ItemRegistry();

	public void preInit(FMLPreInitializationEvent ev) {

	}

	public void init(FMLInitializationEvent ev) {

	}

	public void postInit(FMLPostInitializationEvent ev) {

	}

	public void registerModels() {

	}

	public void registerBlocks(RegistryEvent.Register<Block> ev) {
		this.blocks.registerAll(ev);
	}

	public void registerItems(RegistryEvent.Register<Item> ev) {
		this.items.registerAll(ev);
	}
}
