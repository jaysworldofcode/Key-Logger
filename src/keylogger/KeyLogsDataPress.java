package keylogger;

public class KeyLogsDataPress {
    String logs = "";
    private static KeyLogsDataPress instance = null;    
      public static KeyLogsDataPress getInstance() {
      if(instance == null) {
         instance = new KeyLogsDataPress();
      }
      return instance;
    }
    public void SetLogs(String logs){
        this.logs = logs;
    }
    public String GetLogs(){
        return logs;
    }
    public void ClearData(){
        logs ="";
    }
}