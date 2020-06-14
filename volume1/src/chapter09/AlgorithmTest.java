package chapter09;

import java.util.*;

public class AlgorithmTest {

    public static void main(String[] args) {
        test4();
    }

    // 两分法搜索
    public static void test1() {
        List<Item> list = new ArrayList<>();
        list.add(new Item("abc", 1));
        list.add(new Item("xyz", 2));
        list.add(new Item("efg", 3));
        list.sort(Comparator.comparing(Item::getDescription));
        list.sort(Comparator.comparingInt(Item::getPartNumber).reversed());
        Collections.sort(list);
        list.forEach(System.out::println);
//        int index = Collections.binarySearch(list, new Item("hij", 4),
//                Comparator.comparingInt(Item::getPartNumber).reversed());
        // 没有查找到，返回负数
        int index = Collections.binarySearch(list, new Item("hij", 4));
        System.out.println(index);

        // 在-index - 1处插入未找到的数据，可以保持列表的排序正确
        list.add(-index - 1, new Item("hij", 4));
        list.forEach(System.out::println);
    }

    // 一组算法
    public static void test2() {
        List<Item> list = new ArrayList<>();
        list.add(new Item("abc", 1));
        list.add(new Item("xyz", 2));
        list.add(new Item("efg", 3));
        // 最小值
        Item item = Collections.min(list);
        System.out.println(item);
        // 最大值
        item = Collections.max(list);
        System.out.println(item);

        // 拷贝列表内的数据到新列表
        LinkedList<Object> newList = new LinkedList<>(Arrays.asList(new Object[list.size()]));
        Collections.copy(newList, list);
        System.out.println(newList);

        // 用一个值填充列表
        LinkedList<Object> newList1 = new LinkedList<>(Arrays.asList(null, null, null));
        Collections.fill(newList1, new Item("abc", 1));
        System.out.println(newList1);
        System.out.println(newList1.get(0) == newList1.get(1));

        // 添加一组数据到列表内
        LinkedList<Object> newList2 = new LinkedList<>();
        Collections.addAll(newList2, new Item("abc", 1), new Item("xyz", 2));
        System.out.println(newList2);

        // 替换
        Collections.replaceAll(list, new Item("abc", 1), new Item("abc", 2));
        System.out.println(list);

        // 子列表在主列表的位置索引
        int index = Collections.indexOfSubList(list, List.of(new Item("xyz", 2),
                new Item("efg", 3)));
        System.out.println(index);

        // 子列表在主列表的最后位置索引
        int index1 = Collections.lastIndexOfSubList(list, List.of(new Item("xyz", 2),
                new Item("efg", 3)));
        System.out.println(index);

        // 交换指定位置的两个元素
        Collections.swap(list, 1, 2);
        System.out.println(list);

        // 颠倒列表内元素的顺序
        Collections.reverse(list);
        System.out.println(list);

        // 旋转列表内的元素到指定间隔的位置
        Collections.rotate(list, 2);
        System.out.println(list);

        // 返回集合内与指定元素相等的元素个数
        int count = Collections.frequency(list, new Item("xyz", 2));
        System.out.println(count);

        // 两个集合内，是否没有相同的元素
        Set<Item> set = Set.of(new Item("xyz", 2));
        boolean flag = Collections.disjoint(list, set);
        System.out.println(flag);
    }

    // 批操作
    public static void test3() {
        List<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list1.add(i);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int i = 10; i < 30; i++) {
            set2.add(i);
        }

        // 移除set2内的元素
//        list1.removeAll(set2);

        // 保留set2内的元素，移除其他元素
        list1.retainAll(set2);
        System.out.println(list1);

        // 在map上的keySet集合移除元素，会影响到原始map的数据
        Map<Integer, String> map = new HashMap<>(Map.of(1, "aa", 10, "bb",
                20, "cc", 30, "dd"));
        map.keySet().removeAll(set2);
        System.out.println(map);

        // 清除子列表的数据，会影响到原始列表
        list1.subList(0, 5).clear();
        System.out.println(list1);
    }

    // 数组和集合的互换
    public static void test4() {
        String[] values = {"aa", "bb", "cc"};
        Set<String> set = new HashSet<>(List.of(values));
        System.out.println(set);

//        String[] result = set.toArray(new String[0]);
        String[] result = set.toArray(new String[set.size()]);
        System.out.println(Arrays.toString(result));
    }
}
