package ServerApp.GamePackage;

import java.io.Serializable;
import java.util.Random;

public class Weapon implements Serializable {


    public int[] getDamages() {
        return damages;
    }

    private int damages[] = new int[10];
    private String name;
    private boolean enabled;

    public Weapon(String name){
        this.name = name;
        this.enabled = true;
        generateDamages();
    }

    private void generateDamages() {
        for (int i = 0;i<10;i++) {
            damages[i] = new Random().nextInt(80) + 21;
            System.out.println("Danos"+damages[i]);
        }
        System.out.println(damages);
    }
    
    public void setEnabled(boolean value){
        this.enabled = value;
    }

    public  boolean getEnabled(){
        return this.enabled;
    }

    public int[] atack(){
        this.setEnabled(false);
        return damages;
    }


    public String getName(){
        return  this.name;
    }
}
