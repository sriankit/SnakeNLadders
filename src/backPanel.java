import javax.swing.*;
import java.awt.*;

class backPanel extends JPanel {

    private Image back;
    private int[] positions;

    public backPanel(Image img) {
        this.back = img;
        this.positions = new int[]{1,1};
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(back, 0, 0, null);
        int x0 = (int) (((positions[0] - 1) % 20 < 10) ? (5 + 35.6 * ((positions[0] - 1) % 20)) : (358 - (35.6 * (((positions[0] - 1) % 20) - 9))));
        int x1 = (int) (((positions[1] - 1) % 20 < 10) ? (5 + 35.6 * ((positions[1] - 1) % 20)) : (358 - (35.6 * (((positions[1] - 1) % 20) - 9))));
        int y0 = (int) (358 - (((positions[0] - 1) / 10 + 1) * 35.6));
        int y1 = (int) (358 - (((positions[1] - 1) / 10 + 1) * 35.6));
        System.out.println(positions[0] + " " + positions[1]);
        System.out.println(x0 + " " + y0 + " " + x1 + " " + y1);
        g.setColor(Color.BLUE);
        g.fillOval(x0, y0, 30, 30);
        g.setColor(Color.RED);
        g.fillOval(x1, y1, 30, 30);
    }

    int movePlayer(int a, int step) {
        this.positions[a - 1] = (this.positions[a - 1] + step) <= 100 ? this.positions[a - 1] + step : this.positions[a - 1];
        return check(a - 1);
    }

    private int check(int a) {
        switch(positions[a]) {
            case 4:
                positions[a] = 14;
                return 1;
            case 9:
                positions[a] = 31;
                return 1;
            case 20:
                positions[a] = 38;
                return 1;
            case 17:
                positions[a] = 7;
                return 2;
            case 28:
                positions[a] = 84;
                return 1;
            case 40:
                positions[a] = 59;
                return 1;
            case 51:
                positions[a] = 67;
                return 1;
            case 54:
                positions[a] = 34;
                return 2;
            case 62:
                positions[a] = 19;
                return 2;
            case 64:
                positions[a] = 60;
                return 2;
            case 71:
                positions[a] = 91;
                return 1;
            case 87:
                positions[a] = 24;
                return 2;
            case 93:
                positions[a] = 73;
                return 2;
            case 96:
                positions[a] = 75;
                return 2;
            case 99:
                positions[a] = 78;
                return 2;
            case 100:
                return 3;
            default:
                return 0;
        }
    }
}