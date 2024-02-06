package net.tracen.umapyoi.events.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.event.Event;
import net.fabricmc.fabric.api.event.EventFactory;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.world.entity.HumanoidArm;

/**
 * Replacement for Forge's RenderArmEvent
 */
@Environment(EnvType.CLIENT)
public interface RenderArmCallback {
    boolean callback(PoseStack poseStack, MultiBufferSource buffer, int combinedLight, AbstractClientPlayer player, HumanoidArm arm);

    Event<RenderArmCallback> EVENT = EventFactory.createArrayBacked(RenderArmCallback.class,
            (listeners) -> (poseStack, buffer, combinedLight, player, arm) -> {
                for (RenderArmCallback listener : listeners) {
                    if (listener.callback(poseStack, buffer, combinedLight, player, arm)) return true;
                }

                return false;
            });

    static boolean invoke(PoseStack poseStack, MultiBufferSource buffer, int combinedLight, AbstractClientPlayer player, HumanoidArm arm) {
        return EVENT.invoker().callback(poseStack, buffer, combinedLight, player, arm);
    }
}
