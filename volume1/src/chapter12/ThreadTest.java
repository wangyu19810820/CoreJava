package chapter12;

public class ThreadTest {

    public static final int DELAY = 10;
    public static final int STEPS = 100;
    public static final double MAX_AMOUNT = 1000;

    public static void main(String[] args) {
        var bank = new Bank(4, 100000);
        Runnable task1 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(0, 1, amount);
                    Thread.sleep((int)(DELAY * Math.random()));
                }
            } catch (InterruptedException exception) {
            }
        };

        Runnable task2 = () -> {
            try {
                for (int i = 0; i < STEPS; i++) {
                    double amount = MAX_AMOUNT * Math.random();
                    bank.transfer(2, 3, amount);
                    Thread.sleep((int)(DELAY * Math.random()));
                }
            } catch (InterruptedException exception) {
            }
        };

        new Thread(task1).start();
        new Thread(task2).start();
    }
}

class Bank {
    public Bank(int count, double money) {

    }

    public void transfer(int account1, int account2, double amount) {
        System.out.println(account1 + " to " + account2 + ", 金额:" + amount);
    }
}
