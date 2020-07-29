/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractMessagingSystem;

import ServerApp.Server;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Alvarez
 */
public class TestEjecutor implements MessageHandler{

    
    Server serv;
    
    atacar();
    //Paquete de confites,Caja de cigarros...

    public TestEjecutor() {
        this.serv = new Server(5000,this);
    }
    
    @Override
    public void useMessage(IMessage message) {
        
        switch(message.getId()){
            case "atacar"
                    atacar();
        }
    }
    
}
