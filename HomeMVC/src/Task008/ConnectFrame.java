package Task008;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by Рустам on 20.12.2015.
 */
public class ConnectFrame extends JFrame {
    private JTextField serverAddressText;
    volatile Socket socket;

    public Socket getSocket() {
        return socket;
    }


    public void connect(InetAddress ia) {
        setTitle("Checkers Form");
        JLabel serverAddress = new JLabel();
        serverAddressText = new JTextField();
        final JButton jb = new JButton();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        serverAddress.setText("Введите адрес сервера:");
        String string = "";
        if(ia!=null)
        string = ia.toString().substring(1);
        serverAddressText.setText(string);
        jb.setText("начать игру");
        setBounds(150,150,200,150);
        serverAddress.setBounds(5,5,150,40);
        serverAddressText.setBounds(10,50,150,20);
        jb.setBounds(10,70 ,150,30);
        add(serverAddress);
        add(serverAddressText);
        add(jb);
        setLayout(new GroupLayout(getContentPane()));
        setVisible(true);
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int port = 3456;
                    String host = serverAddressText.getText();
                    socket = new Socket(host, port);
                    jb.setEnabled(false);
                } catch (IOException e1) {
                    JOptionPane.showMessageDialog(null, "Сервер не найден!\n" + serverAddressText.getText());
                    dispose();
                    connect(null);
                }
            }
        });
    }
}
