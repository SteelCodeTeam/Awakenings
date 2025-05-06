package team.steelcode.awakenings.mixin;

import com.mojang.blaze3d.resource.CrossFrameResourcePool;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelTargetBundle;
import net.minecraft.client.renderer.PostChain;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.data.ModAttributes;

import java.util.Set;

//Credits to Startraveler on Discord!
@Mixin(GameRenderer.class)
public class GameRendererAddPostShadersMixin {

    @Shadow
    @Final
    private static ResourceLocation BLUR_POST_CHAIN_ID;
    @Final
    @Shadow
    private Minecraft minecraft;
    @Final
    @Shadow
    private CrossFrameResourcePool resourcePool;

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/LevelRenderer;doEntityOutline()V", shift = At.Shift.AFTER))
    private void verdant$addColorblindFilter(DeltaTracker deltaTracker, boolean renderLevel, CallbackInfo ci) {
        Player player = this.minecraft.player;
        // Make sure there is actually a player. (This should never fail, but it's good to be safe I guess).
        if (player != null) {
            // Check if the player has the colorblind effect. Do other checks here as needed.

            double breaths = player.getAttribute(ModAttributes.BREATHS).getBaseValue();

            if (breaths <= 0) {
                ResourceLocation RL = ResourceLocation.fromNamespaceAndPath(
                        Awakenings.MODID, "without_elevation");

                // If the player has the colorblind effect, get the post shader.

                PostChain postchain = this.minecraft.getShaderManager()
                        .getPostChain(RL, LevelTargetBundle.MAIN_TARGETS);

                if (postchain != null) {
                    // If the post shader was found, then apply it. If not, we probably have bigger problems; don't bother doing anything.
                    postchain.process(this.minecraft.getMainRenderTarget(), this.resourcePool);
                }
            } else if (breaths > 0 && breaths < 200) {
                ResourceLocation RL = ResourceLocation.fromNamespaceAndPath(
                        Awakenings.MODID, "decolored_vision");
                PostChain postchain = this.minecraft.getShaderManager()
                        .getPostChain(RL, LevelTargetBundle.MAIN_TARGETS);

                if (postchain != null) {
                    // If the post shader was found, then apply it. If not, we probably have bigger problems; don't bother doing anything.
                    postchain.process(this.minecraft.getMainRenderTarget(), this.resourcePool);
                }
            }


        }
    }
}