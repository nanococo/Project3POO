package CientApp;

import ServerApp.Server;

import java.io.IOException;
import java.net.Socket;

public class Client {

    private Socket socket;
    private KeyListener keyListener;
    private ServerListener serverListener;

    public Client(String address, int port) {
        // establish a connection
        try {
            socket = new Socket(address, port);
            System.out.println("Connected");

            serverListener = new ServerListener(socket, this);
            serverListener.start();

            keyListener = new KeyListener(socket, this);
            keyListener.start();

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
}
