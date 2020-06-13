package chapter09;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        var staff = new HashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Mary Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("France Cruz"));

        // print all entries
        System.out.println(staff);

        staff.remove("567-24-2546");
        staff.put("456-62-5527", new Employee("France Miller"));
        System.out.println(staff.get("157-62-7935"));
        staff.forEach((k, v) -> System.out.println("key=" + k + ",value=" + v));
    }

    public static void test2() {
        String[] strArr = "aaa bbb ccc aaa bbb".split(" ");
        Map<String, Integer> map = new HashMap<>();
        // map.getOrDefault(str, 0) 取key为str的值，如果没有，默认为0
//        for(var str : strArr) {
//            map.put(str, map.getOrDefault(str, 0) + 1);
//        }
//        for(var key : map.keySet()) {
//            System.out.println("key=" + key + ",value=" + map.get(key));
//        }

        // map.putIfAbsent(str, 0); map中没有str键的值，设置其值为0
//        for(var str : strArr) {
//            map.putIfAbsent(str, 0);
//            map.put(str, map.get(str) + 1);
//        }
//        for(Map.Entry<String, Integer> entry : map.entrySet()) {
//            System.out.println("key=" + entry.getKey() + ",value=" + entry.getValue());
//        }

        // map.merge(str, 1, Integer::sum); map中没有str键的值，赋值为1。如果有str键的值，1和这个值相加，再赋值
        for(var str : strArr) {
            map.merge(str, 1, Integer::sum);
        }
        map.forEach((k, v) -> System.out.println("key=" + k + ",value=" + v));
        for(var integer : map.values()) {
            System.out.println(integer);
        }
    }
}
