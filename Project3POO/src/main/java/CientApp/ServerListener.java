package CientApp;

import Messaging.IMessage;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerListener extends Thread {

    private final Client client;
    private final Socket socket;
    private boolean killSwitch = false;

    public ServerListener(Socket socket, Client client){
        this.client = client;
        this.socket = socket;
    }


    @Override
    public void run() {
        while (!killSwitch){
            try{


                IMessage message = (IMessage) new ObjectInputStream(new BufferedInputStream(socket.getInputStream())).readObject();


            }catch(Exception e) {
                kill();
                client.closeClient();
                break;
            }
        }
    }

    public void kill(){
        this.killSwitch = true;
    }
}
