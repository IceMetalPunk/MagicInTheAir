package com.icemetalpunk.mita.block;

import com.icemetalpunk.mita.MITA;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;

public abstract class BlockMITA extends Block implements IBlockMITA {

	private ItemBlock itemBlock = new ItemBlock(this);

	public BlockMITA(String name, Material materialIn) {
		this(name, materialIn, MapColor.AIR);
	}

	public BlockMITA(String name, Material materialIn, MapColor mapColor) {
		super(materialIn, mapColor);
		this.setRegistryName(MITA.MODID, name).setUnlocalizedName(name).setCreativeTab(MITA.tab);
	}

	@Override
	public ItemBlock getItemBlock() {
		return this.itemBlock;
	}

	@Override
	public boolean registerModels() {
		try {
			ModelResourceLocation model = new ModelResourceLocation(this.getRegistryName(), "inventory");
			ModelLoader.setCustomModelResourceLocation(this.getItemBlock(), 0, model);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public boolean register(RegistryEvent.Register ev) {
		try {
			ev.getRegistry().register(this);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}
