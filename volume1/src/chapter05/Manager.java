package chapter05;

import java.util.Objects;

public class Manager extends Employee {
    private double bonus;

    public Manager(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
        bonus = 0;
    }

    // 能够访问其他Manager的protected字段
    public void printOtherHireDay(Manager manager) {
        System.out.println(manager.hireDate);
    }

    // 编译错误，不能查看Employee的protected字段
//    public void printOtherHireDay(Employee employee) {
//        System.out.println(employee.hireDate);
//    }

    public void setBonus(double b) {
        this.bonus = b;
    }

    @Override
    public String getName() {
        return (String) super.getName();
    }

    @Override
    public double getSalary() {
        return super.getSalary() + bonus;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (!super.equals(otherObject)) return false;
        var other = (Manager) otherObject;
        return bonus == other.bonus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bonus);
    }

    @Override
    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }
}
