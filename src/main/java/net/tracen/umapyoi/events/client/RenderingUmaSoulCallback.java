package net.tracen.umapyoi.events.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.LivingEntity;
import net.tracen.umapyoi.client.model.UmaPlayerModel;

@Environment(EnvType.CLIENT)
public interface RenderingUmaSoulCallback extends RenderingModelCallback {
    interface Pre extends RenderingUmaSoulCallback {
        Event<Pre> EVENT = EventFactory.createArrayBacked(Pre.class,
                (listeners) -> (entity, model, partialTick, poseStack, multiBufferSource, packedLight) -> {
                    for (Pre listener : listeners) {
                        if (listener.callback(entity, model, partialTick, poseStack, multiBufferSource, packedLight))
                            return true;
                    }

                    return false;
                });

        static boolean invoke(LivingEntity entity, UmaPlayerModel<LivingEntity> model, float partialTick,
                           PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
            return EVENT.invoker().callback(entity, model, partialTick, poseStack, multiBufferSource, packedLight);
        }
    }

    interface Post extends RenderingUmaSoulCallback {
        Event<Post> EVENT = EventFactory.createArrayBacked(Post.class,
                (listeners) -> (entity, model, partialTick, poseStack, multiBufferSource, packedLight) -> {
                    for (Post listener : listeners) {
                        if (listener.callback(entity, model, partialTick, poseStack, multiBufferSource, packedLight))
                            return true;
                    }

                    return false;
                });

        static boolean invoke(LivingEntity entity, UmaPlayerModel<LivingEntity> model, float partialTick,
                           PoseStack poseStack, MultiBufferSource multiBufferSource, int packedLight) {
            return EVENT.invoker().callback(entity, model, partialTick, poseStack, multiBufferSource, packedLight);
        }
    }
}
