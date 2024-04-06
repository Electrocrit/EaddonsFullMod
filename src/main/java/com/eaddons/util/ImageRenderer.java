package com.eaddons.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class ImageRenderer {

    private ResourceLocation imageLocation;
    private int imageWidth;
    private int imageHeight;

    public ImageRenderer(ResourceLocation imageLocation, int imageWidth, int imageHeight) {
        this.imageLocation = imageLocation;
        this.imageWidth = imageWidth;
        this.imageHeight = imageHeight;
    }

    public void render(double x, double y) {
        Minecraft mc = Minecraft.getMinecraft();

        // Bind the image texture
        mc.getTextureManager().bindTexture(imageLocation);

        // Set OpenGL color to white
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);


        // Draw the image at the specified position
        mc.ingameGUI.drawTexturedModalRect((int) x, (int) y, 0, 0, imageWidth, imageHeight);
    }

}


