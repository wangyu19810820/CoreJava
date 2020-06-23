package chapter11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DataExchangeTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            var frame = new DataExchangeFrame();
            frame.setTitle("DataExchangeTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class DataExchangeFrame extends JFrame {
    private PasswordChooser dialog = null;
    private JTextArea textArea;

    public DataExchangeFrame() {
        var mbar = new JMenuBar();
        setJMenuBar(mbar);
        var fileMenu = new JMenu("File");
        mbar.add(fileMenu);

        var connectItem = new JMenuItem("Connect");
        connectItem.addActionListener(new ConnectAction());
        fileMenu.add(connectItem);

        var exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));
        fileMenu.add(exitItem);

        textArea = new JTextArea(20, 40);
        add(new JScrollPane(textArea), BorderLayout.CENTER);
        pack();
    }

    private class ConnectAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (dialog == null) dialog = new PasswordChooser();
            dialog.setUser(new User("yourname", null));
            if (dialog.showDialog(DataExchangeFrame.this, "Connect")) {
                User u = dialog.getUser();
                textArea.append("user name = " + u.getName() + ",password = " + u.getPassword() + "\n");
            }
        }
    }
}

class User {
    private String name;
    private String password;

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

class PasswordChooser extends JPanel {
    private JTextField username;
    private JPasswordField password;
    private JButton okButton;
    private boolean ok;
    private JDialog dialog;

    public PasswordChooser() {
        setLayout(new BorderLayout());

        var panel = new JPanel();
        panel.setLayout(new GridLayout(2, 2));
        panel.add(new JLabel("User name:"));
        panel.add(username = new JTextField(""));
        panel.add(new JLabel("Password"));
        panel.add(password = new JPasswordField(""));
        add(panel, BorderLayout.CENTER);

        okButton = new JButton("OK");
        okButton.addActionListener(e -> {
            ok = true;
            dialog.setVisible(false);
        });

        var cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> dialog.setVisible(false));

        var buttonPanel = new JPanel();
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    public void setUser(User u) {
        username.setText(u.getName());
    }

    public User getUser() {
        return new User(username.getText(), new String(password.getPassword()));
    }

    public boolean showDialog(Component parent, String title) {
        ok = false;
        Frame owner = null;
        if (parent instanceof Frame) {
            owner = (Frame) parent;
        } else {
            owner = (Frame) SwingUtilities.getAncestorOfClass(Frame.class, parent);
        }
        if (dialog == null || dialog.getOwner() != owner) {
            dialog = new JDialog(owner, true);
            dialog.add(this);
            dialog.getRootPane().setDefaultButton(okButton);
            dialog.pack();
        }
        dialog.setTitle(title);
        dialog.setVisible(true);
        return ok;
    }
}