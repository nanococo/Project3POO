package ServerApp.Game;

import java.util.Random;

public class Weapon {


    private int damages[] = new int[10];
    private String name;

    public Weapon(String name){
        this.name = name;
        generateDamages();
    }

    private void generateDamages() {
        for (int damage :damages)
            damage = new Random().nextInt(100)+1;
    }
    
    


}
