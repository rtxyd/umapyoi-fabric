package net.tracen.umapyoi.api;

import net.minecraft.core.Registry;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.tracen.umapyoi.item.UmaSoulItem;
import net.tracen.umapyoi.registry.training.card.SupportCard;
import net.tracen.umapyoi.registry.umadata.UmaData;
import net.tracen.umapyoi.utils.ClientUtils;

import dev.emi.trinkets.api.TrinketsApi;

public class UmapyoiAPI {
    public static ItemStack getUmaSoul(LivingEntity entity) {
        var compOpt = TrinketsApi.getTrinketComponent(entity);
        if (compOpt.isPresent()) {
            var comp = compOpt.get();
            var entityInventory = comp.getInventory();
            if (entityInventory.containsKey("umapyoi")) {
                var group = entityInventory.get("umapyoi");
                if (group.containsKey("uma_soul")) {
                    var inventory = group.get("uma_soul");
                    if (inventory.getContainerSize() <= 0)
                        return ItemStack.EMPTY;

                    var stack = inventory.getItem(0);
                    if (stack.getItem() instanceof UmaSoulItem)
                        return stack;
                }
            }
        }
        return ItemStack.EMPTY;
    }

    public static ItemStack getUmaSuit(LivingEntity entity) {
        var compOpt = TrinketsApi.getTrinketComponent(entity);
        if (compOpt.isPresent()) {
            var comp = compOpt.get();
            var entityInventory = comp.getInventory();
            if (entityInventory.containsKey("umapyoi")) {
                var group = entityInventory.get("umapyoi");
                if (group.containsKey("uma_suit")) {
                    var inventory = group.get("uma_suit");
                    if (inventory.getContainerSize() <= 0)
                        return ItemStack.EMPTY;

                    var stack = inventory.getItem(0);
                    if (stack.getItem() instanceof UmaSoulItem)
                        return stack;
                }
            }
        }
        return ItemStack.EMPTY;
    }

    public static boolean isUmaSoulRendering(LivingEntity player) {
        // i dunno?
        return !getUmaSoul(player).isEmpty();
    }

    public static boolean isUmaSuitRendering(LivingEntity player) {
        // i dunno???
        return !getUmaSuit(player).isEmpty();
    }

    public static Registry<UmaData> getUmaDataRegistry(Level level) {
        if (level.isClientSide())
            return ClientUtils.getClientUmaDataRegistry();
        return level.registryAccess().registryOrThrow(UmaData.REGISTRY_KEY);
    }

    public static Registry<SupportCard> getSupportCardRegistry(Level level) {
        if (level.isClientSide())
            return ClientUtils.getClientSupportCardRegistry();
        return level.registryAccess().registryOrThrow(SupportCard.REGISTRY_KEY);
    }

}
