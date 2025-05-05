package team.steelcode.awakenings.data.generators;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import team.steelcode.awakenings.setup.registries.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagsProvider extends ItemTagsProvider {
    public ModItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(ItemTags.SWORDS)
                .add(ModItems.NIGHTBLOOD.get())
                .add(ModItems.NIGHTBLOOD_SHEATHED.get());

        tag(ItemTags.SWORD_ENCHANTABLE)
                .add(ModItems.NIGHTBLOOD.get())
                .add(ModItems.NIGHTBLOOD_SHEATHED.get());
    }
}
