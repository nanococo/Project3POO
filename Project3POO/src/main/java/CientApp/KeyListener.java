package CientApp;

import GUI.IInput;
import Messaging.IMessage;
import ServerApp.CommandManager.CommandUtil;
import messaging.GenericMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class KeyListener  {

    private final ObjectOutputStream outputStream;
    private final IInput input;//Cualquier clase que implemente Iinput

    public KeyListener(Socket socket, IInput input) throws IOException {
        this.input = input;
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
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
