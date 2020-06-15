package chapter10;

import javax.swing.*;
import java.awt.*;

public class ImageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var imageFrame = new ImageFrame();
            imageFrame.setTitle("ImageTest");
            imageFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            imageFrame.setVisible(true);
        });
    }
}

class ImageFrame extends JFrame {
    public ImageFrame() {
        add(new ImageComponent());
        pack();
    }
}

class ImageComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        Image image = new ImageIcon("src/chapter10/gif.jpg").getImage();
        g.drawImage(image, 0, 0, null);
        int imageWidth = image.getWidth(null);
        int imageHeight = image.getHeight(null);
        for (int i = 0; i * imageWidth <= getWidth(); i++) {
            for (int j = 0; j * imageHeight <= getHeight(); j++) {
                if (i + j > 0) {
                    g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
                }
            }
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}
