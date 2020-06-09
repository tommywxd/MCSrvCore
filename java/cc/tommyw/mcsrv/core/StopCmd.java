package cc.tommyw.mcsrv.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class StopCmd implements CommandExecutor {
    public boolean onCommand(CommandSender pSender, Command pCmd, String arg2, String[] arg3) {
        if (arg3.length == 1) {
            if (pSender.hasPermission("subservers.subserver.stop." + arg3[0])) {
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sub stop " + arg3[0]);
                    pSender.sendMessage(ChatColor.GREEN + "Server is being stopped...");
            } else {
                pSender.sendMessage(ChatColor.RED + "You do not have permissions to stop this server.");
            }
        } else {
            pSender.sendMessage(ChatColor.RED + "Incorrect arguments! Correct usage: " + ChatColor.WHITE + "/stop <servername>");
        }
        if(!(pSender instanceof Player)) {
            Bukkit.shutdown();
        }
        return true;
    }
}
