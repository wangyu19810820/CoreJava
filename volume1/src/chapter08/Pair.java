package chapter08;

import java.util.function.Supplier;

public class Pair<T> {
    private T first;
    private T second;

    public Pair() {
        first = null;
        second = null;
    }

    public Pair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public static <T> Pair<T> makePair(Supplier<T> supplier) {
        Pair<T> pair = new Pair<>();
        // 不能直接实例化类型参数
//        pair.first = new T();
//        T[] ts = new T[2];

        pair.first = supplier.get();
        pair.second = supplier.get();
        return pair;
    }

    //  擦除泛型类型后，和Object中的equals冲突流
//    public boolean equals(T obj) {
//        return obj.equlas(first) && obj.equals(second);
//    }

    public T getFirst() {
        return first;
    }

    public T getSecond() {
        return second;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public void setSecond(T second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "[first=" + first + ",second=" + second + "]";
    }
}
