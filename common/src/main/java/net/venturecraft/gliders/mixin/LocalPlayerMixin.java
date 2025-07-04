package net.venturecraft.gliders.mixin;

import commonnetwork.api.Network;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Player;
import net.venturecraft.gliders.network.MessageToggleGlide;
import net.venturecraft.gliders.util.GliderUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.venturecraft.gliders.util.GliderUtil.canDeployHere;

@Mixin(Player.class)
public class LocalPlayerMixin {

    // Logically, I could just write logic for checking if the player press space while falling, but if the logic already exists in the vanilla game...it does make sense to use it
    @Inject(method = "tryToStartFallFlying", at = @At(value = "HEAD"))
    private void aiStep(CallbackInfoReturnable<Boolean> cir) {
        Player localPlayer = (Player) (Object) this;

        if (GliderUtil.hasGliderEquipped(localPlayer) && canDeployHere(localPlayer)) {
            Network.getNetworkHandler().sendToServer(new MessageToggleGlide());
        }
    }


}