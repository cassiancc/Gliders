package net.venturecraft.gliders.client.animation;


import com.zigythebird.playeranim.animation.PlayerAnimationController;
import com.zigythebird.playeranim.api.PlayerAnimationAccess;
import com.zigythebird.playeranimcore.animation.Animation;
import com.zigythebird.playeranimcore.animation.layered.IAnimation;
import com.zigythebird.playeranimcore.animation.layered.ModifierLayer;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.world.entity.player.Player;
import net.venturecraft.gliders.VCGliders;
import net.venturecraft.gliders.VCGlidersClient;
import net.venturecraft.gliders.util.GliderUtil;

public class AnimationHandler {

    public static void startGliderAnimation(Player player, boolean gliding) {
        if (player instanceof AbstractClientPlayer clientPlayer) {
            PlayerAnimationController controller = (PlayerAnimationController) PlayerAnimationAccess.getPlayerAnimationLayer(clientPlayer, VCGlidersClient.LAYER);

            if (GliderUtil.isGlidingWithActiveGlider(player) || gliding) {
                if (controller.getCurrentAnimation() == null) {
                    controller.triggerAnimation(VCGliders.id("gliding"));
                }
            } else {
                controller.stopTriggeredAnimation();
            }
        }
    }

}