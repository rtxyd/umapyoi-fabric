package net.tracen.umapyoi.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;
import net.tracen.umapyoi.item.info.FoodInfo;

public class ItemDrinkBase extends ItemFoodBase {

    public ItemDrinkBase(Item.Properties prop, FoodInfo info) {
        super(prop, info);
    }

    @Override
    public FoodProperties getFoodProperties() {
        return super.getFoodProperties();
    }

    @Override
    public UseAnim getUseAnimation(ItemStack p_77661_1_) {
        return p_77661_1_.getItem().isEdible() ? UseAnim.DRINK : UseAnim.NONE;
    }

    @Override
    public FoodInfo getFoodInfo() {
        return super.getFoodInfo();
    }
}