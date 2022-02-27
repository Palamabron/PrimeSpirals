package spiral;

import java.awt.*;

public class PolarCoord {
    private static final int WIDTH = 1200;
    public static int drawPoint(Graphics g2d) {
        g2d.setColor(Color.white);
        g2d.drawLine(0, 0, WIDTH/4, WIDTH/4);
        g2d.drawLine(0, 1, WIDTH/2, WIDTH/2);
        g2d.drawLine(50, 100, WIDTH/2, WIDTH/2);
        g2d.dispose();
        return 0;
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
