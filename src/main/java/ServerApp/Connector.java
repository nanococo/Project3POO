package ServerApp;

import java.io.IOException;
import java.net.Socket;

public class Connector extends Thread {

    private final Server server;
    private boolean killSwitch = false;

    public Connector(Server server){
        this.server = server;
    }

    @Override
    public void run() {
        while (!killSwitch){
            try {
                System.out.println("Waiting for a client ...");
                Socket client = server.getServerSocket().accept();
                server.getClients().add(client);
                Listener listener = new Listener(client, server);
                listener.start();
                server.getListeners().add(listener);

                System.out.println("Client Accepted");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void kill(){
        this.killSwitch = true;
    }
}
