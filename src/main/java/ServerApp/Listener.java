package ServerApp;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.Socket;

public class Listener extends Thread {

    private final Socket client;
    private final Server server;
    private boolean killSwitch = false;

    public Listener(Socket client, Server server){
        this.client = client;
        this.server = server;
    }


    @Override
    public void run() {
        while(true){
            try{
                String line = new DataInputStream(new BufferedInputStream(client.getInputStream())).readUTF();
                System.out.println(line);

                if(line.equals("Exit")){
                    client.close();
                    System.out.println("Client Exited");
                    break;
                } else if(line.equals("End")){
                    server.endServer();
                    System.out.println("Server Shut Down");
                    break;
                } else if(line.equals("Time")){

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
