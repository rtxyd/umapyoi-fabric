package net.tracen.umapyoi.registry;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

import javax.annotation.Nullable;

public class RegistryObject<T> implements Supplier<T> {
    private final ResourceLocation name;
    private T value = null;

    public RegistryObject(ResourceLocation name) {
        this.name = name;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public ResourceLocation getId() {
        return name;
    }

    @Override
    @Nullable
    public T get() {
        return value;
    }
}
