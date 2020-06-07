package chapter06;

public interface MethodInterface1 {

    void print2();

    default void print3() {
        System.out.println("MethodInterface1 print3");
    }
}
