package net.venturecraft.gliders.mixin.fabric;

import com.llamalad7.mixinextras.sugar.Local;
import com.mojang.blaze3d.resource.GraphicsResourceAllocator;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.client.CameraType;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.*;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.player.Player;
import net.venturecraft.gliders.client.layer.PlayerGliderLayer;
import net.venturecraft.gliders.common.compat.trinket.CuriosTrinketsUtil;
import net.venturecraft.gliders.common.item.GliderItem;
import net.venturecraft.gliders.util.GliderUtil;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public abstract class LevelRendererMixin {

    // TODO new inject point
//    @Inject(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V", ordinal = 15))
//    public void renderLevel(GraphicsResourceAllocator graphicsResourceAllocator, DeltaTracker deltaTracker, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, Matrix4f frustumMatrix, Matrix4f projectionMatrix, CallbackInfo ci, @Local  PoseStack posestack) {
//
//        RenderBuffers bufferSource = Minecraft.getInstance().renderBuffers();
//
//        Player living = Minecraft.getInstance().player;
//        EntityRenderState state = Minecraft.getInstance().getEntityRenderDispatcher().getRenderer(living).createRenderState();
//        var stack = CuriosTrinketsUtil.getInstance().getFirstFoundGlider(living);
//
//
//        if (Minecraft.getInstance().options.getCameraType() == CameraType.FIRST_PERSON && stack.getItem() instanceof GliderItem && GliderUtil.isGlidingWithActiveGlider(living) && state instanceof HumanoidRenderState humanoidRenderState) {
//            posestack.pushPose();
//            posestack.mulPose(Axis.XP.rotationDegrees(180));
//            posestack.mulPose(Axis.YP.rotationDegrees(living.getViewYRot(1F)));
//            posestack.translate(0, -2.4, -0.5);
//            posestack.scale(1.5F, 1.5F, 1.5F);
//
//            if (GliderItem.isSpaceGlider(stack)) {
//                posestack.mulPose(Axis.YP.rotationDegrees(180));
//                posestack.translate(0, -0.2, 0);
//                PlayerGliderLayer.xWingModel.setupAnim(humanoidRenderState);
//                PlayerGliderLayer.xWingModel.renderToBuffer(posestack, bufferSource.bufferSource().getBuffer(RenderType.entityCutoutNoCull(PlayerGliderLayer.getGliderTexture(stack))), LevelRenderer.getLightColor(living.level(), living.blockPosition()), OverlayTexture.NO_OVERLAY, 1);
//            } else {
//                PlayerGliderLayer.gliderModel.setupAnim(humanoidRenderState);
//                PlayerGliderLayer.gliderModel.renderToBuffer(posestack, bufferSource.bufferSource().getBuffer(RenderType.entityCutoutNoCull(PlayerGliderLayer.getGliderTexture(stack))), LevelRenderer.getLightColor(living.level(), living.blockPosition()), OverlayTexture.NO_OVERLAY, 1);
//            }
//            posestack.popPose();
//        }
//
//    }


}
