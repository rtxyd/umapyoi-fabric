package net.tracen.umapyoi.compat.jei.recipes;

import net.minecraft.world.item.ItemStack;

import org.jetbrains.annotations.Unmodifiable;

import java.util.List;

public interface IJEISimpleRecipe {
    @Unmodifiable
    List<ItemStack> getInputs();

    @Unmodifiable
    List<ItemStack> getOutputs();
}
