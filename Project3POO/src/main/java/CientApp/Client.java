package CientApp;

import GUIPackage.MainWindow;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private final Socket socket = GlobalConfigurations.getInstance().getSocket();
    private KeyListener keyListener;
    private ServerListener serverListener;

    public Client(MainWindow input, String id) {
        // establish a connection
        try {

            serverListener = new ServerListener(this, input);
            serverListener.start();

            keyListener = new KeyListener(input);

            GlobalConfigurations.sendMessageToServer("PlayerSetId", GlobalConfigurations.getObjectOutputStream(), id);

        }
        catch(IOException u) {
            u.printStackTrace();
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
