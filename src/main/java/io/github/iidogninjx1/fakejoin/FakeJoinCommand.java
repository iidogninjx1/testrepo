package io.github.iidogninjx1.fakejoin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FakeJoinCommand implements CommandExecutor, TabCompleter {
    private final JavaPlugin plugin;

    public FakeJoinCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("fakejoin.use")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command.");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage(ChatColor.YELLOW + "Usage: /fakejoin <playerName> [custom message]");
            return true;
        }

        String targetName = args[0];

        String message;
        if (args.length > 1) {
            String combined = String.join(" ", java.util.Arrays.copyOfRange(args, 1, args.length));
            // Allow color codes with &
            message = ChatColor.translateAlternateColorCodes('&', combined);
        } else {
            message = ChatColor.GREEN + targetName + ChatColor.WHITE + " joined the game";
        }

        Bukkit.broadcastMessage(message);
        plugin.getLogger().info(sender.getName() + " sent fake join: " + message);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (args.length == 1) {
            // Suggest online player names
            List<String> names = new ArrayList<>();
            for (Player p : Bukkit.getOnlinePlayers()) names.add(p.getName());
            String partial = args[0].toLowerCase();
            return names.stream().filter(n -> n.toLowerCase().startsWith(partial)).collect(Collectors.toList());
        }
        return List.of();
    }
}
