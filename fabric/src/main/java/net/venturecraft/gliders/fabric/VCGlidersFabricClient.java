package net.venturecraft.gliders.fabric;

import com.zigythebird.playeranim.animation.PlayerAnimationController;
import com.zigythebird.playeranim.api.PlayerAnimationFactory;
import com.zigythebird.playeranimcore.enums.PlayState;
import net.fabricmc.api.ClientModInitializer;
import net.venturecraft.gliders.VCGliders;
import net.venturecraft.gliders.VCGlidersClient;

import static com.zigythebird.playeranim.PlayerAnimLibMod.ANIMATION_LAYER_ID;

public class VCGlidersFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        VCGlidersClient.init();
        FabricClientEvents.init();
    }
}
