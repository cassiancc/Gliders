package net.venturecraft.gliders.neoforge;


import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.loading.FMLEnvironment;
import net.venturecraft.gliders.VCGliders;
import net.venturecraft.gliders.VCGlidersClient;
import net.venturecraft.gliders.compat.trinket.CuriosUtil;
import net.venturecraft.gliders.data.neoforge.VCAttachments;

@Mod(VCGliders.MOD_ID)
@EventBusSubscriber(modid = VCGliders.MOD_ID)
public class VCGlidersNeoForge {

    public VCGlidersNeoForge(IEventBus eventBus, ModContainer container) {
        VCGliders.init("neoforge");
        VCAttachments.register(eventBus);

        if (FMLEnvironment.dist.isClient()) {
            VCGlidersClient.init();
        }
        if (ModList.get().isLoaded("curios")) {
            CuriosUtil.init(eventBus);
        }
    }
}
