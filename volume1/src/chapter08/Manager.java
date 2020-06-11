package chapter08;

public class Manager extends Employee {

    private double bonus;

    public Manager(String name) {
        super(name);
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "name=" + getName() +
                "bonus=" + bonus +
                '}';
    }
}
