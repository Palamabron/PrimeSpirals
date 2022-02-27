package spiral;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Write integer: ");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if(input % 2 == 0) {
            SpiralFrame sf = new SpiralFrame();
            sf.drawPoints();
        }
        else {
            new SFrame(1420, 320);
        }
    }
}
