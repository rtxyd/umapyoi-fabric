package net.tracen.umapyoi.registry;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.tracen.umapyoi.Umapyoi;
import net.tracen.umapyoi.registry.umadata.UmaData;
import net.tracen.umapyoi.utils.GachaRanking;

import java.util.function.Supplier;

import io.github.fabricators_of_create.porting_lib.util.LazyRegistrar;
import io.github.fabricators_of_create.porting_lib.util.RegistryObject;

public class UmaDataRegistry {
    public static final LazyRegistrar<UmaData> UMA_DATA = LazyRegistrar.create(UmaData.REGISTRY_KEY,
            Umapyoi.MODID);
    public static final Supplier<Registry<UmaData>> UMA_DATA_REGISTRY = UMA_DATA.makeRegistry();

    private static final LazyRegistrarWrapper<UmaData> w = new LazyRegistrarWrapper<>(UMA_DATA);
    
    public static final RegistryObject<UmaData> COMMON_UMA = w.register("common_uma",
            () -> UmaDataRegistry.createNewUmamusume("common_uma", GachaRanking.R));
    
    public static final RegistryObject<UmaData> COMMON_UMA_A = w.register("common_uma_a",
            () -> UmaDataRegistry.createNewUmamusume("common_uma_a", GachaRanking.R));
    
    public static final RegistryObject<UmaData> COMMON_UMA_B = w.register("common_uma_b",
            () -> UmaDataRegistry.createNewUmamusume("common_uma_b", GachaRanking.R));
    
    public static final RegistryObject<UmaData> COMMON_UMA_C = w.register("common_uma_c",
            () -> UmaDataRegistry.createNewUmamusume("common_uma_c", GachaRanking.R));

    public static final RegistryObject<UmaData> GOLD_SHIP = w.register("gold_ship",
            () -> UmaDataRegistry.createNewUmamusume("gold_ship", GachaRanking.SR, new int[] {0, 20, 10, 0, 0}));

    public static final RegistryObject<UmaData> SPECIAL_WEEK = w.register("special_week",
            () -> UmaDataRegistry.createNewUmamusume("special_week", GachaRanking.SR, new int[] {0, 20, 0, 0, 10}));

    public static final RegistryObject<UmaData> TOKAI_TEIO = w.register("tokai_teio",
            () -> UmaDataRegistry.createNewUmamusume("tokai_teio", GachaRanking.SR, new int[] {20, 10, 0, 0, 0}));

    public static final RegistryObject<UmaData> OGURI_CAP = w.register("oguri_cap",
            () -> UmaDataRegistry.createNewUmamusume("oguri_cap", GachaRanking.SR, new int[] {20, 0, 10, 0, 0}));

    public static final RegistryObject<UmaData> SAKURA_CHIYONO_O = w.register("sakura_chiyono_o",
            () -> UmaDataRegistry.createNewUmamusume("sakura_chiyono_o", GachaRanking.SR, new int[] {10, 0, 0, 10, 10}));

    public static final RegistryObject<UmaData> OGURI_CAP_XMAS = w.register("oguri_cap_xmas",
            () -> UmaDataRegistry.createNewUmamusume("oguri_cap", GachaRanking.SSR, new int[] {15, 15, 0, 0, 10}));

    public static final RegistryObject<UmaData> AGNES_TACHYON = w.register("agnus_tachyon",
            () -> UmaDataRegistry.createNewUmamusume("agnus_tachyon", GachaRanking.SR, new int[] {20, 0, 0, 10, 0}));

    public static final RegistryObject<UmaData> HARU_URARA = w.register("haru_urara",
            () -> UmaDataRegistry.createNewUmamusume("haru_urara", GachaRanking.SR, new int[] {0, 0, 10, 20, 0}));

    public static final RegistryObject<UmaData> TAMAMO_CROSS = w.register("tamamo_cross",
            () -> UmaDataRegistry.createNewUmamusume("tamamo_cross", GachaRanking.SR, new int[] {0, 20, 10, 0, 0}));

    public static final RegistryObject<UmaData> SEIUN_SKY = w.register("seiun_sky",
            () -> UmaDataRegistry.createNewUmamusume("seiun_sky", GachaRanking.SR, new int[] {0, 10, 0, 0, 20}));

    public static final RegistryObject<UmaData> MATIKANEFUKUKITARU = w.register("matikanefukukitaru",
            () -> UmaDataRegistry.createNewUmamusume("matikanefukukitaru", GachaRanking.SR, new int[] {0, 20, 10, 0, 0}));

