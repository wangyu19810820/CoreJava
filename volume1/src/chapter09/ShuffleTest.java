package chapter09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShuffleTest {
    public static void main(String[] args) {
        var number = new ArrayList<Integer>();
        for (int i = 1; i <= 20; i++) {
            number.add(i);
        }
        // 打乱列表内的数据
        Collections.shuffle(number);
        System.out.println(number);

        // 获取子列表，并对子列表排序
        List<Integer> subList = number.subList(0, 6);
        Collections.sort(subList);
        System.out.println(subList);
        System.out.println(number);
    }
}
