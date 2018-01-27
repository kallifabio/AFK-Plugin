package de.kallifabio.afk.command;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import de.kallifabio.afk.utils.FileManager;

public class afkCommand implements CommandExecutor {
	
	public static boolean canMove;
	public static HashMap<String, Location> playerLoc = new HashMap<>();
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    Player player = (Player)sender;
	    if (cmd.getName().equalsIgnoreCase("afk")) {
	      if (FileManager.getStatus()) {
	    	  FileManager.setStatus(false);
	    	  canMove = false;
	    	  Bukkit.broadcastMessage(player.getDisplayName() + " §8ist nicht mehr §cAFK");
	      } else {
	    	  FileManager.setStatus(true);
	    	  canMove = true;
	    	  Bukkit.broadcastMessage(player.getDisplayName() + " §8ist jetzt §cAFK");
	      	}
	    }
	    return false;
	  }
	
	public void onMoveListener() {
		Bukkit.getScheduler().scheduleAsyncRepeatingTask((Plugin) this, new Runnable() {
			
			@Override
			public void run() {
				if(canMove)return;
				for(Player all : Bukkit.getOnlinePlayers()) {
					double x = all.getLocation().getX();
					double z = all.getLocation().getZ();
					if(playerLoc.get(all.getName()).getX() == x && playerLoc.get(all.getName()).getZ() == z) {
						continue;
					}
					all.teleport(playerLoc.get(all.getName()));
					continue;
				}
			}
		}, 4, 4);
	}
}
