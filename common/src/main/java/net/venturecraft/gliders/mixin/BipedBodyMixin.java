package net.venturecraft.gliders.mixin;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.venturecraft.gliders.client.animation.AnimationHandler;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(HumanoidModel.class)
public class BipedBodyMixin {

    @Inject(at = @At("TAIL"), method = "setupAnim(Lnet/minecraft/client/renderer/entity/state/HumanoidRenderState;)V")
    private void setupAnimTail(HumanoidRenderState humanoidRenderState, CallbackInfo ci) {

    }


}