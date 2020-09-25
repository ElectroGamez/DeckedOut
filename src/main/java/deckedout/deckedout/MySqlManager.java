package deckedout.deckedout;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Objects;
import java.util.logging.Level;

public class MySqlManager {
    private final JavaPlugin javaPlugin;

    public MySqlManager(JavaPlugin plugin) {
        javaPlugin = plugin;
    }

    public Connection openConnection() {
        synchronized (this) {

            FileConfiguration configuration = javaPlugin.getConfig();
            try {
                Class.forName("com.mysql.jdbc.Driver");

                return DriverManager.getConnection(String.format("jdbc:mysql://%s/%s?user=%s&password=%s&useSSL=%s", configuration.get("mysql.host") , configuration.get("mysql.database"), configuration.get("mysql.username"), configuration.get("mysql.password"), Objects.requireNonNull(configuration.get("mysql.useSSL")).toString()));

            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
                javaPlugin.getLogger().log(Level.SEVERE, "Could not connect to MySQL Database! More info above: ^^^");
                return null;
            }
        }
    }

    public boolean activeConnection(Connection connection) {
        try {
            return !connection.isClosed();
        } catch (SQLException throwables) {
            return false;
        }
    }
}
