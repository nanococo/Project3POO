/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractMessagingSystem;

/**
 *
 * @author Fernando Alvarez
 */
public interface IMessage {
    
    void packContent(String [] content);//Toma los valores con otra funcion de el baseMessage y hace una asignacion
    Object unpackContent();
    boolean dataValidation();
    String getId();
    
}
