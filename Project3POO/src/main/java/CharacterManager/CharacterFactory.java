/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterManager;

import ServerApp.Game.Types;
import java.util.HashMap;
import ServerApp.Game.Character;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fernando Alvarez
 */
public class CharacterFactory {
    
    private HashMap<String, Character> characterList;
    
    public CharacterFactory(){
        characterList = CharacterLoader.loadCharacter();
        System.out.println("Sau"+characterList);
        if(characterList == null){
            characterList = new HashMap<>();
            CharacterLoader.saveCharacter(characterList);
        }
    }
    
    public void saveCharacter(Character character){//Anadir aca otras validaciones
        Character newChar = getCharacter(character.getName());
        if (newChar == null) {
            characterList.put(character.getName(), character);
            CharacterLoader.saveCharacter(characterList);
        }
        else{
            System.out.println("Personaje existente");
        }
    }
    
    public void saveCharacter(String nombre,String path, Types type){
        Character newChar = new Character(type, path, path);
        saveCharacter(newChar);
    }
    
    public Character getCharacter(String key){
        Character character = characterList.get(key);
        System.out.println(character);
        if (character != null){
            try {
                character = character.deepClone();
            } 
            catch (CloneNotSupportedException ex) {
                Logger.getLogger(CharacterFactory.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            System.out.println("Personaje no existente");
        }
        return character;
    }
    
    public boolean exists(String name){
        if(characterList.get(name) == null)
            return false;
        return true;
    }
    
    public void imprimir(){
        System.out.println(characterList.keySet()+"ayuda");
    }
    
    
}
