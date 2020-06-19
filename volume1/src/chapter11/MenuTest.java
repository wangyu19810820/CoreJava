package chapter11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuTest {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new MenuFrame();
            frame.setTitle("MenuTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class MenuFrame extends JFrame {
    private static final int DEFAULT_WIDTH = 300;
    private static final int DEFAULT_HEIGHT = 200;
    private Action saveAction;
    private Action saveAsAction;
    private JCheckBoxMenuItem readonlyItem;
    private JPopupMenu popup;

    class TestAction extends AbstractAction {
        public TestAction(String name) {
            super(name);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(getValue(Action.NAME) + " selected.");
        }
    }

    public MenuFrame() {
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        var fileMenu = new JMenu("File");
        fileMenu.add(new TestAction("New"));

        var openItem = fileMenu.add(new TestAction("Open"));
        openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl O"));
        fileMenu.addSeparator();

        saveAction = new TestAction("Save");
        JMenuItem saveItem = fileMenu.add(saveAction);
        saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl S"));

        saveAsAction = new TestAction("Save As");
        fileMenu.add(saveAsAction);
        fileMenu.addSeparator();

        fileMenu.add(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        readonlyItem = new JCheckBoxMenuItem("Read only");
        readonlyItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean saveOk = !readonlyItem.isSelected();
                saveAction.setEnabled(saveOk);
                saveAsAction.setEnabled(saveOk);
            }
        });

        var group = new ButtonGroup();

        var insertItem = new JRadioButtonMenuItem("Insert");
        insertItem.setSelected(true);

        var overtypeItem = new JRadioButtonMenuItem("Overtype");

        group.add(insertItem);
        group.add(overtypeItem);

        var cutAction = new TestAction("Cut");
        cutAction.putValue(Action.SMALL_ICON, new ImageIcon("src/chapter11/1.jpg"));
        var copyAction = new TestAction("Copy");
        copyAction.putValue(Action.SMALL_ICON, new ImageIcon("src/chapter11/2.png"));
        var pasteAction = new TestAction("Paste");
        pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("src/chapter11/3.jpg"));

        var editMenu = new JMenu("Edit");
        editMenu.add(cutAction);
        editMenu.add(copyAction);
        editMenu.add(pasteAction);

        var optionMenu = new JMenu("Options");
        optionMenu.add(readonlyItem);
        optionMenu.addSeparator();
        optionMenu.add(insertItem);
        optionMenu.add(overtypeItem);

        editMenu.addSeparator();
        editMenu.add(optionMenu);

        var helpMenu = new JMenu("Help");
        helpMenu.setMnemonic('H');

        var indexItem = new JMenuItem("Index");
        indexItem.setMnemonic('I');
        indexItem.addActionListener(e -> System.out.println("Index"));
        helpMenu.add(indexItem);

        var aboutAction = new TestAction("About");
        aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
        helpMenu.add(aboutAction);

        var menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);

        popup = new JPopupMenu();
        popup.add(cutAction);
        popup.add(copyAction);
        popup.add(pasteAction);

        var panel = new JPanel();
        panel.setComponentPopupMenu(popup);
        add(panel);
    }
}