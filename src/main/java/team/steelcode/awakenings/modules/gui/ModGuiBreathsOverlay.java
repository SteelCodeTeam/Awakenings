package team.steelcode.awakenings.modules.gui;

import net.minecraft.client.DeltaTracker;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.LayeredDraw;
import net.minecraft.resources.ResourceLocation;
import team.steelcode.awakenings.Awakenings;
import team.steelcode.awakenings.data.ModAttributes;

import java.awt.*;

public class ModGuiBreathsOverlay implements LayeredDraw.Layer {

    private static final ResourceLocation[] SPRITE_LOCATIONS = new ResourceLocation[24];
    private static final int FRAME_COUNT = 24;
    private static int ACTUAL_FRAME = 0;
    private static int TICKS_PER_FRAME = 0;


    static {
        for (int i = 1; i <= FRAME_COUNT; i++ ) {
            SPRITE_LOCATIONS[i - 1] = ResourceLocation.fromNamespaceAndPath(Awakenings.MODID, "textures/gui/biocromatic_" + i + ".png");
        }
    }

    @Override
    public void render(GuiGraphics guiGraphics, DeltaTracker deltaTracker) {
        Double breaths = Minecraft.getInstance().player.getAttribute(ModAttributes.BREATHS).getValue();

        float color = (float) ACTUAL_FRAME / (float) FRAME_COUNT;

        int rgbColor = Color.HSBtoRGB(color, 1.0f, 1.0f);

        guiGraphics.blitInscribed(SPRITE_LOCATIONS[ACTUAL_FRAME], 0, 0, 16, 16, 16, 16);

        guiGraphics.drawString(Minecraft.getInstance().font, String.valueOf(breaths.intValue()), 16, 5, rgbColor, true);

        if (TICKS_PER_FRAME % 10 == 0) {
            if (++ACTUAL_FRAME > FRAME_COUNT - 1) {
                ACTUAL_FRAME = 0;
            }
        }

        TICKS_PER_FRAME++;

    }
}
