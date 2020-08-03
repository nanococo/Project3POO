package ServerApp.Game;

public class Game {

    private static Game game;
    public Player[] players = new Player[2];

    private Game(){}


    public static Game getInstance(){
        if(game != null) return game;

        game = new Game();
        return game;
    }
}


