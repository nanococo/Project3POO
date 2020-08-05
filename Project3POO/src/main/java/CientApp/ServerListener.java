package CientApp;

import CientApp.clientCommands.ClientCommandManager;
import GUI.MainWindow;
import Messaging.IMessage;
import ServerApp.Game.PlayerData;
import messaging.GenericMessage;

import java.io.BufferedInputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class ServerListener extends Thread {

    private final Client client;
    private final Socket socket;
    private final MainWindow mainWindow;
    private boolean killSwitch = false;
    private final ClientCommandManager clientCommandManager = ClientCommandManager.getInstance();

    public ServerListener(Socket socket, Client client, MainWindow mainWindow){
        this.client = client;
        this.socket = socket;
        this.mainWindow = mainWindow;
    }


    @Override
    public void run() {
        while (!killSwitch){
            try{
                IMessage message = (IMessage) new ObjectInputStream(new BufferedInputStream(socket.getInputStream())).readObject();

                String key = message.getKey();

                if(key.equals("PlayerData")){
                    PlayerData playerData = ((PlayerData) message);
                    //////


                } else {
                    String[] commandArgs = ((GenericMessage) message).getParams();
                    ClientCommandManager.getInstance().executeOperation(commandArgs, mainWindow, clientCommandManager.getCommand(message.getKey()));
                }

            }catch(Exception e) {
                kill();
                client.closeClient();
                break;
            }
        }
    }

    public void kill(){
        this.killSwitch = true;
    }
}
