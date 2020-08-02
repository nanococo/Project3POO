/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterManager;

import java.util.HashMap;
import ServerApp.Game.Character;
import filemanager.FileManager;

/**
 *
 * @author Fernando Alvarez
 */
public class CharacterLoader {
    
    private static final String path = getPath();
    private static final String fileName = "/characterData.txt";
    
    public static void saveCharacter(HashMap<String,Character> hash){
        FileManager.writeObject(hash,path+fileName);
    }
    
    public static HashMap<String,Character> loadCharacter(){
        return (HashMap<String, Character>)FileManager.readObject(path+fileName);
    }
    
    public static void editCharacter(){
        //TODO
    }
    
    public static void eraseCharacter(){
        //TODO
    }
    
    public static String getPath(){
        String path = System.getProperty("user.dir")+"/src/main/resources";
        return path;
   }
    
}
