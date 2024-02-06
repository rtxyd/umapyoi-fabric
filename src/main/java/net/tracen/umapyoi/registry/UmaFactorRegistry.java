package net.tracen.umapyoi.registry;

import net.minecraft.core.Registry;
import net.tracen.umapyoi.Umapyoi;
import net.tracen.umapyoi.registry.factors.ExtraStatusFactor;
import net.tracen.umapyoi.registry.factors.SkillFactor;
import net.tracen.umapyoi.registry.factors.StatusFactor;
import net.tracen.umapyoi.registry.factors.UmaFactor;
import net.tracen.umapyoi.registry.factors.UniqueSkillFactor;
import net.tracen.umapyoi.registry.factors.WhiteExtraStatusFactor;
import net.tracen.umapyoi.registry.factors.WhiteStatusFactor;
import net.tracen.umapyoi.utils.UmaStatusUtils.StatusType;

import java.util.function.Supplier;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;

public class UmaFactorRegistry {
    public static final LazyRegistrar<UmaFactor> FACTORS = LazyRegistrar.create(UmaFactor.REGISTRY_KEY,
            Umapyoi.MODID);

    public static final Supplier<Registry<UmaFactor>> REGISTRY = FACTORS.makeRegistry();

    private static final LazyRegistrarWrapper<UmaFactor> w = new LazyRegistrarWrapper<>(FACTORS);

    public static final RegistryObject<UmaFactor> SPEED_FACTOR = w.register("speed_factor",
            () -> new StatusFactor(StatusType.SPEED));

    public static final RegistryObject<UmaFactor> STAMINA_FACTOR = w.register("stamina_factor",
            () -> new StatusFactor(StatusType.STAMINA));

    public static final RegistryObject<UmaFactor> STRENGTH_FACTOR = w.register("strength_factor",
            () -> new StatusFactor(StatusType.STRENGTH));

    public static final RegistryObject<UmaFactor> GUTS_FACTOR = w.register("guts_factor",
            () -> new StatusFactor(StatusType.GUTS));

    public static final RegistryObject<UmaFactor> WISDOM_FACTOR = w.register("wisdom_factor",
            () -> new StatusFactor(StatusType.WISDOM));
    
    public static final RegistryObject<UmaFactor> WHITE_SPEED_FACTOR = w.register("white_speed_factor",
            () -> new WhiteStatusFactor(StatusType.SPEED));

    public static final RegistryObject<UmaFactor> WHITE_STAMINA_FACTOR = w.register("white_stamina_factor",
            () -> new WhiteStatusFactor(StatusType.STAMINA));

    public static final RegistryObject<UmaFactor> WHITE_STRENGTH_FACTOR = w.register("white_strength_factor",
            () -> new WhiteStatusFactor(StatusType.STRENGTH));

    public static final RegistryObject<UmaFactor> WHITE_GUTS_FACTOR = w.register("white_guts_factor",
            () -> new WhiteStatusFactor(StatusType.GUTS));

    public static final RegistryObject<UmaFactor> WHITE_WISDOM_FACTOR = w.register("white_wisdom_factor",
            () -> new WhiteStatusFactor(StatusType.WISDOM));

    public static final RegistryObject<UmaFactor> SKILL_FACTOR = w.register("skill_factor", SkillFactor::new);
    public static final RegistryObject<UmaFactor> UNIQUE_SKILL_FACTOR = w.register("unique_skill_factor",
            UniqueSkillFactor::new);
    
    public static final RegistryObject<UmaFactor> PHYSIQUE_FACTOR = w.register("physique_factor",
            () -> new ExtraStatusFactor(0));

    public static final RegistryObject<UmaFactor> TELENT_FACTOR = w.register("telent_factor",
            () -> new ExtraStatusFactor(1));

    public static final RegistryObject<UmaFactor> MEMORY_FACTOR = w.register("memory_factor",
            () -> new ExtraStatusFactor(2));

    public static final RegistryObject<UmaFactor> ACTIONS_FACTOR = w.register("actions_factor",
            () -> new ExtraStatusFactor(3));
    
    public static final RegistryObject<UmaFactor> WHITE_TELENT_FACTOR = w.register("white_telent_factor",
            () -> new WhiteExtraStatusFactor(1));

    public static final RegistryObject<UmaFactor> WHITE_ACTIONS_FACTOR = w.register("white_actions_factor",
            () -> new WhiteExtraStatusFactor(3));
}
