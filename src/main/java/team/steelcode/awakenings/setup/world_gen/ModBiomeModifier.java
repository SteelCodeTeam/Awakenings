package team.steelcode.awakenings.setup.world_gen;

import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import team.steelcode.awakenings.Awakenings;

public class ModBiomeModifier {

    public static ResourceKey<BiomeModifier> ALUMINUM_ORE = registerKey("add_aluminum_ore");

    private static ResourceKey<BiomeModifier> registerKey(String key) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS,
                ResourceLocation.fromNamespaceAndPath(Awakenings.MODID, key));
    }

    public static void bootstrap(BootstrapContext<BiomeModifier> context) {
        HolderSet.Named<Biome> biome = context.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_OVERWORLD);

        HolderSet.Direct<PlacedFeature> placedFeature = HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(ModPlacedFeatures.ALUMINUM_KEY));

        GenerationStep.Decoration genStep = GenerationStep.Decoration.UNDERGROUND_ORES;

        context.register(ALUMINUM_ORE, new BiomeModifiers.AddFeaturesBiomeModifier(biome, placedFeature, genStep));

    }


}
