package chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowAdapterTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new WindowAdapterFrame();
            frame.setTitle("WindowAdapter");
            frame.setVisible(true);
            frame.addWindowListener(new Terminator());
        });
    }
}

class WindowAdapterFrame extends JFrame {
    public WindowAdapterFrame() {
        setSize(300, 200);
    }
}

class Terminator extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        System.out.println("OK");
        System.exit(0);
    }
}