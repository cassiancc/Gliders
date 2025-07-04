package net.venturecraft.gliders.client.animation;

import dev.kosmx.playerAnim.api.layered.IAnimation;
import dev.kosmx.playerAnim.api.layered.KeyframeAnimationPlayer;
import dev.kosmx.playerAnim.api.layered.ModifierLayer;
import dev.kosmx.playerAnim.core.data.KeyframeAnimation;
import dev.kosmx.playerAnim.minecraftApi.PlayerAnimationRegistry;
import net.minecraft.world.entity.player.Player;
import net.venturecraft.gliders.VCGliders;
import net.venturecraft.gliders.util.GliderUtil;

public class AnimationHandler {

    public static void startGliderAnimation(Player player, boolean gliding) {

        ModifierLayer<IAnimation> animationContainer = ((AnimatedPlayer) player).gliders_getModifierLayer();
        KeyframeAnimation gliderAnimation = (KeyframeAnimation) PlayerAnimationRegistry.getAnimation(VCGliders.id("gliding"));

        if (GliderUtil.isGlidingWithActiveGlider(player) || gliding) {
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