package CientApp;

import GUIPackage.IInput;
import Messaging.IMessage;
import MessagingPackage.GenericMessage;
import ServerApp.CommandManager.CommandUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyListener  {


    private final IInput input;//Cualquier clase que implemente Iinput

    public KeyListener(IInput input) {
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
            GlobalConfigurations.getObjectOutputStream().writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(KeyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
