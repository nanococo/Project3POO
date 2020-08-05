/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApp.Game;

import Messaging.BaseMessage;

/**
 *
 * @author Fernando Alvarez
 */
public class PlayerData extends BaseMessage {
    
    private final String id;
    private String enemyID;
    private final History history;


    public PlayerData(String id) {
        super(PlayerData.class.getSimpleName());
        this.id = id;
        this.history = new History();
    }

    public String getEnemyID() {
        return enemyID;
    }

    public void setEnemyID(String enemyID) {
        this.enemyID = enemyID;
    }

    public String getId() {
        return id;
    }

    public void incrementValue(History.enumValues value){
        history.addValue(value);
    }
}
