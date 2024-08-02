package net.irreleven.mintstate.screen;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.irreleven.mintstate.MintStateCraft;
import net.irreleven.mintstate.block.ModBlocks;
import net.irreleven.mintstate.block.entity.TheCrucibleBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;

public class ModScreenHandlers {
    public static final ScreenHandlerType<TheCrucibleScreenHandler> THE_CRUCIBLE_SCREEN_HANDLER =
            Registry.register (Registries.SCREEN_HANDLER, new Identifier (MintStateCraft.MOD_ID, "the_crucible"),
                    new ExtendedScreenHandlerType<> (TheCrucibleScreenHandler::new));

    public static void registerScreenHandlers() {
        MintStateCraft.LOGGER.info ("Registering Screen Handlers for " + MintStateCraft.MOD_ID);
    }
}
