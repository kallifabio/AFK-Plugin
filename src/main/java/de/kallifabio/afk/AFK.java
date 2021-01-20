package de.kallifabio.afk;

import de.kallifabio.afk.commands.afkCommand;
import de.kallifabio.afk.commands.helpCommand;
import de.kallifabio.afk.listeners.PlayerListener;
import de.kallifabio.afk.manager.ConfigManager;
import de.kallifabio.afk.manager.StatusManager;
import de.kallifabio.afk.utils.FileBuilder;
import de.kallifabio.afk.utils.Settings;
import de.kallifabio.afk.utils.UpdateChecker;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AFK extends JavaPlugin {

    private static final String prefix = "§8[§cAFK§8] §r";
    private static AFK instance;
    private final ConfigManager configManager = new ConfigManager();
    private final StatusManager statusManager = new StatusManager();
    public boolean isAFK;

    public static AFK getInstance() {
        return instance;
    }

    public static String getPrefix() {
        return prefix;
    }

    @Override
    public void onEnable() {
        instance = this;
        loadConfig();
        registerEvents();
        registerCommand();
        new UpdateChecker(37211).getLatestVersion(version -> {
            if (getDescription().getVersion().equalsIgnoreCase(version)) {
                System.out.println("Pluginversion ist aktuell!");
            } else {
                System.out.println("*********************************************************************");
                System.out.println("Pluginversion ist nicht aktuell!");
                System.out.println("Neuste Version: " + version);
                System.out.println("Deine Version: " + Settings.VERSION);
                System.out.println("Update herunterladen: " + Settings.PLUGIN_URL);
                System.out.println("*********************************************************************");
            }
        });
        Bukkit.getConsoleSender().sendMessage(prefix + "§aDas Plugin wurde mit der Version§8: §e" + getInstance().getDescription().getVersion() + "§a geladen");
    }

    @Override
    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(prefix + "§cDas Plugin wurde gestoppt");
    }

    private void loadConfig() {
        if (!new FileBuilder("plugins/AFK", "config.yml").exist()) {
            configManager.save();
        }
        if (!new FileBuilder("plugins/AFK", "status.yml").exist()) {
            statusManager.save();
        }
    }

    private void registerCommand() {
        getCommand("afk").setExecutor(new afkCommand());
        getCommand("afk-help").setExecutor(new helpCommand());
    }

    private void registerEvents() {
        PluginManager pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerListener(), this);
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }

    public StatusManager getStatusManager() {
        return statusManager;
    }
}
