package chapter06;

public class PoweredTest implements Powered {

    public static void main(String[] args) {
        PoweredTest test = new PoweredTest();
        test.move(1, 1);
    }

    @Override
    public void move(double x, double y) {
        System.out.println(SPEED_LIMIT);
        System.out.println(Powered.SPEED_LIMIT);
    }

    @Override
    public double milesPerGallon() {
        return 0;
    }
}
