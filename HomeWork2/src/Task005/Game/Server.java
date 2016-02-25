package Task005.Game;

import javax.swing.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Рустам on 28.10.2015.
 */
public class Server  extends JFrame{
    final int PORT = 3456;
    JLabel serverLabel;
    JTextField serverName;
    ArrayList<Connection> connections;
    public Server() throws IOException {
        connections = new ArrayList<Connection>();
        go();
    }

    public void go() throws IOException {
        serverLabel = new JLabel();
        serverName = new JTextField();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ServerSocket s1 = new ServerSocket(PORT);
        setBounds(150,150,200,120);
        serverLabel.setText("Адрес сервера:");
        serverName.setText(InetAddress.getLocalHost() + "");
        serverName.setEditable(false);
        serverLabel.setBounds(5,5,100,40);
        serverName.setBounds(50,10,100,40);
        add(serverLabel);
        add(serverName);
        setVisible(true);
        while (true) {
            Socket client = s1.accept();
            Socket client2 = s1.accept();
            connections.add(new Connection(this, client, client2));
        }
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server();
    }
}
