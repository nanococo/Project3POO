/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CharacterManager;

import ServerApp.GamePackage.Character;

/**
 *
 * @author Fernando Alvarez
 */
public class MakeCharacter {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();
        factory.imprimir();
        Character c = factory.getCharacter("Mario");
        System.out.println(c);
    }
}
