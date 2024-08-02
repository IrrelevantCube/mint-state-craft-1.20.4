package net.irreleven.mintstate.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.irreleven.mintstate.MintStateCraft;
import net.irreleven.mintstate.block.ModBlocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<TheCrucibleBlockEntity> THE_CRUCIBLE_BLOCK_ENTITY =
            Registry.register (Registries.BLOCK_ENTITY_TYPE, new Identifier (MintStateCraft.MOD_ID, "the_crucible_be"),
                    FabricBlockEntityTypeBuilder.create (TheCrucibleBlockEntity::new,
                            ModBlocks.THE_CRUCIBLE).build ());

    public static void registerBlockEntities() {
        MintStateCraft.LOGGER.info ("Registering Block Entities for " + MintStateCraft.MOD_ID);
    }


}
