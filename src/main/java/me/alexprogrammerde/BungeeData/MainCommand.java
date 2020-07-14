package me.alexprogrammerde.BungeeData;

import de.exceptionflug.protocolize.world.WorldModule;
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
                        /// VANILLA
                        // PLAYER
                        sender.sendMessage(new ComponentBuilder(prefix).append("Name: " + player.getName()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("DisplayName: " + player.getDisplayName()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Locale: " + player.getLocale()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Ping: " + player.getPing()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("ChatMode: " + player.getChatMode().name()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("UUID: " + player.getUniqueId().toString()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Version: " + player.getPendingConnection().getVersion()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("MainHand: " + player.getMainHand().name()).create());

                        // SERVER
                        sender.sendMessage(new ComponentBuilder(prefix).append("IsConnected: " + player.isConnected()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Server: " + player.getServer().getInfo().getName()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("IsOnlineMode: " + player.getPendingConnection().isOnlineMode()).create());


                        // FORGE
                        boolean forge = player.isForgeUser();
                        sender.sendMessage(new ComponentBuilder(prefix).append("IsForgeUser: " + forge).create());

                        if (forge) {
                            Map<String, String> mods = player.getModList();

                            for (String key : mods.keySet()) {
                                sender.sendMessage(new ComponentBuilder(prefix).append("Mod: " + key + " | " + mods.get(key)).create());
                            }
                        }

                        // SKIN
                        sender.sendMessage(new ComponentBuilder(prefix).append("HasCape: " + player.getSkinParts().hasCape()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("HasHat: " + player.getSkinParts().hasHat()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("HasJacket: " + player.getSkinParts().hasJacket()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("LeftPants: " + player.getSkinParts().hasLeftPants()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("RightPants: " + player.getSkinParts().hasRightPants()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("LeftSleeve: " + player.getSkinParts().hasLeftSleeve()).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("RightSleeve: " + player.getSkinParts().hasRightSleeve()).create());

                        if (Main.protocolize) {
                            /// PROTOCOLIZE
                            // WORLD
                            sender.sendMessage(new ComponentBuilder(prefix).append("Location: X: " + WorldModule.getLocation(player.getUniqueId()).getX() + " Y: " + WorldModule.getLocation(player.getUniqueId()).getY() + " Z: " + WorldModule.getLocation(player.getUniqueId()).getZ() + " Yaw: " + WorldModule.getLocation(player.getUniqueId()).getYaw() + " Pitch: " + WorldModule.getLocation(player.getUniqueId()).getPitch()).create());
                            // Doesn't work
                            // sender.sendMessage(new ComponentBuilder(prefix).append("GameMode: " + WorldModule.getGamemode(player.getUniqueId())).create());
                        }
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