/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractMessagingSystem;

import java.util.HashMap;

/**
 *
 * @author Fernando Alvarez
 */
public class MessageFactory {//Esta es la que usa el mesage manager para almacenar los tipos de mensaje

    private static MessageFactory messageFactory;
    protected static final HashMap<String,Class<? extends IMessage>> MESSAGES =
            new HashMap<String, Class<? extends IMessage>>();
    
    private MessageFactory(){
        saveMessage(TestMessage.getNAME(),TestMessage.class);
        
    }
    
    public static IMessage getMessage(String key) {
        if (MESSAGES.containsKey(key.toUpperCase())) {               
            try {                   
                return MESSAGES.get(key.toUpperCase()).getConstructor().newInstance();
            } catch (Exception e) {   e.printStackTrace();                   
                //ErrorMessage
            }           
        } 
        //NullMessage
        return null;
    }

    public static void saveMessage(String string, Class<? extends IMessage> message) {
        MESSAGES.put(string, message);
    }

    public static MessageFactory getInstance() {
        if (messageFactory == null) {               
            messageFactory = new MessageFactory() ;   
        }
        return messageFactory;
    }
    
}
