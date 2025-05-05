package team.steelcode.awakenings.setup.world_gen;

import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModOrePlacement {
    public static List<PlacementModifier> commonOrePlacement(int count, HeightRangePlacement placement) {
        return List.of(CountPlacement.of(count), InSquarePlacement.spread(), placement, BiomeFilter.biome());
    }
}
