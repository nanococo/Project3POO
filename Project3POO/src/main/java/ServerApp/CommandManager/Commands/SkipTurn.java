package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

public class SkipTurn implements ICommand {

    public static final String NAME = "skipTurn";

    @Override
    public void execute(String[] args) {
        Game.getInstance().passTurn();
    }
    
}
