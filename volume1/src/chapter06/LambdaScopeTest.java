package chapter06;

import javax.swing.*;
import java.awt.*;

public class LambdaScopeTest {

    public void repeatMessage(String text, int delay) {
        // 与lambda内的变量重名
        // String e = "";
        var timer = new Timer(delay, e -> {
            System.out.println(this.toString() + " " + text);
            Toolkit.getDefaultToolkit().beep();
            // lambda捕获的外围变量，必须是事实最终变量
            // delay = 2000;
        });
        timer.start();
        // lambda捕获的外围变量，必须是事实最终变量
        // text = "OO";
    }

    public static void main(String[] args) {
        new LambdaScopeTest().repeatMessage("OK", 1000);
        JOptionPane.showMessageDialog(null, "Quit program");
        System.exit(0);
    }
}
