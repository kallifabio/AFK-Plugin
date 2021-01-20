package de.kallifabio.afk.commands;

import de.kallifabio.afk.AFK;
import de.kallifabio.afk.manager.StatusManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class afkCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;
        if (cmd.getName().equalsIgnoreCase("afk")) {
            if (AFK.getInstance().getStatusManager().getBuilder().getBoolean("Status")) {
                StatusManager.setStatus(false);
                switch (AFK.getInstance().getConfigManager().getBuilder().getString("Langague.Format")) {
                    case "de":
                        Bukkit.broadcastMessage(AFK.getPrefix() + player.getDisplayName() + AFK.getInstance().getConfigManager().getBuilder().getString("Langague.DE.Off"));
                        break;
                    case "en":
                        Bukkit.broadcastMessage(AFK.getPrefix() + player.getDisplayName() + AFK.getInstance().getConfigManager().getBuilder().getString("Langague.EN.Off"));
                        break;
                    case "fr":
                        Bukkit.broadcastMessage(AFK.getPrefix() + player.getDisplayName() + AFK.getInstance().getConfigManager().getBuilder().getString("Langague.FR.Off"));
                        break;
                }
            } else {
                StatusManager.setStatus(true);
                switch (AFK.getInstance().getConfigManager().getBuilder().getString("Langague.Format")) {
                    case "de":
                        Bukkit.broadcastMessage(AFK.getPrefix() + player.getDisplayName() + AFK.getInstance().getConfigManager().getBuilder().getString("Langague.DE.On"));
                        break;
                    case "en":
                        Bukkit.broadcastMessage(AFK.getPrefix() + player.getDisplayName() + AFK.getInstance().getConfigManager().getBuilder().getString("Langague.EN.On"));
                        break;
                    case "fr":
                        Bukkit.broadcastMessage(AFK.getPrefix() + player.getDisplayName() + AFK.getInstance().getConfigManager().getBuilder().getString("Langague.FR.On"));
                        break;
                }
            }

        }
        return false;
    }
}
