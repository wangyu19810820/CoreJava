package chapter03;

import java.util.Arrays;

public class ArgsDemo {

    public static void main(String[] args) {
        if (args.length <= 0) {
            return;
        }
        if (args[0].equals("-h")) {
            System.out.print("hello,");
        } else if (args[0].equals("-g")) {
            System.out.print("goodbye,");
        }
        for (int i = 1; i < args.length; i++) {
            System.out.print(" " + args[i]);
        }
        System.out.println();
    }
}
