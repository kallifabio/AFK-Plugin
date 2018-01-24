package de.kallifabio.afk.utils;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;

public class FileManager {
	
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

}
