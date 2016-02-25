package Task005.Game;

import Task005.Game.Checker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.Queue;

import static java.awt.Font.PLAIN;
import static java.lang.Math.abs;

/**
 * Created by Рустам on 19.11.2015.
 */
public class Checkers extends JFrame {
    int size;
    JButton[][] buttons;
    Checker[][] checker;
    final int buttonSize = 50;
    int myCheckers;
    int yourCheckers;
    JButton highlightedButton = new JButton();
    JButton actionButton = new JButton();
    Queue<JButton> queue = new LinkedList<>();
    ImageIcon[] image = new ImageIcon[5];
    Queue<Checker> result;
    Queue<Checker> input;
    Checker check;
    volatile boolean isJump;
    volatile boolean strokeLimit;
    JLabel jLabel;
    volatile int how_checkers = 0;

    public void setJump(boolean jump) {
        isJump = jump;
    }

    public void setStrokeLimit(boolean strokeLimit) {
        this.strokeLimit = strokeLimit;
    }

    public boolean isStrokeLimit() {
        return strokeLimit;
    }

    public boolean isJump() {
        return isJump;
    }

    public Checkers(final int size, final int myChekers, final int yourCheckers) {
        this.size = size;
        this.myCheckers = myChekers;
        this.yourCheckers = yourCheckers;
        this.buttons = new JButton[size][size];
        this.checker = new Checker[size][size];
        this.result = new LinkedList<>();
        createImage();
        setTitle("Checkers");
        setBounds(50, 50, buttonSize * (size + 4), buttonSize * size + buttonSize * 3 / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(new GroupLayout(getContentPane()));
        final JLabel jLabel = new JLabel();
        jLabel.setBounds(size * buttonSize, size * buttonSize / 7 * 3, buttonSize * 10, buttonSize);
        jLabel.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel.setFont(new Font("Arial", PLAIN, 24));
        jLabel.setForeground(Color.RED);
        String string = "Ход соперника";
        if (!strokeLimit) {
            string = "Ваш ход";
            jLabel.setForeground(Color.GREEN);
        }
        jLabel.setText(string);
        add(jLabel);
        this.jLabel = jLabel;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                final JButton jb = new JButton();
                if ((i + j) % 2 == 1) {
                    jb.setBackground(Color.WHITE);
                    jb.setEnabled(false);
                } else {
                    jb.setBackground(new Color(101, 67, 33));
                    if (i > size / 2) {
                        jb.setIcon(image[myChekers]);
                        checker[i][j] = new Checker(myChekers);
                    } else {
                        if (i < size / 2 - 1) {
                            jb.setIcon(image[yourCheckers]);
                            checker[i][j] = new Checker(yourCheckers);
                        } else
                            checker[i][j] = new Checker(0);
                    }
                    buttons[i][j] = jb;
                    jb.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (!strokeLimit) {
                                JButton jb = (JButton) e.getSource();
                                int j = (jb.getX() / buttonSize);
                                int i = (jb.getY() / buttonSize);
                                actionButton.setBackground(new Color(101, 67, 33));
                                setJump(i, j, jb);
                                if (!strokeLimit) {
                                    actionButton = jb;
                                    actionButton.setBackground(Color.ORANGE);
                                    if (checker[i][j].getColor() == myChekers) {
                                        if (!checker[i][j].isQueen()) {
                                            if (!isJump) {
                                                highlightChecker(i, j, -1, 1);
                                                highlightChecker(i, j, -1, -1);
                                            } else {
                                                capturedChecker(i, j, -1, 1);
                                                capturedChecker(i, j, -1, -1);
                                            }
                                            capturedChecker(i, j, 1, 1);
                                            capturedChecker(i, j, 1, -1);
                                        } else {
                                            captureQueen(i, j, 1, 1, isJump);
                                            captureQueen(i, j, 1, -1, isJump);
                                            captureQueen(i, j, -1, 1, isJump);
                                            captureQueen(i, j, -1, -1, isJump);
                                        }
                                    }
                                }
                                if (queue.size() == 0 && isJump) {
                                    strokeLimit = true;
                                }
                                if (strokeLimit) {
                                    jLabel.setText("ход соперника");
                                    jLabel.setForeground(Color.RED);
                                }
                            }
                        }
                    });
                }
                jb.setBounds(j * buttonSize, i * buttonSize, buttonSize, buttonSize);
                add(jb);
            }
        }
        setVisible(true);
    }

    public void setJump(int i, int j, JButton jb) {
        while ((highlightedButton = queue.poll()) != null) {
            if (jb == highlightedButton) {
                int x = (actionButton.getY() / buttonSize);
                int y = (actionButton.getX() / buttonSize);
                checker[i][j].setColor(checker[x][y].getColor());
                checker[i][j].setImage(checker[x][y].getImage());
                if (i == 0) {
                    checker[i][j].setQueen();
                }
                checker[x][y].setX(x);
                checker[x][y].setY(y);
                actionButton.setIcon(image[0]);
                checker[x][y].setColor(0);
                result.add(checker[x][y]);
                jb.setIcon(image[checker[i][j].getImage()]);
                if (abs(x - i) > 1 && abs(y - j) > 1) {
                    int i1 = (x - i) / abs(x - i);
                    int j1 = (y - j) / abs(y - j);
                    openButton(x, y, i, j, i1, j1);
                } else {
                    strokeLimit = true;
                }
                isJump = true;
                checker[i][j].setX(i);
                checker[i][j].setY(j);
                result.add(checker[i][j]);
            }
            highlightedButton.setBackground(new Color(101, 67, 33));
        }
    }


    public void openButton(int x, int y, int i, int j, int i1, int j1) {
        boolean f = true;
        while (i != (x - i1)) {
            i += i1;
            j += j1;
            if (checker[i][j].getColor() == yourCheckers) {
                checker[i][j].setX(i);
                checker[i][j].setY(j);
                result.add(checker[i][j]);
                how_checkers = how_checkers + 1;
                f = false;
            }
            buttons[i][j].setIcon(image[0]);
            checker[i][j].setColor(0);
        }
        strokeLimit = f;

    }

    public void captureQueen(int i, int j, int k, int n, boolean f1) {
        if (i + k > -1 && j + n > -1 && i + k < size && j + n < size) {
            int i1 = i;
            int j1 = j;
            Queue<JButton> queue1 = new LinkedList<>();
            boolean b = true;
            boolean b1 = true;
            boolean f = false;
            while (i1 + k > -1 && j1 + n > -1 && i1 + k < size && j1 + n < size &&
                    !(checker[i1 + k][j1 + n].getColor() == myCheckers) && (b | b1)) {
                if (checker[i1 + k][j1 + n].getColor() == 0) {
                    queue1.add(buttons[i1 + k][j1 + n]);
                    b = true;
                    if (checker[i1][j1].getColor() == yourCheckers)
                        f = true;
                } else if (checker[i1 + k][j1 + n].getColor() == yourCheckers) {
                    b1 = b & b1;
                    b = false;
                }
                i1 += k;
                j1 += n;
            }

            if (!f1 || f) {
                while ((highlightedButton = queue1.poll()) != null) {
                    highlightedButton.setBackground(Color.ORANGE);
                    queue.add(highlightedButton);
                }
            }
        }
    }

    public void highlightChecker(int i, int j, int k, int n) {
        if (i + k < size && j + n < size && i + k > -1 && j + n > -1) {
            if (checker[i + k][j + n].getColor() == 0) {
                buttons[i + k][j + n].setBackground(Color.ORANGE);
                queue.add(buttons[i + k][j + n]);
            } else {
                capturedChecker(i, j, k, n);
            }
        }
    }

    public void capturedChecker(int i, int j, int k, int n) {
        if (i + 2 * k < size && j + 2 * n < size && i + 2 * k > -1 && j + 2 * n > -1 &&
                checker[i + k][j + n].getColor() == yourCheckers) {
            k *= 2;
            n *= 2;
            if (checker[i + k][j + n].getColor() == 0) {
                buttons[i + k][j + n].setBackground(Color.ORANGE);
                queue.add(buttons[i + k][j + n]);
            }
        }
    }

    public void createImage() {
        image[0] = null;
        image[1] = setIcon(new ImageIcon("image/black.png"), buttonSize);
        image[2] = setIcon(new ImageIcon("image/white.png"), buttonSize);
        image[3] = setIcon(new ImageIcon("image/Qblack.png"), buttonSize);
        image[4] = setIcon(new ImageIcon("image/Qwhite.png"), buttonSize);
    }

    public ImageIcon setIcon(ImageIcon icon, int size) {
        Image img = icon.getImage().getScaledInstance(size * 4 / 5, size * 4 / 5, Image.SCALE_SMOOTH);
        icon = new ImageIcon(img);
        return icon;
    }

    public ImageIcon[] getImage() {
        return image;
    }

    public Queue<JButton> getQueue() {
        return queue;
    }
}
