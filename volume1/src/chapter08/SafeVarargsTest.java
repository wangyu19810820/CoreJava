package chapter08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SafeVarargsTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        addAll(list, "aa", "bb");
        list.forEach(System.out::println);
    }

    // 此注解只能用于static，final，private方法。不用此注解，有一个警告
    @SafeVarargs
    public static <T> void addAll(Collection<T> col, T... ts) {
        for(T t : ts) {
            col.add(t);
        }
    }
}
