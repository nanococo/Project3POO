package ServerApp.CommandManager;

import ServerApp.CommandManager.Commands.*;
import ServerApp.GamePackage.Game;

import java.io.IOException;
import java.util.HashMap;

public class CommandManager {
    private static CommandManager commandManager;
    private static final HashMap<String, Class<? extends ICommand>> commands = new HashMap<>();

    private CommandManager(){
        //Use this method to register commands
        registerCommand(EchoCommand.NAME, EchoCommand.class);
        registerCommand(PlayerSetId.NAME, PlayerSetId.class);
        registerCommand(Attack.NAME, Attack.class);
        registerCommand(Chat.NAME, Chat.class);
        registerCommand(Start.NAME, Start.class);
    }

    public static CommandManager getInstance(){
        if(commandManager==null){
            commandManager = new CommandManager();
        }
        return commandManager;
    }

    public void executeOperation(String[] params, ICommand command) {
        command.execute(params);
    }

    public ICommand getCommand(String commandName) {
        if (commands.containsKey(commandName.toUpperCase())) {
            try {
                return commands.get(commandName.toUpperCase()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();

                return (param -> {
                    try {
                        Game.getInstance().getPlayerInTurn().sendMessageToPlayer("PrintConsole", "Error command not found");
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }
                });
            }
        }
        else {
            return (param -> {
                try {
                    Game.getInstance().getPlayerInTurn().sendMessageToPlayer("PrintConsole", "Error command not found");
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            });
        }
    }


    public void registerCommand(String commandName, Class<? extends ICommand> command) {
        commands.put(commandName.toUpperCase(), command);
    }
}
