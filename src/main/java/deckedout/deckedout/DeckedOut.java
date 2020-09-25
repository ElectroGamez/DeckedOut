package deckedout.deckedout;

import deckedout.deckedout.Commands.Gamemode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.logging.Level;


public final class DeckedOut extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getLogger().log(Level.INFO, "Hi!");

        //Register the plugins commands.
        registerCommands();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        new Gamemode(getCommand("gm"));
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        return super.onTabComplete(sender, command, alias, args);
    }
}
