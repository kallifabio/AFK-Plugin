package de.kallifabio.afk.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	
	public static final File configFile = new File("plugins//AFK//config.yml");
	public static final FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
	
	static String langague = "de ";
	static String messagede = "§4DE ";
	static String messageen = "§cEN ";
	static String messagefr = "§3FR ";
	
	public static void setDefaults() {
		config.set("langague", langague);
		config.set("message.de", messagede);
		config.set("message.en", messageen);
		config.set("message.fr", messagefr);
		saveConfig();
		config.getString("langague");
		config.getString("message.de");
		config.getString("message.en");
		config.getString("message.fr");
	}
	
	public static void setLangague() {
		config.set("langague", langague);
		saveConfig();
	}
	
	public static String getLangague() {
		return config.getString(langague);
	}
	
	public static void setMessageDE() {
		config.set("message.de", messagede);
		saveConfig();
	}
	
	public static String getMessageDE() {
		return config.getString(messagede);
	}
	
	public static void setMessageEN() {
		config.set("message.en", messageen);
		saveConfig();
	}
	
	public static String getMessageEN() {
		return config.getString(messageen);
	}
	
	public static void setMessageFR() {
		config.set("message.fr", messagefr);
		saveConfig();
	}
	
	public static String getMessageFR() {
		return config.getString(messagefr);
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
