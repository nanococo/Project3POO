package ServerApp;

import Messaging.IMessage;
import ServerApp.CommandManager.CommandManager;
import ServerApp.CommandManager.Commands.ICommand;
import ServerApp.GamePackage.Player;
import messaging.GenericMessage;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Listener extends Thread {

    private final Player player;
    private boolean killSwitch = false;
    private final CommandManager commandManager = CommandManager.getInstance();

    public Listener(Player player) {
        this.player = player;
    }


    @Override
    public void run() {
        while(!killSwitch){

            try{

                IMessage message = (IMessage) player.getInputStream().readObject();

                String commandName = message.getKey();
                String[] commandArgs = ((GenericMessage) message).getParams();

                ICommand command = commandManager.getCommand(commandName);
                command.execute(commandArgs);
                

            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public void kill(){
        this.killSwitch = true;
    }
}
