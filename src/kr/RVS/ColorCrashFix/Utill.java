package kr.RVS.ColorCrashFix;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by EntryPoint on 2016-02-22.
 */
public class Utill {

    public static boolean isCrashColor(String s){
        if (s.contains("§k") || s.contains("&k")) {
            return true;
        }else{
            return false;
        }
    }

    public static void sendMSGtoOP(String s){
        for(Player p: Bukkit.getServer().getOnlinePlayers()){
            if(p.isOp()){
                p.sendMessage(Main.prefix + s);
            }
        }
    }

    public static String colorize(String s){
        return ChatColor.translateAlternateColorCodes(("&").charAt(0), s);
    }

}
