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
public class PlayerData extends BaseMessage implements Comparable<PlayerData>{
    
    private final String id;
    private PlayerData enemyData;//Se tienen que enviar despues de que esten conectados los 2 clientes
    private final History history;
    private String rank;


    public PlayerData(String id) {
        super(PlayerData.class.getSimpleName());
        this.id = id;
        this.history = new History();
        this.enemyData = null;
        this.rank = "";
    }

    public PlayerData getEnemyData() {
        return enemyData;
    }

    public void setEnemyData(PlayerData enemyData) {
        this.enemyData = enemyData;
    }

    public String getRank(){
        return this.rank;
    }

    public  void setRank(String rank){
        this.rank = rank;
    }

    public String getId() {
        return id;
    }

    public void incrementValue(History.enumValues value){
        history.addValue(value);
    }

    public int getValue(History.enumValues value){
        return history.getValue(value);
    }

    public int getScore(){
        return this.history.getScore();
    }

    @Override
    public int compareTo(PlayerData data2) {
        if (getScore() == data2.getScore())
            return  0;
        else if(getScore() < data2.getScore())
            return -1;
        else
            return 1;
    }
}
