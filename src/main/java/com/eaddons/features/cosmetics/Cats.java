package com.eaddons.features.cosmetics;

import com.eaddons.config.Configuration;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static com.eaddons.Eaddons.mc;

public class Cats {
    private static final ResourceLocation CAT_TEXTURE = new ResourceLocation("eaddons", "textures/cat1.png");

    private int posX = 0;
    private int posY = 0;
    private int motionX = 2;
    private int motionY = 2;
    private float scale = 1;
    boolean showSprite = false;
    private int scaledWidth, scaledHeight;

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) {
        if(Configuration.Cats) {
            showSprite = true;
        } else showSprite = false;
        if(showSprite){
            ScaledResolution scaledResolution = new ScaledResolution(mc);

            double scaleFactorX = scaledResolution.getScaledWidth() / 1920.0; // Base width for scaling
            double scaleFactorY = scaledResolution.getScaledHeight() / 1080.0; // Base height for scaling

            // Apply the smaller scale factor to maintain aspect ratio
            double scaleFactor = Math.min(scaleFactorX, scaleFactorY);

            int originalHeight = 600;
            int originalWidth = 500;
            this.scaledWidth = (int) (originalWidth * scaleFactor);
            this.scaledHeight = (int) (originalHeight * scaleFactor);

            // Update sprite position
            posX += motionX;
            posY += motionY;

            // Bounce when hitting the edges
            if (posX <= 0 || posX >= scaledResolution.getScaledWidth() - scaledWidth) {
                motionX = -motionX;
            }

            if (posY <= 0 || posY >= scaledResolution.getScaledHeight() - scaledHeight) {
                motionY = -motionY;
            }

        }

    }
    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent event) {
            if (showSprite) {
                Minecraft mc = Minecraft.getMinecraft();
                GuiIngame guiIngame = mc.ingameGUI;

                int posXInt = (int) posX;
                int posYInt = (int) posY;
                // Draw the sprite
                mc.getTextureManager().bindTexture(CAT_TEXTURE);
                guiIngame.drawTexturedModalRect(posXInt, posYInt, 0, 0, this.scaledWidth, this.scaledHeight);
            }
        }
    }






