package team.steelcode.awakenings.data.generators;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.BlastingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.SmeltingRecipe;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.setup.registries.ModBlocks;
import team.steelcode.awakenings.setup.registries.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    protected ModRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
        super(registries, output);
    }

    @Override
    protected void buildRecipes() {

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.MISC,
                        ModItems.ALUMINUM_INGOT.toStack(1))
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', ModItems.ALUMINUM_NUGGET.get())
                .unlockedBy("has_aluminum_nugget", has(ModItems.ALUMINUM_NUGGET.get()))
                .save(output, "aluminum_ingot_from_nugget");

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.ALUMINUM_BLOCK.toStack(1))
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ModItems.ALUMINUM_INGOT.get())
                .unlockedBy("has_aluminum_ingot", has(ModItems.ALUMINUM_INGOT.get()))
                .save(output, "aluminum_block_from_ingot");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM),
                    RecipeCategory.MISC,
                    ModItems.ALUMINUM_INGOT.toStack(9))
                .requires(ModBlocks.ALUMINUM_BLOCK)
                .unlockedBy("has_aluminum_block", has(ModBlocks.ALUMINUM_BLOCK))
                .save(output, "aluminum_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.MISC,
                        ModItems.ALUMINUM_NUGGET.toStack(9))
                .requires(ModItems.ALUMINUM_INGOT)
                .unlockedBy("has_aluminum_ingot", has(ModItems.ALUMINUM_INGOT))
                .save(output, "aluminum_nugget_from_ingot");


        super.oreCooking(RecipeSerializer.SMELTING_RECIPE,
                SmeltingRecipe::new,
                List.of(ModItems.ALUMINUM_RAW),
                RecipeCategory.MISC,
                ModItems.ALUMINUM_INGOT,
                50,
                20 * 20,
                "aluminum",
                "_from_smelting"
                );

        super.oreCooking(RecipeSerializer.BLASTING_RECIPE,
                BlastingRecipe::new,
                List.of(ModItems.ALUMINUM_RAW),
                RecipeCategory.MISC,
                ModItems.ALUMINUM_INGOT,
                100,
                5 * 20,
                "aluminum",
                "_from_blasting"
        );


        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.MISC,
                        ModItems.ALUMINUM_PLATE.get())
                .pattern("BIB")
                .pattern("INI")
                .pattern(" I ")
                .define('B', ModBlocks.ALUMINUM_BLOCK.get())
                .define('I', ModItems.ALUMINUM_INGOT.get())
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy("has_aluminum_plate", has(ModItems.ALUMINUM_PLATE.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM),
                        RecipeCategory.MISC,
                        ModItems.NETHERITE_PLATE.get())
                .pattern("BPB")
                .pattern("NPN")
                .pattern(" N ")
                .define('B', Blocks.NETHERITE_BLOCK)
                .define('P', ModItems.ALUMINUM_PLATE.get())
                .define('N', Items.NETHERITE_INGOT)
                .unlockedBy("has_netherite_plate", has(ModItems.NETHERITE_PLATE.get()))
                .save(output);

        ShapedRecipeBuilder.shaped(this.registries.lookupOrThrow(Registries.ITEM), RecipeCategory.MISC, ModItems.SWORD_SHEATH.toStack(1))
                .pattern("P P")
                .pattern("P P")
                .pattern(" P ")
                .define('P', ModItems.ALUMINUM_PLATE.get())
                .unlockedBy("has_sword_sheat", has(ModItems.SWORD_SHEATH.get()))
                .save(output);

        SmithingTransformRecipeBuilder.smithing(
                    Ingredient.of(ModItems.NETHERITE_PLATE.get()),
                    Ingredient.of(Items.NETHERITE_SWORD),
                    Ingredient.of(ModItems.SWORD_SHEATH.get()),
                    RecipeCategory.COMBAT,
                    ModItems.NIGHTBLOOD_SHEATHED.get())
                .unlocks("has_nightblood_sheath_smithing", has(ModItems.SWORD_SHEATH.get()))
                .save(output, getItemName(ModItems.NIGHTBLOOD_SHEATHED.get()) + "_smithing");
    }

    public static class Runner extends RecipeProvider.Runner {

        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> registries) {
            super(packOutput, registries);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider registries, RecipeOutput output) {
            return new ModRecipeProvider(registries, output);
        }

        @Override
        public String getName() {
            return "Awakenings Recipe Generator";
        }
    }
}
