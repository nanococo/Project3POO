package ServerApp.CommandManager;

public class CommandTest {
    public static void main(String[] args) {
        CommandManager commandManager = CommandManager.getInstance();

        commandManager.executeOperation(args, param -> System.out.println("Hello World"));
    }
}
