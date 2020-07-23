/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.util.HashMap;

/**
 *
 * @author Fernando Alvarez
 */
public class CommandManager {
    
    private static final HashMap<String, Class<? extends ICommand>> COMMANDS =          
            new HashMap<String, Class<? extends ICommand>>(); 
    private static CommandManager commandManager;
    
    private CommandManager(){
        
    }
    
    public static CommandManager getInstance(){
        if(commandManager == null)
            commandManager = new CommandManager();
        return commandManager;
    }
    
    public void addCommand(String key, Class<? extends ICommand> command){
        COMMANDS.put(key.toUpperCase(), command);   
    }
    
    public ICommand getCommand(String key){
        if (COMMANDS.containsKey(key.toUpperCase())) {               
            try {                   
                return COMMANDS.get(key.toUpperCase()).newInstance();
            } catch (Exception e) {   e.printStackTrace();                   
            return new ErrorCommand();   
            }           
        } 
        else {
            return new NotFoundCommand();   
        }  
    }
}
