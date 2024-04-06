package com.eaddons.features;


import com.eaddons.Eaddons;
import com.eaddons.config.Configuration;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Movementdetect {

    private double lastxpos = Double.MAX_VALUE;
    private double lastzpos = Double.MAX_VALUE;
    static int counter = 0;
    static int time = 0;
    static boolean shouldplaysound = true;

    @SubscribeEvent
    public void onTick(TickEvent.PlayerTickEvent event) {
        if (Configuration.NoMovementDetector) {
            if (event.player == Minecraft.getMinecraft().thePlayer) {
                double xpos = Minecraft.getMinecraft().thePlayer.posX;
                double lastxpos = Minecraft.getMinecraft().thePlayer.lastTickPosX;
                double zpos = Minecraft.getMinecraft().thePlayer.posZ;
                double lastzpos = Minecraft.getMinecraft().thePlayer.lastTickPosZ;
                if (xpos == lastxpos && zpos == lastzpos) {
                    counter++;
                } else {
                    counter = 0;
                }
                if (counter > 100) {
                    if (shouldplaysound) {
                        Minecraft.getMinecraft().thePlayer.playSound("eaddons:ping", 1.0f, 1.0f);
                        shouldplaysound = false;
                        time = 0;
                    }
                    if (time == 60) {
                        shouldplaysound = true;
                    }
                    time++;
                }
            }
        }
    }
}





