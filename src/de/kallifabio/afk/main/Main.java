package de.kallifabio.afk.main;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.kallifabio.afk.command.afkCommand;
import de.kallifabio.afk.utils.Events;

public class Main extends JavaPlugin implements Listener {
	
	public static String prefix = "§2AFK§3";
	public static Main instance;
	public boolean isAFK;
	private CommandSender p;
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(Main.prefix + "Plugin§4--§5aktiviert");
		
		instance = this;
		
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		getCommand("afk").setExecutor(new afkCommand());
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Main.prefix + "Plugin§4--§5deaktiviert");
	}
	
	public static Main getInstance() {
		return instance;
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
