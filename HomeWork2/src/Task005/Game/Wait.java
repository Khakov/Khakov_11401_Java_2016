package Task005.Game;

import javax.swing.*;
import java.awt.*;

import static java.awt.Font.PLAIN;

/**
 * Created by Рустам on 05.12.2015.
 */
public class Wait extends JFrame {
    public Wait() {
        JLabel jl = new JLabel();
        setBounds(500, 250, 300, 150);
        setLayout(new GroupLayout(getContentPane()));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jl.setBounds(0, 0, 300, 150);
        jl.setText("Жду подключения");
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        jl.setFont(new Font("Arial", PLAIN, 24));
        add(jl);
        setVisible(true);

    }

    public void dispose() {
        super.dispose();
    }
}
