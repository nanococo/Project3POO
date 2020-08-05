/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServerApp.GamePackage;

import java.io.Serializable;

/**
 *
 * @author Fernando Alvarez
 */
public class History implements Serializable {

    private int values[] = new int[6];
    
    public enum enumValues{
    ataquesExitosos,
    ataquesFallidos,
    asesinatos,
    ganes,
    perdidas,
    rendiciones
    }

    public void addValue(enumValues value){
        this.values[value.ordinal()]++;
    }
    
    public int getValue(enumValues value){
        return this.values[value.ordinal()];
    }

    public int getScore(){
        return getValue(enumValues.ganes)-getValue(enumValues.perdidas);
    }
    
}
