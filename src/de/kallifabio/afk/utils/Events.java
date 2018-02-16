package de.kallifabio.afk.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import de.kallifabio.afk.main.AFK;

public class Events implements Listener {
	
	//public boolean isAFK;
	
	@EventHandler
	public void onAFKMove(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if(AFK.isAFK) {
			AFK.isAFK = false;
			Bukkit.broadcastMessage(p.getDisplayName() + " §6ist wieder da: §9Hurra!");
		}
	}
	
	@EventHandler
	public void onAFKInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if(AFK.isAFK) {
			AFK.isAFK = false;
			Bukkit.broadcastMessage(p.getDisplayName() + " §6ist wieder da: §9Hurra!");
		}
	}

}
