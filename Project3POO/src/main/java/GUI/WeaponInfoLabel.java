/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;

/**
 *
 * @author Fernando Alvarez
 */
public class WeaponInfoLabel extends JLabel{

    public WeaponInfoLabel() {
        //Crea el arreglo
        this.setBackground(Color.red);
        this.setOpaque(true);
    }
    
   public final void createLabels(String name, String[] values){//Meter a un array
        //1/4 y el resto dividido entre 10
        Dimension dimension = getSize();
        int nameWidthDimension = dimension.width/4;
        int labelWidth = (dimension.width-nameWidthDimension)/10;
        JLabel lblName = new JLabel(name);
        lblName.setBounds(0,0,nameWidthDimension,dimension.height);
        this.add(lblName);
        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(String.valueOf(i));
            label.setBounds((labelWidth*i)+nameWidthDimension, 0, labelWidth, dimension.height);
            this.add(label);
        }
   } 
   
   public void paintValues(){//Pone el color original y cuando un arma esta ocupado pinta las casillas rojas
       
   }
}
