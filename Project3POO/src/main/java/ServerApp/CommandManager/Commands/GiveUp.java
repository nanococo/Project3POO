package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

public class GiveUp implements ICommand {

    public static final String NAME = "giveUp";

    @Override
    public void execute(String[] args) {
        Game.getInstance().surrender();
    }
}
