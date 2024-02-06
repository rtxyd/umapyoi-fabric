package net.tracen.umapyoi.events.handler;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.tracen.umapyoi.api.UmapyoiAPI;
import net.tracen.umapyoi.data.tag.UmapyoiItemTags;
import net.tracen.umapyoi.events.AnvilUpdateCallback;
import net.tracen.umapyoi.item.ItemRegistry;
import net.tracen.umapyoi.registry.UmaDataRegistry;
import net.tracen.umapyoi.utils.GachaRanking;

public class AnvilEvents {
    public static AnvilUpdateCallback.Result onAnvilEgg(ItemStack soul, ItemStack material, String itemName, int baseCost, Player player) {
        AnvilUpdateCallback.Result result;
        if ((result = venusParkSoul(soul, material, itemName, baseCost, player)) != null) return result;
        if ((result = zhengSoul(soul, material, itemName, baseCost, player)) != null) return result;
        if ((result = dumnheintSoul(soul, material, itemName, baseCost, player)) != null) return result;
        if ((result = darleySoul(soul, material, itemName, baseCost, player)) != null) return result;
        if ((result = byerleySoul(soul, material, itemName, baseCost, player)) != null) return result;
        if ((result = godolphinSoul(soul, material, itemName, baseCost, player)) != null) return result;
        return AnvilUpdateCallback.Result.empty();
    }

    public static AnvilUpdateCallback.Result venusParkSoul(ItemStack soul, ItemStack material, String itemName, int baseCost, Player player) {
        if(!soul.is(ItemRegistry.BLANK_UMA_SOUL.get())) return null;
        if(!material.is(UmapyoiItemTags.BREAD)) return null;
        if(!itemName.equalsIgnoreCase("vivelafrance")) return null;
        
        var registry = UmapyoiAPI.getUmaDataRegistry(player.level());
        ResourceLocation name = soul.getOrCreateTag().contains("name") ?
                ResourceLocation.tryParse(soul.getOrCreateTag().getString("name")) : UmaDataRegistry.COMMON_UMA.getId();
        if(!registry.containsKey(name) || registry.get(name).getGachaRanking() != GachaRanking.R) return null;
        
        var id = UmaDataRegistry.VENUS_PARK.getId();
        if(!registry.containsKey(id)) return null;
        ItemStack egg = ItemRegistry.BLANK_UMA_SOUL.get().getDefaultInstance();
        egg.getOrCreateTag().putString("name", id.toString());

        return AnvilUpdateCallback.Result.pass(egg.copy(), 5, 1);
    }
    
    public static AnvilUpdateCallback.Result zhengSoul(ItemStack soul, ItemStack material, String itemName, int baseCost, Player player) {
        if(!soul.is(ItemRegistry.BLANK_UMA_SOUL.get())) return null;
        if(!material.is(Items.FEATHER)) return null;
        
        var registry = UmapyoiAPI.getUmaDataRegistry(player.level());
        ResourceLocation name = soul.getOrCreateTag().contains("name") ?
                ResourceLocation.tryParse(soul.getOrCreateTag().getString("name")) : UmaDataRegistry.COMMON_UMA.getId();
        if(!registry.containsKey(name) || 
                !registry.get(name).getIdentifier().equals(UmaDataRegistry.AGNES_TACHYON.get().getIdentifier())) 
            return null;
        
        var id = UmaDataRegistry.SYAMEIMARU_ZHENG.getId();
        if(!registry.containsKey(id)) return null;
        ItemStack egg = ItemRegistry.BLANK_UMA_SOUL.get().getDefaultInstance();
        egg.getOrCreateTag().putString("name", id.toString());

        return AnvilUpdateCallback.Result.pass(egg.copy(), 5, 1);
    }
    
    public static AnvilUpdateCallback.Result dumnheintSoul(ItemStack soul, ItemStack material, String itemName, int baseCost, Player player) {
        if(!soul.is(ItemRegistry.BLANK_UMA_SOUL.get())) return null;
        if(!material.is(Items.GUNPOWDER)) return null;
        if(!itemName.equalsIgnoreCase("kino")) return null;
        var registry = UmapyoiAPI.getUmaDataRegistry(player.level());
        ResourceLocation name = soul.getOrCreateTag().contains("name") ?
                ResourceLocation.tryParse(soul.getOrCreateTag().getString("name")) : UmaDataRegistry.COMMON_UMA.getId();
        if(!registry.containsKey(name) || registry.get(name).getGachaRanking() != GachaRanking.R) return null;
        
        var id = UmaDataRegistry.DUMNHEINT.getId();
        if(!registry.containsKey(id)) return null;
        ItemStack egg = ItemRegistry.BLANK_UMA_SOUL.get().getDefaultInstance();
        egg.getOrCreateTag().putString("name", id.toString());

        return AnvilUpdateCallback.Result.pass(egg.copy(), 5, 1);
    }
    
    public static AnvilUpdateCallback.Result darleySoul(ItemStack soul, ItemStack material, String itemName, int baseCost, Player player) {
        if(!soul.is(ItemRegistry.BLANK_UMA_SOUL.get())) return null;
        if(!material.is(ItemRegistry.THREE_GODDESS.get())) return null;
        
        if(!itemName.equalsIgnoreCase("darley")) return null;
        
        var registry = UmapyoiAPI.getUmaDataRegistry(player.level());
        
        var id = UmaDataRegistry.DARLEY_ARABIAN.getId();
        if(!registry.containsKey(id)) return null;
        ItemStack egg = ItemRegistry.BLANK_UMA_SOUL.get().getDefaultInstance();
        egg.getOrCreateTag().putString("name", id.toString());

        return AnvilUpdateCallback.Result.pass(egg.copy(), 5, 1);
    }
    
    public static AnvilUpdateCallback.Result byerleySoul(ItemStack soul, ItemStack material, String itemName, int baseCost, Player player) {
        if(!soul.is(ItemRegistry.BLANK_UMA_SOUL.get())) return null;
        if(!material.is(ItemRegistry.THREE_GODDESS.get())) return null;
        
        if(!itemName.equalsIgnoreCase("byerley")) return null;
        
        var registry = UmapyoiAPI.getUmaDataRegistry(player.level());
        
        var id = UmaDataRegistry.BYERLEY_TURK.getId();
        if(!registry.containsKey(id)) return null;
        ItemStack egg = ItemRegistry.BLANK_UMA_SOUL.get().getDefaultInstance();
        egg.getOrCreateTag().putString("name", id.toString());

        return AnvilUpdateCallback.Result.pass(egg.copy(), 5, 1);
    }
    
    public static AnvilUpdateCallback.Result godolphinSoul(ItemStack soul, ItemStack material, String itemName, int baseCost, Player player) {
        if(!soul.is(ItemRegistry.BLANK_UMA_SOUL.get())) return null;
        if(!material.is(ItemRegistry.THREE_GODDESS.get())) return null;
        
        if(!itemName.equalsIgnoreCase("godolphin")) return null;
        
        var registry = UmapyoiAPI.getUmaDataRegistry(player.level());
        
        var id = UmaDataRegistry.GODOLPHIN_BARB.getId();
        if(!registry.containsKey(id)) return null;
        ItemStack egg = ItemRegistry.BLANK_UMA_SOUL.get().getDefaultInstance();
        egg.getOrCreateTag().putString("name", id.toString());

        return AnvilUpdateCallback.Result.pass(egg.copy(), 5, 1);
    }
}
