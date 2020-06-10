package chapter07;

import java.util.logging.*;

public class FormatterLogTest {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("chapter07");
        ConsoleHandler ch = new ConsoleHandler();
        ch.setLevel(Level.FINE);
        ch.setFormatter(new MyFormatter());
        logger.setUseParentHandlers(false);
        logger.addHandler(ch);
        logger.info("hello");
    }
}

class MyFormatter extends Formatter {

    @Override
    public String format(LogRecord record) {
        return "hi," + record.getMessage();
    }

}
