package de.kallifabio.afk.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.kallifabio.afk.main.Main;
import de.kallifabio.afk.utils.FileManager;

public class afkCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		final Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("afk")) {
			if(FileManager.getStatus()) {
				FileManager.setStatus(false);
				p.sendMessage(Main.prefix + "§r" + p.getName() + " §8ist nicht mehr §cAFK");
			} else if(cmd.getName().equalsIgnoreCase("unafk")) {
				if(FileManager.getStatus()) {
					FileManager.setStatus(true);
					p.sendMessage(Main.prefix + "§r" + p.getName() + " §8ist jetzt §cAFK");
				}
			}
		}
		return false;
		
	}

}
