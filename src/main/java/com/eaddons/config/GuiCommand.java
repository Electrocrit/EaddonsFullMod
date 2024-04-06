package com.eaddons.config;

import cc.polyfrost.oneconfig.gui.OneConfigGui;
import com.eaddons.Eaddons;
import com.eaddons.features.ToggleCommand;
import net.minecraft.client.Minecraft;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.fml.relauncher.SideOnly;


public class GuiCommand extends CommandBase {

    @Override
    public String getCommandName() {
        return "eaddons";
    }

    @Override
    public String getCommandUsage(ICommandSender sender) {
        return "";
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public void processCommand(ICommandSender sender, String[] args) throws CommandException {



    }

}
