package chapter11;

import javax.swing.*;
import java.awt.*;

public class TextComponentTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new TextComponentFrame();
            frame.setTitle("TextComponentTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class TextComponentFrame extends JFrame {
    public TextComponentFrame() {
        var textField = new JTextField();
        var passwordField = new JPasswordField();
        var northPanel = new JPanel();
        northPanel.setLayout(new GridLayout(2, 2));
        northPanel.add(new JLabel("User name:", SwingConstants.RIGHT));
        northPanel.add(textField);
        northPanel.add(new JLabel("Password:", JLabel.RIGHT));
        northPanel.add(passwordField);
        add(northPanel, BorderLayout.NORTH);

        var textArea = new JTextArea(8, 20);
        var scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        var southPanel = new JPanel();
        var insertButton = new JButton("Insert");
        southPanel.add(insertButton);
        insertButton.addActionListener(e -> {textArea.append("User name:" + textField.getText()
                + " Password:" + new String(passwordField.getPassword()) + "\n");
            textField.setText("");
            passwordField.setText("");
        });
        add(southPanel, BorderLayout.SOUTH);
        pack();
    }
}