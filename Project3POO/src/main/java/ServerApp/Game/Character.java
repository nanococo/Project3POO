package ServerApp.Game;

import java.io.Serializable;

public class Character implements Serializable,Cloneable{
    
    Types type;
    String name;
    String path;
    public String getPath;
 
    public Character(Types type, String name, String path) {
        this.type = type;
        this.name = name;
        this.path = path;
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
}
