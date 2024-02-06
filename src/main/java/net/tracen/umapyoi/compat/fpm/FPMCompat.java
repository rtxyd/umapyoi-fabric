package net.tracen.umapyoi.compat.fpm;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.tracen.umapyoi.client.model.UmaPlayerModel;

import dev.tr7zw.firstperson.api.FirstPersonAPI;

@Environment(EnvType.CLIENT)
public final class FPMCompat {
    public static void hideHead(UmaPlayerModel<?> model) {
        if(FirstPersonAPI.isRenderingPlayer()) {
            model.head.visible = false;
            if(!model.hat.isEmpty()) model.hat.visible = false;
        }
    }
    
    public static void showHead(UmaPlayerModel<?> model) {
        model.head.visible = true;
        if(!model.hat.isEmpty()) model.hat.visible = true;
    }
}
