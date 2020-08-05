package GUI;

import javax.swing.*;

public class WeaponLabel extends JLabel {

    WeaponInfoLabel[] labels = new WeaponInfoLabel[5];

    public void addToLabel(){
        for (WeaponInfoLabel label:labels){
            this.add(label);
        }
    }

}
