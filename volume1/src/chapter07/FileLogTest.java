package chapter07;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileLogTest {

    public static void main(String[] args) throws IOException {
        FileHandler fh = new FileHandler("%h/myapp.log");
        fh.setLevel(Level.ALL);
        Logger.getGlobal().addHandler(fh);
        Logger.getGlobal().setLevel(Level.ALL);
        Logger.getGlobal().info("File -> Open menu item selected");
    }
}
