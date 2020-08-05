package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

public class MutualGiveUp implements ICommand {

    @Override
    public void execute(String[] args) {
        Game.getInstance().surrender();
    }

}
