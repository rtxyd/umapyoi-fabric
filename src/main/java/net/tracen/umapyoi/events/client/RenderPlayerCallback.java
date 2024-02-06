package net.tracen.umapyoi.events.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;

/**
 * Replacement for Forge's RenderPlayerEvent
 */
@Environment(EnvType.CLIENT)
public interface RenderPlayerCallback {
    void callback(PlayerRenderer renderer, AbstractClientPlayer entity, float entityYaw, float partialTicks,
                  PoseStack poseStack, MultiBufferSource buffer, int packedLight);

    interface Pre extends RenderPlayerCallback {
        Event<Pre> EVENT = EventFactory.createArrayBacked(Pre.class,
                (listeners) -> (renderer, entity, entityYaw, partialTicks, poseStack, buffer, packedLight) -> {
                    for (Pre listener : listeners) {
                        listener.callback(renderer, entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
                    }
                });

        static void invoke(PlayerRenderer renderer, AbstractClientPlayer entity, float entityYaw, float partialTicks,
                           PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
            EVENT.invoker().callback(renderer, entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        }
    }

    interface Post extends RenderPlayerCallback {
        Event<Post> EVENT = EventFactory.createArrayBacked(Post.class,
                (listeners) -> (renderer, entity, entityYaw, partialTicks, poseStack, buffer, packedLight) -> {
                    for (Post listener : listeners) {
                        listener.callback(renderer, entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
                    }
                });

        static void invoke(PlayerRenderer renderer, AbstractClientPlayer entity, float entityYaw, float partialTicks,
                           PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
            EVENT.invoker().callback(renderer, entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
        }
    }
}
