package ServerApp.GamePackage;

import CharacterManager.CharacterFactory;
import FileManager.PlayerLoader;

import java.io.IOException;
import java.net.Socket;
import java.util.Random;


public class Game {

    private static Game game;
    public CharacterFactory factory;
    public Player[] players = new Player[2];
    public Log log;
    public PlayerLoader playerLoader;
    public long time = 0;

    private Player playerInTurn;
    private boolean mutualGiveUp;//2 booleanos
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

    public Player getPlayerInTurn() {
        return playerInTurn;
    }

    public void setPlayer(String id){
        int index = 0;
        if(players[index].getData() != null)
            index++;
        players[index].setData(playerLoader.searchPlayer(id));
        if(index == 1){
            completeData();
        }
    }

    private void completeData() {
        int enemy = 1;
        for (int i = 0;i<2;i++){
            players[i].getData().setEnemyData(players[enemy].getData());
            players[i].getData().setRank(getRank());
            players[i].getData().setCharacter(players[i].getCharacters());
            enemy--;
        }
    }

    public void setCharacters(Player player){
        for (int i = 0;i<5;i++) {
            int random = new Random().nextInt(factory.numeroDePersonajes());
            player.getCharacters()[i] = factory.getCharacter(random);
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

    private void doubleAttack(String character1, String weapon1, String character2, String weapon2){
        attack(character1,weapon1);//Cuidado aca porque si no existe la segunda arma ya se va a haber realizado el primer ataque
        attack(character2,weapon2);
    }

    private void doubleWeapon(String character,String weapon1,String weapon2){
        attack(character,weapon1);
        attack(character,weapon2);
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

    public void attack(String characterName, String weaponName){//If is in turn?
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
                    sendPlayerData();
                    try{
                        playerInTurn.sendMessageToPlayer("PrintConsole", attackMsg);
                    }catch (IOException e){
                        e.printStackTrace();
                    }

                }
                else{
                    sendPlayerData();
                    try{
                        playerInTurn.sendMessageToPlayer("PrintConsole", "Weapon already used");
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }

            }
            else{
                sendPlayerData();
                try{
                    playerInTurn.sendMessageToPlayer("PrintConsole", "Weapon does not exist");
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        else{
            sendPlayerData();
            try{
                playerInTurn.sendMessageToPlayer("PrintConsole", "Character does not exist");
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void endGame() {
    }

    public static void sendPlayerData(){
        try {
            if(Game.getInstance().players[1]!=null){
                Game.getInstance().players[0].getObjectOutput().writeObject(Game.getInstance().players[0].getData());
                Game.getInstance().players[1].getObjectOutput().writeObject(Game.getInstance().players[1].getData());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public String reloadWeapons(String characterName){
        Character character = playerInTurn.getCharacter(characterName);
        boolean canReload = true;
        for (Weapon weapon:character.getWeapons()){
            if(weapon.getEnabled())
                canReload = false;
        }
        if (canReload) {
            character.reloadWeapons();
            return playerInTurn.getId() + " reloaded weapons";
        }
        else {
            return  "Available weapons";
        }
    }

    public void wildCard(String[] args){//Si se reciben dos armas o si s reciben dos character
            if(args.length == 3)
                doubleWeapon(args[0],args[1],args[2]);
            else
                doubleAttack(args[0],args[1],args[2],args[3]);
    }

    public String selectPlayer(){//Creo que es un command propio del cliente o hay que seleccionar para atacar?
        return "";
    }

    public void passTurn(){
        String msg = playerInTurn.getId() + " passed turn";
        nextTurn();
        try{
            playerInTurn.sendMessageToPlayer("PrintConsole", msg);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getRank() {
        return this.playerLoader.getRank();
    }


}


