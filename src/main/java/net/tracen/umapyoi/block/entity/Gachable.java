package net.tracen.umapyoi.block.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.function.Predicate;

public interface Gachable {
    public Predicate<? super ResourceLocation> getFilter(Level level, ItemStack input);
}
