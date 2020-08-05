package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

import java.io.IOException;

public class Start implements ICommand{

    public static final String NAME = "start";

    @Override
    public void execute(String[] args) {
        try {
            if(Game.getInstance().players[1]!=null){
                Game.getInstance().players[0].getObjectOutput().writeObject(Game.getInstance().players[0].getData());
                Game.getInstance().players[1].getObjectOutput().writeObject(Game.getInstance().players[1].getData());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
