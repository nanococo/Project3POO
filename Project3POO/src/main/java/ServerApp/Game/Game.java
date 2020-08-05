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

    private Player playerInTurn;
    private boolean mutualGiveUp;
    private boolean winCondition;

    private Game(){
        this.winCondition = false;
    	this.factory = new CharacterFactory();
        this.log = new Log();
        this.playerLoader = new PlayerLoader();
    }

    //Pre game settings

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
        if(players[index].getData() != null)
            index++;
        players[index].setData(playerLoader.searchPlayer(id));
    }
    
    public void setCharacters(Player player){
        for (Character character : player.getCharacters()) {
            int random = new Random().nextInt(factory.numeroDePersonajes());
            character = factory.getCharacter(random);
        }
    }

    public Player initPlayer(Socket socket) throws IOException {
        int index = 0;
        if(players[index] != null)
            index++;
        players[index] = new Player(socket);
        return players[index];
    }

    //In game methods

    private void nextTurn(){
        if(playerInTurn == players[0])
            playerInTurn = players[1];
        else
            playerInTurn = players[0];
    }

    private String doubleAtack(String character1,String weapon1,String character2,String weapon2){
        String msg = "";
        msg+= attack(character1,weapon1);//Cuidado aca porque si no existe la segunda arma ya se va a haber realizado el primer ataque
        msg += "\n";
        msg+= attack(character2,weapon2);
        return  msg;
    }

    private String doubleWeapon(String character,String weapon1,String weapon2){
        String msg = "";
        msg+= attack(character,weapon1);
        msg+="\n";
        msg+= attack(character,weapon2);
        return msg;
    }


    private boolean isInTurn(Player player){
        return  player==playerInTurn;
    }

    private  boolean isInTurn(String playerId){
        return playerId == playerInTurn.getId();
    }

    private Player enemyPlayer(){
        for (Player player:players){
            if(player != playerInTurn)
                return  player;
        }
        return  null;
    }

    private boolean weaponEnabled(Weapon weapon){
        return weapon.getEnabled();
    }

    public String attack(String characterName, String weaponName){//If is in turn?
        Character character = playerInTurn.getCharacter(characterName);
        String attackMsg = "";
        if(character != null){
            Weapon weapon = character.getWeapon(weaponName);
            if (weapon != null){
                if (weapon.getEnabled()) {
                    attackMsg += characterName + " atacked with "+weaponName+"\n";
                    attackMsg += dealDamage(weapon);
                    if(winCondition)
                        endGame();
                    else
                        nextTurn();//Paso de turno al atacar
                    return attackMsg;
                }
                else
                    return "Weapon already used";//Error msg
            }
            else{
                return "Weapon does not exist";
            }
        }
        else
            return "Character does not exist";
    }

    private void endGame() {
    }

    private String dealDamage(Weapon weapon){
        String msg = "";
        Player enemy = enemyPlayer();
        int[] damages = weapon.atack();
        for (Character character:enemy.getCharacters()){//El dano hace return del estado del personaje
            int damage = damages[character.getType().ordinal()];
            boolean alive = character.recieveDamage(damage);
            msg += character.getName()+" recieved " +damage+"% damage";
            if(!alive)
                msg+=" and died";
            msg+= "\n";
        }
        return msg;
    }

    public String surrender(){
        winCondition = true;
        playerInTurn.giveUp();
        endGame();
        return playerInTurn.getId()+" gave up";
    }

    public String mutualGiveUp(){//Tienen que estar los dos de acuerdo
        winCondition = true;
        playerInTurn.giveUp();
        enemyPlayer().giveUp();
        return  "Both players gave up";
    }

    public void reloadWeapons(String characterName){
        Character character = playerInTurn.getCharacter(characterName);
        boolean canReload = true;
        for (Weapon weapon:character.getWeapons()){
            if(weapon.getEnabled())
                canReload = false;
        }
        if (canReload) character.reloadWeapons();
    }

    public String wildCard(String[] args){//Si se reciben dos armas o si s reciben dos character
            if(args.length == 3)
                return doubleWeapon(args[0],args[1],args[2]);
            else
                return doubleAtack(args[0],args[1],args[2],args[3]);
    }

    public String selectPlayer(){//Creo que es un command propio del cliente o hay que seleccionar para atacar?
        return "";
    }

    public String passTurn(){
        String msg = playerInTurn.getId() + " passed turn";
        nextTurn();
        return msg;
    }
    
}


