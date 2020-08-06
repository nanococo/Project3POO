package ServerApp.GamePackage;

import java.io.Serializable;

public class Character implements Serializable,Cloneable{
    
    Types type;
    String name;
    String path;
    int health;
    private Weapon weapons[];
    boolean alive;

 
    public Character(Types type, String name, String path) {
        this.type = type;
        this.name = name;
        this.path = path;
        this.health = 100;
        this.weapons = new Weapon[5];
        this.alive = true;
    }
    
    @Override
    public Character clone() throws CloneNotSupportedException{
        return (Character)super.clone();
    }
    
    public Character deepClone() throws CloneNotSupportedException{//Si se agrega algun dato
        Character character = clone();
        //character.x = new x();
        return character;
    }

    public String getName() {
        return name;
    }
    
    public String getPath(){
    return path;
    }

    public Weapon[] getWeapons(){
        return  weapons;
    }

    public Weapon getWeapon(String weaponName){
        for (Weapon weapon:weapons){
            if(weapon.getName().equals(weaponName))
                return  weapon;
        }
        return  null;
    }

    public boolean recieveDamage(int damage){
        this.health = this.health-damage;
        if(health <= 0)
            this.alive = false;
        return alive;
    }

    public Types getType(){
        return  this.type;
    }

    public void reloadWeapons() {
        for (Weapon weapon:weapons)
            weapon.setEnabled(true);
    }


}
