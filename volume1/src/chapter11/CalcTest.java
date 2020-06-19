package chapter11;

import javax.swing.*;
import java.awt.*;

public class CalcTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new CalcFrame();
            frame.setTitle("CalcTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class CalcFrame extends JFrame {
    public CalcFrame() {
        setSize(300, 200);
        JLabel label = new JLabel("<html><body><b>0</b></body></html>", JLabel.CENTER);
        label.setFont(new Font("Serif", Font.PLAIN, 20));
        add(label, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);

        panel.add(new JButton("7"));
        panel.add(new JButton("8"));
        panel.add(new JButton("9"));
        panel.add(new JButton("/"));

        panel.add(new JButton("4"));
        panel.add(new JButton("5"));
        panel.add(new JButton("6"));
        panel.add(new JButton("*"));

        panel.add(new JButton("1"));
        panel.add(new JButton("2"));
        panel.add(new JButton("3"));
        panel.add(new JButton("-"));

        panel.add(new JButton("0"));
        panel.add(new JButton("."));
        panel.add(new JButton("="));
        panel.add(new JButton("+"));
    }
}
