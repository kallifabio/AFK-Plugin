package de.kallifabio.afk.listeners;

import de.kallifabio.afk.AFK;
import de.kallifabio.afk.utils.Settings;
import de.kallifabio.afk.utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        final Player player = event.getPlayer();
        if (AFK.getInstance().getConfigManager().getBuilder().getBoolean("Update.Enabled")) {
            new UpdateChecker(37211).getLatestVersion(version -> {
                if (!AFK.getInstance().getDescription().getVersion().equalsIgnoreCase(version)) {
                    player.sendMessage(ChatColor.GRAY + "****************************************************************");
                    player.sendMessage(ChatColor.RED + "Pluginversion ist nicht aktuell!");
                    player.sendMessage(ChatColor.RED + "Neuste Version: " + version);
                    player.sendMessage(ChatColor.RED + "Deine Version: " + ChatColor.BOLD + Settings.VERSION);
                    player.sendMessage(ChatColor.GOLD + "Update herunterladen: " + ChatColor.ITALIC + Settings.PLUGIN_URL);
                    player.sendMessage(ChatColor.GRAY + "****************************************************************");
                }
            });
        }
    }

    @EventHandler
    public void onPlayerMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (AFK.getInstance().isAFK) {
            AFK.getInstance().isAFK = false;
            Bukkit.broadcastMessage(p.getDisplayName() + " §6ist wieder da: §9Hurra!");
        }
    }

    @EventHandler
    public void onPlayerInteract(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (AFK.getInstance().isAFK) {
            AFK.getInstance().isAFK = false;
            Bukkit.broadcastMessage(p.getDisplayName() + " §6ist wieder da: §9Hurra!");
        }
    }
}
