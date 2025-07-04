package net.venturecraft.gliders.mixin;

import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.world.item.ItemStack;
import net.venturecraft.gliders.access.LivingEntityRenderStateAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(LivingEntityRenderState.class)
public class LivingEntityRenderStateMixin implements LivingEntityRenderStateAccess {
    @Unique
    public boolean vc_gliders$isGliding;
    @Unique
    public boolean vc_gliders$hasGlider;
    @Unique
    public boolean vc_gliders$isXWing;
    @Unique
    public ItemStack vc_gliders$item;


    public LivingEntityRenderStateMixin() {
        vc_gliders$isGliding = false;
        vc_gliders$hasGlider = false;
        vc_gliders$isXWing = false;
        vc_gliders$item = ItemStack.EMPTY;
    }

    @Override
    public boolean vc_gliders$hasGlider() {
        return vc_gliders$hasGlider;
    }
    @Override
    public boolean vc_gliders$isGliding() {
        return vc_gliders$isGliding;
    }
    @Override
    public boolean vc_gliders$isXWing() {
        return vc_gliders$isXWing;
    }

    @Override
    public ItemStack vc_gliders$getItem() {
        return vc_gliders$item;
    }
}
