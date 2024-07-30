package net.irreleven.mintstate.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.irreleven.mintstate.MintStateCraft;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item EMERALD_PLANCHET = registerItem ("emerald_planchet", new Item(new FabricItemSettings ()));
    public static final Item DIAMOND_PLANCHET = registerItem ("diamond_planchet", new Item(new FabricItemSettings ()));
    public static final Item GOLD_PLANCHET = registerItem ("gold_planchet", new Item(new FabricItemSettings ()));
    public static final Item COPPER_PLANCHET = registerItem ("copper_planchet", new Item(new FabricItemSettings ()));
    public static final Item ZINC_PLANCHET = registerItem ("zinc_planchet", new Item(new FabricItemSettings ()));
    public static final Item NICKEL_PLANCHET = registerItem ("nickel_planchet", new Item(new FabricItemSettings ()));
    public static final Item NICKELGOLD_PLANCHET = registerItem ("nickelgold_planchet", new Item(new FabricItemSettings ()));

    public static final Item DIAMOND_MASTER_DIE_COPPER = registerItem ("diamond_master_die_copper", new Item(new FabricItemSettings ()));
    public static final Item IRON_MASTER_DIE_COPPER = registerItem ("iron_master_die_copper", new Item(new FabricItemSettings ()));
    public static final Item NETHERITE_MASTER_DIE_COPPER = registerItem ("netherite_master_die_copper", new Item(new FabricItemSettings ()));
    public static final Item STONE_MASTER_DIE_COPPER = registerItem ("stone_master_die_copper", new Item(new FabricItemSettings ()));

    public static final Item DIAMOND_MASTER_DIE_EMERALD = registerItem ("diamond_master_die_emerald", new Item(new FabricItemSettings ()));
    public static final Item IRON_MASTER_DIE_EMERALD = registerItem ("iron_master_die_emerald", new Item(new FabricItemSettings ()));
    public static final Item NETHERITE_MASTER_DIE_EMERALD = registerItem ("netherite_master_die_emerald", new Item(new FabricItemSettings ()));
    public static final Item STONE_MASTER_DIE_EMERALD = registerItem ("stone_master_die_emerald", new Item(new FabricItemSettings ()));

    public static final Item DIAMOND_MASTER_DIE_GOLD = registerItem ("diamond_master_die_gold", new Item(new FabricItemSettings ()));
    public static final Item IRON_MASTER_DIE_GOLD = registerItem ("iron_master_die_gold", new Item(new FabricItemSettings ()));
    public static final Item NETHERITE_MASTER_DIE_GOLD = registerItem ("netherite_master_die_gold", new Item(new FabricItemSettings ()));
    public static final Item STONE_MASTER_DIE_GOLD = registerItem ("stone_master_die_gold", new Item(new FabricItemSettings ()));

    public static final Item DIAMOND_MASTER_DIE_DIAMOND = registerItem ("diamond_master_die_diamond", new Item(new FabricItemSettings ()));
    public static final Item IRON_MASTER_DIE_DIAMOND = registerItem ("iron_master_die_diamond", new Item(new FabricItemSettings ()));
    public static final Item NETHERITE_MASTER_DIE_DIAMOND = registerItem ("netherite_master_die_diamond", new Item(new FabricItemSettings ()));
    public static final Item STONE_MASTER_DIE_DIAMOND = registerItem ("stone_master_die_diamond", new Item(new FabricItemSettings ()));

    public static final Item DIAMOND_MASTER_DIE_ZINC = registerItem ("diamond_master_die_zinc", new Item(new FabricItemSettings ()));
    public static final Item IRON_MASTER_DIE_ZINC = registerItem ("iron_master_die_zinc", new Item(new FabricItemSettings ()));
    public static final Item NETHERITE_MASTER_DIE_ZINC = registerItem ("netherite_master_die_zinc", new Item(new FabricItemSettings ()));
    public static final Item STONE_MASTER_DIE_ZINC = registerItem ("stone_master_die_zinc", new Item(new FabricItemSettings ()));

    public static final Item DIAMOND_MASTER_DIE_NICKEL = registerItem ("diamond_master_die_nickel", new Item(new FabricItemSettings ()));
    public static final Item IRON_MASTER_DIE_NICKEL = registerItem ("iron_master_die_nickel", new Item(new FabricItemSettings ()));
    public static final Item NETHERITE_MASTER_DIE_NICKEL = registerItem ("netherite_master_die_nickel", new Item(new FabricItemSettings ()));
    public static final Item STONE_MASTER_DIE_NICKEL = registerItem ("stone_master_die_nickel", new Item(new FabricItemSettings ()));

    public static final Item DIAMOND_MASTER_DIE_NICKELGOLD = registerItem ("diamond_master_die_nickelgold", new Item(new FabricItemSettings ()));
    public static final Item IRON_MASTER_DIE_NICKELGOLD = registerItem ("iron_master_die_nickelgold", new Item(new FabricItemSettings ()));
    public static final Item NETHERITE_MASTER_DIE_NICKELGOLD = registerItem ("netherite_master_die_nickelgold", new Item(new FabricItemSettings ()));
    public static final Item STONE_MASTER_DIE_NICKELGOLD = registerItem ("stone_master_die_nickelgold", new Item(new FabricItemSettings ()));

    private static void addItemsToSearchTabItemGroup (FabricItemGroupEntries entries) {
        entries.add(EMERALD_PLANCHET);
        entries.add(DIAMOND_PLANCHET);
        entries.add(GOLD_PLANCHET);
        entries.add(COPPER_PLANCHET);
        entries.add(ZINC_PLANCHET);
        entries.add(NICKEL_PLANCHET);
        entries.add(NICKELGOLD_PLANCHET);


        entries.add(DIAMOND_MASTER_DIE_COPPER);
        entries.add(IRON_MASTER_DIE_COPPER);
        entries.add(NETHERITE_MASTER_DIE_COPPER);
        entries.add(STONE_MASTER_DIE_COPPER);

        entries.add(DIAMOND_MASTER_DIE_EMERALD);
        entries.add(IRON_MASTER_DIE_EMERALD);
        entries.add(NETHERITE_MASTER_DIE_EMERALD);
        entries.add(STONE_MASTER_DIE_EMERALD);

        entries.add(DIAMOND_MASTER_DIE_DIAMOND);
        entries.add(IRON_MASTER_DIE_DIAMOND);
        entries.add(NETHERITE_MASTER_DIE_DIAMOND);
        entries.add(STONE_MASTER_DIE_DIAMOND);

        entries.add(DIAMOND_MASTER_DIE_GOLD);
        entries.add(IRON_MASTER_DIE_GOLD);
        entries.add(NETHERITE_MASTER_DIE_GOLD);
        entries.add(STONE_MASTER_DIE_GOLD);

        entries.add(DIAMOND_MASTER_DIE_ZINC);
        entries.add(IRON_MASTER_DIE_ZINC);
        entries.add(NETHERITE_MASTER_DIE_ZINC);
        entries.add(STONE_MASTER_DIE_ZINC);

        entries.add(DIAMOND_MASTER_DIE_NICKEL);
        entries.add(IRON_MASTER_DIE_NICKEL);
        entries.add(NETHERITE_MASTER_DIE_NICKEL);
        entries.add(STONE_MASTER_DIE_NICKEL);

        entries.add(DIAMOND_MASTER_DIE_NICKELGOLD);
        entries.add(IRON_MASTER_DIE_NICKELGOLD);
        entries.add(NETHERITE_MASTER_DIE_NICKELGOLD);
        entries.add(STONE_MASTER_DIE_NICKELGOLD);

    }

    private static Item registerItem(String name, Item item) {
        return Registry.register (Registries.ITEM, new Identifier (MintStateCraft.MOD_ID, name), item);
    }

    public static void registerModItems() {
        MintStateCraft.LOGGER.info ("Registering Mod Items For " + MintStateCraft.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent (ItemGroups.SEARCH).register (ModItems::addItemsToSearchTabItemGroup);
    }
}
