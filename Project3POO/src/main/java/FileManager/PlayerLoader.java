/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileManager;

import ServerApp.Game.Player;
import ServerApp.Game.PlayerData;
import filemanager.FileManager;
import java.util.HashMap;

/**
 *
 * @author Fernando Alvarez
 */
public class PlayerLoader {
    
    private final String path = getPath();
    private final String fileName = "/playerData.txt";
    private HashMap<String, PlayerData> playerList;
    
    public PlayerLoader(){
        playerList = loadPlayers();
        if(playerList == null){
            playerList = new HashMap<>();
            savePlayers();
        }
    }
    
    public void savePlayers(){
        FileManager.writeObject(playerList,path+fileName);
    }
    
    public HashMap<String,PlayerData> loadPlayers(){
        return (HashMap<String, PlayerData>)FileManager.readObject(path+fileName);
    }
        
    public String getPath(){
        String path = System.getProperty("user.dir")+"/src/main/resources";
        return path;
   }
    
    public void addPlayer(PlayerData playerData){
        this.playerList.put(playerData.getId(), playerData);
        savePlayers();
    }
    
    
    public PlayerData searchPlayer(String id){
        PlayerData data = playerList.get(id);
        if (data == null) {
            data = new PlayerData(id);
            addPlayer(data);
        }
        return data;
    }
}
