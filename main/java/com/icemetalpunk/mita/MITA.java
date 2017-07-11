package com.icemetalpunk.mita;

import com.icemetalpunk.mita.events.RegistryHandler;
import com.icemetalpunk.mita.proxy.CommonProxy;
import com.icemetalpunk.mita.world.WorldGenTest;

import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialTransparent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = MITA.MODID, version = MITA.VERSION)
public class MITA {
	public static final String MODID = "mita";
	public static final String VERSION = "0.1";

	// Handlers
	public RegistryHandler registryHandler = new RegistryHandler();
	public static IWorldGenerator worldGen = new WorldGenTest();

	@SidedProxy(clientSide = "com.icemetalpunk.mita.proxy.ClientProxy", serverSide = "com.icemetalpunk.mita.proxy.ServerProxy")
	public static CommonProxy proxy;

	// Tab
	public static CreativeTabs tab = new CreativeTabs("Magic in the Air") {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Blocks.ENCHANTING_TABLE);
		}

	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.preInit(event);
		MinecraftForge.EVENT_BUS.register(this.registryHandler);
		GameRegistry.registerWorldGenerator(worldGen, 1000);
	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init(event);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit(event);
	}

	public static class Materials {

		// XXX: .setNoPushMobility() isn't visible, so this workaround works.
		public static final Material GAS = (new MaterialTransparent(MapColor.AIR) {
			@Override
			public EnumPushReaction getMobilityFlag() {
				return EnumPushReaction.DESTROY;
			}
		});
	}
}