package chapter06;

import java.util.Arrays;
import java.util.Comparator;
import static java.util.Comparator.*;

public class ComparatorTest {

    public static void main(String[] args) {
        // 比较原始的Comparator
        String[] friends = {"Peter", "Paul", "Mary"};
        Arrays.sort(friends, new LengthComparator());
        System.out.println(Arrays.toString(friends));

        // 应用键提取器的Comparator
        Person1[] people = new Person1[3];
        people[0] = new Person1("aa", "xx", 18);
        people[1] = new Person1("b", null, 17);
        people[2] = new Person1("aa", "yy", 16);
        Arrays.sort(people, Comparator.comparing(Person1::getName)
                .thenComparing(Person1::getAge));
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, comparing(Person1::getName,
                (first, second) -> first.length() - second.length()));
        System.out.println(Arrays.toString(people));

        Arrays.sort(people, comparing(Person1::getMiddleName, nullsFirst(naturalOrder())));
        System.out.println(Arrays.toString(people));
    }
}

class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String first, String second) {
        return first.length() - second.length();
    }
}

class Person1 {
    private String name;
    private String middleName;
    private int age;

    Person1(String name, String middleName, int age) {
        this.name = name;
        this.middleName = middleName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getMiddleName() {
        return middleName;
    }

    @Override
    public String toString() {
        return "(name=" + name + ",middleName=" + middleName + ",age=" + age + ")";
    }
}