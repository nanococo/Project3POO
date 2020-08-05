package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

import java.io.IOException;

public class Reload implements ICommand {

    public static final String NAME = "reload";

    @Override
    public void execute(String[] args) {
        if(args.length<=0) return;

        String response = Game.getInstance().reloadWeapons(args[0]);

        try {
            Game.getInstance().getPlayerInTurn().sendMessageToPlayer("PrintConsole", response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
