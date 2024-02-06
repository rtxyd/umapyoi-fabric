package net.tracen.umapyoi.events.handler;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.tracen.umapyoi.Umapyoi;
import net.tracen.umapyoi.api.UmapyoiAPI;
import net.tracen.umapyoi.effect.MobEffectRegistry;
import net.tracen.umapyoi.registry.factors.UmaFactorStack;
import net.tracen.umapyoi.registry.training.SupportStack;
import net.tracen.umapyoi.registry.umadata.Motivations;
import net.tracen.umapyoi.utils.ResultRankingUtils;
import net.tracen.umapyoi.utils.UmaSkillUtils;
import net.tracen.umapyoi.utils.UmaSoulUtils;
import net.tracen.umapyoi.utils.UmaStatusUtils;

public class CommonEvents {
    public static boolean onDamageDownMotivation(LivingEntity entity, DamageSource source, float amount) {
        ItemStack soul = UmapyoiAPI.getUmaSoul(entity);
        if (soul.isEmpty())
            return true;
        if (amount < Umapyoi.CONFIG.DAMAGE_MOTIVATION_EFFECT())
            return true;
        if (Umapyoi.CONFIG.CHANCE_MOTIVATION_EFFECT() > 0) {
            if (entity.level().getRandom().nextDouble() <= Umapyoi.CONFIG.CHANCE_MOTIVATION_EFFECT())
                UmaStatusUtils.downMotivation(soul);
        }
        return true;
    }

    public static boolean onDamagePanicking(LivingEntity entity, DamageSource source, float amount) {
        ItemStack soul = UmapyoiAPI.getUmaSoul(entity);
        if (soul.isEmpty() || UmaSoulUtils.getMotivation(soul) != Motivations.BAD)
            return true;
        if (amount < Umapyoi.CONFIG.DAMAGE_MOTIVATION_EFFECT())
            return true;
        if (Umapyoi.CONFIG.CHANCE_MOTIVATION_EFFECT() > 0) {
            if (entity.level().getRandom().nextDouble() <= Umapyoi.CONFIG.CHANCE_MOTIVATION_EFFECT())
                entity.addEffect(new MobEffectInstance(MobEffectRegistry.PANICKING.get(), 3600));
        }
        return true;
    }

    public static boolean onTrainingFinished(SupportStack stack, ItemStack soul) {
        UmaSkillUtils.syncActionPoint(soul);
        CompoundTag tag = soul.getOrCreateTag();
        tag.putInt("resultRanking", ResultRankingUtils.generateRanking(soul));
        return false;
    }

    public static boolean onFactorFinished(UmaFactorStack stack, ItemStack soul) {
        UmaSkillUtils.syncActionPoint(soul);
        CompoundTag tag = soul.getOrCreateTag();
        tag.putInt("resultRanking", ResultRankingUtils.generateRanking(soul));
        return false;
    }
}
