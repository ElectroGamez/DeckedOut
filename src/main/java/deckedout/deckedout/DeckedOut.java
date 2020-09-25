package deckedout.deckedout;

import deckedout.deckedout.Commands.Gamemode;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
public final class DeckedOut extends JavaPlugin {
    public FileConfiguration defaultConfig;

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().log(Level.INFO, "Hi!");

        // Save default config if no config exists.
        saveDefaultConfig();
        defaultConfig = getConfig();

        //Register the plugins commands.
        registerCommands();

        MySqlManager mySqlManager = new MySqlManager(this);
        Connection connection = mySqlManager.openConnection();

        if (mySqlManager.activeConnection(connection)) getLogger().log(Level.INFO, "We have a active MySQL connection!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        new Gamemode(getCommand("gm"));
    }
}
