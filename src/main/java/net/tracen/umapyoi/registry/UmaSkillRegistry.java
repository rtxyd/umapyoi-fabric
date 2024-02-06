package net.tracen.umapyoi.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.tracen.umapyoi.Umapyoi;
import net.tracen.umapyoi.registry.skills.HealSkill;
import net.tracen.umapyoi.registry.skills.LastLegSkill;
import net.tracen.umapyoi.registry.skills.LowHealthBuffSkill;
import net.tracen.umapyoi.registry.skills.LowHealthHealSkill;
import net.tracen.umapyoi.registry.skills.NutritionalSupplementsSkill;
import net.tracen.umapyoi.registry.skills.SereneSkill;
import net.tracen.umapyoi.registry.skills.SkillType;
import net.tracen.umapyoi.registry.skills.SpeedSkill;
import net.tracen.umapyoi.registry.skills.SteelWillSkill;
import net.tracen.umapyoi.registry.skills.UmaSkill;
import net.tracen.umapyoi.registry.skills.passive.PassiveSkill;

import java.util.function.Supplier;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;

public class UmaSkillRegistry {
    public static final LazyRegistrar<UmaSkill> SKILLS = LazyRegistrar.create(UmaSkill.REGISTRY_KEY,
            Umapyoi.MODID);

    public static final Supplier<Registry<UmaSkill>> REGISTRY = SKILLS.makeRegistry();

    private static final LazyRegistrarWrapper<UmaSkill> w = new LazyRegistrarWrapper<>(SKILLS);

    public static final RegistryObject<UmaSkill> BASIC_PACE = w.register("basic_pace",
            () -> new SpeedSkill(new UmaSkill.Builder().level(1).type(SkillType.BUFF), 400));

    public static final RegistryObject<UmaSkill> LAST_LEG = w.register("last_leg",
            () -> new LastLegSkill(new UmaSkill.Builder().upperSkill(new ResourceLocation(Umapyoi.MODID, "heart_and_soul")).level(1).type(SkillType.BUFF).actionPoint(400).requiredWisdom(2), 
                    100));
    public static final RegistryObject<UmaSkill> HEART_AND_SOUL = w.register("heart_and_soul",
            () -> new LastLegSkill(new UmaSkill.Builder().level(2).type(SkillType.BUFF).actionPoint(900).requiredWisdom(4), 
                    100));

    public static final RegistryObject<UmaSkill> DEEP_BREATHS = w.register("deep_breaths",
            () -> new HealSkill(new UmaSkill.Builder().upperSkill(new ResourceLocation(Umapyoi.MODID, "cooldown")).level(1).type(SkillType.HEAL).actionPoint(400).requiredWisdom(2)));
    public static final RegistryObject<UmaSkill> COOLDOWN = w.register("cooldown",
            () -> new HealSkill(new UmaSkill.Builder().level(2).type(SkillType.HEAL).actionPoint(900).requiredWisdom(4)));
    
    public static final RegistryObject<UmaSkill> LOW_HEALTH_HEAL = w.register("low_health_heal",
            () -> new LowHealthHealSkill(new UmaSkill.Builder().upperSkill(new ResourceLocation(Umapyoi.MODID, "adv_low_health_heal")).level(1).type(SkillType.HEAL).actionPoint(400).requiredWisdom(2)));
    public static final RegistryObject<UmaSkill> ADV_LOWHEALTH_HEAL = w.register("adv_low_health_heal",
            () -> new LowHealthHealSkill(new UmaSkill.Builder().level(2).type(SkillType.HEAL).actionPoint(900).requiredWisdom(4)));
    
    public static final RegistryObject<UmaSkill> LOW_HEALTH_BUFF = w.register("low_health_buff",
            () -> new LowHealthBuffSkill(new UmaSkill.Builder().upperSkill(new ResourceLocation(Umapyoi.MODID, "adv_low_health_buff")).level(1).type(SkillType.BUFF).actionPoint(400).requiredWisdom(2)));
    public static final RegistryObject<UmaSkill> ADV_LOWHEALTH_BUFF = w.register("adv_low_health_buff",
            () -> new LowHealthBuffSkill(new UmaSkill.Builder().level(2).type(SkillType.BUFF).actionPoint(900).requiredWisdom(4)));
    
    
    public static final RegistryObject<UmaSkill> NUTRITIONAL_SUPPLEMENTS = w.register("nutritional_supplements",
            () -> new NutritionalSupplementsSkill(new UmaSkill.Builder().upperSkill(new ResourceLocation(Umapyoi.MODID, "big_eater")).level(1).type(SkillType.HEAL).actionPoint(600).requiredWisdom(3)));
    public static final RegistryObject<UmaSkill> BIG_EATER = w.register("big_eater",
            () -> new NutritionalSupplementsSkill(new UmaSkill.Builder().level(2).type(SkillType.HEAL).actionPoint(1000).requiredWisdom(5)));

    public static final RegistryObject<UmaSkill> SERENE = w.register("serene",
            () -> new SereneSkill(new UmaSkill.Builder().level(1).type(SkillType.HEAL).actionPoint(300).requiredWisdom(2)));
    
    public static final RegistryObject<UmaSkill> STEEL_WILL = w.register("steel_will",
            () -> new SteelWillSkill(new UmaSkill.Builder().level(3).type(SkillType.HEAL).actionPoint(1200).requiredWisdom(8)));
    
    public static final RegistryObject<UmaSkill> MOUNTAIN_CLIMBER = w.register("mountain_climber",
            () -> new PassiveSkill(new UmaSkill.Builder().level(1).requiredWisdom(2)));
    
    public static final RegistryObject<UmaSkill> DIG_SPEED = w.register("dig_speed",
            () -> new PassiveSkill(new UmaSkill.Builder().level(1).requiredWisdom(2)));
    
    public static final RegistryObject<UmaSkill> TURF_RUNNER = w.register("turf_runner",
            () -> new PassiveSkill(new UmaSkill.Builder().level(1).requiredWisdom(2)));
    
    public static final RegistryObject<UmaSkill> DIRT_RUNNER = w.register("dirt_runner",
            () -> new PassiveSkill(new UmaSkill.Builder().level(1).requiredWisdom(2)));

    public static final RegistryObject<UmaSkill> SNOW_RUNNER = w.register("snow_runner",
            () -> new PassiveSkill(new UmaSkill.Builder().level(1).requiredWisdom(2)));
}