    public static final RegistryObject<UmaData> RICE_SHOWER = w.register("rice_shower",
            () -> UmaDataRegistry.createNewUmamusume("rice_shower", GachaRanking.SR, new int[] {0, 10, 0, 20, 0}));

    public static final RegistryObject<UmaData> VODKA = w.register("vodka",
            () -> UmaDataRegistry.createNewUmamusume("vodka", GachaRanking.SR, new int[] {10, 0, 20, 0, 0}));

    public static final RegistryObject<UmaData> SAKURA_BAKUSHIN_O = w.register("sakura_bakushin_o",
            () -> UmaDataRegistry.createNewUmamusume("sakura_bakushin_o", GachaRanking.SR, new int[] {20, 0, 0, 0, 10}));

    public static final RegistryObject<UmaData> MANHATTAN_CAFE = w.register("manhattan_cafe",
            () -> UmaDataRegistry.createNewUmamusume("manhattan_cafe", GachaRanking.SR, new int[] {0, 30, 0, 0, 0}));

    public static final RegistryObject<UmaData> MEJIRO_ARDAN = w.register("mejiro_ardan",
            () -> UmaDataRegistry.createNewUmamusume("mejiro_ardan", GachaRanking.SR, new int[] {10, 0, 0, 0, 20}));

    public static final RegistryObject<UmaData> DAITAKU_HELIOS = w.register("daitaku_helios",
            () -> UmaDataRegistry.createNewUmamusume("daitaku_helios", GachaRanking.SR, new int[] {15, 0, 15, 0, 0}));

    public static final RegistryObject<UmaData> SWEEP_TOSHO = w.register("sweep_tosho",
            () -> UmaDataRegistry.createNewUmamusume("sweep_tosho", GachaRanking.SR, new int[] {10, 0, 20, 0, 0}));

    public static final RegistryObject<UmaData> GOLD_CITY = w.register("gold_city",
            () -> UmaDataRegistry.createNewUmamusume("gold_city", GachaRanking.SR, new int[] {0, 0, 10, 20, 0}));

    public static final RegistryObject<UmaData> GOLD_SHIP_WATER = w.register("gold_ship_water",
            () -> UmaDataRegistry.createNewUmamusume("gold_ship", GachaRanking.SSR, new int[] {0, 0, 20, 0, 20}));

    public static final RegistryObject<UmaData> MR_CB = w.register("mr_cb",
            () -> UmaDataRegistry.createNewUmamusume("mr_cb", GachaRanking.SR, new int[] {10, 10, 0, 0, 10}));

    public static final RegistryObject<UmaData> GRASS_WONDER = w.register("grass_wonder",
            () -> UmaDataRegistry.createNewUmamusume("grass_wonder", GachaRanking.SR, new int[] {20, 0, 10, 0, 0}));

    public static final RegistryObject<UmaData> CURREN_CHAN = w.register("curren_chan",
            () -> UmaDataRegistry.createNewUmamusume("curren_chan", GachaRanking.SR, new int[] {10, 0, 20, 0, 0}));

    public static final RegistryObject<UmaData> SILENCE_SUZUKA = w.register("silence_suzuka",
            () -> UmaDataRegistry.createNewUmamusume("silence_suzuka", GachaRanking.SR, new int[] {20, 0, 0, 10, 0}));

    public static final RegistryObject<UmaData> TAMAMO_CROSS_FESTIVAL = w.register("tamamo_cross_festival",
            () -> UmaDataRegistry.createNewUmamusume("tamamo_cross", GachaRanking.SSR, new int[] {15, 10, 0, 15, 0}));

    public static final RegistryObject<UmaData> ASTON_MACHAN = w.register("aston_machan",
            () -> UmaDataRegistry.createNewUmamusume("aston_machan", GachaRanking.SR, new int[] {20, 0, 0, 10, 0}));
    
    public static final RegistryObject<UmaData> KITASAN_BLACK = w.register("kitasan_black",
            () -> UmaDataRegistry.createNewUmamusume("kitasan_black", GachaRanking.SR, new int[] {20, 10, 0, 0, 0}));

    public static final RegistryObject<UmaData> SATONO_DIAMOND = w.register("satono_diamond",
            () -> UmaDataRegistry.createNewUmamusume("satono_diamond", GachaRanking.SR, new int[] {0, 15, 0, 0, 15}));

