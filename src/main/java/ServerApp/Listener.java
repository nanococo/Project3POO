package ServerApp;

import ServerApp.CommandManager.CommandManager;
import ServerApp.CommandManager.CommandUtil;
import ServerApp.CommandManager.Commands.ICommand;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.net.Socket;
import java.util.Arrays;

public class Listener extends Thread {

    private final CommandManager commandManager = CommandManager.getInstance();
    private final Socket client;
    private final Server server;
    private boolean killSwitch = false;

    public Listener(Socket client, Server server){
        this.client = client;
        this.server = server;
    }


    @Override
    public void run() {
        while(true){
            try{
                String line = new DataInputStream(new BufferedInputStream(client.getInputStream())).readUTF();

                if (line.trim().length() == 0) {
                    continue;
                }
                String[] commands = CommandUtil.tokenizerArgs(line);
                String commandName = commands[0];
                String[] commandArgs = null;

                if (commands.length > 1) {
                    commandArgs = Arrays.copyOfRange(commands, 1, commands.length);
                }

                ICommand command = commandManager.getCommand(commandName);
                command.execute(commandArgs);


//                if(line.equals("Exit")){
//                    client.close();
//                    System.out.println("Client Exited");
//                    break;
//                } else if(line.equals("End")){
//                    server.endServer();
//                    System.out.println("Server Shut Down");
//                    break;
//                } else if(line.equals("Time")){
//
//                }

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void kill(){
        this.killSwitch = true;
    }
}
