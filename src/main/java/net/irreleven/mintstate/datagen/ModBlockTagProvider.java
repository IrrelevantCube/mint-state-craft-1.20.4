package net.irreleven.mintstate.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.irreleven.mintstate.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super (output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder (BlockTags.PICKAXE_MINEABLE)
                .add (ModBlocks.DEEPSLATE_NICKEL_ORE)
                .add (ModBlocks.NICKEL_ORE)
                .add (ModBlocks.DEEPSLATE_ZINC_ORE)
                .add (ModBlocks.ZINC_ORE);
        getOrCreateTagBuilder (BlockTags.NEEDS_IRON_TOOL)
                .add (ModBlocks.DEEPSLATE_NICKEL_ORE)
                .add (ModBlocks.NICKEL_ORE)
                .add (ModBlocks.DEEPSLATE_ZINC_ORE)
                .add (ModBlocks.ZINC_ORE);

    }
}
