package net.tracen.umapyoi.item;

import net.minecraft.resources.ResourceLocation;
import net.tracen.umapyoi.Umapyoi;
import net.tracen.umapyoi.utils.ClientUtils;

public class SummerUniformItem extends AbstractSuitItem {
    @Override
    protected ResourceLocation getModel() {
        return ClientUtils.SUMMER_UNIFORM;
    }

    @Override
    protected ResourceLocation getTexture(boolean tanned) {
        return tanned ? new ResourceLocation(Umapyoi.MODID, "textures/model/summer_uniform_tanned.png")
                : new ResourceLocation(Umapyoi.MODID, "textures/model/summer_uniform.png");
    }

    @Override
    protected ResourceLocation getFlatModel() {
        return ClientUtils.SUMMER_UNIFORM_FLAT;
    }

    @Override
    protected ResourceLocation getFlatTexture(boolean tanned) {
        return tanned ? new ResourceLocation(Umapyoi.MODID, "textures/model/summer_uniform_tanned.png")
                : new ResourceLocation(Umapyoi.MODID, "textures/model/summer_uniform.png");
    }
}
