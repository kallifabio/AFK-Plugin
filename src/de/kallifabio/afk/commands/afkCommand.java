package de.kallifabio.afk.command;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import de.kallifabio.afk.main.AFK;
import de.kallifabio.afk.utils.FileManager;

public class afkCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player player = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("afk")) {
	      if (FileManager.getStatus()) {
	    	  FileManager.setStatus(false);
	    	  Bukkit.broadcastMessage(AFK.getPrefix() + player.getDisplayName() + " §8ist nicht mehr §cAFK");
	      } else {
	    	  FileManager.setStatus(true);
	    	  Bukkit.broadcastMessage(AFK.getPrefix() + player.getDisplayName() + " §8ist jetzt §cAFK");
	      	}
	    }
	    return false;
	  }
}
