package kr.RVS.ColorCrashFix;

import org.bukkit.plugin.PluginDescriptionFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by EntryPoint on 2016-02-21.
 */
public class Update {

    public static Main plugin;

    public static void Update(){

        try{
            URL u = new URL("http://121.136.183.22/plugins/ColorCrashFix/ver");
            BufferedReader br = new BufferedReader(new InputStreamReader(u.openStream()));
            String Line = br.readLine();

            if(Double.parseDouble(Line) > Main.ver){
                System.out.println("[ CCF ] 버전이 업데이트 되었습니다");
                System.out.println("[ CCF ] 다운로드 주소:");
                System.out.println("[ CCF ] http://121.136.183.22/plugins/ColorCrashFix/CCF-latest.jar");
            }


        }catch(MalformedURLException e){
        }catch(IOException e){}

    }
}
