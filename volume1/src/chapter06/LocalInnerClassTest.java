package chapter06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class LocalInnerClassTest {

    public static void main(String[] args) {
        var talkingClock = new TalkingClock1();
        talkingClock.start(1000, false);
        JOptionPane.showMessageDialog(null, "退出程序");
        System.exit(0);
    }
}

class TalkingClock1 {
    public void start(int interval, boolean beep) {
        class TimePrinter1 implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("the time is " + Instant.ofEpochMilli(e.getWhen()));
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        }
        // 局部内部类捕获的变量必须是事实最终变量
        // beep = true;
        var timer = new Timer(interval, new TimePrinter1());
        timer.start();
    }
}
