package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

public class WildCard implements ICommand {

    public static final String NAME = "wildCard";

    @Override
    public void execute(String[] args) {
        if(Game.getInstance().time == 0){
            Game.getInstance().wildCard(args);
        } else if (System.currentTimeMillis() - Game.getInstance().time >= 300000){
            Game.getInstance().wildCard(args);
            Game.getInstance().time = System.currentTimeMillis();
        }
    }

}
