/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApp.GamePackage;

import java.io.File;


/**
 *
 * @author Fernando Alvarez
 */
public class Log {
    
    private String log;
        
    public void addToLog(String msg,String [] args){
        log += java.time.LocalDateTime.now()+" "+msg+" "+args+"\n";
    }
    
    public void getLog(){
        
    }

    public void saveLog(){

    }

}
