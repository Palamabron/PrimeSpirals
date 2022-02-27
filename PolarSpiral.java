package spiral;

import java.awt.*;
import javax.swing.*;

public class PolarSpiral extends JPanel{
    private int WIDTH, ZOOM;
    public PolarSpiral(int WIDTH, int ZOOM) {
        this.WIDTH = WIDTH;
        this.ZOOM = ZOOM;
    }

    public void paint(Graphics g){
        g.setColor(Color.cyan);
        double x, y;
        int x1, y1;
//        Graphics2D g2d = (Graphics2D) this.getGraphics();
//        g2d.setColor(Color.cyan);
        final int WIDTH = this.WIDTH;
        final int ZOOM = this.ZOOM;
        double j;
        for (int i = 2; i < WIDTH*ZOOM; i++) {
            if (isPrime(i)) {
                j = (double) i / ZOOM;
                x = j * Math.cos(j) + (double) WIDTH / 2;
                y = j * Math.sin(j) + (double) WIDTH / 2;
//                if (x > WIDTH) System.out.println("x za duzie" + x);
//                if (y > WIDTH) System.out.println("y za duzie" + y);
                x1 = (int) Math.round(x);
                y1 = (int) Math.round(y);
                g.drawLine(x1, y1, x1, y1);
            }
        }
//        g2d.drawLine(0, 0, WIDTH, WIDTH);
    }
    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
class SFrame extends JFrame {
    private int WIDTH, ZOOM;
    public SFrame(int WIDTH, int ZOOM) {
//        this.ZOOM = ZOOM;
//        this.WIDTH = WIDTH;
//        spiralPanel = new Test();
//        spiralPanel.setSize(WIDTH, WIDTH);
//        spiralPanel.setPreferredSize(new Dimension(WIDTH, WIDTH));
        setBackground(Color.black);

        getContentPane().add(new PolarSpiral(WIDTH, ZOOM));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, WIDTH));
        setPreferredSize(new Dimension(WIDTH, WIDTH));
        pack();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        setVisible(true);
    }
}