    public static final RegistryObject<UmaData> NICE_NATURE = w.register("nice_nature",
            () -> UmaDataRegistry.createNewUmamusume("nice_nature", GachaRanking.SR, new int[] {0, 0, 20, 0, 10}));

    public static final RegistryObject<UmaData> MAYANO_TOP_GUN = w.register("mayano_top_gun",
            () -> UmaDataRegistry.createNewUmamusume("mayano_top_gun", GachaRanking.SR, new int[] {0, 20, 0, 10, 0}));
    
    public static final RegistryObject<UmaData> NEO_UNIVERSE = w.register("neo_universe",
            () -> UmaDataRegistry.createNewUmamusume("neo_universe", GachaRanking.SR, new int[] {0, 0, 0, 0, 30}));
    
    public static final RegistryObject<UmaData> MEISHO_DOTOU = w.register("meisho_dotou",
            () -> UmaDataRegistry.createNewUmamusume("meisho_dotou", GachaRanking.SR, new int[] {0, 20, 0, 10, 0}));
    
    public static final RegistryObject<UmaData> TAIKI_SHUTTLE = w.register("taiki_shuttle",
            () -> UmaDataRegistry.createNewUmamusume("taiki_shuttle", GachaRanking.SR, new int[] {20, 0, 0, 0, 10}));
    
    public static final RegistryObject<UmaData> CURREN_CHAN_DRESS = w.register("curren_chan_dress",
            () -> UmaDataRegistry.createNewUmamusume("curren_chan", GachaRanking.SSR, new int[] {10, 0, 20, 0, 10}));
    
    public static final RegistryObject<UmaData> MEJIRO_MCQUEEN = w.register("mejiro_mcqueen",
            () -> UmaDataRegistry.createNewUmamusume("mejiro_mcqueen", GachaRanking.SR, new int[] {0, 20, 0, 0, 10}));
    
    public static final RegistryObject<UmaData> COPANO_RICKEY = w.register("copano_rickey",
            () -> UmaDataRegistry.createNewUmamusume("copano_rickey", GachaRanking.SR, new int[] {0, 0, 10, 0, 20}));
    
    public static final RegistryObject<UmaData> SYMBOLI_RUDOLF = w.register("symboli_rudolf",
            () -> UmaDataRegistry.createNewUmamusume("symboli_rudolf", GachaRanking.SR, new int[] {0, 20, 0, 10, 0}));
    
    public static final RegistryObject<UmaData> NARITA_TOP_ROAD = w.register("narita_top_road",
            () -> UmaDataRegistry.createNewUmamusume("narita_top_road", GachaRanking.SR, new int[] {20, 10, 0, 0, 0}));
    
    public static final RegistryObject<UmaData> VENUS_PARK = w.register("venus_park",
            () -> UmaDataRegistry.createNewUmamusume("venus_park", GachaRanking.EASTER_EGG, new int[] {10, 10, 10, 10, 10}));
    
    public static final RegistryObject<UmaData> AGNES_TACHYON_SWIM = w.register("agnus_tachyon_swim",
            () -> UmaDataRegistry.createNewUmamusume("agnus_tachyon", GachaRanking.SSR, new int[] {15, 0, 10, 0, 15}));
    
    public static final RegistryObject<UmaData> MIHONO_BOURBON = w.register("mihono_bourbon",
            () -> UmaDataRegistry.createNewUmamusume("mihono_bourbon", GachaRanking.SR, new int[] {0, 20, 10, 0, 0}));
    
    public static final RegistryObject<UmaData> MATIKANETANNHAUSER = w.register("matikanetannhauser",
            () -> UmaDataRegistry.createNewUmamusume("matikanetannhauser", GachaRanking.SR, new int[] {0, 20, 0, 10, 0}));
    
    public static final RegistryObject<UmaData> KAWAKAMI_PRINCESS = w.register("kawakami_princess",
            () -> UmaDataRegistry.createNewUmamusume("kawakami_princess", GachaRanking.SR, new int[] {0, 10, 0, 20, 0}));
    
    public static final RegistryObject<UmaData> TWIN_TURBO = w.register("twinturbo",
            () -> UmaDataRegistry.createNewUmamusume("twinturbo", GachaRanking.SR, new int[] {30, 0, 0, 0, 0}));
    
    public static final RegistryObject<UmaData> LITTLE_COCON = w.register("little_cocon",
            () -> UmaDataRegistry.createNewUmamusume("little_cocon", GachaRanking.SR, new int[] {10, 0, 10, 0, 10}));
    
