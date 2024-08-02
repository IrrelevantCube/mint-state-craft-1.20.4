package net.irreleven.mintstate;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.irreleven.mintstate.screen.ModScreenHandlers;
import net.irreleven.mintstate.screen.TheCrucibleScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MintStateCraftClient implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		HandledScreens.register (ModScreenHandlers.THE_CRUCIBLE_SCREEN_HANDLER, TheCrucibleScreen::new);

	}
}