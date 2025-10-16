package net.venturecraft.gliders.fabric;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.venturecraft.gliders.VCGlidersClient;

public class FabricClientEvents {

    public static void init() {
        ClientLifecycleEvents.CLIENT_STARTED.register((minecraft -> VCGlidersClient.clientSetup()));
        /*
        WorldRenderEvents.AFTER_TRANSLUCENT.register((worldRenderContext -> {
            var posestack = worldRenderContext.matrixStack();
            RenderBuffers bufferSource = Minecraft.getInstance().renderBuffers();

            Player living = Minecraft.getInstance().player;
            EntityRenderState state = Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(living).createRenderState();
            var stack = CuriosTrinketsUtil.getInstance().getFirstFoundGlider(living);


            if (Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON && stack.getItem() instanceof GliderItem && GliderUtil.isGlidingWithActiveGlider(living) && state instanceof HumanoidRenderState humanoidRenderState) {
                posestack.pushPose();
                posestack.mulPose(Axis.XP.rotationDegrees(180));
                posestack.mulPose(Axis.YP.rotationDegrees(living.getViewYRot(1F)));
                posestack.translate(0, -2.4, -0.5);
                posestack.scale(1.5F, 1.5F, 1.5F);

                if (GliderItem.isSpaceGlider(stack)) {
                    posestack.mulPose(Axis.YP.rotationDegrees(180));
                    posestack.translate(0, -0.2, 0);
                    PlayerGliderLayer.xWingModel.setupAnim(humanoidRenderState);
                    PlayerGliderLayer.xWingModel.renderToBuffer(posestack, bufferSource.bufferSource().getBuffer(RenderType.entityCutoutNoCull(PlayerGliderLayer.getGliderTexture(stack))), LevelRenderer.getLightColor(living.level(), living.blockPosition()), OverlayTexture.NO_OVERLAY, -1);
                } else {
                    PlayerGliderLayer.gliderModel.setupAnim(humanoidRenderState);
                    PlayerGliderLayer.gliderModel.renderToBuffer(posestack, bufferSource.bufferSource().getBuffer(RenderType.entityCutoutNoCull(PlayerGliderLayer.getGliderTexture(stack))), LevelRenderer.getLightColor(living.level(), living.blockPosition()), OverlayTexture.NO_OVERLAY, -1);
                }
                posestack.popPose();
            }

        }));

         */
    }

}
