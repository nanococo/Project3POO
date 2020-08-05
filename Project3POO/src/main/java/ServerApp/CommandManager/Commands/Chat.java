package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

import java.io.IOException;

public class Chat implements ICommand {

    public static final String NAME = "chat";

    @Override
    public void execute(String[] args) {
        if(args.length<=0) return;

        try {
            Game.getInstance().players[0].sendMessageToPlayer("PrintConsole", args[0]);
            Game.getInstance().players[1].sendMessageToPlayer("PrintConsole", args[0]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
