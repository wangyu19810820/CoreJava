package chapter07;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LocalLogTest {

    private static Logger myLogger1 = Logger.getLogger("chapter07",
            "chapter07.logmessages_cn");

    public static void main(String[] args) {
        myLogger1.info("error1");
        myLogger1.log(Level.INFO, "error2", "aa");
        myLogger1.log(Level.INFO, "error2", new Object[]{"aa", "bb"});
    }
}
