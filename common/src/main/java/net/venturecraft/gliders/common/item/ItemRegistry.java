package net.venturecraft.gliders.common.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.venturecraft.gliders.VCGliders;
import net.venturecraft.gliders.registry.DeferredRegistry;
import net.venturecraft.gliders.registry.RegistrySupplier;
import net.venturecraft.gliders.util.VCGliderTags;

import static net.venturecraft.gliders.VCGliders.MOD_ID;

public class ItemRegistry {

    public static final DeferredRegistry<Item> ITEMS = DeferredRegistry.create(MOD_ID, Registries.ITEM);
//    public static CreativeModeTab MAIN = CreativeModeTabRegistry.create(Component.translatable("itemGroup." + VCGliders.MOD_ID + ".main"), () -> new ItemStack(ItemRegistry.PARAGLIDER_DIAMOND.get()));

    // Gliders
    public static final RegistrySupplier<Item> PARAGLIDER_WOOD = ITEMS.register("paraglider_wood", () -> new GliderItem((properties("paraglider_wood")).durability(50).rarity(Rarity.COMMON), VCGliderTags.REPAIRS_WOODEN_PARAGLIDER));
    public static final RegistrySupplier<Item> PARAGLIDER_IRON = ITEMS.register("paraglider_iron", () -> new GliderItem((properties("paraglider_iron")).durability(100).rarity(Rarity.UNCOMMON), VCGliderTags.REPAIRS_IRON_PARAGLIDER));
    public static final RegistrySupplier<Item> PARAGLIDER_GOLD = ITEMS.register("paraglider_gold", () -> new GliderItem((properties("paraglider_gold")).durability(200).rarity(Rarity.UNCOMMON), VCGliderTags.REPAIRS_GOLD_PARAGLIDER));
    public static final RegistrySupplier<Item> PARAGLIDER_DIAMOND = ITEMS.register("paraglider_diamond", () -> new GliderItem((properties("paraglider_diamond")).durability(300).rarity(Rarity.RARE), VCGliderTags.REPAIRS_DIAMOND_PARAGLIDER));
    public static final RegistrySupplier<Item> PARAGLIDER_NETHERITE = ITEMS.register("paraglider_netherite", () -> new GliderItem((properties("paraglider_netherite")).durability(500).rarity(Rarity.EPIC), VCGliderTags.REPAIRS_NETHERITE_PARAGLIDER));
    public static final RegistrySupplier<Item> COPPER_UPGRADE = ITEMS.register("copper_upgrade", () -> new Item((properties("copper_upgrade"))));
    public static final RegistrySupplier<Item> NETHER_UPGRADE = ITEMS.register("nether_upgrade", () -> new Item((properties("nether_upgrade"))));

    public static final RegistrySupplier<Item> REINFORCED_PAPER = ITEMS.register("reinforced_paper", () -> new Item(properties("reinforced_paper").rarity(Rarity.COMMON)));
    public static final RegistrySupplier<Item> REINFORCED_PAPER_IRON = ITEMS.register("reinforced_paper_iron", () -> new Item(properties("reinforced_paper_iron").rarity(Rarity.UNCOMMON)));
    public static final RegistrySupplier<Item> REINFORCED_PAPER_GOLD = ITEMS.register("reinforced_paper_gold", () -> new Item(properties("reinforced_paper_gold").rarity(Rarity.UNCOMMON)));
    public static final RegistrySupplier<Item> REINFORCED_PAPER_DIAMOND = ITEMS.register("reinforced_paper_diamond", () -> new Item(properties("reinforced_paper_diamond").rarity(Rarity.RARE)));
    public static final RegistrySupplier<Item> REINFORCED_PAPER_NETHERITE = ITEMS.register("reinforced_paper_netherite", () -> new Item(properties("reinforced_paper_netherite").rarity(Rarity.EPIC)));


    private static Item.Properties properties(String id) {
        return new Item.Properties().setId(ResourceKey.create(Registries.ITEM, VCGliders.id(id)));
    }
}
