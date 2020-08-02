package ServerApp.Game;

import messaging.GenericMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Player {

    private final Socket connectionToPlayer;
    private final ObjectOutputStream outputStream;

    private String ID;
    private String name;

    public Player(Socket socket) throws IOException {
        this.connectionToPlayer = socket;
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
    }

    public void sendMessageToPlayer(String commandName, String... params) throws IOException {
        outputStream.writeObject(new GenericMessage(commandName, params));
    }

}
