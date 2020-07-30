package ServerApp;

import Messaging.IMessage;
import ServerApp.CommandManager.CommandManager;
import ServerApp.CommandManager.CommandUtil;
import ServerApp.CommandManager.Commands.ICommand;
import messaging.GenericMessage;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Arrays;

public class Listener extends Thread {

    private final Socket client;
    private final Server server;
    private boolean killSwitch = false;
    private final CommandManager commandManager = CommandManager.getInstance();

    public Listener(Socket client, Server server) {
        this.client = client;
        this.server = server;
    }


    @Override
    public void run() {
        while(!killSwitch){
            try{
                
                IMessage message = (IMessage) new ObjectInputStream(new BufferedInputStream(client.getInputStream())).readObject();

                String commandName = message.getKey();
                String[] commandArgs = ((GenericMessage) message).getParams();

                ICommand command = commandManager.getCommand(commandName);
                command.execute(commandArgs);
                

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    public void kill(){
        this.killSwitch = true;
    }
}
