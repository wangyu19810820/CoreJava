package chapter06;

import java.util.Arrays;

public class EmployeeSortTest {

    public static void main(String[] args) {
        var staff = new Employee[3];
        staff[0] = new Employee("Harry Hacker", 35000);
        staff[1] = new Employee("Carl Cracker", 75000);
        staff[2] = new Employee("Tony Tester", 38000);
        // 禁止比较父类子类，抛异常
        // staff[2] = new Manager("Tony Tester", 38000);

        Arrays.sort(staff);
        for (Employee e : staff) {
            System.out.println(e);
        }

        Comparable e = new Employee("aa", 10000);
        System.out.println(staff[2] instanceof Comparable);
    }
}
