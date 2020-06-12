package chapter09;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

    public static void main(String[] args) {
        // 按Item的compareTo来排序，具体是先partNumber，后description排序
        var treeSet1 = new TreeSet<Item>();
        treeSet1.add(new Item("Toaster", 4562));
        treeSet1.add(new Item("Widget", 1234));
        treeSet1.add(new Item("Modem", 9912));
        System.out.println(treeSet1);

        // 按自定义排序器来排序，具体是Item的描述来排序
        var treeSet2 = new TreeSet<Item>(Comparator.comparing(Item::getDescription));
        treeSet2.addAll(treeSet1);
        System.out.println(treeSet2);
    }
}
