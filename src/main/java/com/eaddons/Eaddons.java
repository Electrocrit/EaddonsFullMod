package com.eaddons;



import com.eaddons.config.Configuration;
import com.eaddons.features.ToggleCommand;
import com.eaddons.features.Movementdetect;
import com.eaddons.features.cosmetics.Cats;
import com.eaddons.util.ImageRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.init.Blocks;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventBus;

import java.io.File;

@Mod(modid = "eaddons", useMetadata=true)
public class Eaddons {
    public static final Minecraft mc = Minecraft.getMinecraft();
    public static final File dir = new File(new File(mc.mcDataDir, "config"), "example");
    public static final Eaddons instance = new Eaddons();
    public static Configuration config;
    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        config = new Configuration();
        System.out.println("Dirt: " + Blocks.dirt.getUnlocalizedName());
        ClientCommandHandler.instance.registerCommand(new ToggleCommand());

    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        EventBus mcBus = MinecraftForge.EVENT_BUS;

        mcBus.register(new Movementdetect());
        mcBus.register(new Cats());
    }
}
