package chapter04;

import java.time.LocalDate;

/**
 * 雇员类，可以设置<ul><li>用户名</li><li>薪水</li><li>雇用日期</li></ul>
 * {@code Employee} can set username, <strong>salary</strong>,<em>hire date</em>.
 * {@link chapter04.EmployeeTest#main(String[]) employee.main}
 * @author 汪昱
 * @version 1.0 2020-6-1
 * @since 1.8
 * @see chapter04.EmployeeTest#main(String[]) employee.main
 * @see <a href="http://www.sina.com">sina</a>
 * @see "Core Java"
 */
public class Employee {
    private final String name;
    private double salary;
    protected LocalDate hireDate;

    public Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        hireDate = LocalDate.of(year, month, day);
    }

    public CharSequence getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString() {
        return "version2, name=" + getName() + ",salary=" + getSalary() + ",hireDay=" + getHireDate();
    }
}
