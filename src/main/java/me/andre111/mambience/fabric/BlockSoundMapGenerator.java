package me.andre111.mambience.fabric;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.registry.Registry;

public class BlockSoundMapGenerator {
	private static final Map<BlockSoundGroup, String> DEFAULT_SOUND_MAP = new HashMap<>();
	static {
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.WOOD, "planks");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.GRAVEL, "gravel");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.GRASS, "grass");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.LILY_PAD, "grass");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.STONE, "stone");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.METAL, "hardmetal");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.GLASS, "glass");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.WOOL, "rug");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.SAND, "sand");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.SNOW, "snow");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.LADDER, "ladder");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.ANVIL, "metalcompressed,hardmetal");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.SLIME, "mud");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.HONEY, "mud");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.WET_GRASS, "organic");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.CORAL, "");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.BAMBOO, "log");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.BAMBOO_SAPLING, "grass");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.SCAFFOLDING, "squeakywood");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.SWEET_BERRY_BUSH, "grass");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.CROP, "grass");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.STEM, "grass");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.VINE, "straw");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.NETHER_WART, "organic");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.LANTERN, "metalbar");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.NETHER_STEM, "grass");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.NYLIUM, "grass,organic");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.FUNGUS, "organic_dry");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.ROOTS, "straw");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.SHROOMLIGHT, "shroomlight");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.WEEPING_VINES, "grass,organic");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.WEEPING_VINES_LOW_PITCH, "grass,organic");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.SOUL_SAND, "soulsand");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.SOUL_SOIL, "soulsoil");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.BASALT, "basalt");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.WART_BLOCK, "organic");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.NETHERRACK, "netherrack");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.NETHER_BRICKS, "netherbrick");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.NETHER_SPROUTS, "grass");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.NETHER_ORE, "netherrack");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.BONE, "bone");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.NETHERITE, "hardmetal");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.ANCIENT_DEBRIS, "hardmetal");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.LODESTONE, "stonemachine");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.CHAIN, "metalbar");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.NETHER_GOLD_ORE, "netherrack");
		DEFAULT_SOUND_MAP.put(BlockSoundGroup.GILDED_BLACKSTONE, "stone");
	}
	
	public static void generateBlockSoundMap() {
		Registry.BLOCK.forEach(block -> {
			String id = Registry.BLOCK.getId(block).toString();
			String type = DEFAULT_SOUND_MAP.get(block.getSoundGroup(block.getDefaultState()));
			System.out.println("\""+id+"\": \""+type+"\",");
		});
	}
}
