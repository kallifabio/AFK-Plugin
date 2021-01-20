package de.kallifabio.afk.manager;

import de.kallifabio.afk.utils.FileBuilder;
import org.bukkit.ChatColor;

public class ConfigManager {

    private FileBuilder builder = new FileBuilder("plugins/AFK", "config.yml");

    public void save() {
        builder.setValue("Update.Enabled", "true");
        builder.setValue("Langague.Format", "de");
        builder.setValue("Langague.DE.On", ChatColor.translateAlternateColorCodes('&', " &8ist jetzt &cAFK"));
        builder.setValue("Langague.DE.Off", ChatColor.translateAlternateColorCodes('&', " &8ist nicht mehr &cAFK"));
        builder.setValue("Langague.EN.On", ChatColor.translateAlternateColorCodes('&', " &8is now &cAFK"));
        builder.setValue("Langague.EN.Off", ChatColor.translateAlternateColorCodes('&', " &8is not now &cAFK"));
        builder.save();
    }

    public FileBuilder getBuilder() {
        return builder;
    }
}
