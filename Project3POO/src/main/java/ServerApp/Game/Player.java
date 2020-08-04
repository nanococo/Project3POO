package ServerApp.Game;

import messaging.GenericMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Player {

    private final ObjectOutputStream outputStream;
    private PlayerData data;
    private Character characters[];
    private int NUMBER_OF_CHARACTERS = 5;
    

    public Player(Socket socket) throws IOException {
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
        characters = new Character[NUMBER_OF_CHARACTERS];
    }

    public void sendMessageToPlayer(String commandName, String... params) throws IOException {
        outputStream.writeObject(new GenericMessage(commandName, params));
    }

    public void setData(PlayerData data){
        this.data = data;
    }

    public String getId() {
        return data.getId();
    }

    Character[] getCharacter() {
        return characters;
    }

    public ObjectOutputStream getObjectOutput(){
        return outputStream;
    }
}
