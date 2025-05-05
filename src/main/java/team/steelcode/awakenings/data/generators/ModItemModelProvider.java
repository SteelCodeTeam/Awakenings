package team.steelcode.awakenings.data.generators;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.setup.registries.ModItems;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Awakenings.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        super.basicItem(ModItems.ALUMINUM_INGOT.get());
        super.basicItem(ModItems.ALUMINUM_NUGGET.get());
        super.basicItem(ModItems.ALUMINUM_RAW.get());

        super.basicItem(ModItems.ALUMINUM_PLATE.get());
        super.basicItem(ModItems.NETHERITE_PLATE.get());
        super.handheldItem(ModItems.NIGHTBLOOD.get());
        super.basicItem(ModItems.SWORD_SHEATH.get());
    }
}
