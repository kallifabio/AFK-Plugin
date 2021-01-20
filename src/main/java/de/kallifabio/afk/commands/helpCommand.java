package de.kallifabio.afk.commands;

import de.kallifabio.afk.AFK;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class helpCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(AFK.getPrefix() + "§cDu musst ein Spieler sein.");
            return true;
        }

        final Player player = (Player) sender;

        if (player.hasPermission("command.afk.use")) {
            if (cmd.getName().equalsIgnoreCase("afk-help")) {
                player.sendMessage("§8§m----------§6Help AFK§8§m----------");
                player.sendMessage("§bProgrammiert von §8" + AFK.getInstance().getDescription().getAuthors());
                player.sendMessage("§bDerzeitige Version §8" + AFK.getInstance().getDescription().getVersion());
                player.sendMessage(" ");
                player.sendMessage("§3/afk - AFK Modus aktiviert");
                player.sendMessage(" ");
                player.sendMessage("§bInfos auf §8https://www.spigotmc.org/resources/simple-afk-plugin.37211/");
                player.sendMessage("§8§m----------§6Help AFK§8§m----------");
            } else {
                player.sendMessage(AFK.getPrefix() + "§cBitte benutze §7/afk-help");
            }
        } else {
            player.sendMessage(AFK.getPrefix() + "§4Du hast dazu keine Rechte");
        }
        return false;
    }
}
