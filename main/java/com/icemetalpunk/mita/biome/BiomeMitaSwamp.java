package com.icemetalpunk.mita.biome;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeSwamp;
import net.minecraft.world.chunk.ChunkPrimer;

public class BiomeMitaSwamp extends BiomeSwamp {

	public BiomeMitaSwamp(BiomeProperties properties) {
		super(properties);
		this.setRegistryName("minecraft", "swampland");
	}

	// FIXME: Leaves "random" patches of water in swamps uncovered; why?
	@Override
	public void genTerrainBlocks(World worldIn, Random rand, ChunkPrimer chunkPrimerIn, int j, int i, double noiseVal) {
		super.genTerrainBlocks(worldIn, rand, chunkPrimerIn, j, i, noiseVal);
		int x = j & 15;
		int z = i & 15;
		for (int y = 255; y >= 0; --y) {
			Material mat = chunkPrimerIn.getBlockState(x, y, z).getMaterial();
			boolean isWater = (mat == Material.WATER);
			boolean isAir = (mat == Material.AIR);
			if (!isAir) {
				if (isWater) {
					chunkPrimerIn.setBlockState(x, y + 1, z, Blocks.MAGMA.getDefaultState());
				}
				return;
			}
		}
	}

}
