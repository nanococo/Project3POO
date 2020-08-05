package ServerApp.CommandManager.Commands;

import ServerApp.GamePackage.Game;

public class PlayerSetId implements ICommand {

    public static final String NAME = "PlayerSetId";

    @Override
    public void execute(String[] args) {
        if(args.length<=0) return;

        Game.getInstance().setPlayer(args[0]);
        System.out.println("Id set: "+args[0]);
    }
}
