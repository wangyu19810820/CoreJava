package chapter06;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class AnonymousInnerClassTest {

    public static void main(String[] args) {
        var clock = new TalkingClock2();
        clock.start(1000, true);
        JOptionPane.showMessageDialog(null, "退出程序");
        
        // 双括号初始化，第一个花括号是内部类，第二个花括号是对象初始化块
        invite(new ArrayList<String>(){{add("aa"); add("bb");}});
        invite(List.of("xx", "yy", "zz"));

        // 获取类名
        String className = new Object(){}.getClass().getEnclosingClass().getName();
        System.out.println(className);

        System.exit(0);
    }

    public static void invite(List<String> list) {
        for (var s : list) {
            System.out.println(s);
        }
    }
}

class TalkingClock2 {
    public void start(int interval, boolean beep) {
        var timer = new Timer(interval, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("the time is " + Instant.ofEpochMilli(e.getWhen()));
                if (beep) {
                    Toolkit.getDefaultToolkit().beep();
                }
            }
        });
        timer.start();
    }
}
