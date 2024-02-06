package net.tracen.umapyoi.events.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.tracen.umapyoi.client.model.UmaPlayerModel;

@Environment(EnvType.CLIENT)
public interface RenderingModelCallback {
    boolean callback(LivingEntity entity, UmaPlayerModel<LivingEntity> model, float partialTick,
                  PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight);
}
