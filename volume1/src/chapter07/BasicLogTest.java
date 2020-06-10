package chapter07;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BasicLogTest {

    private static final Logger myLogger1 = Logger.getLogger("chapter07");
    private static final Logger myLogger2 = Logger.getLogger("chapter07.BasicLogTest");

    public static void main(String[] args) {
        // 关闭日志
        // Logger.getGlobal().setLevel(Level.OFF);
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.ALL);
        // Logger.getGlobal().addHandler(ch);
        Logger.getGlobal().setLevel(Level.ALL);
        Logger.getGlobal().config("File -> Open menu item selected");

//        myLogger1.setLevel(Level.WARNING);
//        myLogger1.setUseParentHandlers(false);  // 禁用父处理器
//        myLogger1.addHandler(ch);
//        myLogger1.log(Level.WARNING, "myLogger1 warning");
//        myLogger2.info("myLogger2.info");
//        myLogger2.logp(Level.WARNING, "chapter07.BasicLogTest1", "main2", "myLogger2.logp");
//
//
//        myLogger1.setLevel(Level.FINER);
//        read("input.txt", "abc");

//        var e = new IOException("can not read file");
//        myLogger1.log(Level.FINE, "抛异常", e);
//        myLogger1.throwing("chapter07.BasicLogTest4", "main4", e);
    }

    public static int read(String file, String pattern) {
        myLogger1.entering("chapter07.BasicLogTest2", "read2", new Object[]{file, pattern});

        var count = 10;
        myLogger1.exiting("chapter07.BasicLogTest3", "read3", count);
        return count;
    }
}
