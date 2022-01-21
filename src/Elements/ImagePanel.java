package Elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel {
    private BufferedImage image;
    private int height;
    private int width;

    public ImagePanel(String src, int width, int height) {
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(new File(src));
        } catch (IOException ex) {
            // something
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, width, height, this);
    }
}
