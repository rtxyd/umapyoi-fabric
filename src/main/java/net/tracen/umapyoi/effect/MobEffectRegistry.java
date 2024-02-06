package net.tracen.umapyoi.effect;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.tracen.umapyoi.Umapyoi;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;

public class MobEffectRegistry {
    public static final LazyRegistrar<MobEffect> EFFECTS = LazyRegistrar.create(Registries.MOB_EFFECT,
            Umapyoi.MODID);

    public static final RegistryObject<MobEffect> PANICKING = EFFECTS.register("panicking", PanickingEffect::new);
}
