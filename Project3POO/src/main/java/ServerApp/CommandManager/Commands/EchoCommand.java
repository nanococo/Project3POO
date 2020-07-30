package ServerApp.CommandManager.Commands;

public class EchoCommand implements ICommand {

    public static final String NAME = "echo";

    @Override
    public void execute(String[] args) {
        if(args.length<=0) return;

        System.out.println(args[0]);
    }

}
