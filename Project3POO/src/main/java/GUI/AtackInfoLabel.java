/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JLabel;

/**
 *
 * @author Fernando Alvarez
 */
public class AtackInfoLabel extends JLabel{

    public AtackInfoLabel(String name,String type,String weapon,String damage) {
        
        String atack = "<html>You Atacked "+"Dummy"+" ["+"Test"+"]"+"<BR>"+
                        "Weapon: "+ "PumPam"+"<BR><BR>"+
                        "53%";
        atack += "<html>";
        setText(atack);
    }
    
    
}
