package CientApp.clientCommands;

import GUIPackage.MainWindow;

@FunctionalInterface
public interface IClientCommand {
    void execute(String[] args, MainWindow mainWindow);
}
