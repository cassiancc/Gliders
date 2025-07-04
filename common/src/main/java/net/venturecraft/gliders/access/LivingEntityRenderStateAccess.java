package net.venturecraft.gliders.access;

import net.minecraft.world.item.ItemStack;

public interface LivingEntityRenderStateAccess {
    boolean vc_gliders$hasGlider();
    boolean vc_gliders$isGliding();
    ItemStack vc_gliders$getItem();

    void vc_gliders$setHasGlider(boolean glider);
    void vc_gliders$setIsGliding(boolean glidingWithActiveGlider);
    void vc_gliders$setItem(ItemStack stack);
}
