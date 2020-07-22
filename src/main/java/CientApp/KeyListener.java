package CientApp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class KeyListener extends Thread {

    private final Client client;
    private boolean killSwitch = false;
    private final DataOutputStream outputStream;
    private Scanner scanner;

    public KeyListener(Socket socket, Client client) throws IOException {
        this.client = client;
        this.scanner = new Scanner(System.in);
        this.outputStream = new DataOutputStream(socket.getOutputStream());
    }

    @Override
    public void run() {
        while (!killSwitch){
            try{
                String line = scanner.nextLine();
                outputStream.writeUTF(line);
                if(line.equals("End")){
                    client.closeClient();
                }
            } catch (Exception e){
                client.closeClient();
                break;
            }
        }
    }

    public void kill(){
        this.killSwitch = true;
    }
}
