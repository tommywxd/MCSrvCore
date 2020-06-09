package cc.tommyw.mcsrv.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class StartCmd implements CommandExecutor {
    public boolean onCommand(CommandSender pSender, Command pCmd, String arg2, String[] arg3) {
        if (arg3.length == 1) {
            if (pSender.hasPermission("subservers.subserver.start." + arg3[0])) {
                StringBuilder message = new StringBuilder();
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sub start " + arg3[0]);
                pSender.sendMessage(ChatColor.GREEN + "Server is being started...");
            } else {
                pSender.sendMessage(ChatColor.RED + "You do not have permissions to start this server.");
            }
        } else {
            pSender.sendMessage(ChatColor.RED + "Incorrect arguments! Correct usage: " + ChatColor.WHITE + "/start <servername>");
        }
        return true;
    }
}