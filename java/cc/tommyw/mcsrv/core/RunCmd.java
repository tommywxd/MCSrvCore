package cc.tommyw.mcsrv.core;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

    public class RunCmd implements CommandExecutor {
        public boolean onCommand(CommandSender pSender, Command pCmd, String arg2, String[] arg3) {
            if (arg3.length >= 2) {
                if (pSender.hasPermission("subservers.subserver.command." + arg3[0])) {
                    StringBuilder sb = new StringBuilder();
                    for(int i = 1; i < arg3.length; i++) {
                        if (i > 0) sb.append(" ");
                        sb.append(arg3[i]);
                    }
                        String result = sb.toString();
                        String command = result.substring(1);
                        pSender.sendMessage(ChatColor.GREEN + "Executed " + ChatColor.RED + "/" + command + ChatColor.GREEN + " successfully!");
                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sub cmd " + arg3[0] + " " + command);
                } else {
                    pSender.sendMessage(ChatColor.RED + "You do not have permissions to execute commands on this server.");
                }
            } else {
                pSender.sendMessage(ChatColor.RED + "Incorrect arguments! Correct usage: " + ChatColor.WHITE + "/command <servername> <command>");
            }
            return true;
        }
    }
