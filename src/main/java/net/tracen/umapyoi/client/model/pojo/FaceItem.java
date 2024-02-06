package net.tracen.umapyoi.client.model.pojo;

import com.google.gson.annotations.SerializedName;

public class FaceItem {
    @SerializedName("uv")
    private float[] uv;

    @SerializedName("uv_size")
    private float[] uvSize;

    public float[] getUv() {
        return uv;
    }

    public float[] getUvSize() {
        return uvSize;
    }

    public static FaceItem single16X() {
        FaceItem face = new FaceItem();
        face.uv = new float[]{0, 0};
        face.uvSize = new float[]{16, 16};
        return face;
    }

    public static FaceItem empty() {
        FaceItem face = new FaceItem();
        face.uv = new float[]{0, 0};
        face.uvSize = new float[]{0, 0};
        return face;
    }
}
