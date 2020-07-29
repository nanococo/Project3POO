/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractMessagingSystem;

import java.util.Arrays;

/**
 *
 * @author Fernando Alvarez
 */
public class MessageManager {
    
    
    public MessageManager(){

    }
        
    public static IMessage createMessage(String message){//Primer pos nombre, el resto argumentos
        String[] mensaje = message.split(" ");
        IMessage msg = MessageFactory.getMessage(mensaje[0]);
        String [] args = Arrays.copyOfRange(mensaje, 1, mensaje.length);
        msg.packContent(args);
        return msg;
    }
    
    public static Object readMessage(IMessage message){
        return message.unpackContent();
    }
    
    
}
