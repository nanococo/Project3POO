package ServerApp.Game;

import messaging.GenericMessage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Player {

    private final ObjectOutputStream outputStream;
    private PlayerData data;
    private Character characters[];
    private Weapon weapons[] = new Weapon[5];
    private int NUMBER_OF_CHARACTERS = 5;
    private  String names[] = {
            "Pistola","Cuchillo","Bomba","Globo",
            "Espada","Bazooka","Tenedor","Puños",
            "Garras","Hacha","Laser"
    };
    

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

    private void generateWeapons(){
        shuffleArray();
        for(int i = 0;i<5;i++){
            weapons[i] = new Weapon(names[i]);
        }
    }

    private void shuffleArray(){
        List<String> list = Arrays.asList(names);
        Collections.shuffle(list);
        names = (String[]) list.toArray();
    }
}
