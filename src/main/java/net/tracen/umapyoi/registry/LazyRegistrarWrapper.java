package net.tracen.umapyoi.registry;

import net.minecraft.resources.ResourceLocation;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;

public class LazyRegistrarWrapper<T extends RegistryNameHolder> {
    LazyRegistrar<T> r;

    public LazyRegistrarWrapper(LazyRegistrar<T> r) {
        this.r = r;
    }

    private static class RegistryNameHolderSupplier<T extends RegistryNameHolder> implements Supplier<T> {
        @Nullable
        private ResourceLocation name;
        private final Supplier<T> entry;

        public RegistryNameHolderSupplier(Supplier<T> entry) {
            this.name = null;
            this.entry = entry;
        }

        public void setRegistryName(ResourceLocation name) {
            this.name = name;
        }

        @Override
        public T get() {
            T value = entry.get();
            value.setRegistryName(name);
            return value;
        }
    }

    public RegistryObject<T> register(String id, Supplier<T> entry) {
        RegistryNameHolderSupplier<T> wrapped = new RegistryNameHolderSupplier<>(entry);
        RegistryObject<T> object = r.register(id, wrapped);
        wrapped.setRegistryName(object.getId());
        return object;
    }
}
