package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

public class Start implements ICommand{

    public static final String NAME = "start";

    @Override
    public void execute(String[] args) {
        Game.sendPlayerData();
    }
}
