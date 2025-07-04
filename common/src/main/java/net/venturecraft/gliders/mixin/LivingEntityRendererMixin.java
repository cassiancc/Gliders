package net.venturecraft.gliders.mixin;

import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.venturecraft.gliders.access.LivingEntityRenderStateAccess;
import net.venturecraft.gliders.common.compat.trinket.CuriosTrinketsUtil;
import net.venturecraft.gliders.util.GliderUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {

    @Inject(method = "extractRenderState(Lnet/minecraft/world/entity/LivingEntity;Lnet/minecraft/client/renderer/entity/state/LivingEntityRenderState;F)V", at = @At(value = "RETURN"))
    private void mixin(LivingEntity livingEntity, LivingEntityRenderState livingEntityRenderState, float f, CallbackInfo ci) {
        var access = ((LivingEntityRenderStateAccess) livingEntityRenderState);
        access.vc_gliders$setIsGliding(GliderUtil.isGlidingWithActiveGlider(livingEntity));
        access.vc_gliders$setHasGlider(GliderUtil.hasGliderEquipped(livingEntity));
        access.vc_gliders$setItem(CuriosTrinketsUtil.getInstance().getFirstFoundGlider(livingEntity));
    }
}
