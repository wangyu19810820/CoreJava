package chapter09;

import java.util.*;

public class ViewTest {

    public static void main(String[] args) {
        test5();
    }

    // of和nCopies方法返回的集合
    private static void test1() {
        // 最多20个参数
        var map = Map.of("Tom", 1, "Jerry", 2, "Allen", 3, "aa", 4,
                "bb", 5, "cc", 6, "dd", 7, "ee", 8, "ff", 9,
                "gg", 10);
        System.out.println(map);

        var map1 = Map.ofEntries(Map.entry("aaa", 1), Map.entry("bbb", 2));
        System.out.println(map1);

        // of和ofEntries返回的是不可更改的集合
//        map1.put("aaa", 3);

        var map2 = new HashMap<String, Integer>(Map.ofEntries(Map.entry("aaa", 1), Map.entry("bbb", 2)));
        map2.put("aaa", 3);
        System.out.println(map2);

        List<String> list = Arrays.asList("aa", "bb", "cc");
        list.set(1, "dd");
        System.out.println(list);
        // Arrays.asList出来的集合，只能set不能add和remove
//        list.add("ee");
//        list.remove(0);

        Item item = new Item("aa", 1);
        List<Item> list1 = Collections.nCopies(3, item);
        System.out.println(list1);
        System.out.println(list1.get(0) == list1.get(2));
    }

    // 子视图
    private static void test2() {
        List<String> list = new ArrayList<>(List.of("aa", "bb", "cc"));
        List<String> list1 = list.subList(0, 2);    // 返回索引0和1的值，索引2不包括在子列表中
        System.out.println(list1);
        list1.clear();      // 清空子列表，影响原始列表
        System.out.println(list);

        SortedSet<String> set = new TreeSet<>(Set.of("bb", "aa", "cc"));
        SortedSet<String> set1 = set.subSet("aa", "cc");    // 子集
        System.out.println(set1);
        SortedSet<String> set2 = set.headSet("cc");         // 从头到某某的子集
        System.out.println(set2);
        SortedSet<String> set3 = set.tailSet("bb");
        System.out.println(set3);

        SortedMap<String, Integer> map = new TreeMap<>(Map.of("bb", 2, "aa", 1, "cc", 3));
        SortedMap<String, Integer> map1 = map.subMap("aa", "cc");   // 子映射
        System.out.println(map1);
        SortedMap<String, Integer> map2 = map.headMap("cc");
        System.out.println(map2);
        SortedMap<String, Integer> map3 = map.tailMap("bb");
        System.out.println(map3);
    }

    // 只读视图
    private static void test3() {
        List<String> list1 = new ArrayList<>(List.of("aa", "bb", "cc"));
        list1.add("dd");
        List<String> list2 = Collections.unmodifiableList(list1);
        System.out.println(list2);
        // 只读视图不可修改
//        list2.set(1, "ee");
        List<String> list3 = new ArrayList<>(List.of("aa", "bb", "cc", "dd"));
        System.out.println(list2.equals(list3));    // 比较内容是否相同

        Collection collection1 = Collections.unmodifiableCollection(list1);
        Collection collection2 = Collections.unmodifiableCollection(list1);
        System.out.println(collection1.equals(collection2));    // 比较内存地址是否相同
    }

    // 同步视图
    private static void test4() {
        HashMap<String, Integer> map = new HashMap<>(Map.ofEntries(Map.entry("aa", 1), Map.entry("bb", 2)));
        Map<String, Integer> map1 = Collections.synchronizedMap(map);
        System.out.println(map1);
    }

    // 检查型视图
    private static void test5() {
        List<String> list = new ArrayList<>(List.of("aa", "bb"));
        List rawList = list;
        rawList.add(new Date());    // 不抛异常
        List<String> safeList = Collections.checkedList(list, String.class);
        rawList = safeList;
        // 抛异常
//        rawList.add(new Date());
    }
}
