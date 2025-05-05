package team.steelcode.awakenings.data.generators;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.setup.registries.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Awakenings.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        super.simpleBlockWithItem(ModBlocks.ALUMINUM_BLOCK.get(), cubeAll(ModBlocks.ALUMINUM_BLOCK.get()));
        super.simpleBlockWithItem(ModBlocks.ALUMINUM_ORE.get(), cubeAll(ModBlocks.ALUMINUM_ORE.get()));
    }
}
