package team.steelcode.awakenings.setup.world_gen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import team.steelcode.awakenings.Awakenings;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> ALUMINUM_KEY = registerKey("aluminum_ore");


    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        Holder.Reference<ConfiguredFeature<?, ?>> configFeatures =
                context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(ModConfiguredFeatures.ALUMINUM_KEY);


        context.register(ALUMINUM_KEY, new PlacedFeature(configFeatures,
                ModOrePlacement.commonOrePlacement(12,
                        HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-64),
                                VerticalAnchor.absolute(72)
                        )
                    )
                )
            );
    }


    private static ResourceKey<PlacedFeature> registerKey(String key) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(Awakenings.MODID, key));
    }
}
