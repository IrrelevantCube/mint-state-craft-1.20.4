package net.irreleven.mintstate.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.irreleven.mintstate.block.ModBlocks;
import net.irreleven.mintstate.item.ModItems;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super (output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll (ModBlocks.NICKEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll (ModBlocks.DEEPSLATE_NICKEL_ORE);
        blockStateModelGenerator.registerSimpleCubeAll (ModBlocks.ZINC_ORE);
        blockStateModelGenerator.registerSimpleCubeAll (ModBlocks.DEEPSLATE_ZINC_ORE);

        blockStateModelGenerator.registerSimpleState (ModBlocks.THE_CRUCIBLE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register (ModItems.COIN_AMALGAM, Models.GENERATED);
        itemModelGenerator.register (ModItems.NICKEL_INGOT, Models.GENERATED);
        itemModelGenerator.register (ModItems.ZINC_INGOT, Models.GENERATED);
        itemModelGenerator.register (ModItems.EMERALD_PLANCHET, Models.GENERATED);
        itemModelGenerator.register (ModItems.DIAMOND_PLANCHET, Models.GENERATED);
        itemModelGenerator.register (ModItems.GOLD_PLANCHET, Models.GENERATED);
        itemModelGenerator.register (ModItems.NICKEL_PLANCHET, Models.GENERATED);
        itemModelGenerator.register (ModItems.ZINC_PLANCHET, Models.GENERATED);
        itemModelGenerator.register (ModItems.NICKELGOLD_PLANCHET, Models.GENERATED);
        itemModelGenerator.register (ModItems.COPPER_PLANCHET, Models.GENERATED);
        itemModelGenerator.register (ModItems.DIAMOND_MASTER_DIE_DIAMOND, Models.GENERATED);
        itemModelGenerator.register (ModItems.DIAMOND_MASTER_DIE_COPPER, Models.GENERATED);
        itemModelGenerator.register (ModItems.DIAMOND_MASTER_DIE_EMERALD, Models.GENERATED);
        itemModelGenerator.register (ModItems.DIAMOND_MASTER_DIE_GOLD, Models.GENERATED);
        itemModelGenerator.register (ModItems.DIAMOND_MASTER_DIE_NICKEL, Models.GENERATED);
        itemModelGenerator.register (ModItems.DIAMOND_MASTER_DIE_NICKELGOLD, Models.GENERATED);
        itemModelGenerator.register (ModItems.DIAMOND_MASTER_DIE_ZINC, Models.GENERATED);
        itemModelGenerator.register (ModItems.IRON_MASTER_DIE_COPPER, Models.GENERATED);
        itemModelGenerator.register (ModItems.IRON_MASTER_DIE_DIAMOND, Models.GENERATED);
        itemModelGenerator.register (ModItems.IRON_MASTER_DIE_EMERALD, Models.GENERATED);
        itemModelGenerator.register (ModItems.IRON_MASTER_DIE_GOLD, Models.GENERATED);
        itemModelGenerator.register (ModItems.IRON_MASTER_DIE_NICKEL, Models.GENERATED);
        itemModelGenerator.register (ModItems.IRON_MASTER_DIE_NICKELGOLD, Models.GENERATED);
        itemModelGenerator.register (ModItems.IRON_MASTER_DIE_ZINC, Models.GENERATED);
        itemModelGenerator.register (ModItems.STONE_MASTER_DIE_COPPER, Models.GENERATED);
        itemModelGenerator.register (ModItems.STONE_MASTER_DIE_DIAMOND, Models.GENERATED);
        itemModelGenerator.register (ModItems.STONE_MASTER_DIE_EMERALD, Models.GENERATED);
        itemModelGenerator.register (ModItems.STONE_MASTER_DIE_GOLD, Models.GENERATED);
        itemModelGenerator.register (ModItems.STONE_MASTER_DIE_NICKEL, Models.GENERATED);
        itemModelGenerator.register (ModItems.STONE_MASTER_DIE_NICKELGOLD, Models.GENERATED);
        itemModelGenerator.register (ModItems.STONE_MASTER_DIE_ZINC, Models.GENERATED);
        itemModelGenerator.register (ModItems.NETHERITE_MASTER_DIE_COPPER, Models.GENERATED);
        itemModelGenerator.register (ModItems.NETHERITE_MASTER_DIE_DIAMOND, Models.GENERATED);
        itemModelGenerator.register (ModItems.NETHERITE_MASTER_DIE_EMERALD, Models.GENERATED);
        itemModelGenerator.register (ModItems.NETHERITE_MASTER_DIE_GOLD, Models.GENERATED);
        itemModelGenerator.register (ModItems.NETHERITE_MASTER_DIE_NICKELGOLD, Models.GENERATED);
        itemModelGenerator.register (ModItems.NETHERITE_MASTER_DIE_ZINC, Models.GENERATED);
        itemModelGenerator.register (ModItems.NETHERITE_MASTER_DIE_NICKEL, Models.GENERATED);
        itemModelGenerator.register (ModItems.RAW_NICKEL, Models.GENERATED);
        itemModelGenerator.register (ModItems.RAW_ZINC, Models.GENERATED);

    }
}
