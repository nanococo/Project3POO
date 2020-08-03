package CientApp.clientCommands;

import CientApp.GlobalConfigurations;
import GUI.MainWindow;

public class SetClientID extends BaseClientCommand {

    public static final String NAME = "SetClientID";

    @Override
    public void execute(String[] args, MainWindow mainWindow) {
        System.out.println("Here");
        if(GlobalConfigurations.getInstance().getClientID()!=null) return;
        if(args.length<=0) return;

        GlobalConfigurations.getInstance().setClientID(args[0]);
        write(mainWindow, "Server set your ID as: "+args[0]);
    }

}
