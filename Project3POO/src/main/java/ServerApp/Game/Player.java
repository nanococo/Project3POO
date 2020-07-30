package ServerApp.Game;

import java.net.Socket;

public class Player {

    private final Socket connectionToPlayer;

    private String ID;
    private String name;

    public Player(Socket socket){
        this.connectionToPlayer = socket;
    }

}
