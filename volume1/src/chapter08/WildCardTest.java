package chapter08;

public class WildCardTest {

    public static void main(String[] args) {
        var ceo = new Manager("john");
        var cfo = new Manager("smith");
        var managerBuddies = new Pair<Manager>(ceo, cfo);
        // Pair<Manager>可以赋值给Pair<? extends Employee>，也可以赋值给Pair<? super Boss>
        Pair<? extends Employee> wildcardBuddies = managerBuddies;
        Employee employee = wildcardBuddies.getFirst();
        // ? extends Employee的变量，可以赋值给Employee，但是不能接收Employee
        // wildcardBuddies.setFirst(new Employee("tom"));

        Pair<? super Boss> wildcardBuddies1 = managerBuddies;
        wildcardBuddies1.setFirst(new Boss("jerry"));
        // ? super Boss的变量，可以接收Boss，但不能赋值给Boss
        // Boss boss = wildcardBuddies1.getFirst();
        System.out.println(wildcardBuddies1);
    }
}