    public static final RegistryObject<UmaData> SAKURA_LAUREL = w.register("sakura_laurel",
            () -> UmaDataRegistry.createNewUmamusume("sakura_laurel", GachaRanking.SR, new int[] {0, 20, 10, 0, 0}));
    
    public static final RegistryObject<UmaData> FINE_MOTION = w.register("fine_motion",
            () -> UmaDataRegistry.createNewUmamusume("fine_motion", GachaRanking.SR, new int[] {0, 0, 15, 0, 15}));
    
    public static final RegistryObject<UmaData> TM_OPERA_O = w.register("tm_opera_o",
            () -> UmaDataRegistry.createNewUmamusume("tm_opera_o", GachaRanking.SR, new int[] {0, 20, 0, 0, 10}));
    
    public static final RegistryObject<UmaData> ADMIRE_VEGA = w.register("admire_vega",
            () -> UmaDataRegistry.createNewUmamusume("admire_vega", GachaRanking.SR, new int[] {10, 0, 20, 0, 0}));
    
    public static final RegistryObject<UmaData> JUNGLE_POCKET = w.register("jungle_pocket",
            () -> UmaDataRegistry.createNewUmamusume("jungle_pocket", GachaRanking.SR, new int[] {10, 0, 20, 0, 0}));
    
    public static final RegistryObject<UmaData> NARITA_TAISHIN = w.register("narita_taishin",
            () -> UmaDataRegistry.createNewUmamusume("narita_taishin", GachaRanking.SR, new int[] {10, 0, 0, 20, 0}));
    
    public static final RegistryObject<UmaData> GOLD_CITY_AUTUMN = w.register("gold_city_autumn",
            () -> UmaDataRegistry.createNewUmamusume("gold_city", GachaRanking.SSR, new int[] {10, 0, 15, 0, 15}));
    
    public static final RegistryObject<UmaData> GRASS_WONDER_UMANET = w.register("grass_wonder_umanet",
            () -> UmaDataRegistry.createNewUmamusume("grass_wonder", GachaRanking.SSR, new int[] {15, 0, 10, 0, 15}));
    
    public static final RegistryObject<UmaData> SATONO_DIAMOND_FRENCH = w.register("satono_diamond_french",
            () -> UmaDataRegistry.createNewUmamusume("satono_diamond", GachaRanking.SSR, new int[] {10, 15, 0, 15, 0}));
    
    public static final RegistryObject<UmaData> SYAMEIMARU_ZHENG = w.register("syameimaru_zheng",
            () -> UmaDataRegistry.createNewUmamusume("syameimaru_zheng", GachaRanking.EASTER_EGG, new int[] {20, 0, 0, 10, 0}));
    
    public static final RegistryObject<UmaData> DUMNHEINT = w.register("dumnheint",
            () -> UmaDataRegistry.createNewUmamusume("dumnheint", GachaRanking.EASTER_EGG, new int[] {10, 0, 20, 0, 0}));
    
    public static final RegistryObject<UmaData> DARLEY_ARABIAN = w.register("darley_arabian",
            () -> UmaDataRegistry.createNewUmamusume("darley_arabian", GachaRanking.EASTER_EGG, new int[] {10, 10, 10, 10, 10}));
    
    public static final RegistryObject<UmaData> GODOLPHIN_BARB = w.register("godolphin_barb",
            () -> UmaDataRegistry.createNewUmamusume("godolphin_barb", GachaRanking.EASTER_EGG, new int[] {25, 0, 0, 0, 25}));
    
    public static final RegistryObject<UmaData> BYERLEY_TURK = w.register("byerley_turk",
            () -> UmaDataRegistry.createNewUmamusume("byerley_turk", GachaRanking.EASTER_EGG, new int[] {0, 15, 20, 15, 0}));
    
    public static UmaData createNewUmamusume(String name, GachaRanking ranking) {
        return new UmaData(new ResourceLocation(Umapyoi.MODID, name), ranking, new int[] { 1, 1, 1, 1, 1 },
                new int[] { 18, 18, 18, 18, 18 }, new int[] { 0, 0, 0, 0, 0 }, new ResourceLocation(Umapyoi.MODID, "basic_pace"));
    }
    
    public static UmaData createNewUmamusume(String name, GachaRanking ranking, int[] rate) {
        return new UmaData(new ResourceLocation(Umapyoi.MODID, name), ranking, new int[] { 1, 1, 1, 1, 1 },
                new int[] { 18, 18, 18, 18, 18 }, rate,new ResourceLocation(Umapyoi.MODID, "basic_pace"));
    }
}
