/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Command;

import java.io.OutputStream;

public abstract class BaseCommand implements ICommand {       
    
    @Override       
    public abstract String getCommandName();       
    
    @Override       
    public abstract void execute(String[] args/*,Pantalla pantalla*/);       
    
    public void write(Server server, String message) {     //Adaptar a pantalla
        server.writeAll(mensaje); //Tendria un getInputText() para traer de "consola" los comandos
        //Envia el mismo mensaje por el socket
    } 
}
