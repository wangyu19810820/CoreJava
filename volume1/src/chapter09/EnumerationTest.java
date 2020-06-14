package chapter09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Set;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class EnumerationTest {

    private static Logger logger = Logger.getLogger("chapter09");

    public static void main(String[] args) {
        // Enumeration转换成ArrayList
        ArrayList<String> loggeNames = Collections.list(LogManager.getLogManager().getLoggerNames());
        System.out.println(loggeNames);

        // Enumeration转换成Iterator
        LogManager.getLogManager().getLoggerNames().asIterator().forEachRemaining(System.out::println);

        // 集合转成Enumeration
        Enumeration<String> enumeration = Collections.enumeration(Set.of("aa", "bb", "cc"));
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
