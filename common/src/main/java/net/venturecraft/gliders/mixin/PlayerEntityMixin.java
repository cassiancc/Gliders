package net.venturecraft.gliders.mixin;

import commonnetwork.api.Network;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.venturecraft.gliders.client.animation.AnimationHandler;
import net.venturecraft.gliders.common.compat.trinket.CuriosTrinketsUtil;
import net.venturecraft.gliders.common.item.GliderItem;
import net.venturecraft.gliders.data.GliderData;
import net.venturecraft.gliders.network.MessageToggleGlide;
import net.venturecraft.gliders.util.GliderUtil;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import static net.venturecraft.gliders.util.GliderUtil.canDeployHere;

@Mixin(Player.class)
public class PlayerEntityMixin {
    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void tick(CallbackInfo info) {
        var player = (Player) (Object) this;
        GliderData.tick(player);
    }

    @Inject(method = "attack", at = @At(value = "HEAD"), cancellable = true)
    private void livingEntityAttack(CallbackInfo info) {
        var player = (Player) (Object) this;
        if (GliderUtil.isGlidingWithActiveGlider(player)) info.cancel();
    }

    @Inject(method = "hurtServer", at = @At(value = "HEAD"), cancellable = true)
    private void livingEntityHurt(ServerLevel level, DamageSource damageSource, float amount, CallbackInfoReturnable<Boolean> cir) {
        var player = (Player) (Object) this;
        ItemStack chestItem = CuriosTrinketsUtil.getInstance().getFirstFoundGlider(player);
        boolean hasCopperMod = GliderItem.hasCopperUpgrade(chestItem);
        boolean isGliding = GliderUtil.isGlidingWithActiveGlider(player);
        boolean isLightning = damageSource.is(DamageTypes.LIGHTNING_BOLT);
        if (hasCopperMod && isGliding && isLightning) {
            cir.setReturnValue(false);
        }
    }

    // Logically, I could just write logic for checking if the player press space while falling, but if the logic already exists in the vanilla game...it does make sense to use it
    @Inject(method = "tryToStartFallFlying", at = @At(value = "HEAD"))
    private void aiStep(CallbackInfoReturnable<Boolean> cir) {
        Player localPlayer = (Player) (Object) this;

        if (GliderUtil.hasGliderEquipped(localPlayer) && canDeployHere(localPlayer)) {
            Network.getNetworkHandler().sendToServer(new MessageToggleGlide());
            AnimationHandler.startGliderAnimation(localPlayer, true);
        }
    }
}
