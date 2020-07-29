package CientApp;

import AbstractMessagingSystem.IInput;
import AbstractMessagingSystem.IOutput;
import AbstractMessagingSystem.MessageHandler;
import AbstractMessagingSystem.MessageManager;
import ServerApp.Server;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private Socket socket;
    private KeyListener keyListener;
    private ServerListener serverListener;
    private MessageHandler messageHandler;//Aca puede ser la pantalla para actualizar los datos

    public Client(String address, int port,IInput input,IOutput output,MessageHandler messageHandler) {
        // establish a connection
        try {
            this.messageHandler = messageHandler;
            socket = new Socket(address, port);
            System.out.println("Connected");

            serverListener = new ServerListener(socket, this,output);
            serverListener.start();

            keyListener = new KeyListener(socket, this,input);

        }
        catch(IOException u) {
            System.out.println(u.getMessage());
        }
    }

    public void closeClient(){
        // close the connection
        try {
            keyListener.kill();
            serverListener.kill();
            socket.close();
            System.out.println("Disconnected");
        }
        catch(IOException i) {
            System.out.println(i.getMessage());
        }
    }

    MessageHandler getMessageHandler() {
        return this.messageHandler;
    }
    
    public void sendMessage(){
        this.keyListener.getInput();
    }
}
