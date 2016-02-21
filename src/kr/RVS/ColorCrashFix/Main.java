package kr.RVS.ColorCrashFix;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by EntryPoint on 2016-02-21.
 */
public class Main
        extends JavaPlugin
        implements Listener {

    public static String prefix = Utill.colorize("&c&l[ ColorCrashFix ] &f");
    public static Double ver;

    public void onEnable(){
        getConfig().options().copyDefaults(true);
        saveConfig();
        ver = Double.parseDouble(getDescription().getVersion());
        Update.Update();
        getServer().getPluginManager().registerEvents(new Event(this), this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (label.equalsIgnoreCase("ccfreload") && sender.hasPermission("ccf.reload")) {
            reloadConfig();
            sender.sendMessage(prefix + "리로드되었습니다.");
        }
        return false;
    }

}