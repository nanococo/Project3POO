package CientApp;


import java.io.IOException;
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
        } catch (IOException e){
            System.out.println(e.getMessage());
        }

        return globalConfigurations;
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
