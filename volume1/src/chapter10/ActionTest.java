package chapter10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ActionTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(()->{
            var frame = new ActionFrame();
            frame.setTitle("ActionTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ActionFrame extends JFrame {
    private JPanel buttonPanel;

    public ActionFrame() {
        setSize(300, 200);

        var yellowAction = new ColorAction("Yellow", new ImageIcon("src/chapter10/1.jpg"), Color.YELLOW);
        var blueAction = new ColorAction("Blue", new ImageIcon("src/chapter10/2.png"), Color.BLUE);
        var redAction = new ColorAction("Red", new ImageIcon("src/chapter10/3.jpg"), Color.RED);

        var yellowButton = new JButton(yellowAction);
        var blueButton = new JButton(blueAction);
        var redButton = new JButton(redAction);

        buttonPanel = new JPanel();
        buttonPanel.add(yellowButton);
        buttonPanel.add(blueButton);
        buttonPanel.add(redButton);
        add(buttonPanel);

        KeyStroke bKey = KeyStroke.getKeyStroke("ctrl B");
        KeyStroke yKey = KeyStroke.getKeyStroke("ctrl Y");
        KeyStroke rKey = KeyStroke.getKeyStroke("ctrl R");

        InputMap imap = buttonPanel.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        imap.put(bKey, "panel.blue");
        imap.put(yKey, "panel.yellow");
        imap.put(rKey, "panel.red");

        ActionMap amap = buttonPanel.getActionMap();
        amap.put("panel.blue", blueAction);
        amap.put("panel.yellow", yellowAction);
        amap.put("panel.red", redAction);
    }

    class ColorAction extends AbstractAction {

        public ColorAction(String name, Icon icon, Color color) {
            putValue(Action.NAME, name);
            putValue(Action.SMALL_ICON, icon);
            putValue("color", color);
            putValue(Action.SHORT_DESCRIPTION, "Set panel color to " + name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Color c = (Color)getValue("color");
            buttonPanel.setBackground(c);
        }
    }
}

