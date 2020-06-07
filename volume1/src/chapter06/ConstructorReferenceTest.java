package chapter06;

import java.util.Arrays;
import java.util.List;

public class ConstructorReferenceTest {

    public static void main(String[] args) {
        List<String> names = List.of("aa", "bb");
        // 引用Person的构造器和数组的构造器
        Person[] people = names.stream().map(Person::new).toArray(Person[]::new);
        System.out.println(Arrays.toString(people));
    }
}

class Person {
    private String name;

    Person(String n) {
        name = n;
    }

    @Override
    public String toString() {
        return "(" + getClass().getName() + ",name=" + name + ")";
    }
}