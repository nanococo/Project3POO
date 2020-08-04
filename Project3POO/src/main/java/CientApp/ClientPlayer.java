/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CientApp;

import CientApp.Client;
import GUI.MainWindow;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Fernando Alvarez
 */
public class ClientPlayer implements KeyListener {
    
    Client client;
    MainWindow playerWindow;
    String id;

    public ClientPlayer(String id) {
        this.playerWindow = new MainWindow(this);
        this.id = id;
        client = new Client(playerWindow);
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
