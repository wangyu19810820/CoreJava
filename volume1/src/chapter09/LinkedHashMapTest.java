package chapter09;

import java.util.Iterator;
import java.util.LinkedHashMap;

public class LinkedHashMapTest {

    public static void main(String[] args) {
        var staff = new LinkedHashMap<String, Employee>();
        staff.put("144-25-5464", new Employee("Amy Lee"));
        staff.put("567-24-2546", new Employee("Mary Hacker"));
        staff.put("157-62-7935", new Employee("Gary Cooper"));
        staff.put("456-62-5527", new Employee("France Cruz"));

        Iterator<String> iterator1 = staff.keySet().iterator();
        while(iterator1.hasNext()) {
            String key = iterator1.next();
            System.out.println("key=" + key + ",value=" + staff.get(key));
        }
    }
}
