import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameBoard extends JFrame {
    backPanel panel;
    JButton player1Button, player2Button;
    JLabel rightNow;
    String[] names;
    int[] wins = new int[]{0, 0};

    public GameBoard() {
        super();
        names = new String[2];
        for (int i = 0; i < 2; i++) {
            names[i] = JOptionPane.showInputDialog(this, "player " + (i + 1) + " name : ");
        }
        setTitle("Snake-N-Ladder");
        setSize(415, 450);
        setLocationByPlatform(true);
        gameOn();

    }

    private void gameOn() {
        panel = new backPanel(new ImageIcon("ankit.jpg").getImage());

        this.add(panel, BorderLayout.CENTER);

        player1Button = new JButton(names[0] + " Roll");
        player1Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (play(1)) {
                    player2Button.setEnabled(true);
                    player1Button.setEnabled(false);
                }
            }
        });
        player2Button = new JButton(names[1] + " Roll");
        player2Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (play(2)) {
                    player1Button.setEnabled(true);
                    player2Button.setEnabled(false);
                }
            }
        });
        player2Button.setEnabled(false);

        rightNow = new JLabel("Start " + names[0]);

        JPanel bottom = new JPanel();
        bottom.add(player1Button);
        bottom.add(player2Button);
        bottom.add(rightNow);
        JButton usageButton = new JButton("usage stats");
        usageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Usage Stats: \n" + names[0] + " : " + wins[0] + '\n' + names[1] + " : " + wins[1]);
            }
        });
        bottom.add(usageButton);
        this.add(bottom, BorderLayout.SOUTH);
    }

    private boolean play(int a) {
        boolean ab = true;
        Random random = new Random();
        int step = random.nextInt(6);
        step++;
        switch (panel.movePlayer(a, step)) {
            case 0: {
                this.rightNow.setText("Rolled " + step);
                break;
            }
            case 1: {
                this.rightNow.setText("Excellent! Moved " + step);
                break;
            }
            case 2: {
                this.rightNow.setText("Bite! Moved " + step);
                break;
            }
            case 3: {
                wins[a - 1]++;
                this.rightNow.setText(names[a-1] + " Wins!");
                this.player1Button.setEnabled(false);
                this.player2Button.setEnabled(false);
                ab = false;
                break;
            }
            default:
                break;
        }
        panel.repaint();
        return ab;
    }
}
