package chapter05;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class ResourceTest {
    public static void main(String[] args) throws IOException {
        Class cl = ResourceTest.class;
        URL imgUrl = cl.getResource("2.png");
        var icon = new ImageIcon(imgUrl);

        InputStream is1 = cl.getResourceAsStream("data/a.txt");
        var about = new String(is1.readAllBytes(), "UTF-8");

        InputStream is2 = cl.getResourceAsStream("/chapter05/data/b.txt");
        var title = new String(is2.readAllBytes(), StandardCharsets.UTF_8).trim();

        JOptionPane.showMessageDialog(null, about, title,
                JOptionPane.INFORMATION_MESSAGE, icon);
    }
}
