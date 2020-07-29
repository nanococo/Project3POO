/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractMessagingSystem;

import CientApp.Client;
import GUI.MainWindow;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Fernando Alvarez
 */
public class TestPlayer implements KeyListener {
    
    Client client;
    MainWindow playerWindow;

    public TestPlayer() {
        this.playerWindow = new MainWindow(this);
        client = new Client("127.0.0.1",5000,playerWindow,playerWindow,playerWindow);
        playerWindow.setVisible(true);
    }
    
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("TESTPLAYER");
            client.sendMessage();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
