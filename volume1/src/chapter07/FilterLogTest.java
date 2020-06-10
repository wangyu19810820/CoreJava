package chapter07;

import java.util.logging.*;

public class FilterLogTest {

    public static void main(String[] args) {
        ConsoleHandler ch = new ConsoleHandler();
        ch.setFilter(new FileFilter());
        ch.setLevel(Level.INFO);

        Logger.getGlobal().setUseParentHandlers(false);
        Logger.getGlobal().addHandler(ch);
        Logger.getGlobal().setFilter(new FileFilter1());
        Logger.getGlobal().info("hi");
        Logger.getGlobal().info("good bye");
        Logger.getGlobal().info("good morning, everyone");
    }
}

class FileFilter implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        var msg = record.getMessage();
        return msg.startsWith("good");
    }
}

class FileFilter1 implements Filter {

    @Override
    public boolean isLoggable(LogRecord record) {
        var msg = record.getMessage();
        return msg.startsWith("good morning");
    }
}
