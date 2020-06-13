package chapter05;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {
    private final String name;
    private double salary;
    protected LocalDate hireDate;

    public Employee(String n) {
        name = n;
    }

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

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) {
            return true;
        }
        if (otherObject == null) {
            return false;
        }
        if (getClass() != otherObject.getClass()) {
            return false;
        }

        Employee other = (Employee) otherObject;

        return Objects.equals(getName(), other.getName())
                && getSalary() == other.getSalary()
                && Objects.equals(getHireDate(), other.getHireDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSalary(), getHireDate());
//        return 7 * Objects.hashCode(getName())
//                + 11 * Objects.hashCode(getSalary())
//                + 13 * Objects.hashCode(getHireDate());
    }

    @Override
    public String toString() {
        return getClass().getName() + "[name=" + name + ",salary=" + salary + ",hireDay="
                + hireDate + "]";
    }

}
