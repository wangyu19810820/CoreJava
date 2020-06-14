package chapter10;

import javax.swing.*;
import java.awt.*;

public class SimpleFrameTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new SimpleFrame();
            // 设置位置
            frame.setLocation(100, 100);
            // 设置位置和宽、高
            frame.setBounds(200, 200, 600, 400);

            // 获得和设置窗口的标题
            System.out.println("title:" + frame.getTitle());
            frame.setTitle("Hello World!");
            System.out.println("title:" + frame.getTitle());

            // 获取和设置窗口是否可以更改大小
            System.out.println("frame isResizable:" + frame.isResizable());
            frame.setResizable(false);
            System.out.println("frame isResizable:" + frame.isResizable());

            // 设置宽度和高度是屏幕的一半
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            frame.setSize(screenSize.width / 2, screenSize.height / 2);

            // 设置窗体图标
            Image img = new ImageIcon("src/chapter10/gif.jpg").getImage();
            frame.setIconImage(img);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class SimpleFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;

    public SimpleFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
