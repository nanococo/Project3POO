package CientApp;

import AbstractMessagingSystem.IMessage;
import AbstractMessagingSystem.IOutput;
import AbstractMessagingSystem.MessageManager;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerListener extends Thread {

    private final Client client;
    private final Socket socket;
    private boolean killSwitch = false;
    private IOutput output; //Cualquier clase que implemente IOutput

    public ServerListener(Socket socket, Client client,IOutput output){
        this.client = client;
        this.socket = socket;
        this.output = output;
    }


    @Override
    public void run() {
        while (!killSwitch){
            try{
                IMessage message =(IMessage) new ObjectInputStream(new BufferedInputStream(socket.getInputStream())).readObject();
                client.getMessageHandler().useMessage(message);
                System.out.println("SERVERLSITENER");
                if(message.equals("Exit")){
                    client.closeClient();
                }
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
