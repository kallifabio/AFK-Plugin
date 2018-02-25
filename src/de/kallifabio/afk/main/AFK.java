package de.kallifabio.afk.main;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import de.kallifabio.afk.command.afkCommand;

public class AFK extends JavaPlugin {
	
	private static String prefix = "§3[§2AFK§3] ";
	public static AFK instance;
	public static boolean isAFK;
	private CommandSender p;
	
	@Override
	public void onEnable() {
		loadConfig();
		
		instance = this;
		
		getCommand("afk").setExecutor(new afkCommand());
		getCommand("afk-help").setExecutor(this);
		System.out.println(" ");
		Bukkit.getConsoleSender().sendMessage(AFK.prefix + "§3§lDas Plugin wurde mit der Version§8: §e" + AFK.getInstance().getDescription().getVersion() + "§3§l geladen");
		System.out.println(" ");
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(AFK.prefix + "Plugin§8--§4deaktiviert");
	}
	
	public static AFK getInstance() {
		return instance;
	}
	
	public static String getPrefix() {
		return prefix;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (cmd.getName().equalsIgnoreCase("afk-help")) {
	    	sender.sendMessage("§8==========§6Help AFK:§8==========");
	    	sender.sendMessage("§3/afk - AFK Modus aktiviert");
	    	sender.sendMessage("§8==========§6Help AFK:§8==========");
	    }
		return false;
	}
	
	private void loadConfig() {
        File file = new File("plugins/" + getDescription().getName() + "/config.yml");
        if (!file.exists()) {
            saveDefaultConfig();
        }
    }
	
}