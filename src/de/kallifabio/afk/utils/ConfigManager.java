package de.kallifabio.afk.utils;

import java.io.File;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	
	public static final File configFile = new File("plugins/AFK/config.yml");
	public static final FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
	
	static String langague = "de";
	static String messagede = "§4DE";
	static String messageen = "§cEN";
	static String messagefr = "§3FR";
	
	public static void setDefaults() {
		config.options().copyDefaults(true);
		
		config.addDefault("Langague", "DE");
		
		config.addDefault("Message.DE.On", "%player% &8ist jetzt &cAFK");
		config.addDefault("Message.DE.Off", "%player% &8ist nicht mehr &cAFK");
		
		config.addDefault("Message.EN.On", "%player% &8is now &cAFK");
		config.addDefault("Message.EN.Off", "%player% &8is not &cAFK");
		
		config.addDefault("Message.FR.On", messagefr);
		config.addDefault("Message.FR.Off", messagefr);
		
		saveConfig();
		
		langague = config.getString("Langague");
		
		messagede = config.getString("Message.DE.On");
		messagede = config.getString("Message.DE.Off");
		
		messageen = config.getString("Message.EN.On");
		messageen = config.getString("Message.EN.Off");
		
		messagefr = config.getString("Message.FR.On");
		messagefr = config.getString("Message.FR.Off");
	}
	
	public static void saveConfig() {
		try {
			config.save(configFile);
		} catch (Exception e) {
			System.out.println("Alles wurde gespeichert");
			e.printStackTrace();
		}
	}

}
