/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import javax.swing.JLabel;
import javax.swing.JTextArea;

/**
 *
 * @author Fernando Alvarez
 */
public class AtackedByInfoLabel extends JLabel{
    
    public AtackedByInfoLabel(String name,String type,String weapon,String[] atackResult) {
        
        String atack = "<html>Atacked by "+"Dummy"+" ["+"Test"+"]"+"<BR>"+
                        "Weapon: "+ "Weapon"+"<BR><BR>";
        for (int i = 0; i < 5; i++) {
            atack += ("E"+String.valueOf(i))+":"+"-"+String.valueOf(i)+"%"+"<BR>";
        }
        atack += "<html>";
        setText(atack);
    }
    
}
