package net.venturecraft.gliders.mixin;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.venturecraft.gliders.client.animation.AnimationHandler;
import net.venturecraft.gliders.util.GliderUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LocalPlayer.class)
public class LocalPlayerMixin {

    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void tick(CallbackInfo ci) {
        LocalPlayer localPlayer = (LocalPlayer) (Object) this;
        AnimationHandler.startGliderAnimation(localPlayer, GliderUtil.isGlidingWithActiveGlider(localPlayer));
    }


}