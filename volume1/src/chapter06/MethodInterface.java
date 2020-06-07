package chapter06;

public interface MethodInterface {

    private boolean isEmpty() {
        return false;
    }

    private static boolean isEmpty1() {
        return false;
    }

    static void print1() {
        System.out.println(isEmpty1());
    }

    default void print() {
        System.out.println(isEmpty());
    }

    default void print2() {
        System.out.println("MethodInterface print2");
    }

    default void print3() {
        System.out.println("MethodInterface print3");
    }
}
