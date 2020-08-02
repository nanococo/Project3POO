package CientApp.clientCommands;

import GUI.MainWindow;

public abstract class BaseClientCommand implements IClientCommand {

    public void write(MainWindow mainWindow, String string){
        mainWindow.write(string);
    }
}
