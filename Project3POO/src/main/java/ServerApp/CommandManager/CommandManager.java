package ServerApp.CommandManager;

import ServerApp.CommandManager.Commands.EchoCommand;
import ServerApp.CommandManager.Commands.ICommand;

import java.util.HashMap;

public class CommandManager {
    private static CommandManager commandManager;
    private static final HashMap<String, Class<? extends ICommand>> commands = new HashMap<>();

    private CommandManager(){
        //Use this method to register commands
        registerCommand(EchoCommand.NAME, EchoCommand.class);
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
                return (param -> System.out.println("Error command not found"));
            }
        }
        else {
            return (param -> System.out.println("Error command not found"));
        }
    }


    public void registerCommand(String commandName, Class<? extends ICommand> command) {
        commands.put(commandName.toUpperCase(), command);
    }
}
