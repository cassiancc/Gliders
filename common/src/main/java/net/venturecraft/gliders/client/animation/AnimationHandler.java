package net.venturecraft.gliders.client.animation;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.venturecraft.gliders.VCGliders;
import net.venturecraft.gliders.util.GliderUtil;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class AnimationHandler {

    public static void startGliderAnimation(AbstractClientPlayer renderState) {

        ModifierLayer<IAnimation> animationContainer = ((AnimatedPlayer) renderState).gliders_getModifierLayer();
        KeyframeAnimation gliderAnimation = (KeyframeAnimation) PlayerAnimationRegistry.getAnimation(VCGliders.id("gliding"));

        if (GliderUtil.isGlidingWithActiveGlider(renderState)) {
            if (animationContainer.getAnimation() == null) {
                KeyframeAnimation.AnimationBuilder builder = null;
                if (gliderAnimation != null) {
                    builder = gliderAnimation.mutableCopy();
                }
                gliderAnimation = builder.build();
                animationContainer.setAnimation(new KeyframeAnimationPlayer(gliderAnimation));
            }
        } else {
            animationContainer.setAnimation(null);
        }
    }

}