package CientApp;

import GUI.MainWindow;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {

    private final Socket socket = GlobalConfigurations.getInstance().getSocket();
    private KeyListener keyListener;
    private ServerListener serverListener;

    public Client(MainWindow input, String id) {
        // establish a connection
        try {

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());

            serverListener = new ServerListener(socket, this, input);
            serverListener.start();

            keyListener = new KeyListener(input, outputStream);

            GlobalConfigurations.sendMessageToServer("PlayerSetId", outputStream, id);

        }
        catch(IOException u) {
            System.out.println(u.getMessage());
        }
    }


    public void closeClient(){
        // close the connection
        try {
            serverListener.kill();
            socket.close();
            System.out.println("Disconnected");
        }
        catch(IOException i) {
            System.out.println(i.getMessage());
        }
    }

    public void sendMessage(){
        this.keyListener.getInput();
    }


}
