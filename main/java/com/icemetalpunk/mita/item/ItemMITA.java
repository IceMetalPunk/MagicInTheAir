package com.icemetalpunk.mita.item;

import com.icemetalpunk.mita.MITA;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public abstract class ItemMITA extends Item implements IItemMITA {

	public ItemMITA(String name) {
		super();
		this.setRegistryName(MITA.MODID, name).setUnlocalizedName(name).setCreativeTab(MITA.tab);
	}

	@Override
	public boolean registerModels() {
		try {
			ModelResourceLocation model = new ModelResourceLocation(this.getRegistryName(), "inventory");
			ModelLoader.setCustomModelResourceLocation(this, 0, model);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean register(RegistryEvent.Register ev) {
		try {
			GameRegistry.findRegistry(Item.class).register(this);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
