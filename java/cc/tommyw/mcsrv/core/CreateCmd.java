package cc.tommyw.mcsrv.core;

import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.*;
import java.util.Scanner;

public class CreateCmd implements CommandExecutor {

	private final Main plugin;
	
	public CreateCmd(Main plugin) {
		this.plugin = plugin;
	}

	public boolean onCommand(CommandSender pSender, Command pCmd, String arg2,
			String[] arg3) {
		if (arg3.length == 2) {
				if(pSender.hasPermission("server.created") && pSender.isOp() == false) {
						pSender.sendMessage(ChatColor.RED + "You already have a server!");
				return true;
			} else {
				File file = new File("servernames.txt");
				try {
					Scanner scanner = new Scanner(file);
					int lineNum = 0;
					while (scanner.hasNextLine()) {
						String line = scanner.nextLine();
						lineNum++;
						if(line.equalsIgnoreCase(arg3[0])) {
							pSender.sendMessage(ChatColor.RED + "A server with that name already exists!");
							return true;
						}
					}
				} catch(FileNotFoundException e) {
					pSender.sendMessage(ChatColor.RED + "A critical error occurred while creating the server (ServerNames file not found - 1)");
					return true;
				}
					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "sub create " + arg3[0] + " ~ Spigot " + arg3[1]);
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + pSender.getName() + " add subservers.subserver.command." + arg3[0]);
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + pSender.getName() + " add subservers.subserver.stop." + arg3[0]);
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + pSender.getName() + " add subservers.subserver.start." + arg3[0]);
				pSender.sendMessage(ChatColor.GREEN + "Server is being created! One completed, you can access it with: \n" + ChatColor.WHITE + "/server " + arg3[0] + ChatColor.AQUA + "\nIf the server is not created within 20m, please contact " + ChatColor.RED + "PENGUIN114#6116 " + ChatColor.AQUA + "on discord.");
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "pex user " + pSender.getName() + " add server.created");
				try (PrintStream out = new PrintStream(new FileOutputStream("servernames.txt", true))) {
					out.print(System.lineSeparator() + arg3[0]);
				} catch (FileNotFoundException e) {
					pSender.sendMessage(ChatColor.RED + "A critical error occurred while creating the server (ServerNames file not found - 2)");
					return true;
				}
			}
		} else {
			pSender.sendMessage(ChatColor.RED + "Incorrect arguments! Correct usage: " + ChatColor.WHITE + "/create <servername> <version> " + ChatColor.RED + "\nYou can see our supported versions list here: " + ChatColor.WHITE + "http://mcsrv.pw/serverversions/");
		}
		return true;
	}
}
