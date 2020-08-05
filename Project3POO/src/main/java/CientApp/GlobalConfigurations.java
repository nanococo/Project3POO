package CientApp;


import messaging.GenericMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * Acts as a container for socket connection easy access in the app
 */
public final class GlobalConfigurations {

    private static GlobalConfigurations globalConfigurations;
    public static Socket socket;
    public static String clientID;

    private GlobalConfigurations(){}

    public static GlobalConfigurations getInstance() {
        if(globalConfigurations !=null) return globalConfigurations;

        globalConfigurations = new GlobalConfigurations();
        try{
            socket = new Socket("127.0.0.1",5000);
            System.out.println("Connected");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return globalConfigurations;
    }

    public static void sendMessageToServer(String commandName, ObjectOutputStream outputStream, String... params) throws IOException {
        outputStream.writeObject(new GenericMessage(commandName, params));
    }


    public Socket getSocket(){
        return socket;
    }

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String id) {
        clientID = id;
    }
}
