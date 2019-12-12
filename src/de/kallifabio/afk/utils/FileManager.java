package de.kallifabio.afk.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import de.kallifabio.afk.main.AFK;

public class FileManager {
	
	public static void setStatus(boolean status) {
		Player player = null;
		File ordner = new File("plugins/" + AFK.getInstance().getDescription().getName());
		File file = new File("plugins/" + AFK.getInstance().getDescription().getName() + "/status.yml");
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
		Player player = null;
		File ordner = new File("plugins/" + AFK.getInstance().getDescription().getName());
		File file = new File("plugins/" + AFK.getInstance().getDescription().getName() + "/status.yml");
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

}
