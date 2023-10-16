package net.thepyrogod.pyromod.core.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.thepyrogod.pyromod.PyroMod;
import net.thepyrogod.pyromod.core.init.ItemInit;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> EXAMPLE_SMELTABLES = List.of(ItemInit.EXAMPLE_ITEM.get());//Do ,ItemInit.NAME.get() for more

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        oreSmelting(pWriter, EXAMPLE_SMELTABLES, RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM.get(), 0.25f, 200, "example_item");
        oreBlasting(pWriter, EXAMPLE_SMELTABLES, RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM.get(), 0.25f, 100, "example_item");

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemInit.EXAMPLE_ITEM.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ItemInit.EXAMPLE_ITEM.get())
                .unlockedBy(getHasName(ItemInit.EXAMPLE_ITEM.get()), has(ItemInit.EXAMPLE_ITEM.get()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemInit.WEED.get(), 3)
                .requires(ItemInit.WEED_MUSIC_DISC.get())
                .unlockedBy(getHasName(ItemInit.EXAMPLE_ITEM.get()), has(ItemInit.EXAMPLE_ITEM.get()))
                .save(pWriter);
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  PyroMod.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
