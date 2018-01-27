package de.kallifabio.afk.main;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.kallifabio.afk.command.afkCommand;
import de.kallifabio.afk.utils.ConfigManager;
import de.kallifabio.afk.utils.Events;

public class Main extends JavaPlugin implements Listener {
	
	public static String langague;
	public static String messagede;
	public static String messageen;
	public static String messagefr;
	
	public static String prefix = "§2AFK§3";
	public static Main m;
	public static boolean isAFK;
	private CommandSender p;
	//public static boolean canMove;
	//public static HashMap<String, Location> playerLoc = new HashMap<>();
	
	@Override
	public void onEnable() {
		//onMoveListener();
		ConfigManager.saveConfig();
		ConfigManager.setDefaults();
		ConfigManager.saveConfig();
		langague = ConfigManager.getLangague();
		//messagede = ConfigManager.
		Bukkit.getConsoleSender().sendMessage(Main.prefix + "Plugin§4--§aaktiviert");
		
		m = this;
		
		//Bukkit.getPluginManager().registerEvents(new Events(), this);
		getCommand("afk").setExecutor(new afkCommand());
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Main.prefix + "Plugin§8--§4deaktiviert");
	}
	
	public static Main getInstance() {
		return m;
	}
	
	public void onCommand(final String[] args) {
	    if ((args[0].equalsIgnoreCase("/")) || (args[0].equalsIgnoreCase("/help"))) {
	      p.sendMessage("§6Help AFK:");
	    }
	    p.sendMessage("§2Wenn /afk benutzt wurde und man sich bewegt schaltet es sich der AFK Modus aus");
	    p.sendMessage("§3/afk-AFK Modus aktiviert");
	    p.sendMessage("§3/unafk-AFK Modus deaktiviert");
	  }

}