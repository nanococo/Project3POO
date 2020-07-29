package ServerApp;

import AbstractMessagingSystem.IMessage;
import AbstractMessagingSystem.MessageHandler;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server{

    private List<Socket> clients = Collections.synchronizedList(new ArrayList<Socket>());
    private List<Listener> listeners = new ArrayList<>();
    private ServerSocket serverSocket;
    private Connector connector;
    private ObjectOutputStream op;
    private MessageHandler messageHandler; //Aca puede ser el comandManager para ejecutar comandos y luego enviar una respuesta

    public List<Socket> getClients() {
        return clients;
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    public List<Listener> getListeners() {
        return listeners;
    }

    public Server(int port,MessageHandler messageHandler) {
        // starts server and waits for a connection
       // op = new ObjectOutputStream(new );
        try {
            this.messageHandler = messageHandler;
            this.serverSocket = new ServerSocket(port);
            System.out.println("Server started");

            connector = new Connector(this);
            connector.start();
        }
        catch(IOException i) {
            System.out.println(i.getMessage());
        }
    }

    public void endServer() throws IOException {
        System.out.println("Closing Server");

        // close connection
        killListeners();
        connector.kill();
        killClients();
        serverSocket.close();
    }

    public void killClients(){
        for (Socket client : clients){
            try{
                //new DataOutputStream(client.getOutputStream()).writeUTF("End");
                client.close();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void killListeners(){
        for (Listener listener : listeners) {
            listener.kill();
        }
    }

    MessageHandler getMessageHandler() {
        return this.messageHandler;
    }
    
    public void sendToAll(IMessage message) throws IOException{
        for (Socket client : clients) {
            new ObjectOutputStream(client.getOutputStream()).writeObject(message);
        }
    }
    
    //

}
