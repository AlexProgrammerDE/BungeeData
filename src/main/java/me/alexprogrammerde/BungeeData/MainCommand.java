package me.alexprogrammerde.BungeeData;

import de.exceptionflug.protocolize.world.WorldModule;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.hover.content.Text;
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
                        sender.sendMessage(new ComponentBuilder(prefix).append("Name: " + player.getName()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, player.getName())).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("DisplayName: " + player.getDisplayName()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, player.getDisplayName())).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Locale: " + player.getLocale()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, player.getLocale().toString())).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Ping: " + player.getPing()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.getPing()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("ChatMode: " + player.getChatMode().name()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, player.getChatMode().name())).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("UUID: " + player.getUniqueId().toString()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, player.getUniqueId().toString())).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Version: " + player.getPendingConnection().getVersion()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.getPendingConnection().getVersion()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("MainHand: " + player.getMainHand().name()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, player.getMainHand().name())).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());

                        // SERVER
                        sender.sendMessage(new ComponentBuilder(prefix).append("IsConnected: " + player.isConnected()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.isConnected()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("Server: " + player.getServer().getInfo().getName()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, player.getServer().getInfo().getName())).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("IsOnlineMode: " + player.getPendingConnection().isOnlineMode()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.getPendingConnection().isOnlineMode()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());


                        // FORGE
                        boolean forge = player.isForgeUser();
                        sender.sendMessage(new ComponentBuilder(prefix).append("IsForgeUser: " + forge).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(forge))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());

                        if (forge) {
                            Map<String, String> mods = player.getModList();

                            for (String key : mods.keySet()) {
                                sender.sendMessage(new ComponentBuilder(prefix).append("Mod: " + key + " | " + mods.get(key)).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, "Mod: " + key + " | " + mods.get(key))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                            }
                        }

                        // SKIN
                        sender.sendMessage(new ComponentBuilder(prefix).append("HasCape: " + player.getSkinParts().hasCape()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.getSkinParts().hasCape()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("HasHat: " + player.getSkinParts().hasHat()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.getSkinParts().hasHat()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("HasJacket: " + player.getSkinParts().hasJacket()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.getSkinParts().hasJacket()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("LeftPants: " + player.getSkinParts().hasLeftPants()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.getSkinParts().hasLeftPants()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("RightPants: " + player.getSkinParts().hasRightPants()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.getSkinParts().hasRightPants()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("LeftSleeve: " + player.getSkinParts().hasLeftSleeve()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.getSkinParts().hasLeftSleeve()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
                        sender.sendMessage(new ComponentBuilder(prefix).append("RightSleeve: " + player.getSkinParts().hasRightSleeve()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, String.valueOf(player.getSkinParts().hasRightSleeve()))).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());

                        if (Main.protocolize) {
                            /// PROTOCOLIZE
                            // WORLD
                            sender.sendMessage(new ComponentBuilder(prefix).append("Location: X: " + WorldModule.getLocation(player.getUniqueId()).getX() + " Y: " + WorldModule.getLocation(player.getUniqueId()).getY() + " Z: " + WorldModule.getLocation(player.getUniqueId()).getZ() + " Yaw: " + WorldModule.getLocation(player.getUniqueId()).getYaw() + " Pitch: " + WorldModule.getLocation(player.getUniqueId()).getPitch()).event(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD, WorldModule.getLocation(player.getUniqueId()).getX() + " " + WorldModule.getLocation(player.getUniqueId()).getY() + " " + WorldModule.getLocation(player.getUniqueId()).getZ() + " " + WorldModule.getLocation(player.getUniqueId()).getYaw() + " " + WorldModule.getLocation(player.getUniqueId()).getPitch())).event(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(new ComponentBuilder("Click me!").create()))).create());
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