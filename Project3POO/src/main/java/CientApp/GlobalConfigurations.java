package CientApp;


import MessagingPackage.GenericMessage;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


/**
 * Acts as a container for socket connection easy access in the app
 */
public final class GlobalConfigurations {

    private static GlobalConfigurations globalConfigurations;
    public static Socket socket;
    public static String clientID;
    public static ObjectInputStream objectInputStream;
    public static ObjectOutputStream objectOutputStream;

    private GlobalConfigurations(){}

    public static GlobalConfigurations getInstance() {
        if(globalConfigurations !=null) return globalConfigurations;

        globalConfigurations = new GlobalConfigurations();
        try{
            socket = new Socket("127.0.0.1",5000);
            objectInputStream = new ObjectInputStream(socket.getInputStream());
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            System.out.println("Connected");
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return globalConfigurations;
    }

    public static void sendMessageToServer(String commandName, ObjectOutputStream outputStream, String... params) throws IOException {
        outputStream.writeObject(new GenericMessage(commandName, params));
    }

    public static ObjectInputStream getObjectInputStream() {
        return objectInputStream;
    }

    public static ObjectOutputStream getObjectOutputStream() {
        return objectOutputStream;
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
