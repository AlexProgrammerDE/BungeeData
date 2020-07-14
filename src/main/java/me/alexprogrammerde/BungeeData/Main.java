package me.alexprogrammerde.BungeeData;

import net.md_5.bungee.api.plugin.Plugin;
import java.util.logging.Logger;

public class Main extends Plugin {
    static Main plugin;

    public void onEnable() {
        plugin = this;
        Logger logger = this.getLogger();

        logger.info("§6Registering command");
        getProxy().getPluginManager().registerCommand(this, new MainCommand("bungeedata", "bungeedata.use"));

        logger.info("§6Loading metrics");
        Metrics metrics = new Metrics(this, 8182);

        /*logger.info("§6Checking for update");
        new UpdateChecker(this, 81430).getVersion(version -> {
            if (this.getDescription().getVersion().equalsIgnoreCase(version)) {
                logger.info("§6There is not a new update available.");
            } else {
                logger.info("§cThere is a new update available. Its: " + version);
            }
        });*/
    }

    @Override
    public void onDisable() {

    }

    public static Main getMain() {
        return plugin;
    }
}
