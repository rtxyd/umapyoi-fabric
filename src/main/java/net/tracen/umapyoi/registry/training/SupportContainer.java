package net.tracen.umapyoi.registry.training;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tracen.umapyoi.utils.GachaRanking;

import java.util.List;
import java.util.function.Predicate;

public interface SupportContainer {
    boolean isConsumable(Level level, ItemStack stack);

    GachaRanking getSupportLevel(Level level, ItemStack stack);

    SupportType getSupportType(Level level, ItemStack stack);

    List<SupportStack> getSupports(Level level, ItemStack stack);

    Predicate<ItemStack> canSupport(Level level, ItemStack stack);
}
