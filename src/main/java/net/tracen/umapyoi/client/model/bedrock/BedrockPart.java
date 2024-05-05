package net.tracen.umapyoi.client.model.bedrock;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.geom.PartPose;

import org.apache.commons.compress.utils.Lists;
import org.joml.Quaternionf;

import java.util.List;
import java.util.Random;

@Environment(EnvType.CLIENT)
public final class BedrockPart {
    public final List<BedrockCube> cubes;
    private final List<BedrockPart> children;
    
    public float x;
    public float y;
    public float z;
    public float xRot;
    public float yRot;
    public float zRot;

    public boolean visible;
    public boolean mirror;
    public boolean emissive;

    public BedrockPart() {
        cubes = Lists.newArrayList();
        children = Lists.newArrayList();
        visible = true;
        emissive = false;
    }

    public void setPos(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public void render(PoseStack poseStack, VertexConsumer consumer, int texU, int texV) {
        this.render(poseStack, consumer, texU, texV, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void render(PoseStack poseStack, VertexConsumer consumer, int texU, int texV, float red, float green,
            float blue, float alpha) {
        if (this.visible) {
            renderCubes(false, poseStack, consumer, texU, texV, red, green, blue, alpha);
        }
    }
    
    public void renderEmissive(PoseStack poseStack, VertexConsumer consumer, int texU, int texV) {
        this.renderEmissive(poseStack, consumer, texU, texV, 1.0F, 1.0F, 1.0F, 1.0F);
    }

    public void renderEmissive(PoseStack poseStack, VertexConsumer consumer, int texU, int texV, float red, float green,
            float blue, float alpha) {
        if (this.visible) {
            renderCubes(true, poseStack, consumer, texU, texV, red, green, blue, alpha);
        }
    }

    public void renderCubes(boolean renderEmissive, PoseStack poseStack, VertexConsumer consumer, int texU, int texV, float red, float green,
            float blue, float alpha) {
        if (!this.isEmpty()) {
            poseStack.pushPose();
            this.translateAndRotate(poseStack);
            if(this.emissive == renderEmissive)
                this.compile(poseStack.last(), consumer, texU, texV, red, green, blue, alpha);
            
            for (BedrockPart part : this.children) {
                if(renderEmissive)
                    part.renderEmissive(poseStack, consumer, texU, texV, red, green, blue, alpha);
                else
                    part.render(poseStack, consumer, texU, texV, red, green, blue, alpha);
            }

            poseStack.popPose();
        }
    }
    
    public void translateAndRotate(PoseStack poseStack) {
        poseStack.translate(this.x / 16.0F, this.y / 16.0F, this.z / 16.0F);
        if (this.xRot != 0.0F || this.yRot != 0.0F || this.zRot != 0.0F) {
            poseStack.mulPose((new Quaternionf()).rotationZYX(this.zRot, this.yRot, this.xRot));
        }
     }

    private void compile(PoseStack.Pose pose, VertexConsumer consumer, int texU, int texV, float red, float green,
            float blue, float alpha) {
        for (BedrockCube bedrockCube : this.cubes) {
            bedrockCube.compile(pose, consumer, texU, texV, red, green, blue, alpha);
        }
    }
    
    public boolean isEmissive() {
        return emissive;
    }

    public void setEmissive(boolean emissive) {
        this.emissive = emissive;
    }

    public BedrockCube getRandomCube(Random random) {
        return this.cubes.get(random.nextInt(this.cubes.size()));
    }

    public boolean isEmpty() {
        return this.cubes.isEmpty() && this.children.isEmpty();
    }

    public PartPose storePose() {
        return PartPose.offsetAndRotation(this.x, this.y, this.z, this.xRot, this.yRot, this.zRot);
    }

    public void loadPose(PartPose pose) {
        this.x = pose.x;
        this.y = pose.y;
        this.z = pose.z;
        this.xRot = pose.xRot;
        this.yRot = pose.yRot;
        this.zRot = pose.zRot;
    }

    public void copyFrom(BedrockPart part) {
        this.xRot = part.xRot;
        this.yRot = part.yRot;
        this.zRot = part.zRot;
        this.x = part.x;
        this.y = part.y;
        this.z = part.z;
    }

    public void addChild(BedrockPart model) {
        if(this.isEmissive())
            model.setEmissive(true);
        this.children.add(model);
    }
    
    public List<BedrockPart> getChildren() {
        return children;
    }

}
