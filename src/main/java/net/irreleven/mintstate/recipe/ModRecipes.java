package net.irreleven.mintstate.recipe;

import net.irreleven.mintstate.MintStateCraft;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {
    public static void registerRecipes() {
        Registry.register (Registries.RECIPE_SERIALIZER, new Identifier (MintStateCraft.MOD_ID, TheCrucibleRecipe.Serializer.ID),
                TheCrucibleRecipe.Serializer.INSTANCE);
        Registry.register (Registries.RECIPE_TYPE, new Identifier (MintStateCraft.MOD_ID, TheCrucibleRecipe.Type.ID),
                TheCrucibleRecipe.Type.INSTANCE);
    }
}
