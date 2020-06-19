package chapter11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CheckBoxTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new CheckBoxFrame();
            frame.setTitle("CheckBoxTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class CheckBoxFrame extends JFrame {
    private JLabel label;
    private JCheckBox bold;
    private JCheckBox italic;
    private static final int FONTSIZE = 24;

    public CheckBoxFrame() {
        label = new JLabel("The quick brown for jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.BOLD, FONTSIZE));
        add(label, BorderLayout.CENTER);

        ActionListener listener = e -> {
            int mode = 0;
            if (bold.isSelected()) {
                mode += Font.BOLD;
            }
            if (italic.isSelected()) {
                mode += Font.ITALIC;
            }
            label.setFont(new Font("Serif", mode, FONTSIZE));
        };

        var buttonPanel = new JPanel();
        bold = new JCheckBox("Bold");
        bold.addActionListener(listener);
        bold.setSelected(true);
        buttonPanel.add(bold);

        italic = new JCheckBox("Italic");
        italic.addActionListener(listener);
        buttonPanel.add(italic);

        add(buttonPanel, BorderLayout.SOUTH);
        pack();
    }
}
