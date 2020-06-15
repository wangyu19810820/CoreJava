package chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class FontTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new FontFrame();
            frame.setTitle("FontTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class FontFrame extends JFrame {
    public FontFrame() {
        add(new FontComponent());
        pack();
    }
}

class FontComponent extends JComponent {
    @Override
    protected void paintComponent(Graphics g) {
        var g2 = (Graphics2D)g;
        var messaage = "Hello, World!";
        var f = new Font("Serif", Font.BOLD, 36);
        g2.setFont(f);

        // 获取字符串矩形的范围
        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = f.getStringBounds(messaage, context);

        double x = (getWidth() - bounds.getWidth()) / 2;
        double y = (getHeight() - bounds.getHeight()) / 2;
        double ascent = -bounds.getY();     // 获取上坡度
        double baseY = y + ascent;

        g2.drawString(messaage, (int)x, (int)baseY);

        g2.setPaint(Color.LIGHT_GRAY);
        g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));
        var rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
        g2.draw(rect);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }
}
