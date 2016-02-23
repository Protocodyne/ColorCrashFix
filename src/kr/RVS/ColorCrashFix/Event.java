package kr.RVS.ColorCrashFix;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;

/**
 * Created by EntryPoint on 2016-02-22.
 */
public class Event implements Listener {

    private final Main plugin;

    public Event(Main instance){
        plugin = instance;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        e.getPlayer().sendMessage(Main.prefix + "본 서버는 컬러코드 취약점 방지 플러그인을 사용 중입니다");
        e.getPlayer().sendMessage(Main.prefix + "제작자: EntryPoint / 아이디어 제공자: Beebbong");
    }

    @EventHandler
    public void onCMD(PlayerCommandPreprocessEvent e) {

        if(Utill.isCrashColor(e.getMessage())){

            if(e.getPlayer().isOp() && !Boolean.parseBoolean(plugin.getConfig().getString("cmd-deny-op"))) {
                return;
            }

            if(Boolean.parseBoolean((plugin.getConfig().getString("cmd-kick")))){
                e.getPlayer().kickPlayer(Main.prefix + "색코드 취약점 사용 시도를 차단했습니다.");
            }else {
                e.getPlayer().sendMessage(Main.prefix + "색코드 취약점 사용 시도를 차단했습니다.");
            }

            Utill.sendMSGtoOP(Utill.colorize("&e&l" + e.getPlayer().getName() + " &f님의 명령어를 통한 색코드 취약점 사용을 차단했습니다."));
            Utill.sendMSGtoOP(Utill.colorize("제작자: EntryPoint / 아이디어 제공자: Beebbong"));
            e.setMessage("/ccfblock");

        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){

        if(Utill.isCrashColor(e.getMessage())){

            if(e.getPlayer().isOp() && !Boolean.parseBoolean(plugin.getConfig().getString("chat-deny-op"))){
                return;
            }

            if(Boolean.parseBoolean(plugin.getConfig().getString("chat-kick"))){
                plugin.getServer().getScheduler().runTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                        e.getPlayer().kickPlayer(Main.prefix + "색코드 취약점 사용 시도를 차단했습니다.");
                    }
                });
            }else {
                e.getPlayer().sendMessage(Main.prefix + "색코드 취약점 사용 시도를 차단했습니다.");
            }

            Utill.sendMSGtoOP(Utill.colorize("&e&l" + e.getPlayer().getName() + " &f님의 채팅을 통한 색코드 취약점 사용을 차단했습니다."));
            Utill.sendMSGtoOP(Utill.colorize("제작자: EntryPoint / 아이디어 제공자: Beebbong"));
            e.setMessage("k");

        }

    }
}
