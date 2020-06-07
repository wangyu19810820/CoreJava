package chapter06;

public class Manager extends Employee {
    private double bonus;

    public Manager(String n, double s) {
        super(n, s);
        bonus = 0;
    }

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
    public String toString() {
        return super.toString() + "[bonus=" + bonus + "]";
    }

    @Override
    public int compareTo(Employee other) {
        if (getClass() != other.getClass()) throw new ClassCastException();
        return Double.compare(getSalary(), other.getSalary());
    }
}
