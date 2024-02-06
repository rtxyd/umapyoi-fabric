package net.tracen.umapyoi.registry;

import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public class RegistryNameHolder {
    @Nullable
    private ResourceLocation name;

    protected RegistryNameHolder() {
        this.name = null;
    }

    public void setRegistryName(ResourceLocation name) {
        this.name = name;
    }

    public final ResourceLocation getRegistryName() {
        return name;
    }
}
