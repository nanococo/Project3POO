/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Fernando Alvarez
 */
public class PersonajeLabel extends JLabel{
    
    JLabel name;
    JLabel hp;

    public PersonajeLabel(String name) {
        this.setOpaque(true);
        this.name = new JLabel();
        this.hp = new JLabel();
        this.name.setOpaque(true);
        this.hp.setOpaque(true);
        this.name.setText(name);
        this.hp.setText("%100");
        this.hp.setBackground(Color.red);
        this.name.setBackground(Color.red);
        this.name.setBounds(0,0,50,20);
        this.hp.setBounds(0,50,30,20);
        this.add(this.name);
        this.add(this.hp);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        /*try {
            this.setIcon(new ImageIcon(ImageIO.read(this.getClass().getClassLoader().getResourceAsStream("/Images/toledoatack.png"))));
        } catch (IOException ex) {
            Logger.getLogger(PersonajeLabel.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    public void updateHp(String hp){
        this.hp.setText("%"+hp);
    }
}
