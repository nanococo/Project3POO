package CientApp.clientCommands;

import GUI.MainWindow;

import java.util.HashMap;

public class ClientCommandManager {
    private static ClientCommandManager commandManager;
    private static final HashMap<String, Class<? extends IClientCommand>> commands = new HashMap<>();

    private ClientCommandManager(){
        //Use this method to register commands
        registerCommand(PrintConsole.NAME, PrintConsole.class);
        registerCommand(SetClientID.NAME, SetClientID.class);
    }

    public static ClientCommandManager getInstance(){
        if(commandManager==null){
            commandManager = new ClientCommandManager();
        }
        return commandManager;
    }

    public void executeOperation(String[] params, MainWindow mainWindow, IClientCommand command) {
        command.execute(params, mainWindow);
    }

    public IClientCommand getCommand(String commandName) {
        if (commands.containsKey(commandName.toUpperCase())) {
            try {
                return commands.get(commandName.toUpperCase()).newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return ((param, window) -> System.out.println("Error command not found"));
            }
        }
        else {
            return ((param, window) -> System.out.println("Error command not found"));
        }
    }


    public void registerCommand(String commandName, Class<? extends IClientCommand> command) {
        commands.put(commandName.toUpperCase(), command);
    }
}
