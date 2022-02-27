package spiral;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PrimeFinder {
    private ArrayList<Integer> primes;
    private JPanel spiralPanel;

    public PrimeFinder(JPanel spiralPanel) {
        this.primes = new ArrayList<>();
        this.primes.add(2);
        this.spiralPanel = spiralPanel;
    }

    public ArrayList<Integer> getPrimes() {
        return primes;
    }

    public void addPrime(int prime) {
        this.primes.add(prime);
    }

    public void calculatePrimes() {
        int n = this.primes.get(this.primes.size() - 1);
        boolean isPrime = true;
        for (int i = 2; i <= 100_000; i++) {
            if (isPrime(i)) {
                this.primes.add(i);
            }
        }
    }

    public static boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static Boolean[][] genUlam(int n, Graphics2D g2d){
        return genUlam(n, 2, g2d);
    }

    public static Boolean[][] genUlam(int n, int i, Graphics2D g2d) {
        Boolean[][] spiral = new Boolean[n][n];
        SpiralFrame.Direction dir = SpiralFrame.Direction.RIGHT;
        g2d.setColor(Color.cyan);
        int j = i;
        int y = n / 2;
        int x = (n % 2 == 0) ? y - 1 : y; //shift left for even n's
        while(j <= (n * n) + 2){
            spiral[y][x] = isPrime(j);
            if (spiral[y][x])   g2d.drawLine(x, y, x, y);

            switch(dir){
                case RIGHT:
                    if(x <= (n - 1) && spiral[y - 1][x] == null && j > i) {
                        dir = SpiralFrame.Direction.UP;
                    }
                    break;
                case UP:
                    if(spiral[y][x - 1] == null) {
                        dir = SpiralFrame.Direction.LEFT;
                    }
                    break;
                case LEFT:
                    if(x == 0 || spiral[y + 1][x] == null) {
                        dir = SpiralFrame.Direction.DOWN;
                    }
                    break;
                case DOWN:
                    if(spiral[y][x + 1] == null) {
                        dir = SpiralFrame.Direction.RIGHT;
                    }
                    break;
            }

            switch (dir) {
                case RIGHT -> x++;
                case UP -> y--;
                case LEFT -> x--;
                case DOWN -> y++;
            }
            j++;
        }
        return spiral;
    }



}
