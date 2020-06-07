package chapter06;

public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        var original = new Employee("John public", 50000);
        original.setHireDay(1998, 3, 14);

        Employee clone = (Employee)original.clone();
        clone.setHireDay(2000, 1, 1);
        clone.raiseSalary(10);

        System.out.println(original);
        System.out.println(clone);
    }
}
