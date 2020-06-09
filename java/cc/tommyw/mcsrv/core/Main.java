package cc.tommyw.mcsrv.core;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		this.getCommand("create").setExecutor(new CreateCmd(this));
		this.getCommand("command").setExecutor(new RunCmd());
		this.getCommand("start").setExecutor(new StartCmd());
		this.getCommand("stop").setExecutor(new StopCmd());
	}
	
	@Override
	public void onDisable() {
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {		
		
		return false;
	}
	
}
