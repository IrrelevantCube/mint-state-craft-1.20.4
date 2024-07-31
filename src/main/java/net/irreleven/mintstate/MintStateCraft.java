package net.irreleven.mintstate;

import net.fabricmc.api.ModInitializer;

import net.irreleven.mintstate.block.ModBlocks;
import net.irreleven.mintstate.item.ModItemGroups;
import net.irreleven.mintstate.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MintStateCraft implements ModInitializer {
	public static final String MOD_ID = "mintstate";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups ();
		ModItems.registerModItems ();

		ModBlocks.registerModBlocks();
	}
}