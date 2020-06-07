package chapter05;

public class ManagerTest {

    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        Manager manager = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        manager.setBonus(5000);
        employees[0] = manager;

        employees[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        employees[2] = new Employee("Tommy Tester", 40000, 1990, 3, 15);

        for(Employee e: employees) {
            System.out.println(e);
        }

        manager.printOtherHireDay(new Manager("wangyu", 8000, 1999, 1, 1));
        System.out.println(manager.equals(employees[1]));
        Manager manager1 = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        manager1.setBonus(5000);
        System.out.println(manager.equals(manager1));
        System.out.println(manager.hashCode());
        System.out.println(manager1.hashCode());
        System.out.println(manager);
    }
}
