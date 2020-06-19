package chapter11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ToolBarTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ToolBarFrame();
            frame.setTitle("ToolBarTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ToolBarFrame extends JFrame {
    public ToolBarFrame() {
        setSize(600, 400);
        var toolbar = new JToolBar("ToolBar");

        var btn = new JButton("");
        btn.setIcon(new ImageIcon("src/chapter11/1.jpg"));
        btn.setToolTipText("Button1");
        toolbar.add(btn);

        toolbar.addSeparator();

        Action action = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        };
        action.putValue(Action.NAME, "Button2");
        action.putValue(Action.SMALL_ICON, new ImageIcon("src/chapter11/2.png"));
        action.putValue(Action.SHORT_DESCRIPTION, "Button2");
        toolbar.add(action);

        var btn1 = new JButton("");
        btn1.setIcon(new ImageIcon("src/chapter11/3.jpg"));
        btn1.setToolTipText("Button3");
        toolbar.add(btn1);

        add(toolbar, BorderLayout.NORTH);
    }
}
