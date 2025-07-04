package net.venturecraft.gliders.common.item;

import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraft.world.item.component.CustomModelData;
import net.minecraft.world.item.component.TooltipDisplay;
import net.minecraft.world.item.equipment.Equippable;
import net.venturecraft.gliders.util.ModConstants;

import java.util.List;
import java.util.function.Consumer;

public class GliderItem extends Item {

    public GliderItem(Properties itemProperties, TagKey<Item> stackSupplier) {
        super(itemProperties.component(DataComponents.EQUIPPABLE, Equippable.builder(EquipmentSlot.CHEST).setEquipSound(SoundEvents.ARMOR_EQUIP_ELYTRA).build()).repairable(stackSupplier));
    }

    public static boolean isSpaceGlider(ItemStack stack) {
        return stack.getDisplayName().getString().contains("xwing");
    }

    public static ItemStack setCopper(ItemStack itemStack, boolean copper) {
        if (hasNetherUpgrade(itemStack)) {
            itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(), List.of("combined"), List.of()));
        } else {
            itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(), List.of("copper"), List.of()));
        }
        itemStack.set(ItemComponentRegistry.COPPER_UPGRADE.get(), copper);
        return itemStack;
    }

    public static boolean hasCopperUpgrade(ItemStack itemStack) {
        DataComponentMap compound = itemStack.getComponents();
        if (!compound.has(ItemComponentRegistry.COPPER_UPGRADE.get())) return false;
        return compound.get(ItemComponentRegistry.COPPER_UPGRADE.get());
    }

    public static ItemStack setNether(ItemStack itemStack, boolean copper) {
        if (hasCopperUpgrade(itemStack)) {
            itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(), List.of("combined"), List.of()));
        } else {
            itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(), List.of("nether"), List.of()));
        }
        itemStack.set(ItemComponentRegistry.NETHER_UPGRADE.get(), copper);
        return itemStack;
    }

    public static boolean hasNetherUpgrade(ItemStack itemStack) {
        DataComponentMap compound = itemStack.getComponents();
        if (!compound.has(ItemComponentRegistry.NETHER_UPGRADE.get())) return false;
        return compound.get(ItemComponentRegistry.NETHER_UPGRADE.get());
    }

    public static boolean isGlidingEnabled(ItemStack itemStack) {
        DataComponentMap compound = itemStack.getComponents();
        if (!compound.has(ItemComponentRegistry.GLIDE.get())) return false;
        return compound.get(ItemComponentRegistry.GLIDE.get()) && !isBroken(itemStack);
    }

    public static boolean isTooBroken(ItemStack itemStack) {
        return !(itemStack.getDamageValue() < itemStack.getMaxDamage() - 1);
    }

    public static void setGlide(ItemStack itemStack, boolean canGlide) {
        itemStack.set(ItemComponentRegistry.GLIDE.get(), canGlide);
    }

    public static void setBroken(ItemStack itemStack, boolean broken) {
        itemStack.set(ItemComponentRegistry.BROKEN.get(), broken);
    }

    public static boolean isBroken(ItemStack itemStack) {
        DataComponentMap compound = itemStack.getComponents();
        if (!compound.has(ItemComponentRegistry.BROKEN.get())) return false;
        return compound.get(ItemComponentRegistry.BROKEN.get());
    }

    public static void setStruck(ItemStack itemStack, boolean isStruck) {
        if (isStruck) {
            itemStack.set(DataComponents.CUSTOM_MODEL_DATA, new CustomModelData(List.of(), List.of(), List.of("damaged"), List.of()));
        }
        itemStack.set(ItemComponentRegistry.STRUCK.get(), isStruck);
    }

    public static boolean hasBeenStruck(ItemStack itemStack) {
        DataComponentMap compound = itemStack.getComponents();
        if (!compound.has(ItemComponentRegistry.STRUCK.get())) return false;
        return compound.get(ItemComponentRegistry.STRUCK.get());
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltip, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltipDisplay, tooltip, tooltipFlag);

        if (hasCopperUpgrade(stack) || hasNetherUpgrade(stack)) {
            tooltip.accept(Component.translatable(ModConstants.INSTALLED_UPGRADES));
            if (hasCopperUpgrade(stack)) {
                tooltip.accept(Component.literal("- ").append(Component.translatable(ModConstants.COPPER_UPGRADE)));
            }

            if (hasNetherUpgrade(stack)) {
                tooltip.accept(Component.literal("- ").append(Component.translatable(ModConstants.NETHER_UPGRADE)));
            }
        }
    }

}