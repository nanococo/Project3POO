package ServerApp.Game;

import CharacterManager.CharacterFactory;
import FileManager.PlayerLoader;
import ServerApp.Server;
import java.io.IOException;
import java.net.Socket;
import java.util.Random;


public class Game {

    private static Game game;
    public CharacterFactory factory;
    public Player[] players = new Player[2];
    public Log log;
    public PlayerLoader playerLoader;
    public Server server;

    private Game(){
    	this.factory = new CharacterFactory();
        this.log = new Log();
        this.playerLoader = new PlayerLoader();
    }


    public static Game getInstance(){
        if(game != null) return game;

        game = new Game();
        return game;
    }

    public void initGame(){
        //Desbloquea comnado o abre otra pantalla
    }
    
    public void setPlayer(String id){
        int index = 0;
        if(players[index] != null)
            index++;
        players[index].setData(playerLoader.searchPlayer(id));
    }
    
    public void setCharacters(Player player){
        for (Character character : player.getCharacter()) {
            int random = new Random().nextInt(factory.numeroDePersonajes());
            character = factory.getCharacter(random);
        }
    }

    public void initPlayer(Socket socket) throws IOException {
        int index = 0;
        if(players[index] != null)
            index++;
        players[index] = new Player(socket);
    }
    
}


