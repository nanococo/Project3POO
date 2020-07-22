package CientApp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
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
                String line = new DataInputStream(new BufferedInputStream(socket.getInputStream())).readUTF();
                System.out.println(line);

                if(line.equals("Exit")){
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
