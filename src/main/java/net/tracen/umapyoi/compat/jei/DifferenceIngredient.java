package net.tracen.umapyoi.compat.jei;

import net.fabricmc.fabric.api.recipe.v1.ingredient.CustomIngredient;
import net.fabricmc.fabric.api.recipe.v1.ingredient.CustomIngredientSerializer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.Arrays;
import java.util.List;

import it.unimi.dsi.fastutil.ints.IntList;

public class DifferenceIngredient implements CustomIngredient {
    private final Ingredient base;
    private final Ingredient subtracted;
    private List<ItemStack> filteredMatchingStacks;
    private IntList packedMatchingStacks;

    public static DifferenceIngredient of(Ingredient base, Ingredient subtracted) {
        return new DifferenceIngredient(base, subtracted);
    }

    private DifferenceIngredient(Ingredient base, Ingredient subtracted) {
        this.base = base;
        this.subtracted = subtracted;
    }

    @Override
    public boolean test(ItemStack stack) {
        if (stack == null || stack.isEmpty())
            return false;
        return base.test(stack) && !subtracted.test(stack);
    }

    @Override
    public List<ItemStack> getMatchingStacks() {
        if (this.filteredMatchingStacks == null)
            this.filteredMatchingStacks = Arrays.stream(base.getItems())
                    .filter(stack -> !subtracted.test(stack))
                    .toList();
        return filteredMatchingStacks;
    }

    @Override
    public boolean requiresTesting() {
        return true;
    }

    @Override
    public CustomIngredientSerializer<?> getSerializer() {
        return null;
    }
}