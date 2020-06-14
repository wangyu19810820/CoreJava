package chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class ColorTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ColorFrame();
            frame.setTitle("Color Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ColorFrame extends JFrame {
    public ColorFrame() {
        var component = new ColorComponent();
        component.setBackground(Color.WHITE);   // 设置背景色，无效果
        System.out.println(component.getBackground());  // 得到背景色
        component.setForeground(Color.RED);     // 设置前景色
        add(component);
        pack();
    }
}

class ColorComponent extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        g2.drawString("Hello World", 10, 20);

        Rectangle2D rect = new Rectangle2D.Double(20, 40, 100, 100);
        g2.setPaint(Color.blue);    // 设置颜色
        g2.fill(rect);              // 填充矩形

        Ellipse2D circle = new Ellipse2D.Double(20, 200, 100, 100);
        g2.setPaint(new Color(0, 255, 255));    // 设置颜色
        g2.fill(circle);                                 // 填充圆形
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400, 400);
    }
}
