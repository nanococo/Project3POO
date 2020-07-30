package ServerApp.CommandManager.Commands;

@FunctionalInterface
public interface ICommand {
    void execute(String[] args);
}
