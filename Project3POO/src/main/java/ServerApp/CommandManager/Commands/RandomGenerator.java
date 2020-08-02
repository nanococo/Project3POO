package ServerApp.CommandManager.Commands;

import java.util.Random;

public class RandomGenerator {
    public static void main(String[] args) {
        Random random = new Random();

        int x = random.nextInt(2);

        switch (x){
            case 0:
                System.out.println("Jorge");
                break;
            case 1:
                System.out.println("Sebas");
                break;
        }
    }
}
