package chapter06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;

public class InnerClassTest {

    public static void main(String[] args) {
        var talkingClock = new TalkingClock(1000, true);
        // TalkingClock.TimePrinter1 timePrinter1 = talkingClock.new TimePrinter1();
        talkingClock.start();
        JOptionPane.showMessageDialog(null, "退出程序");
        System.exit(0);
    }
}

class TalkingClock {
    private int interval;
    private boolean beep;

    public TalkingClock(int interval, boolean beep) {
        this.interval = interval;
        this.beep = beep;
    }

    public void start() {
        var timer = new Timer(interval, this.new TimePrinter1());
        timer.start();
    }

    public class TimePrinter1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("the time is " + Instant.ofEpochMilli(e.getWhen()));
            if (TalkingClock.this.beep) {
                Toolkit.getDefaultToolkit().beep();
            }
        }

        // 内部类的静态字段必须是final的
        private static final int i = 0;

        // 内部类不能有静态方法
        // public static void demo1() {}
    }
}
