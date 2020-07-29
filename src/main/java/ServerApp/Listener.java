package ServerApp;

import AbstractMessagingSystem.IMessage;
import AbstractMessagingSystem.MessageManager;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Listener extends Thread {

    private final Socket client;
    private final Server server;
    private boolean killSwitch = false;

    public Listener(Socket client, Server server)throws IOException{
        this.client = client;
        this.server = server;
    }


    @Override
    public void run() {
        while(true){
            try{
                
                IMessage message =(IMessage) new ObjectInputStream(new BufferedInputStream(client.getInputStream())).readObject();
                server.getMessageHandler().useMessage(message);//Aca se envia a la clase que tiene que utilizar el mensaje y se ejecuta segun se haya programado el metodo abstracto

                if(message.equals("Exit")){
                    client.close();
                    System.out.println("Client Exited");
                    break;
                } else if(message.equals("End")){
                    server.endServer();
                    System.out.println("Server Shut Down");
                    break;
                } else if(message.equals("Time")){

                }
                

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void kill(){
        this.killSwitch = true;
    }
}
