package chapter06;

import java.time.LocalDate;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee>, Cloneable {
    private final String name;
    private double salary;
    protected Date hireDate;

    public Employee(String n, double s) {
        name = n;
        salary = s;
        hireDate = new Date();
    }

    public CharSequence getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDay(int year, int month, int day) {
        Date newHireDay = new GregorianCalendar(year, month - 1, day).getTime();
        hireDate.setTime(newHireDay.getTime());
    }

    public void raiseSalary(double byPercent) {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay="
                + hireDate + "]";
    }

    @Override
    public int compareTo(Employee other) {
        if (getClass() != other.getClass()) throw new ClassCastException();
        return Double.compare(salary, other.salary);
    }

    @Override
    protected Employee clone() throws CloneNotSupportedException {
        Employee employee = (Employee)super.clone();
        employee.hireDate = (Date)hireDate.clone();
        return employee;
    }
}
