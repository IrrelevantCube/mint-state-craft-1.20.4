package net.irreleven.mintstate.world;

import net.irreleven.mintstate.MintStateCraft;
import net.irreleven.mintstate.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> NICKEL_ORE_KEY = registerKey("nickel_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ZINC_ORE_KEY = registerKey("zinc_ore");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest (BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest (BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreFeatureConfig.Target> overworldZincOres =
                List.of (OreFeatureConfig.createTarget (stoneReplacables, ModBlocks.ZINC_ORE.getDefaultState ()),
                        OreFeatureConfig.createTarget (deepslateReplacables, ModBlocks.DEEPSLATE_ZINC_ORE.getDefaultState ()));
        List<OreFeatureConfig.Target> overworldNickelOres =
                List.of (OreFeatureConfig.createTarget (stoneReplacables, ModBlocks.NICKEL_ORE.getDefaultState ()),
                        OreFeatureConfig.createTarget (deepslateReplacables, ModBlocks.DEEPSLATE_NICKEL_ORE.getDefaultState ()));

        register(context, NICKEL_ORE_KEY, Feature.ORE, new OreFeatureConfig (overworldNickelOres, 19));
        register(context, ZINC_ORE_KEY, Feature.ORE, new OreFeatureConfig (overworldZincOres, 19));
    }
    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier (MintStateCraft.MOD_ID, name));

    }
    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register (key, new ConfiguredFeature<> (feature, configuration));
    }

}
