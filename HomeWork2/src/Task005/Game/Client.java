package Task005.Game;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Рустам on 26.11.2015.
 */
public class Client {
    ObjectOutputStream os;
    ObjectInputStream is;
    Socket s;
    volatile boolean flag = true;

    public void connection(InetAddress ia) throws IOException {
        ConnectFrame connect = new ConnectFrame();
        connect.connect(ia);
        boolean f = false;
        s = null;
        while (!f) {
            s = connect.getSocket();
            f = (s != null);
        }
        Wait wait = new Wait();
        connect.dispose();
        this.os = new ObjectOutputStream(s.getOutputStream());
        this.is = new ObjectInputStream(s.getInputStream());
        wait.dispose();
    }

    public Client() throws IOException, ClassNotFoundException {
        new Client(null);
    }

    public Client(InetAddress ia) throws IOException, ClassNotFoundException {
        connection(ia);
        int i = (Integer) is.readObject();
        int j;
        if (i == 1)
            j = 2;
        else j = 1;
        Checkers checkers = new Checkers(8, i, j);
        newGame(checkers);
        while (flag) {
            if (checkers.strokeLimit) {
                send(checkers);
                input(checkers);
            }
        }
    }


    public void send(Checkers client) {
        try {
            os.reset();
            os.writeObject(client.result);
            os.reset();
            os.writeObject(client.how_checkers);
            client.result = new LinkedList<>();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void input(Checkers client) throws IOException {
        try {
            boolean b = (boolean) is.readObject();
            if (b) {
                client.input = (Queue) is.readObject();
                while ((client.check = client.input.poll()) != null) {
                    if (client.check.getColor() == client.myCheckers) {
                        client.checker[7 - client.check.getX()][7 - client.check.getY()].setColor(0);
                        client.buttons[7 - client.check.getX()]
                                [7 - client.check.getY()].setIcon(null);
                    } else {
                        client.checker[7 - client.check.getX()][7 - client.check.getY()] = client.check;
                        client.buttons[7 - client.check.getX()][7 - client.check.getY()].setIcon(client.image[client.check.getImage()]);
                    }
                }
                client.strokeLimit = false;
                client.isJump = false;
                client.jLabel.setForeground(Color.GREEN);
                setText(client, "Ваш ход");
                client.how_checkers = 0;
            } else {
                boolean isWin = (boolean) is.readObject();
                String string = "You lose!";
                if (isWin)
                    string = "You win!";
                message(client, string);
            }
        } catch (IOException e) {
            message(client, "No connection");
            flag = false;
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            client.dispose();
        }
    }

    private void setText(Checkers client, String string) {
        client.jLabel.setText(string);
    }

    private void message(Checkers client, String string) throws IOException {
        try {
            flag = false;
            if (JOptionPane.showConfirmDialog(null, string + "\nRestart game?", string,
                    JOptionPane.YES_NO_OPTION) == 0) {
                client.dispose();
                new Client(s.getInetAddress());
            } else {
                client.dispose();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void newGame(Checkers checkers) {
        try {
            checkers.strokeLimit = (boolean) is.readObject();
            checkers.isJump = false;
            String string = "Ход соперника";
            checkers.jLabel.setForeground(Color.RED);
            if (!checkers.strokeLimit) {
                string = "Ваш ход";
                checkers.jLabel.setForeground(Color.GREEN);
            }
            setText(checkers, string);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Client();
    }
}
