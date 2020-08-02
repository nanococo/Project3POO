package ServerApp;

import ServerApp.Game.Player;

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


                if(server.getGame().players[0]==null){
                    server.getGame().players[0] = new Player(client);
                    server.getGame().players[0].sendMessageToPlayer("PrintConsole", "Waiting for player 2");

                } else {
                    server.getGame().players[1] = new Player(client);
                    server.getGame().players[0].sendMessageToPlayer("PrintConsole", "Players Connected");
                    server.getGame().players[1].sendMessageToPlayer("PrintConsole", "Players Connected");
                    break;
                }

                Listener listener = new Listener(client);
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
