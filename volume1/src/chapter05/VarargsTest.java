package chapter05;

import java.util.Arrays;

public class VarargsTest {

    public static void main(String[] args) {
        method1(1, 2, 3);
        method1(new int[]{1, 2, 3});
    }

    private static void method1(int... args) {
        System.out.println(args[0]);
    }
}
