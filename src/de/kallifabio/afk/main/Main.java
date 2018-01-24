package de.kallifabio.afk.main;

import org.bukkit.plugin.PluginManager;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import de.kallifabio.afk.utils.Events;

public class Main extends JavaPlugin implements Listener {
	
	public static String prefix = "§2AFK§3";
	public static Main main;
	public boolean isAFK;
	private CommandSender p;
	
	@Override
	public void onEnable() {
		Bukkit.getConsoleSender().sendMessage(Main.prefix + "Plugin§4--§5aktiviert");
		
		main = this;
		
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		PluginManager pm = Bukkit.getPluginManager();
		//pm.registerEvents(new Events(), this);
	}
	
	@Override
	public void onDisable() {
		Bukkit.getConsoleSender().sendMessage(Main.prefix + "Plugin§4--§5deaktiviert");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("afk")) {
			if(getStatus()) {
				setStatus(false);
				p.sendMessage(Main.prefix + "§r" + p.getName() + " §8ist nicht mehr §cAFK");
			} else if(cmd.getName().equalsIgnoreCase("unafk")) {
				if(getStatus()) {
					setStatus(true);
					p.sendMessage(Main.prefix + "§r" + p.getName() + " §8ist jetzt §cAFK");
				}
			}
		}
		return false;
		
	}
	
	public static Main getInstance() {
		return main;
	}

	public static void setStatus(final boolean status) {
		File ordner = new File("plugins//AFK");
		File file = new File("plugins//AFK//Status.yml");
		if(!ordner.exists()) {
			ordner.mkdir();
		}
		if(!file.exists()) {
			try {
				file.createNewFile();
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		cfg.set("Status", Boolean.valueOf(status));
		try {
			cfg.save(file);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean getStatus() {
		File ordner = new File("plugins//AFK");
		File file = new File("plugins//AFK//Status.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		if(!ordner.exists()) {
			ordner.mkdir();
		}
		if(!file.exists()) {
			try {
				file.createNewFile();
				cfg.set("Status", Boolean.valueOf(false));
				cfg.save(file);
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		boolean status = cfg.getBoolean("Status");
		
		return status;
	}
	
	public void onCommand(final String[] args) {
	    if ((args[0].equalsIgnoreCase("/")) || (args[0].equalsIgnoreCase("/help"))) {
	      this.p.sendMessage("§6Help AFK:");
	    }
	    this.p.sendMessage("§2Wenn /afk benutzt wurde und man sich bewegt schaltet es sich der AFK Modus aus");
	    this.p.sendMessage("§3/afk-AFK Modus aktiviert");
	    this.p.sendMessage("§3/unafk-AFK Modus deaktiviert");
	  }
	
	public static JavaPlugin getPlugin() {
		return null;
	}

}
