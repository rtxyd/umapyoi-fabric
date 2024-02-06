package net.tracen.umapyoi.registry;

import net.minecraft.core.Registry;
import net.tracen.umapyoi.Umapyoi;
import net.tracen.umapyoi.registry.training.ExtraStatusSupport;
import net.tracen.umapyoi.registry.training.SkillSupport;
import net.tracen.umapyoi.registry.training.StatusSupport;
import net.tracen.umapyoi.registry.training.TrainingSupport;
import net.tracen.umapyoi.utils.UmaStatusUtils.StatusType;

import java.util.function.Supplier;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;

public class TrainingSupportRegistry {
    public static final LazyRegistrar<TrainingSupport> SUPPORTS = LazyRegistrar
            .create(TrainingSupport.REGISTRY_KEY, Umapyoi.MODID);

    public static final Supplier<Registry<TrainingSupport>> REGISTRY = SUPPORTS.makeRegistry();

    private static final LazyRegistrarWrapper<TrainingSupport> w = new LazyRegistrarWrapper<>(SUPPORTS);

    public static final RegistryObject<TrainingSupport> SPEED_SUPPORT = w.register("speed_support",
            () -> new StatusSupport(StatusType.SPEED));

    public static final RegistryObject<TrainingSupport> STAMINA_SUPPORT = w.register("stamina_support",
            () -> new StatusSupport(StatusType.STAMINA));

    public static final RegistryObject<TrainingSupport> STRENGTH_SUPPORT = w.register("strength_support",
            () -> new StatusSupport(StatusType.STRENGTH));

    public static final RegistryObject<TrainingSupport> GUTS_SUPPORT = w.register("guts_support",
            () -> new StatusSupport(StatusType.GUTS));

    public static final RegistryObject<TrainingSupport> WISDOM_SUPPORT = w.register("wisdom_support",
            () -> new StatusSupport(StatusType.WISDOM));

    public static final RegistryObject<TrainingSupport> SKILL_SUPPORT = w.register("skill_support",
            SkillSupport::new);
    
    public static final RegistryObject<TrainingSupport> AP_SUPPORT = w.register("actionpoint_support",
            () -> new ExtraStatusSupport(3));

}
