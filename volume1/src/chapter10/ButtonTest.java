package chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ButtonFrame extends JFrame{
    private JPanel buttonPanel;

    public ButtonFrame() {
        setSize(300, 200);

        var yellowButton = new JButton("Yellow");
        var blueButton = new JButton("Blue");
        var redButton = new JButton("Red");

        buttonPanel = new JPanel();
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        add(buttonPanel);

        // 添加事件
        yellowButton.addActionListener(new ColorAction(Color.YELLOW));
        blueButton.addActionListener(new ColorAction(Color.BLUE));
        redButton.addActionListener(e -> buttonPanel.setBackground(Color.RED));     // 简洁写法
    }

    private class ColorAction implements ActionListener {
        private Color backgroundColor;

        public ColorAction(Color c) {
            backgroundColor = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            buttonPanel.setBackground(backgroundColor);
        }
    }
}