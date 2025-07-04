package net.venturecraft.gliders.access;

import net.minecraft.world.item.ItemStack;

public interface LivingEntityRenderStateAccess {
    boolean vc_gliders$hasGlider();
    boolean vc_gliders$isGliding();
    boolean vc_gliders$isXWing();
    ItemStack vc_gliders$getItem();
}
