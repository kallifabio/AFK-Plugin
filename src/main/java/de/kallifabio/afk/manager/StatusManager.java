package de.kallifabio.afk.manager;

import de.kallifabio.afk.utils.FileBuilder;

public class StatusManager {

    private static FileBuilder builder = new FileBuilder("plugins/AFK", "status.yml");

    public static void setStatus(boolean status) {
        builder.setValue("Status", status);
        builder.save();
    }

    public void save() {
        builder.setValue("Status", "false");
        builder.save();
    }

    public FileBuilder getBuilder() {
        return builder;
    }
}
