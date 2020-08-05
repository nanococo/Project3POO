package CientApp;

import GUI.IInput;
import Messaging.IMessage;
import ServerApp.CommandManager.CommandUtil;
import messaging.GenericMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyListener  {


    private final IInput input;//Cualquier clase que implemente Iinput
    private final ObjectOutputStream outputStream;

    public KeyListener(IInput input, ObjectOutputStream outputStream) {
        this.input = input;
        this.outputStream = outputStream;
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
            outputStream.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(KeyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
