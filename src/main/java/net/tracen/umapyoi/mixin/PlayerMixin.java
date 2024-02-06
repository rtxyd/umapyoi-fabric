package net.tracen.umapyoi.mixin;

import net.minecraft.world.entity.player.Player;
import net.tracen.umapyoi.events.PlayerTickCallback;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Player.class)
public class PlayerMixin {
    @Inject(method = "tick", at = @At("HEAD"))
    public void preTick(CallbackInfo info) {
        PlayerTickCallback.invoke((Player)(Object) this);
    }
}