package net.irreleven.mintstate.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.irreleven.mintstate.MintStateCraft;
import net.irreleven.mintstate.block.custom.TheCrucibleBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {
    public static final Block ZINC_ORE = registerBlock("zinc_ore",
            new ExperienceDroppingBlock (UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_ZINC_ORE = registerBlock("deepslate_zinc_ore",
            new ExperienceDroppingBlock (UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));
    public static final Block NICKEL_ORE = registerBlock("nickel_ore",
            new ExperienceDroppingBlock (UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));
    public static final Block DEEPSLATE_NICKEL_ORE = registerBlock("deepslate_nickel_ore",
            new ExperienceDroppingBlock (UniformIntProvider.create(2, 5), FabricBlockSettings.copyOf(Blocks.STONE).strength(2f)));

    public static final Block THE_CRUCIBLE = registerBlock ("the_crucible",
            new TheCrucibleBlock (FabricBlockSettings.copyOf (Blocks.IRON_BLOCK).nonOpaque ()));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier (MintStateCraft.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(MintStateCraft.MOD_ID, name),
                new BlockItem (block, new FabricItemSettings ()));
    }

    public static void registerModBlocks() {
        MintStateCraft.LOGGER.info("Registering ModBlocks for " + MintStateCraft.MOD_ID);
    }
}
