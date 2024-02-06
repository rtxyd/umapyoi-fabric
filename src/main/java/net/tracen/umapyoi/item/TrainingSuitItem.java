package net.tracen.umapyoi.item;

import net.minecraft.resources.ResourceLocation;
import net.tracen.umapyoi.Umapyoi;
import net.tracen.umapyoi.utils.ClientUtils;

public class TrainingSuitItem extends AbstractSuitItem {
    @Override
    protected ResourceLocation getModel() {
        return ClientUtils.TRAINING_SUIT;
    }

    @Override
    protected ResourceLocation getTexture(boolean tanned) {
        return tanned ? new ResourceLocation(Umapyoi.MODID, "textures/model/trainning_suit_tanned.png")
                : new ResourceLocation(Umapyoi.MODID, "textures/model/trainning_suit.png");
    }

    @Override
    protected ResourceLocation getFlatModel() {
        return ClientUtils.TRAINING_SUIT_FLAT;
    }

    @Override
    protected ResourceLocation getFlatTexture(boolean tanned) {
        return tanned ? new ResourceLocation(Umapyoi.MODID, "textures/model/trainning_suit_tanned.png")
                : new ResourceLocation(Umapyoi.MODID, "textures/model/trainning_suit.png");
    }
}
