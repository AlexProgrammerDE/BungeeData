package me.alexprogrammerde.BungeeData;

import net.md_5.bungee.api.plugin.Plugin;
import java.util.logging.Logger;

public class Main extends Plugin {
    static Main plugin;

    public void onEnable() {
        plugin = this;
        Logger logger = this.getLogger();

        logger.info("§aRegistering command");
        getProxy().getPluginManager().registerCommand(this, new MainCommand("bungeedata", "bungeedata.use"));

        logger.info("§aLoading metrics");
        Metrics metrics = new Metrics(this, 8182);
    }

    @Override
    public void onDisable() {

    }

    public static Main getMain() {
        return plugin;
    }
}
