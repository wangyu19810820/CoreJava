package chapter11;

import javax.swing.*;
import java.awt.*;

public class ComboBoxTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ComboBoxFrame();
            frame.setTitle("ComboBoxTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ComboBoxFrame extends JFrame {
    private JComboBox<String> faceCombo;
    private JLabel label;
    private static final int DEFAULT_SIZE = 24;

    public ComboBoxFrame() {
        label = new JLabel("The quick brown fox jumps over the lazy dog.");
        label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
        add(label, BorderLayout.CENTER);

        faceCombo = new JComboBox<>();
        faceCombo.addItem("Serif");
        faceCombo.addItem("SansSerif");
        faceCombo.addItem("Monospaced");
        faceCombo.addItem("Dialog");
        faceCombo.addItem("DialogInput");

        faceCombo.addActionListener(e -> {
            String fontName = faceCombo.getItemAt(faceCombo.getSelectedIndex());
            label.setFont(new Font(fontName, Font.PLAIN, DEFAULT_SIZE));
        });

        var comboPanel = new JPanel();
        comboPanel.add(faceCombo);
        add(comboPanel, BorderLayout.SOUTH);
        pack();
    }
}