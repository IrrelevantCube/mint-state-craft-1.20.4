package net.irreleven.mintstate.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.irreleven.mintstate.MintStateCraft;
import net.irreleven.mintstate.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup MINT_STATE_COINS = Registry.register (Registries.ITEM_GROUP, new Identifier (MintStateCraft.MOD_ID, "mint_state_coins"), FabricItemGroup.builder ().displayName (Text.translatable ("itemgroup.mint_state_coins")).icon (() -> new ItemStack (ModItems.EMERALD_PLANCHET)).entries ((displayContext, entries) -> {
        entries.add (ModItems.EMERALD_PLANCHET);
        entries.add (ModItems.DIAMOND_PLANCHET);
        entries.add (ModItems.GOLD_PLANCHET);
        entries.add (ModItems.COPPER_PLANCHET);
        entries.add (ModItems.ZINC_PLANCHET);
        entries.add (ModItems.NICKEL_PLANCHET);
        entries.add (ModItems.NICKELGOLD_PLANCHET);

        entries.add(ModItems.DIAMOND_MASTER_DIE_COPPER);
        entries.add(ModItems.IRON_MASTER_DIE_COPPER);
        entries.add(ModItems.NETHERITE_MASTER_DIE_COPPER);
        entries.add(ModItems.STONE_MASTER_DIE_COPPER);

        entries.add(ModItems.DIAMOND_MASTER_DIE_EMERALD);
        entries.add(ModItems.IRON_MASTER_DIE_EMERALD);
        entries.add(ModItems.NETHERITE_MASTER_DIE_EMERALD);
        entries.add(ModItems.STONE_MASTER_DIE_EMERALD);

        entries.add(ModItems.DIAMOND_MASTER_DIE_DIAMOND);
        entries.add(ModItems.IRON_MASTER_DIE_DIAMOND);
        entries.add(ModItems.NETHERITE_MASTER_DIE_DIAMOND);
        entries.add(ModItems.STONE_MASTER_DIE_DIAMOND);

        entries.add(ModItems.DIAMOND_MASTER_DIE_GOLD);
        entries.add(ModItems.IRON_MASTER_DIE_GOLD);
        entries.add(ModItems.NETHERITE_MASTER_DIE_GOLD);
        entries.add(ModItems.STONE_MASTER_DIE_GOLD);

        entries.add(ModItems.DIAMOND_MASTER_DIE_ZINC);
        entries.add(ModItems.IRON_MASTER_DIE_ZINC);
        entries.add(ModItems.NETHERITE_MASTER_DIE_ZINC);
        entries.add(ModItems.STONE_MASTER_DIE_ZINC);

        entries.add(ModItems.DIAMOND_MASTER_DIE_NICKEL);
        entries.add(ModItems.IRON_MASTER_DIE_NICKEL);
        entries.add(ModItems.NETHERITE_MASTER_DIE_NICKEL);
        entries.add(ModItems.STONE_MASTER_DIE_NICKEL);

        entries.add(ModItems.COIN_AMALGAM);

        entries.add(ModItems.DIAMOND_MASTER_DIE_NICKELGOLD);
        entries.add(ModItems.IRON_MASTER_DIE_NICKELGOLD);
        entries.add(ModItems.NETHERITE_MASTER_DIE_NICKELGOLD);
        entries.add(ModItems.STONE_MASTER_DIE_NICKELGOLD);






    }).build ());
    public static final ItemGroup MINT_STATE_NATURE = Registry.register (Registries.ITEM_GROUP, new Identifier (MintStateCraft.MOD_ID, "mint_state_nature"), FabricItemGroup.builder ().displayName (Text.translatable ("itemgroup.mint_state_nature")).icon (() -> new ItemStack (ModItems.RAW_NICKEL)).entries ((displayContext, entries) -> {
        entries.add (ModItems.ZINC_INGOT);
        entries.add (ModItems.RAW_ZINC);
        entries.add (ModItems.NICKEL_INGOT);
        entries.add (ModItems.RAW_NICKEL);

        entries.add (ModBlocks.DEEPSLATE_NICKEL_ORE);
        entries.add (ModBlocks.DEEPSLATE_ZINC_ORE);
        entries.add (ModBlocks.ZINC_ORE);
        entries.add (ModBlocks.NICKEL_ORE);

    }).build ());

    public static void registerItemGroups() {
        MintStateCraft.LOGGER.info ("Registering Item Groups for " + MintStateCraft.MOD_ID);
    }
}
