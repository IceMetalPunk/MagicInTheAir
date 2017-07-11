package com.icemetalpunk.mita.block.gas;

import com.icemetalpunk.mita.MITA;
import com.icemetalpunk.mita.block.BlockMITA;

import net.minecraft.block.material.Material;

public class BlockMITAGas extends BlockMITA {

	public BlockMITAGas(String name) {
		this(name, MITA.Materials.GAS);
	}

	public BlockMITAGas(String name, Material mat) {
		super(name, mat);
	}
}
