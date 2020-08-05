package GUI;

import javax.swing.*;

public class WeaponLabel extends JLabel {

    WeaponInfoLabel[] labels = new WeaponInfoLabel[5];

    public WeaponLabel() {
        setOpaque(true);
    }
    
    

    public void addToLabel(){
        for (WeaponInfoLabel label:labels){
            this.add(label);
        }
    }
    
    public void setUsed(String weaponName){
        for (WeaponInfoLabel label : labels) {
            if (label.labels[0].getText() == weaponName) {
                label.usedWeapon();
            }
        }
    }
    
    public void resetWeapons(){
        for (WeaponInfoLabel label : labels) {
            label.resetWeapon();
        }
    }

}
