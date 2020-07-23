/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

/**
 *
 * @author Fernando Alvarez
 */
public class ErrorCommand extends BaseCommand{
    private static final String COMMAND_NAME = "ERROR";       
    
    @Override       
    public String getCommandName() {           
        return COMMAND_NAME;   
    }       
    
    @Override       
    public void execute(String[] args, Pantalla pantalla) {           
        String message = "Error al invocar el comando";  
        Server.sendAll();
    }       
}
