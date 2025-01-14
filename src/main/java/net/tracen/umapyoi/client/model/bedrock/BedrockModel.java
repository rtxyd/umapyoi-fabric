package net.tracen.umapyoi.client.model.bedrock;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.world.phys.AABB;
import net.tracen.umapyoi.client.model.pojo.BedrockModelPOJO;
import net.tracen.umapyoi.client.model.pojo.BonesItem;
import net.tracen.umapyoi.client.model.pojo.CubesItem;
import net.tracen.umapyoi.client.model.pojo.Description;
import net.tracen.umapyoi.client.model.pojo.FaceUVsItem;
import net.tracen.umapyoi.utils.ClientUtils;

import java.util.HashMap;
import java.util.List;

public interface BedrockModel {
    BedrockModelPOJO getBedrockModelPOJO();
    void setBedrockModelPOJO(BedrockModelPOJO pojo);
    HashMap<String, BedrockPart> getModelMap();
    HashMap<String, BonesItem> getIndexBones();
    List<BedrockPart> getShouldRender();
    AABB getRenderBoundingBox();
    void setRenderBoundingBox(AABB aabb);

    default boolean needRefresh(BedrockModelPOJO pojo) {
        // if not same object, refresh it.
        return this.getBedrockModelPOJO() != pojo;
    }

