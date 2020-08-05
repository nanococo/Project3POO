package CientApp;

import CientApp.clientCommands.ClientCommandManager;
import GUIPackage.MainWindow;
import Messaging.IMessage;
import MessagingPackage.GenericMessage;
import ServerApp.GamePackage.PlayerData;

public class ServerListener extends Thread {

    private final Client client;
    private final MainWindow mainWindow;
    private boolean killSwitch = false;
    private final ClientCommandManager clientCommandManager = ClientCommandManager.getInstance();

    public ServerListener(Client client, MainWindow mainWindow){
        this.client = client;
        this.mainWindow = mainWindow;
    }


    @Override
    public void run() {
        while (!killSwitch){
            try{
                IMessage message = (IMessage) GlobalConfigurations.getObjectInputStream().readObject();

                String key = message.getKey();

                if(key.equals("PlayerData")){
                    PlayerData playerData = ((PlayerData) message);


                } else {
                    String[] commandArgs = ((GenericMessage) message).getParams();
                    ClientCommandManager.getInstance().executeOperation(commandArgs, mainWindow, clientCommandManager.getCommand(message.getKey()));
                }

            }catch(Exception e) {
                e.printStackTrace();
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
