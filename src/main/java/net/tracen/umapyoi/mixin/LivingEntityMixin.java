package net.tracen.umapyoi.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.tracen.umapyoi.attributes.ExtraAttributes;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(value = LivingEntity.class, priority = 500)
public abstract class LivingEntityMixin {
    @ModifyReturnValue(method = "createLivingAttributes", at = @At("RETURN"))
    private static AttributeSupplier.Builder addExtraAttributes(AttributeSupplier.Builder builder) {
        return builder.add(ExtraAttributes.SWIM_SPEED).add(ExtraAttributes.STEP_HEIGHT_ADDITION);
    }

    @ModifyArg(method = "travel", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;moveRelative(FLnet/minecraft/world/phys/Vec3;)V", ordinal = 0))
    private float swimSpeed(float origSpeed) {
        return origSpeed * (float)(((LivingEntity)(Object) this).getAttribute(ExtraAttributes.SWIM_SPEED)).getValue();
    }

    @ModifyArg(method = "jumpInLiquid", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/phys/Vec3;add(DDD)Lnet/minecraft/world/phys/Vec3;"), index = 1)
    private double modifySwimSpeed(double y) {
        return y * ((LivingEntity)(Object) this).getAttribute(ExtraAttributes.SWIM_SPEED).getValue();
    }

    @ModifyReturnValue(method = "maxUpStep", at = @At("RETURN"))
    private float modifyStepHeight(float origStep) {
        return (float) (origStep + ((LivingEntity)(Object) this).getAttribute(ExtraAttributes.STEP_HEIGHT_ADDITION).getValue());
    }
}