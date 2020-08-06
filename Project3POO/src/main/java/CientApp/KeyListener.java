package CientApp;

import CientApp.clientCommands.ClientCommandManager;
import GUIPackage.IInput;
import GUIPackage.MainWindow;
import Messaging.IMessage;
import MessagingPackage.GenericMessage;
import ServerApp.CommandManager.CommandUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyListener  {


    private final MainWindow input;//Cualquier clase que implemente Iinput

    public KeyListener(MainWindow  input ) {
        this.input = input;
    }

    
    public void getInput(){
        String line = input.nextLine();

        if (line.trim().length() == 0) {
            return;
        }
        String[] commands = CommandUtil.tokenizerArgs(line);
        String commandName = commands[0];
        String[] commandArgs = null;

        if (commands.length > 1) {
            commandArgs = Arrays.copyOfRange(commands, 1, commands.length);
        }

        IMessage message = new GenericMessage(commandName, commandArgs);

        try {
            if(!commandName.equals("selectplayer"))
                GlobalConfigurations.getObjectOutputStream().writeObject(message);
            else
                ClientCommandManager.getInstance().executeOperation(commandArgs, input, ClientCommandManager.getInstance().getCommand(message.getKey()));
        } catch (IOException ex) {
            Logger.getLogger(KeyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
