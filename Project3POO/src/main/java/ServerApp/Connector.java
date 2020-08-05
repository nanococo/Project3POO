package ServerApp;

import ServerApp.GamePackage.Player;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
                Player player = server.getGame().initPlayer(client);//Pasando el socket al jugador

               /* if(Game.getInstance().players[0]==null){
                    Game.getInstance().players[0] = new Player(client);
                    Game.getInstance().players[0].sendMessageToPlayer("SetClientID", "ABC");
                    Game.getInstance().players[0].sendMessageToPlayer("PrintConsole", "Waiting for player 2");

                } else {
                    Game.getInstance().players[1] = new Player(client);
                    Game.getInstance().players[0].sendMessageToPlayer("PrintConsole", "Players Connected");
                    Game.getInstance().players[1].sendMessageToPlayer("SetClientID", "DEF");
                    Game.getInstance().players[1].sendMessageToPlayer("PrintConsole", "Players Connected");
                }*/


                Listener listener = new Listener(player);
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
