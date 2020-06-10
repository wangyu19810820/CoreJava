package chapter07;

import java.util.Random;
import java.util.logging.Logger;

public class LoggingProxy {

    public static void main(String[] args) {
        var random = new Random() {
            @Override
            public double nextDouble() {
                double result = super.nextDouble();
                Logger.getGlobal().info("nextDouble:" + result);
                Thread.dumpStack();
                return result;
            }
        };
        System.out.println(random.nextDouble());
    }
}
