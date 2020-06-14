package chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class DrawTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class DrawFrame extends JFrame {
    public DrawFrame() {
        add(new DrawComponent());
        pack();
    }
}

class DrawComponent extends JComponent {
    private static final int DEFAULT_WIDTH = 400;
    private static final int DEFAULT_HEIGHT = 400;

    @Override
    public void paintComponent(Graphics g) {
        var g2 = (Graphics2D)g;
        double leftX = 100;
        double topY = 100;
        double width = 200;
        double height = 150;

        // 画一个矩形
        var rect = new Rectangle2D.Double(leftX, topY, width, height);
        g2.draw(rect);

        // 画一个椭圆
        var ellipse = new Ellipse2D.Double();
        ellipse.setFrame(rect);
        g2.draw(ellipse);

        // 画一条直线
//        g2.draw(new Line2D.Double(leftX, topY, leftX + width, topY + height));
        Point2D start = new Point2D.Double(leftX, topY);
        Point2D end = new Point2D.Double(leftX + width, topY + height);
        g2.draw(new Line2D.Double(start, end));

        double centerX = rect.getCenterX();
        double centerY = rect.getCenterY();
        double radius = 150;

        // 画一个圆
        var circle = new Ellipse2D.Double();
        circle.setFrameFromCenter(centerX, centerY, centerX + radius, centerY + radius);
        g2.draw(circle);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
