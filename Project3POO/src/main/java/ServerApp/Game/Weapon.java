package ServerApp.Game;

import com.sun.org.apache.bcel.internal.generic.RETURN;

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
        for (int damage :damages)
            damage = new Random().nextInt(80)+21;
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
