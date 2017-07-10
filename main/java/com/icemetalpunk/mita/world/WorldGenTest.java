package com.icemetalpunk.mita.world;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

// XXX: Just a test to see if we can generate blocks based on existing blocks *regardless of biome*
/* FIXME: Though this works, it also logs "MITA loaded a new chunk during chunk population, causing cascading worldgen lag" warnings.
 * Where am I loading a new chunk?
 */
public class WorldGenTest implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider) {
		int x, y, z, i, j;
		IBlockState state, upstate;
		BlockPos pos;
		for (i = 0; i < 16; ++i) {
			for (j = 0; j < 16; ++j) {
				x = chunkX * 16 + i;
				z = chunkZ * 16 + j;
				for (y = 255; y >= 0; --y) {
					pos = new BlockPos(x, y, z);
					state = world.getBlockState(pos);
					upstate = world.getBlockState(pos.up());
					if (state.getMaterial() == Material.LAVA && upstate.getMaterial() == Material.AIR) {
						world.setBlockState(pos.up(), Blocks.OBSIDIAN.getDefaultState());
					}
				}
			}
		}
	}

}
