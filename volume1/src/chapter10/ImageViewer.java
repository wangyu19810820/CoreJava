package chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.prefs.Preferences;

public class ImageViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewerFrame();
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageViewerFrame extends JFrame {
    private String image;

    public ImageViewerFrame() {
        Preferences root = Preferences.userRoot();
        Preferences node = root.node("/com/corejava/ImageViewer");
        
        int left = node.getInt("left", 0);
        int top = node.getInt("top", 0);
        int width = node.getInt("width", 300);
        int height = node.getInt("height", 200);
        setBounds(left, top, width, height);
        image = node.get("image", null);
        var label = new JLabel();
        if (image != null) {
            label.setIcon(new ImageIcon(image));
        }

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                node.putInt("left", getX());
                node.putInt("top", getY());
                node.putInt("width", getWidth());
                node.putInt("height", getHeight());
                node.put("image", image);
            }
        });

        add(label);

        var chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("."));

        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        var menu = new JMenu("File");
        menuBar.add(menu);

        var openItem = new JMenuItem("Open");
        menu.add(openItem);
        openItem.addActionListener(e -> {
            int result = chooser.showOpenDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                image = chooser.getSelectedFile().getPath();
                label.setIcon(new ImageIcon(image));
            }
        });
    }
}
