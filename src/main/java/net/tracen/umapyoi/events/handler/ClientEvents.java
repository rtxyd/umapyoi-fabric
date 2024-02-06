package net.tracen.umapyoi.events.handler;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ElytraItem;
import net.minecraft.world.item.ItemStack;
import net.tracen.umapyoi.Umapyoi;
import net.tracen.umapyoi.api.UmapyoiAPI;
import net.tracen.umapyoi.client.model.UmaPlayerModel;
import net.tracen.umapyoi.utils.ClientUtils;
import net.tracen.umapyoi.utils.UmaSoulUtils;

@Environment(EnvType.CLIENT)
public class ClientEvents {
    private static NonNullList<ItemStack> armor;

    public static void onPlayerRendering(PlayerRenderer renderer,  AbstractClientPlayer player, float entityYaw, float partialTicks,
                                         PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        ItemStack umasoul = UmapyoiAPI.getUmaSoul(player);
        if (!umasoul.isEmpty() && UmapyoiAPI.isUmaSoulRendering(player)) {
            renderer.getModel().setAllVisible(false);
            if (!Umapyoi.CONFIG.VANILLA_ARMOR_RENDER()) {
                armor = NonNullList.create();
                for (int i = 0; i < player.getInventory().armor.size(); ++i) {
                    armor.add(player.getInventory().armor.get(i).copy());
                    if (Umapyoi.CONFIG.ELYTRA_RENDER()
                            && player.getInventory().armor.get(i).getItem() instanceof ElytraItem)
                        player.getInventory().armor.set(i, player.getInventory().armor.get(i));
                    else
                        player.getInventory().armor.set(i, ItemStack.EMPTY);
                }
            }
        }
    }

    public static void onPlayerRenderingPost(PlayerRenderer renderer, AbstractClientPlayer player, float entityYaw, float partialTicks,
                                             PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if (!Umapyoi.CONFIG.VANILLA_ARMOR_RENDER() && armor != null && UmapyoiAPI.isUmaSoulRendering(player)) {
            for (int i = 0; i < player.getInventory().armor.size(); ++i) {
                player.getInventory().armor.set(i, armor.get(i));
            }
        }
    }

    public static boolean onPlayerArmRendering(PoseStack poseStack, MultiBufferSource buffer, int combinedLight,
                                            AbstractClientPlayer player, HumanoidArm arm) {
        ItemStack umasoul = UmapyoiAPI.getUmaSoul(player);
        if (!umasoul.isEmpty() && UmapyoiAPI.isUmaSoulRendering(player)) {
            ResourceLocation name = UmaSoulUtils.getName(umasoul);
            VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityTranslucent(getTexture(name)));
            UmaPlayerModel<LivingEntity> base_model = new UmaPlayerModel<>(ClientUtils.getModelPOJO(name));

            base_model.setModelProperties(player);
            base_model.attackTime = 0.0F;
            base_model.crouching = false;
            base_model.swimAmount = 0.0F;
            base_model.setupAnim(player, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
            if (arm == HumanoidArm.RIGHT) {
                base_model.rightArm.xRot = 0.0F;
                base_model.rightArm.x -=1F;
                base_model.rightArm.render(poseStack, vertexconsumer, combinedLight,
                        OverlayTexture.NO_OVERLAY);
                base_model.rightArm.x +=1F;
            } else {
                base_model.leftArm.xRot = 0.0F;
                base_model.leftArm.x +=1F;
                base_model.leftArm.render(poseStack, vertexconsumer, combinedLight,
                        OverlayTexture.NO_OVERLAY);
                base_model.leftArm.x -=1F;
            }
            return true;
        }
        return false;
    }

    private static ResourceLocation getTexture(ResourceLocation name) {
        return new ResourceLocation(name.getNamespace(), "textures/model/" + name.getPath() + ".png");
    }
}
