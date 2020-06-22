package chapter11;

import javax.swing.*;
import java.awt.*;

public class DialogTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            DialogFrame frame = new DialogFrame();
            frame.setTitle("DialogTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class DialogFrame extends JFrame {
    private AboutDialog dialog;

    public DialogFrame() {
        setSize(300, 200);
        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        var fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        var aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(e -> {
            if (dialog == null) {
                dialog = new AboutDialog(DialogFrame.this);
            }
            dialog.setVisible(true);
        });
        fileMenu.add(aboutItem);

        var exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);
    }
}

class AboutDialog extends JDialog {
    public AboutDialog(JFrame owner) {
        super(owner, "About DialogTest", true);
        add(new JLabel(
                "<html><H1><i>Core Java</i></H1><hr>By wangyu</html>"),
                BorderLayout.CENTER);
        var ok = new JButton("OK");
        ok.addActionListener(e -> setVisible(false));

        var panel = new JPanel();
        panel.add(ok);
        add(panel, BorderLayout.SOUTH);
        pack();
    }
}