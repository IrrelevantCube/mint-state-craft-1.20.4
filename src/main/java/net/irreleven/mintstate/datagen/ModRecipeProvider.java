package net.irreleven.mintstate.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.irreleven.mintstate.block.ModBlocks;
import net.irreleven.mintstate.item.ModItems;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> NICKEL_SMELTABLES = List.of (ModItems.RAW_NICKEL,
            ModBlocks.NICKEL_ORE, ModBlocks.DEEPSLATE_NICKEL_ORE);
    private static final List<ItemConvertible> ZINC_SMELTABLES = List.of (ModItems.RAW_ZINC,
            ModBlocks.ZINC_ORE, ModBlocks.DEEPSLATE_ZINC_ORE);
    public ModRecipeProvider(FabricDataOutput output) {
        super (output);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting (exporter, NICKEL_SMELTABLES, RecipeCategory.MISC, ModItems.NICKEL_INGOT,
                0.05f, 600, "nickel");
        offerBlasting (exporter, NICKEL_SMELTABLES, RecipeCategory.MISC, ModItems.NICKEL_INGOT,
                0.05f, 450, "nickel");
        offerSmelting (exporter, ZINC_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_INGOT,
                0.08f, 1000, "zinc");
        offerBlasting (exporter, ZINC_SMELTABLES, RecipeCategory.MISC, ModItems.ZINC_INGOT,
                0.08f, 800, "zinc");

        offer2x2CompactingRecipe (exporter, RecipeCategory.MISC, ModItems.COIN_AMALGAM,  ModItems.DIAMOND_MASTER_DIE_EMERALD);

        ShapedRecipeJsonBuilder.create (RecipeCategory.MISC, ModItems.DIAMOND_PLANCHET, 1)
                .pattern ("#C#")
                .pattern ("CDC")
                .pattern ("#C#")
                .input ('C', ModItems.COIN_AMALGAM)
                .input ('D', Items.DIAMOND)
                .input ('#', Items.AIR)
                .criterion (hasItem (Items.DIAMOND), conditionsFromItem (Items.DIAMOND))
                .criterion (hasItem (ModItems.COIN_AMALGAM), conditionsFromItem (ModItems.COIN_AMALGAM))
                .offerTo (exporter, new Identifier (getRecipeName (ModItems.DIAMOND_PLANCHET)));
        ShapedRecipeJsonBuilder.create (RecipeCategory.MISC, ModItems.COPPER_PLANCHET, 1)
                .pattern ("#C#")
                .pattern ("CDC")
                .pattern ("#C#")
                .input ('C', ModItems.COIN_AMALGAM)
                .input ('D', Items.COPPER_INGOT)
                .input ('#', Items.AIR)
                .criterion (hasItem (Items.COPPER_INGOT), conditionsFromItem (Items.COPPER_INGOT))
                .criterion (hasItem (ModItems.COIN_AMALGAM), conditionsFromItem (ModItems.COIN_AMALGAM))
                .offerTo (exporter, new Identifier (getRecipeName (ModItems.COPPER_PLANCHET)));
        ShapedRecipeJsonBuilder.create (RecipeCategory.MISC, ModItems.GOLD_PLANCHET, 1)
                .pattern ("#C#")
                .pattern ("CDC")
                .pattern ("#C#")
                .input ('C', ModItems.COIN_AMALGAM)
                .input ('D', Items.GOLD_INGOT)
                .input ('#', Items.AIR)
                .criterion (hasItem (Items.GOLD_INGOT), conditionsFromItem (Items.GOLD_INGOT))
                .criterion (hasItem (ModItems.COIN_AMALGAM), conditionsFromItem (ModItems.COIN_AMALGAM))
                .offerTo (exporter, new Identifier (getRecipeName (ModItems.GOLD_PLANCHET)));
        ShapedRecipeJsonBuilder.create (RecipeCategory.MISC, ModItems.NICKEL_PLANCHET, 1)
                .pattern ("#C#")
                .pattern ("CDC")
                .pattern ("#C#")
                .input ('C', ModItems.COIN_AMALGAM)
                .input ('D', ModItems.NICKEL_INGOT)
                .input ('#', Items.AIR)
                .criterion (hasItem (ModItems.NICKEL_INGOT), conditionsFromItem (ModItems.NICKEL_INGOT))
                .criterion (hasItem (ModItems.COIN_AMALGAM), conditionsFromItem (ModItems.COIN_AMALGAM))
                .offerTo (exporter, new Identifier (getRecipeName (ModItems.NICKEL_PLANCHET)));
        ShapedRecipeJsonBuilder.create (RecipeCategory.MISC, ModItems.ZINC_PLANCHET, 1)
                .pattern ("#C#")
                .pattern ("CDC")
                .pattern ("#C#")
                .input ('C', ModItems.COIN_AMALGAM)
                .input ('D', ModItems.ZINC_INGOT)
                .input ('#', Items.AIR)
                .criterion (hasItem (ModItems.ZINC_INGOT), conditionsFromItem (ModItems.ZINC_INGOT))
                .criterion (hasItem (ModItems.COIN_AMALGAM), conditionsFromItem (ModItems.COIN_AMALGAM))
                .offerTo (exporter, new Identifier (getRecipeName (ModItems.ZINC_PLANCHET)));
    }
}
