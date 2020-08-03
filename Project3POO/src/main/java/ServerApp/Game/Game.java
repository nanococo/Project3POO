package ServerApp.Game;

import CharacterManager.CharacterFactory;
import FileManager.PlayerLoader;
import ServerApp.Server;
import java.util.Random;


public class Game {

    public CharacterFactory factory;
    public Player[] players = new Player[2];
    public Log log;
    public PlayerLoader playerLoader;
    public Server server;
    
    public Game(Server server){
        this.factory = new CharacterFactory();
        this.log = new Log();
        this.playerLoader = new PlayerLoader();
        initPlayer(server);
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

    private void initPlayer(Server server) {
        for (Player player : players) {
            //player = new Player();
        }
    }
    
}
