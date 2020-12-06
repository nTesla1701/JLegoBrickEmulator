/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jlegobrickemulator;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tesla
 */
public class JLegoBrickEmulator {

    /**
     * @param args the command line arguments
     */
    private static  MainWindow mainWindow;
    private static char[][] displayText = new char[3][15];
    
    public static void main(String[] args) {
        init_ECD();        
        sleep(1000);
        rowTest();
        /*
        output_LCD(1, 1, "M");
        sleep(1000);
        output_LCD(1, 1, " ");        
        output_LCD(2, 1, "M");       
        sleep(1000);
        output_LCD(2, 1, " ");               
        output_LCD(3, 1, "M");
*/
    }
    
    public static void rowTest(){
        for(int r=1;r<4;r++){
            for(int c=1;c<15;c++){
                output_LCD(r, c, "M");
                sleep(100);
                output_LCD(r,c," ");
            }
            
        }
        
    }
    
   
    
    
    public static void init_ECD(){
       displayText = new char[3][15];
       mainWindow = new MainWindow();
       mainWindow.setVisible(true);
    }
    
    public static void output_LCD(int row,int col,String text){
        displayText[row-1][col-1] = text.charAt(0);
        
        mainWindow.SetLcdText(renderDisplayText());
    }
    
    public static void sleep(int ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
            Logger.getLogger(JLegoBrickEmulator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static String renderDisplayText(){
        StringBuffer sb = new StringBuffer();
        for(int r=0;r<3;r++){            
            for(int c=0;c<15;c++){
            sb.append(displayText[r][c]);
            }   
            if(r<2)
                sb.append('\n');
        }
        return sb.toString();        
    }
}
