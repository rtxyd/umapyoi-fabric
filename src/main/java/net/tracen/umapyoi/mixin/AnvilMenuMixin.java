package net.tracen.umapyoi.mixin;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.DataSlot;
import net.minecraft.world.inventory.ItemCombinerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.tracen.umapyoi.events.AnvilUpdateCallback;

import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Map;

@Mixin(AnvilMenu.class)
public abstract class AnvilMenuMixin extends ItemCombinerMenu {
    public AnvilMenuMixin(@Nullable MenuType<?> type, int containerId, Inventory playerInventory, ContainerLevelAccess access) {
        super(type, containerId, playerInventory, access);
    }

    @Accessor("itemName")
    abstract String getItemName();

    @Accessor("cost")
    abstract DataSlot getCost_();

    @Accessor("repairItemCountCost")
    abstract void setRepairItemCountCost(int value);

    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isEmpty()Z", ordinal = 2), method = "createResult", cancellable = true)
    public void createResult(CallbackInfo callback) {
        var left = inputSlots.getItem(0);
        var right = inputSlots.getItem(1);
        Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(left);
        var baseCost = left.getBaseRepairCost() + (right.isEmpty() ? 0 : right.getBaseRepairCost());

        var result = AnvilUpdateCallback.invoke(left, right, getItemName(), baseCost, player);
        if (result.cancel)
            callback.cancel();

        if (!result.output.isEmpty()) {
            resultSlots.setItem(0, result.output);
            getCost_().set(result.cost);
            setRepairItemCountCost(result.materialCost);
            callback.cancel();
        }
    }
}
