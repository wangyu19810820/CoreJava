package chapter06;

import java.util.function.IntConsumer;

public class HandleLambdaTest {

    public static void repeat(int n, Runnable action) {
        for(var i = 0; i < n; i++) {
            action.run();
        }
    }

    public static void repeat(int n, MyIntConsume action) {
        for(var i = 0; i < n; i++) {
            action.handle(i);
        }
    }

    public static void main(String[] args) {
        repeat(3, () -> System.out.println("OK"));
        repeat(10, i -> System.out.println(9 - i));
    }
}
