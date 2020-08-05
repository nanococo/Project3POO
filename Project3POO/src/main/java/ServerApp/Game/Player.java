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
    private final Character[] characters;
    private final int NUMBER_OF_CHARACTERS = 5;
    private String[] names = {
            "Pistola","Cuchillo","Bomba","Globo",
            "Espada","Bazooka","Tenedor","Puños",
            "Garras","Hacha","Laser"
    };
    private Player selectedCharacter;

    public Player(Socket socket) throws IOException {
        this.outputStream = new ObjectOutputStream(socket.getOutputStream());
        characters = new Character[NUMBER_OF_CHARACTERS];
        Game.getInstance().setCharacters(this);
    }

    public void sendMessageToPlayer(String commandName, String... params) throws IOException {
        outputStream.writeObject(new GenericMessage(commandName, params));
    }





    public PlayerData getData() {
        return data;
    }

    public void setData(PlayerData data){
        this.data = data;
    }

    public String getId() {
        return data.getId();
    }

    public Character[] getCharacters() {
        return characters;
    }

    public Character getCharacter(String character){
        for (Character chare:characters){
            if(chare.getName() == character)
                return chare;
        }
        return  null;
    }

    public ObjectOutputStream getObjectOutput(){
        return outputStream;
    }

    private void generateWeapons(){
        shuffleArray();
        for(int i = 0;i<5;i++){
            Character character = characters[i];
            for(int j =0;j<5;j++){
                Weapon weapon = character.getWeapons()[j];
                weapon = new Weapon(names[j]);
            }

        }
    }

    public void giveUp(){
        //Modifica el historial
    }

    private void shuffleArray(){
        List<String> list = Arrays.asList(names);
        Collections.shuffle(list);
        names = (String[]) list.toArray();
    }
}
