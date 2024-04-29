package com.uraneptus.snowpig.core.data.server;

import com.uraneptus.snowpig.core.registry.SPItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.concurrent.CompletableFuture;

import static com.uraneptus.snowpig.core.data.SPDatagenUtil.*;

@SuppressWarnings("SameParameterValue")
public class SPRecipeProvider extends RecipeProvider {

    public SPRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider);
    }

    @Override
    protected void buildRecipes(RecipeOutput pRecipeOutput) {
        cookingRecipes(SPItems.FROZEN_PORKCHOP.get(), Items.PORKCHOP, 0.2F, "porkchop_recipe", pRecipeOutput);
        //modLoadedCookingRecipes(ModIntegrations.FD_MODID, SPItems.FROZEN_HAM.get(), ModIntegrations.getHam(), 0.2F, "ham_recipe", pRecipeOutput);

    }

    private static void cookingRecipes(ItemLike ingredient, ItemLike result, float experience, String group, RecipeOutput pRecipeOutput) {
        String resultName = getItemName(result);

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200).group(group)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pRecipeOutput, smeltingPath(resultName));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600).group(group)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pRecipeOutput, campfire_cookingPath(resultName + "_from_campfire_cooking"));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100).group(group)
                .unlockedBy(getHasName(ingredient), has(ingredient))
                .save(pRecipeOutput, smokingPath(resultName + "_from_smoking"));
    }

    /*
    private static void modLoadedCookingRecipes(String modId, ItemLike ingredient, ItemLike result, float experience, String group, RecipeOutput pRecipeOutput) {
        String resultName = getItemName(result);

        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(modId))
                .addRecipe(consumer1 -> SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200).group(group)
                        .unlockedBy(getHasName(ingredient), has(ingredient))
                        .save(consumer1, SnowPigMod.modPrefix(getItemName(result))))
                .build(pRecipeOutput, smeltingPath(resultName));
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(modId))
                .addRecipe(consumer1 -> SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600).group(group)
                        .unlockedBy(getHasName(ingredient), has(ingredient))
                        .save(consumer1, SnowPigMod.modPrefix(getItemName(result))))
                .build(pRecipeOutput, campfire_cookingPath(resultName + "_from_campfire_cooking"));
        ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition(modId))
                .addRecipe(consumer1 -> SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100).group(group)
                        .unlockedBy(getHasName(ingredient), has(ingredient))
                        .save(consumer1, SnowPigMod.modPrefix(getItemName(result))))
                .build(pRecipeOutput, smokingPath(resultName + "_from_smoking"));
    }

     */
}
