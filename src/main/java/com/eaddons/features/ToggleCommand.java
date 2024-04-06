package com.eaddons.features;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.util.ChatComponentText;

public class ToggleCommand extends CommandBase {
    static boolean yescommand = false;
    boolean state = false;
    @Override
    public String getCommandName() {
        return "toggledetector";
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
        if (state == false){
            ToggleCommand.yescommand = true;
            sender.addChatMessage(new ChatComponentText("On!"));
            state = true;
        } else {
           yescommand = false;
           state = false;
           sender.addChatMessage(new ChatComponentText("Off!"));
        }
    }
}
