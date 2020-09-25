package deckedout.deckedout.Commands;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class Gamemode extends BaseCommand {
    public Gamemode(PluginCommand command) {
        super(command);
    }

    @Override
    public boolean playerExecution(Player player, Command command, String label, String[] args) {
        player.setGameMode(GameMode.CREATIVE);

        if (args.length == 1) {

            switch (args[0]) {
                case "0":
                    player.setGameMode(GameMode.SURVIVAL);
                    break;

                case "1":
                    player.setGameMode(GameMode.CREATIVE);
                    break;

                case "2":
                    player.setGameMode(GameMode.ADVENTURE);
                    break;

                case "3":
                    player.setGameMode(GameMode.SPECTATOR);
                    break;
            }
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<String> tabCompletion(CommandSender sender, Command command, String alias, String[] args) {
        return Arrays.asList("0", "1", "2", "3");
    }
}
