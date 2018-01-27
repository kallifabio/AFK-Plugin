package de.kallifabio.afk.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class ConfigManager {
	
	public static final File configFile = new File("plugins//AFK//config.yml");
	public static final FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);
	
	public static void setLangague(String langague) {
		config.set("langague", langague);
		saveConfig();
	}

	public static String getLangague() {
		return config.getString("langague");
	}
	
	public static void setMessageDE(String messagede) {
		config.set("message.de", messagede);
		saveConfig();
	}

	private static String getMessageDE() {
		return config.getString("message.de");
	}

	public static void setMessageEN(String messageen) {
		config.set("message.en", messageen);
		saveConfig();
	}

	private static String getMessageEN() {
		return config.getString("message.en");
	}
	
	public static void setMessageFR(String messagefr) {
		config.set("message.fr", messagefr);
		saveConfig();
	}

	private static String getMessageFR() {
		return config.getString("message.fr");
	}

	public static void setDefaults() {
		config.set("langague", getLangague());
		config.set("message.de", getMessageDE());
		config.set("message.en", getMessageEN());
		config.set("message.fr", getMessageFR());
		saveConfig();
	}

	public static void saveConfig() {
		try {
			config.save(configFile);
		} catch (IOException e) {
		}
	}

}