    default void renderBedrockModel(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        for (BedrockPart model : this.getShouldRender()) {
            model.render(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }

    default void renderEmissiveParts(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
        for (BedrockPart model : this.getShouldRender()) {
            model.renderEmissive(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
        }
    }

    boolean isEmissive();

    void setEmissive(boolean emissive);

    default void loadModel(BedrockModelPOJO pojo) {
        this.getModelMap().clear();
        this.getIndexBones().clear();
        this.getShouldRender().clear();
        String formatVersion = pojo.getFormatVersion();
        if (formatVersion.equals(BedrockVersion.LEGACY.getVersion())) {
            loadLegacyModel(pojo);
        } else if (formatVersion.equals(BedrockVersion.NEW.getVersion())) {
            loadNewModel(pojo);
        }
        this.setBedrockModelPOJO(pojo);
    }

    default void loadNewModel(BedrockModelPOJO pojo) {
        assert pojo.getGeometryModelNew() != null;
        pojo.getGeometryModelNew().deco();

        Description description = pojo.getGeometryModelNew().getDescription();

        int texWidth = description.getTextureWidth();
        int texHeight = description.getTextureHeight();

        List<Float> offset = description.getVisibleBoundsOffset();
        float offsetX = offset.get(0);
        float offsetY = offset.get(1);
        float offsetZ = offset.get(2);
        float width = description.getVisibleBoundsWidth() / 2.0f;
        float height = description.getVisibleBoundsHeight() / 2.0f;
        this.setRenderBoundingBox(new AABB(offsetX - width, offsetY - height, offsetZ - width, offsetX + width, offsetY + height, offsetZ + width));
        // Ensure default emissive setting is false, so we can change POJO safely.
        this.setEmissive(false);

        for (BonesItem bones : pojo.getGeometryModelNew().getBones()) {
            this.getIndexBones().put(bones.getName(), bones);
            this.getModelMap().put(bones.getName(), new BedrockPart());
        }

        for (BonesItem bones : pojo.getGeometryModelNew().getBones()) {
            String name = bones.getName();
            List<Float> rotation = bones.getRotation();
            String parent = bones.getParent();
            BedrockPart model = this.getModelMap().get(name);
            if(name.startsWith("emissive")) {
                model.setEmissive(true);
                this.setEmissive(true);
            }
            model.mirror = bones.isMirror();

            model.setPos(convertPivot(bones, 0), convertPivot(bones, 1), convertPivot(bones, 2));

            if (rotation != null) {
                setRotationAngle(model, ClientUtils.convertRotation(rotation.get(0)), ClientUtils.convertRotation(rotation.get(1)), ClientUtils.convertRotation(rotation.get(2)));
            }

            if (parent != null) {
                var parentPart = this.getModelMap().get(parent);
                parentPart.addChild(model);
            } else {
                this.getShouldRender().add(model);
            }

            if (bones.getCubes() == null) {
                continue;
            }

            for (CubesItem cube : bones.getCubes()) {
                List<Float> uv = cube.getUv();
                FaceUVsItem faceUv = cube.getFaceUv();
                List<Float> size = cube.getSize();
                List<Float> cubeRotation = cube.getRotation();
                boolean mirror = cube.isMirror();
                float inflate = cube.getInflate();

                if (cubeRotation == null) {
                    if (faceUv == null) {
                        model.cubes.add(new BedrockCube(uv.get(0), uv.get(1),
                                convertOrigin(bones, cube, 0), convertOrigin(bones, cube, 1), convertOrigin(bones, cube, 2),
                                size.get(0), size.get(1), size.get(2), inflate, mirror,
                                texWidth, texHeight));
                    } else {
                        model.cubes.add(new BedrockCube(
                                convertOrigin(bones, cube, 0), convertOrigin(bones, cube, 1), convertOrigin(bones, cube, 2),
                                size.get(0), size.get(1), size.get(2), inflate,
                                texWidth, texHeight, faceUv));
                    }
                }

                else {
                    BedrockPart cubeRenderer = new BedrockPart();
                    cubeRenderer.setPos(convertPivot(bones, cube, 0), convertPivot(bones, cube, 1), convertPivot(bones, cube, 2));
                    setRotationAngle(cubeRenderer, ClientUtils.convertRotation(cubeRotation.get(0)), ClientUtils.convertRotation(cubeRotation.get(1)), ClientUtils.convertRotation(cubeRotation.get(2)));
                    if (faceUv == null) {
                        cubeRenderer.cubes.add(new BedrockCube(uv.get(0), uv.get(1),
                                convertOrigin(cube, 0), convertOrigin(cube, 1), convertOrigin(cube, 2),
                                size.get(0), size.get(1), size.get(2), inflate, mirror,
                                texWidth, texHeight));
                    } else {
                        cubeRenderer.cubes.add(new BedrockCube(
                                convertOrigin(cube, 0), convertOrigin(cube, 1), convertOrigin(cube, 2),
                                size.get(0), size.get(1), size.get(2), inflate,
                                texWidth, texHeight, faceUv));
                    }

                    model.addChild(cubeRenderer);
                }
            }
        }
    }

    default void loadLegacyModel(BedrockModelPOJO pojo) {
        assert pojo.getGeometryModelLegacy() != null;
        pojo.getGeometryModelLegacy().deco();

        int texWidth = pojo.getGeometryModelLegacy().getTextureWidth();
        int texHeight = pojo.getGeometryModelLegacy().getTextureHeight();

        List<Float> offset = pojo.getGeometryModelLegacy().getVisibleBoundsOffset();
        float offsetX = offset.get(0);
        float offsetY = offset.get(1);
        float offsetZ = offset.get(2);
        float width = pojo.getGeometryModelLegacy().getVisibleBoundsWidth() / 2.0f;
        float height = pojo.getGeometryModelLegacy().getVisibleBoundsHeight() / 2.0f;
        this.setRenderBoundingBox(new AABB(offsetX - width, offsetY - height, offsetZ - width, offsetX + width, offsetY + height, offsetZ + width));
        // Ensure default emissive setting is false, so we can change POJO safely.
        this.setEmissive(false);

        for (BonesItem bones : pojo.getGeometryModelLegacy().getBones()) {
            this.getIndexBones().put(bones.getName(), bones);
            this.getModelMap().put(bones.getName(), new BedrockPart());
        }

        for (BonesItem bones : pojo.getGeometryModelLegacy().getBones()) {
            String name = bones.getName();
            List<Float> rotation = bones.getRotation();
            String parent = bones.getParent();
            BedrockPart model = this.getModelMap().get(name);
            if(name.startsWith("emissive")) {
                model.setEmissive(true);
                this.setEmissive(true);
            }
            model.mirror = bones.isMirror();

            model.setPos(convertPivot(bones, 0), convertPivot(bones, 1), convertPivot(bones, 2));

            if (rotation != null) {
                setRotationAngle(model, ClientUtils.convertRotation(rotation.get(0)), ClientUtils.convertRotation(rotation.get(1)), ClientUtils.convertRotation(rotation.get(2)));
            }

            if (parent != null) {
                this.getModelMap().get(parent).addChild(model);
            } else {
                this.getShouldRender().add(model);
            }

            if (bones.getCubes() == null) {
                continue;
            }

            for (CubesItem cube : bones.getCubes()) {
                List<Float> uv = cube.getUv();
                List<Float> size = cube.getSize();
                boolean mirror = cube.isMirror();
                float inflate = cube.getInflate();

                model.cubes.add(new BedrockCube(uv.get(0), uv.get(1),
                        convertOrigin(bones, cube, 0), convertOrigin(bones, cube, 1), convertOrigin(bones, cube, 2),
                        size.get(0), size.get(1), size.get(2), inflate, mirror,
                        texWidth, texHeight));
            }
        }
    }

    default void setRotationAngle(BedrockPart modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }

    default float convertPivot(BonesItem bones, int index) {
        if (bones.getParent() != null) {
            if (index == 1) {
                return getIndexBones().get(bones.getParent()).getPivot().get(index) - bones.getPivot().get(index);
            } else {
                return bones.getPivot().get(index) - getIndexBones().get(bones.getParent()).getPivot().get(index);
            }
        } else {
            if (index == 1) {
                return 24 - bones.getPivot().get(index);
            } else {
                return bones.getPivot().get(index);
            }
        }
    }

    default float convertPivot(BonesItem parent, CubesItem cube, int index) {
        assert cube.getPivot() != null;
        if (index == 1) {
            return parent.getPivot().get(index) - cube.getPivot().get(index);
        } else {
            return cube.getPivot().get(index) - parent.getPivot().get(index);
        }
    }

    default float convertOrigin(BonesItem bone, CubesItem cube, int index) {
        if (index == 1) {
            return bone.getPivot().get(index) - cube.getOrigin().get(index) - cube.getSize().get(index);
        } else {
            return cube.getOrigin().get(index) - bone.getPivot().get(index);
        }
    }

    default float convertOrigin(CubesItem cube, int index) {
        assert cube.getPivot() != null;
        if (index == 1) {
            return cube.getPivot().get(index) - cube.getOrigin().get(index) - cube.getSize().get(index);
        } else {
            return cube.getOrigin().get(index) - cube.getPivot().get(index);
        }
    }

    default BedrockPart getChild(String partName) {
        return this.getModelMap().get(partName);
    }
}