package net.tracen.umapyoi.registry;

import net.minecraft.resources.ResourceLocation;
import net.tracen.umapyoi.Umapyoi;
import net.tracen.umapyoi.registry.training.SupportType;
import net.tracen.umapyoi.registry.training.card.SupportCard;
import net.tracen.umapyoi.registry.training.card.SupportEntry;
import net.tracen.umapyoi.utils.GachaRanking;
import net.tracen.umapyoi.utils.UmaSkillUtils;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;

public class SupportCardRegistry {
    public static final LazyRegistrar<SupportCard> SUPPORT_CARD = LazyRegistrar.create(SupportCard.REGISTRY_KEY,
            Umapyoi.MODID);

    private static final LazyRegistrarWrapper<SupportCard> w = new LazyRegistrarWrapper<>(SUPPORT_CARD);
    public static final RegistryObject<SupportCard> BLANK_CARD = w.register("blank_card",
            SupportCard.Builder.create().ranking(GachaRanking.EASTER_EGG).supportType(SupportType.GROUP)::build);
    
    public static final RegistryObject<SupportCard> R_TURF_TRAINING = w.register("r_turf_training",
                    SupportCard.Builder.create()
                    .ranking(GachaRanking.R)
                    .maxDamage(10)
                    .supportType(SupportType.SPEED)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 1))
                    .addSupport(UmaSkillUtils.getSkillSupportEnrty(UmaSkillRegistry.TURF_RUNNER.getId()))
                    ::build);
    
    public static final RegistryObject<SupportCard> R_DIRT_TRAINING = w.register("r_dirt_training",
                    SupportCard.Builder.create()
                    .ranking(GachaRanking.R)
                    .maxDamage(10)
                    .supportType(SupportType.STRENGTH)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 1))
                    .addSupport(UmaSkillUtils.getSkillSupportEnrty(UmaSkillRegistry.DIRT_RUNNER.getId()))
                    ::build);
    
    public static final RegistryObject<SupportCard> R_SNOW_TRAINING = w.register("r_snow_training",
                    SupportCard.Builder.create()
                    .ranking(GachaRanking.R)
                    .maxDamage(10)
                    .supportType(SupportType.GUTS)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.GUTS_SUPPORT.getId(), 1))
                    .addSupport(UmaSkillUtils.getSkillSupportEnrty(UmaSkillRegistry.SNOW_RUNNER.getId()))
                    ::build);
    
    public static final RegistryObject<SupportCard> R_KITASANBLACK = w.register("r_kitasan_black",
                    SupportCard.Builder.create()
                    .ranking(GachaRanking.R)
                    .maxDamage(12)
                    .supportType(SupportType.SPEED)
                    .addSupporter(UmaDataRegistry.KITASAN_BLACK.getId())
                    .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 1))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 1))
                    ::build);
    
    public static final RegistryObject<SupportCard> R_SUPERCREEK = w.register("r_super_creek",
                    SupportCard.Builder.create()
                    .ranking(GachaRanking.R)
                    .maxDamage(10)
                    .supportType(SupportType.STAMINA)
                    .addSupporter(new ResourceLocation(Umapyoi.MODID, "super_creek"))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STAMINA_SUPPORT.getId(), 1))
                    .addSupport(UmaSkillUtils.getSkillSupportEnrty(UmaSkillRegistry.NUTRITIONAL_SUPPLEMENTS.getId()))
                    ::build);
    
    public static final RegistryObject<SupportCard> R_OGURICAP = w.register("r_oguri_cap",
                    SupportCard.Builder.create()
                    .ranking(GachaRanking.R)
                    .maxDamage(10)
                    .supportType(SupportType.STRENGTH)
                    .addSupporter(UmaDataRegistry.OGURI_CAP.getId())
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STAMINA_SUPPORT.getId(), 1))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 1))
                    ::build);
    
    public static final RegistryObject<SupportCard> R_KS_MIRACLE = w.register("r_ks_miracle",
                    SupportCard.Builder.create()
                    .ranking(GachaRanking.R)
                    .maxDamage(10)
                    .supportType(SupportType.GUTS)
                    .addSupporter(new ResourceLocation(Umapyoi.MODID, "ks_miracle"))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.GUTS_SUPPORT.getId(), 2))
                    ::build);
    
    public static final RegistryObject<SupportCard> R_AGNES_TACHYON = w.register("r_agnus_tachyon",
                    SupportCard.Builder.create()
                    .ranking(GachaRanking.R)
                    .maxDamage(10)
                    .supportType(SupportType.WISDOM)
                    .addSupporter(UmaDataRegistry.AGNES_TACHYON.getId())
                    .addSupport(new SupportEntry(TrainingSupportRegistry.WISDOM_SUPPORT.getId(), 1))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 1))
                    ::build);
    
    public static final RegistryObject<SupportCard> BASIC_SPEED_CARD = w.register("basic_speed_card",
            SupportCard.Builder.create().ranking(GachaRanking.R).maxDamage(10).supportType(SupportType.SPEED)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 1))::build);
    public static final RegistryObject<SupportCard> BASIC_STAMINA_CARD = w.register("basic_stamina_card",
            SupportCard.Builder.create().ranking(GachaRanking.R).maxDamage(10).supportType(SupportType.STAMINA)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STAMINA_SUPPORT.getId(), 1))::build);
    public static final RegistryObject<SupportCard> BASIC_STRENGTH_CARD = w.register("basic_strength_card",
            SupportCard.Builder.create().ranking(GachaRanking.R).maxDamage(10).supportType(SupportType.STRENGTH)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 1))::build);
    public static final RegistryObject<SupportCard> BASIC_GUTS_CARD = w.register("basic_guts_card",
            SupportCard.Builder.create().ranking(GachaRanking.R).maxDamage(10).supportType(SupportType.GUTS)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.GUTS_SUPPORT.getId(), 1))::build);
    public static final RegistryObject<SupportCard> BASIC_WISDOM_CARD = w.register("basic_wisdom_card",
            SupportCard.Builder.create().ranking(GachaRanking.R).maxDamage(10).supportType(SupportType.WISDOM)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.WISDOM_SUPPORT.getId(), 1))::build);
    
    public static final RegistryObject<SupportCard> ADV_SPEED_CARD = w.register("adv_speed_card",
            SupportCard.Builder.create().ranking(GachaRanking.SR).maxDamage(8).supportType(SupportType.SPEED)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 2))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 1))::build);

    public static final RegistryObject<SupportCard> ADV_STAMINA_CARD = w.register("adv_stamina_card",
            SupportCard.Builder.create().ranking(GachaRanking.SR).maxDamage(8).supportType(SupportType.STAMINA)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STAMINA_SUPPORT.getId(), 2))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.GUTS_SUPPORT.getId(), 1))::build);

    public static final RegistryObject<SupportCard> ADV_STRENGTH_CARD = w.register("adv_strength_card",
            SupportCard.Builder.create().ranking(GachaRanking.SR).maxDamage(8).supportType(SupportType.STRENGTH)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STAMINA_SUPPORT.getId(), 1))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 2))::build);

    public static final RegistryObject<SupportCard> ADV_GUTS_CARD = w.register("adv_guts_card",
            SupportCard.Builder.create().ranking(GachaRanking.SR).maxDamage(8).supportType(SupportType.GUTS)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 1))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.GUTS_SUPPORT.getId(), 2))::build);

    public static final RegistryObject<SupportCard> ADV_WISDOM_CARD = w.register("adv_wisdom_card",
            SupportCard.Builder.create().ranking(GachaRanking.SR).maxDamage(8).supportType(SupportType.WISDOM)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.AP_SUPPORT.getId(), 1))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.WISDOM_SUPPORT.getId(), 2))::build);
    
    public static final RegistryObject<SupportCard> SPEED_MASTER_CARD = w.register("speed_master_card",
            SupportCard.Builder.create().ranking(GachaRanking.SSR).supportType(SupportType.SPEED).maxDamage(5)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 3))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 2))::build);

    public static final RegistryObject<SupportCard> STAMINA_MASTER_CARD = w.register("stamina_master_card",
            SupportCard.Builder.create().ranking(GachaRanking.SSR).supportType(SupportType.STAMINA).maxDamage(5)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STAMINA_SUPPORT.getId(), 3))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.GUTS_SUPPORT.getId(), 2))::build);

    public static final RegistryObject<SupportCard> STRENGTH_MASTER_CARD = w.register("strength_master_card",
            SupportCard.Builder.create().ranking(GachaRanking.SSR).supportType(SupportType.STRENGTH).maxDamage(5)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STAMINA_SUPPORT.getId(), 2))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 3))::build);

    public static final RegistryObject<SupportCard> GUTS_MASTER_CARD = w.register("guts_master_card",
            SupportCard.Builder.create().ranking(GachaRanking.SSR).supportType(SupportType.GUTS).maxDamage(5)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 1))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 2))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.GUTS_SUPPORT.getId(), 3))::build);

    public static final RegistryObject<SupportCard> WISDOM_MASTER_CARD = w.register("wisdom_master_card",
            SupportCard.Builder.create().ranking(GachaRanking.SSR).supportType(SupportType.WISDOM).maxDamage(5)
                    .addSupport(new SupportEntry(TrainingSupportRegistry.AP_SUPPORT.getId(), 1))
                    .addSupport(new SupportEntry(TrainingSupportRegistry.WISDOM_SUPPORT.getId(), 3))
                    ::build);

    public static final RegistryObject<SupportCard> SSR_KITASANBLACK = w.register("ssr_kitasan_black",
                SupportCard.Builder.create()
                .ranking(GachaRanking.SSR)
                .supportType(SupportType.SPEED)
                .maxDamage(6)
                .addSupporter(UmaDataRegistry.KITASAN_BLACK.getId())
                .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 3))
                .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 3))
                ::build);

    public static final RegistryObject<SupportCard> SSR_SUPERCREEK = w.register("ssr_super_creek",
                SupportCard.Builder.create()
                .ranking(GachaRanking.SSR)
                .supportType(SupportType.STAMINA)
                .maxDamage(5)
                .addSupporter(new ResourceLocation(Umapyoi.MODID, "super_creek"))
                .addSupport(new SupportEntry(TrainingSupportRegistry.STAMINA_SUPPORT.getId(), 3))
                .addSupport(UmaSkillUtils.getSkillSupportEnrty(UmaSkillRegistry.BIG_EATER.getId()))
                ::build);
    
    public static final RegistryObject<SupportCard> SSR_OGURICAP = w.register("ssr_oguri_cap",
                SupportCard.Builder.create()
                .ranking(GachaRanking.SSR)
                .maxDamage(5)
                .supportType(SupportType.STRENGTH)
                .addSupporter(UmaDataRegistry.OGURI_CAP.getId())
                .addSupport(new SupportEntry(TrainingSupportRegistry.STAMINA_SUPPORT.getId(), 1))
                .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 3))
                .addSupport(UmaSkillUtils.getSkillSupportEnrty(UmaSkillRegistry.NUTRITIONAL_SUPPLEMENTS.getId()))
                ::build);
    
    public static final RegistryObject<SupportCard> SSR_KS_MIRACLE = w.register("ssr_ks_miracle",
                SupportCard.Builder.create()
                .ranking(GachaRanking.SSR)
                .maxDamage(5)
                .supportType(SupportType.GUTS)
                .addSupporter(new ResourceLocation(Umapyoi.MODID, "ks_miracle"))
                .addSupport(new SupportEntry(TrainingSupportRegistry.GUTS_SUPPORT.getId(), 3))
                .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 2))
                .addSupport(UmaSkillUtils.getSkillSupportEnrty(UmaSkillRegistry.HEART_AND_SOUL.getId()))
                ::build);
    
    public static final RegistryObject<SupportCard> SR_AGNES_TACHYON = w.register("sr_agnus_tachyon",
                SupportCard.Builder.create()
                .ranking(GachaRanking.SR)
                .supportType(SupportType.WISDOM)
                .maxDamage(8)
                .addSupporter(UmaDataRegistry.AGNES_TACHYON.getId())
                .addSupport(new SupportEntry(TrainingSupportRegistry.WISDOM_SUPPORT.getId(), 2))
                .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 1))
                .addSupport(UmaSkillUtils.getSkillSupportEnrty(UmaSkillRegistry.LAST_LEG.getId()))
                ::build);
    
    public static final RegistryObject<SupportCard> SSR_AGNES_TACHYON = w.register("ssr_agnus_tachyon",
                SupportCard.Builder.create()
                .ranking(GachaRanking.SSR)
                .maxDamage(5)
                .supportType(SupportType.SPEED)
                .addSupporter(UmaDataRegistry.AGNES_TACHYON.getId())
                .addSupport(new SupportEntry(TrainingSupportRegistry.STRENGTH_SUPPORT.getId(), 2))
                .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 3))
                .addSupport(UmaSkillUtils.getSkillSupportEnrty(UmaSkillRegistry.ADV_LOWHEALTH_BUFF.getId()))
                ::build);
    
    public static final RegistryObject<SupportCard> SSR_FINE_MOTION = w.register("ssr_fine_motion",
                SupportCard.Builder.create()
                .ranking(GachaRanking.SSR)
                .maxDamage(5)
                .supportType(SupportType.WISDOM)
                .addSupporter(new ResourceLocation(Umapyoi.MODID, "fine_motion"))
                .addSupport(new SupportEntry(TrainingSupportRegistry.WISDOM_SUPPORT.getId(), 3))
                .addSupport(new SupportEntry(TrainingSupportRegistry.SPEED_SUPPORT.getId(), 1))
                .addSupport(new SupportEntry(TrainingSupportRegistry.AP_SUPPORT.getId(), 2))
                ::build);

}
