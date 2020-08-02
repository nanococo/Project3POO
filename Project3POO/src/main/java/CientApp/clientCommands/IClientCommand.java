package CientApp.clientCommands;

import GUI.MainWindow;

@FunctionalInterface
public interface IClientCommand {
    void execute(String[] args, MainWindow mainWindow);
}
