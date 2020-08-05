/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIPackage;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Fernando Alvarez
 */
public class WeaponInfoLabel extends JLabel{

    JLabel labels[] = new JLabel[11];
    Color NEGRA = new Color(50, 50, 50);
    
    public WeaponInfoLabel() {
        this.setBackground(NEGRA);
        this.setOpaque(true);
    }
    
   public final void createLabels(String name, int[] values){//Meter a un array
        //1/4 y el resto dividido entre 10
        Dimension dimension = getSize();
        int nameWidthDimension = dimension.width/4;
        int labelWidth = (dimension.width-nameWidthDimension)/10;
        JLabel lblName = new JLabel(name);
        lblName.setBounds(0,0,nameWidthDimension,dimension.height);
        labels[0] = lblName;
        this.add(lblName);
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(String.valueOf(values[i]));
            //JLabel label = new JLabel(String.valueOf(i));
            label.setBounds((labelWidth*i)+nameWidthDimension, 0, labelWidth, dimension.height);
            labels[i+1] = label;
            this.add(label);
        }
        
   } 
   
   public void usedWeapon(){//Pone el color original y cuando un arma esta ocupado pinta las casillas rojas
       for (JLabel label : labels) {
           label.setBackground(Color.red);
       }
   }
   
    public void resetWeapon() {
       for (JLabel label : labels) {
           label.setBackground(NEGRA);
       }
    }
}
