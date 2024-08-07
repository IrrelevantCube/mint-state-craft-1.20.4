package net.irreleven.mintstate;

import net.fabricmc.api.ModInitializer;

import net.irreleven.mintstate.block.ModBlocks;
import net.irreleven.mintstate.block.entity.ModBlockEntities;
import net.irreleven.mintstate.item.ModItemGroups;
import net.irreleven.mintstate.item.ModItems;
import net.irreleven.mintstate.recipe.ModRecipes;
import net.irreleven.mintstate.screen.ModScreenHandlers;
import net.irreleven.mintstate.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MintStateCraft implements ModInitializer {
	public static final String MOD_ID = "mintstate";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups ();
		ModItems.registerModItems ();
		ModWorldGeneration.generateModWorldGen ();

		ModBlockEntities.registerBlockEntities ();

		ModRecipes.registerRecipes ();

		ModBlocks.registerModBlocks();
		ModScreenHandlers.registerScreenHandlers ();
	}
}