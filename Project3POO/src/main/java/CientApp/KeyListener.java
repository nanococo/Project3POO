package CientApp;

import AbstractMessagingSystem.IInput;
import AbstractMessagingSystem.MessageManager;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
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
        try {
            outputStream.writeObject(MessageManager.createMessage(line));
        } catch (IOException ex) {
            Logger.getLogger(KeyListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
