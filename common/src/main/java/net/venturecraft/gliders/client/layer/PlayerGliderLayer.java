package net.venturecraft.gliders.client.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.venturecraft.gliders.VCGliders;
import net.venturecraft.gliders.client.model.GliderModel;
import net.venturecraft.gliders.client.model.ModelRegistry;
import net.venturecraft.gliders.client.model.XWingModel;
import net.venturecraft.gliders.common.item.GliderItem;
import net.venturecraft.gliders.util.GliderUtil;

public class PlayerGliderLayer<T extends HumanoidRenderState, M extends HumanoidModel<T>, A extends HumanoidModel<T>> extends RenderLayer<T, M> {

    private static final ResourceLocation COPPER_EMBED = VCGliders.id( "textures/entity/glider/copper_overlay.png");
    private static final ResourceLocation NETHER_UPGRADE = VCGliders.id( "textures/entity/glider/nether_upgrade_overlay.png");
    private static final ResourceLocation COPPER_EMBED_CHARGED = VCGliders.id( "textures/entity/glider/copper_overlay_charged.png");
    private static final ResourceLocation XWING_TEXTURE = VCGliders.id( "textures/entity/glider/xwing.png");
    public static GliderModel gliderModel;
    public static XWingModel<EntityRenderState> xWingModel;


    public PlayerGliderLayer(RenderLayerParent<T, M> renderLayerParent) {
        super(renderLayerParent);
        gliderModel = new GliderModel(Minecraft.getInstance().getEntityModels().bakeLayer(ModelRegistry.GLIDER));
        xWingModel = new XWingModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelRegistry.X_WING));
    }

    public static ResourceLocation getGliderTexture(ItemStack stack) {
        if (stack.getDisplayName().getString().contains("xwing")) return XWING_TEXTURE;
        ResourceLocation itemLoc = GliderUtil.getItemId(stack.getItem());
        return ResourceLocation.fromNamespaceAndPath(itemLoc.getNamespace(), "textures/entity/glider/" + itemLoc.getPath() + ".png");
    }

    public static ResourceLocation getGliderTexture(EntityRenderState state) {
        return getGliderTexture(GliderUtil.getItem(state));
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, T renderState, float yRot, float xRot) {
        if (renderState.isInvisibleToPlayer) return;

        // Render above players when gliding
        if (GliderUtil.isGlidingWithActiveGlider(renderState)) {
            poseStack.pushPose();
            var stack = GliderUtil.getItem(renderState);


            if (GliderItem.isSpaceGlider(stack)) {
                // Translate and render base glider
                poseStack.translate(0, -1.9, -0.5);
                xWingModel.setupAnim(renderState);
                nodeCollector.submitModel(xWingModel, renderState, poseStack, RenderType.entityCutoutNoCull(getGliderTexture(renderState)), packedLight, OverlayTexture.NO_OVERLAY, -1, null);
            } else {

                // Translate and render base glider
                poseStack.translate(0, -1.8, 0);
                gliderModel.setupAnim(renderState);
                nodeCollector.submitModel(gliderModel, renderState, poseStack, RenderType.entityCutoutNoCull(getGliderTexture(renderState)), packedLight, OverlayTexture.NO_OVERLAY, -1, null);


                // Has Coppered Embedded
                if (GliderItem.hasCopperUpgrade(stack)) {
                    gliderModel.setupAnim(renderState);
                    nodeCollector.submitModel(gliderModel, renderState, poseStack, RenderType.eyes(GliderItem.hasBeenStruck(stack) ? COPPER_EMBED_CHARGED : COPPER_EMBED), packedLight, OverlayTexture.NO_OVERLAY, -1, null);
                }

                // Has Nether Embedded
                if (GliderItem.hasNetherUpgrade(stack)) {
                    gliderModel.setupAnim(renderState);
                    nodeCollector.submitModel(gliderModel, renderState, poseStack, RenderType.entityCutoutNoCull(NETHER_UPGRADE), packedLight, OverlayTexture.NO_OVERLAY, -1, null);
                }
            }
            poseStack.popPose();
        }

    }

}