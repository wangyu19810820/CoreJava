package chapter05;

import java.util.ArrayList;

public class ArrayListTest {

    // @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList<Employee> staff = new ArrayList<>(3);
        var staff1 = new ArrayList<Employee>();
        staff.ensureCapacity(3);    // 分配数组大小

        Employee employee1 = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff.add(employee1);   // 添加元素
        Employee employee2 = new Employee("wang yu", 85000, 1990, 12, 20);
        staff.set(0, employee2);    // 设置元素

        Employee employee3 = staff.get(0);  // 得到元素
        staff.add(new Employee("aa", 10000, 1991, 2, 12));

        Employee employee4 = new Employee("wang yu", 85000, 1990, 12, 20);
        staff.remove(employee4);    // 删除元素,通过equals确认是该元素需被删除
        staff.trimToSize();         // 调整容量
        System.out.println(staff.size());

        // 遍历数组列表
        for (Employee employee : staff) {
            System.out.println(employee);
        }

        // 类型化的数组列表，传递给非类型化的数组列表
        update(staff);
        // 非类型的数组列表，传递给数组列表，会有警告
        @SuppressWarnings("unchecked")
        ArrayList<Employee> staff2 = (ArrayList<Employee>) getAll();
    }


    private static void update(ArrayList list) {
    }

    private static ArrayList getAll() {
        return new ArrayList();
    }
}
