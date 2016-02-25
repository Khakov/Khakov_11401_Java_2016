package Task005.Game;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Рустам on 09.11.2015.
 */
public class Connection implements Runnable, Serializable {
    Socket socket;
    Socket socket2;
    Thread thread;
    Server server;
    Queue<Checker> checkers = new LinkedList<>();
    int checker = 0;
    boolean isWin = false;

    public Connection(Server server, Socket socket, Socket socket2) {

        this.socket = socket;
        this.socket2 = socket2;
        this.server = server;
        thread = new Thread(this);
        thread.start();
    }

    public void run() {
        try {
            int player1 = 12;
            int player2 = 12;
            ObjectOutputStream oos1 = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois1 = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos2 = new ObjectOutputStream(socket2.getOutputStream());
            ObjectInputStream ois2 = new ObjectInputStream(socket2.getInputStream());
            oos1.writeObject(2);
            oos2.writeObject(1);
            oos1.reset();
            oos2.reset();
            oos1.writeObject(false);
            oos2.writeObject(true);
            ois2.readObject();
            ois2.readObject();
            boolean flag = true;
            while (flag) {
                if (!isWin) {
                    checkers = (Queue<Checker>) ois1.readObject();
                    checker = (int) ois1.readObject();
                    player2 -= checker;
                    isWin = (player2 < 1);
                } else {
                    flag = false;
                }
                if (flag) {
                    oos2.reset();
                    oos2.writeObject(!isWin);
                    oos2.reset();
                    if (!isWin) {
                        oos2.writeObject(checkers);
                        checkers = (Queue<Checker>) ois2.readObject();
                        checker = (int) ois2.readObject();
                        player1 -= checker;
                        isWin = (player1 < 1);
                    } else {
                        oos2.writeObject(player1 < 1);
                    }
                    oos1.reset();
                    oos1.writeObject(!isWin);
                    oos1.reset();
                    if (!isWin) {
                        oos1.writeObject(checkers);
                    } else
                        oos1.writeObject(player2 < 1);
                }
            }
        } catch (IOException e) {
            try {
                socket.close();
                socket2.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}