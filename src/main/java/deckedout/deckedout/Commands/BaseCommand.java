package deckedout.deckedout.Commands;

import org.bukkit.command.*;
import org.bukkit.entity.Player;

import java.util.List;

public class BaseCommand {
    public CommandExecutor executor;
    public TabCompleter tabCompleter;


//    Load Command and TabComplete to Plugin
    public BaseCommand(PluginCommand command) {
        command.setExecutor(new BCommandExecutor());
        command.setTabCompleter(new BTabCompleter());
    }

//    playerExecutor is only used if the CommandSender is a player.
    private class BCommandExecutor implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (sender instanceof Player) {
//            Execute the player command listener.
                return playerExecution(((Player) sender).getPlayer(), command, label, args);
            } else {
                sender.sendMessage("Command is only useful if activated by a player.");
                return true;
            }
        }
    }

//    Bukket TabCompleter gets redirected to our TabCompleter
    private class BTabCompleter implements TabCompleter {
        @Override
        public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
            return tabCompletion(sender, command, alias, args);
        }
    }

//    Defaults for our own functions

    public boolean playerExecution(Player player, Command command, String label, String[] args) {
        return false;
    }

    public List<String> tabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}
