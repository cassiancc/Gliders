package net.venturecraft.gliders;

import com.zigythebird.playeranim.animation.PlayerAnimationController;
import com.zigythebird.playeranim.api.PlayerAnimationFactory;
import com.zigythebird.playeranimcore.enums.PlayState;
import net.minecraft.client.OptionInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.venturecraft.gliders.client.layer.PlayerGliderLayer;
import net.venturecraft.gliders.client.model.ModelRegistry;
import net.venturecraft.gliders.common.item.GliderItem;
import net.venturecraft.gliders.common.item.ItemRegistry;
import net.venturecraft.gliders.registry.EntityRendererRegistry;
import net.venturecraft.gliders.registry.RegistrySupplier;
import net.venturecraft.gliders.util.ClientUtil;

public class VCGlidersClient {

    public static int lightLevel = 0;
    public static OptionInstance<Boolean> autoPerspective;
    public static final ResourceLocation LAYER = VCGliders.id("animation_layer");


    public static void init() {
        autoPerspective = OptionInstance.createBoolean("options.glider_perspective", false);
        ModelRegistry.init();
        EntityRendererRegistry.addRenderLayerToPlayer(renderLayerParent -> new PlayerGliderLayer(renderLayerParent));

        PlayerAnimationFactory.ANIMATION_DATA_FACTORY.registerFactory(LAYER, 1000,
                player -> new PlayerAnimationController(player,
                        (controller, state, animSetter) -> PlayState.STOP
                )
        );

    /*    ClientTickEvents.CLIENT_POST.register(new ClientTickEvents.ClientTick() {
            @Override
            public void clientTick(Minecraft minecraft) {
                LocalPlayer player = minecraft.player;
                if ((GliderKeybinds.ACTIVATE_GLIDER.consumeClick() || Minecraft.getInstance().options.keyJump.consumeClick())) {
                    if (GliderUtil.hasGliderEquipped(player) *//*&& GliderUtil.canDeployHere(player)*//*) {
                        new MessageToggleGlide().send();
                    }
                }
            }
        });*/
    }

    public static void clientSetup() {
    }

}
