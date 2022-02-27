package spiral;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Objects;

public class SpiralFrame extends JFrame {
    private final int WIDTH = 1400;
    private JPanel spiralPanel;
//    private int x = WIDTH/2, y = WIDTH/2;

    enum Direction{
        RIGHT, UP, LEFT, DOWN;
    }

    public SpiralFrame() {

//        PrimeFinder primeFinder = new PrimeFinder(spiralPanel);
        spiralPanel = new JPanel();
        spiralPanel.setSize(WIDTH, WIDTH);
        spiralPanel.setPreferredSize(new Dimension(WIDTH, WIDTH));
        spiralPanel.setBackground(Color.black);

        add(spiralPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(WIDTH, WIDTH));
        setPreferredSize(new Dimension(WIDTH, WIDTH));
        pack();
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation(size.width/2 - getWidth()/2, size.height/2 - getHeight()/2);
        setVisible(true);
    }

    public void drawPoints() {
        Boolean[][] spiralArray = PrimeFinder.genUlam(WIDTH, (Graphics2D) this.getGraphics());
//        try
//        {
//            BufferedImage image = new BufferedImage(WIDTH, WIDTH, BufferedImage.TYPE_INT_RGB);
//            Graphics2D graphics2D = image.createGraphics();
//            this.paint(graphics2D);
//            ImageIO.write(image,"jpeg", new File("D:\\Programming\\spiral\\src\\dupa.jpeg"));
//        }
//        catch(Exception exception)
//        {
//            //code
//        }
        /*Graphics2D g2d = (Graphics2D) this.getGraphics();
        g2d.setColor(Color.white);
        for (int i = 0; i < spiralArray.length; i++) {
            for (int j = 0; j < spiralArray[i].length; j++) {
                if (Objects.equals(spiralArray[i][j], true)) {
                    g2d.drawLine(i, j, i, j);
                }
            }
        }*/
    }





}
