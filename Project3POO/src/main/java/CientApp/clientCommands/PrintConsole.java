package CientApp.clientCommands;

import GUI.MainWindow;

public class PrintConsole extends BaseClientCommand {

    public static final String NAME = "PrintConsole";


    @Override
    public void execute(String[] args, MainWindow mainWindow) {
        if(args.length<=0) return;

        write(mainWindow, args[0]);
    }
}
