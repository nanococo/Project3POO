package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

import java.io.IOException;

public class EchoCommand implements ICommand {

    public static final String NAME = "echo";

    @Override
    public void execute(String[] args) {
        if(args.length<=0) return;

        System.out.println(args[0]);
    }

}
