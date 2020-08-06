package CientApp.clientCommands;

import GUIPackage.MainWindow;

public class SelectPlayer extends BaseClientCommand {
    public static final String NAME = "selectplayer";

    @Override
    public void execute(String[] args, MainWindow mainWindow) {
        mainWindow.selectCharacter(args[0]);
    }
}
