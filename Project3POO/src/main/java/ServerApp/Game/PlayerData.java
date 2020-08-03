/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApp.Game;

import java.io.Serializable;

/**
 *
 * @author Fernando Alvarez
 */
public class PlayerData implements Serializable{
    
    private final String id;
    private History history; 

    public PlayerData(String id) {
        this.id = id;
        this.history = new History();
    }

    public String getId() {
        return id;
    }
    
    public void incrementValue(History.enumValues value){
        history.addValue(value);
    }
}
