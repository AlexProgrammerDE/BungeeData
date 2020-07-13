package me.alexprogrammerde.BungeeData;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

import java.util.*;

public class MainCommand extends Command implements TabExecutor {

    String name;

    public MainCommand(String name, String permission, String... aliases) {
        super(name, permission, aliases);
        this.name= name;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (sender.hasPermission("bungeedata.use")) {
            if (args.length > 0) {
                ProxiedPlayer player = Main.plugin.getProxy().getPlayer(args[0]);

                if (player != null) {

                    String prefix = ChatColor.AQUA + "[BungeeData] " + ChatColor.GOLD;

                    if (player.isConnected()) {
                        sender.sendMessage(new ComponentBuilder(prefix).append("IsConnected: " + player.isConnected()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Name: " + player.getName()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("DisplayName: " + player.getDisplayName()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("IsForgeUser: " + player.isForgeUser()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Locale: " + player.getLocale()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Ping: " + player.getPing()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("ChatMode: " + player.getChatMode().name()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Server: " + player.getServer().getInfo().getName()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Scoreboard: " + player.getScoreboard()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("UUID: " + player.getUniqueId().toString()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Version: " + player.getPendingConnection().getVersion()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("ReconnectServer: " + player.getReconnectServer().getName()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("MainHand: " + player.getMainHand().name()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("IsOnlineMode: " + player.getPendingConnection().isOnlineMode()).create());
                    } else {
                        sender.sendMessage(new ComponentBuilder(prefix).append("IsConnected: " + player.isConnected()).create());
                    }
                } else {
                    sender.sendMessage(new ComponentBuilder("Sorry this player isn't connected.").create());
                }
            } else {
                sender.sendMessage(new ComponentBuilder("Please specify a player name").create());
            }
        }
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender sender, String[] args) {
        List<String> completion = new ArrayList<>();

        if (sender.hasPermission("bungeedata.use")) {
            List<String> players = new ArrayList<>();

            for (ProxiedPlayer player : Main.plugin.getProxy().getPlayers()) {
                players.add(player.getName());
            }

            if (args.length == 1) {
                for (String string : players)
                    if (string.toLowerCase().startsWith(args[0].toLowerCase())) completion.add(string);
            }

            Collections.sort(players);
        }

        return completion;
    }
}