package net.irreleven.mintstate.world;

import net.irreleven.mintstate.MintStateCraft;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;

import java.util.List;

import static net.irreleven.mintstate.world.ModConfiguredFeatures.*;

public class ModPlacedFeatures {
    public static final RegistryKey<PlacedFeature> ZINC_ORE_PLACED_KEY = registerKey("zinc_ore_placed");
    public static final RegistryKey<PlacedFeature> NICKEL_ORE_PLACED_KEY = registerKey("nickel_ore_placed");

    public static void bootstrap(Registerable<PlacedFeature> context) {
        var configuredFeatureRegistryLookup = context.getRegistryLookup (RegistryKeys.CONFIGURED_FEATURE);

        register(context, NICKEL_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow (NICKEL_ORE_KEY),
                ModOrePlacement.modifiersWithCount (12,
                        HeightRangePlacementModifier.uniform (YOffset.fixed (-50), YOffset.fixed (120))));

        register(context, ZINC_ORE_PLACED_KEY, configuredFeatureRegistryLookup.getOrThrow (ZINC_ORE_KEY),
                ModOrePlacement.modifiersWithCount (12,
                        HeightRangePlacementModifier.trapezoid (YOffset.fixed (-63), YOffset.fixed (40))));
    }
    public static RegistryKey<PlacedFeature>registerKey (String name) {
        return RegistryKey.of (RegistryKeys.PLACED_FEATURE, new Identifier (MintStateCraft.MOD_ID, name));

    }
    public static void register(Registerable<PlacedFeature> context, RegistryKey<PlacedFeature> key, RegistryEntry<ConfiguredFeature<?, ?>> configuration,
                                List<PlacementModifier> modifiers) {
        context.register (key, new PlacedFeature (configuration, List.copyOf (modifiers)));
    }
}
