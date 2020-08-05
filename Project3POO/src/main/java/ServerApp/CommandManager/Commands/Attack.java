package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

public class Attack implements ICommand {

    public static final String NAME = "Attack";

    @Override
    public void execute(String[] args) {
        if(args.length<=0) return;

        Game.getInstance().attack(args[1], args[2]);
    }
}
